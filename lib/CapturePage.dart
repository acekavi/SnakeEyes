import 'dart:io';
import 'dart:async';

import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';
import 'package:flutter/services.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:image_picker/image_picker.dart';
import 'package:path_provider/path_provider.dart';
import 'package:permission_handler/permission_handler.dart';
import 'package:tflite/tflite.dart';

class capturePage extends StatefulWidget {
  const capturePage({Key? key}) : super(key: key);

  @override
  _capturePageState createState() => _capturePageState();
}

class _capturePageState extends State<capturePage> {
  File? image;
  List? _outputs;
  String name = "";
  String confidence="";
  String numbers="";

  Future pickImage(ImageSource source) async {
    try {
      var status = await Permission.camera.status;

      if (status.isDenied) {
        // We didn't ask for permission yet or the permission has been denied before but not permanently.
      }

// You can can also directly ask the permission about its status.
      if (await Permission.location.isRestricted) {
        // The OS restricts access, for example because of parental controls.
      }

      final image = await ImagePicker().pickImage(source: source);
      if (image == null) return;
      final imageTemp = File(image.path);
      classifyImage(imageTemp);
      setState(() {
        this.image = imageTemp;

      });
    } on PlatformException catch (e) {
      print("Failed to pick image $e!");
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Capture"),
        backgroundColor: const Color(0xFF0C3823),
      ),
      body: SafeArea(
        child: Center(
          child: ListView(
            children: [
              Container(
                margin: const EdgeInsets.all(10),
                child: Ink(

                    //margin: EdgeInsets.all(10),
                    decoration: BoxDecoration(
                      gradient: const LinearGradient(
                          colors: [Color(0xff00b09b), Color(0xff96c93d)]),
                      // border: Border.all(color: Colors.black),
                      borderRadius: BorderRadius.circular(6),
                    ),
                    child: TextButton.icon(
                        autofocus: true,
                        onPressed: () {
                          pickImage(ImageSource.camera);
                        },
                        label: const Text(
                          "Capture",
                          style: TextStyle(
                              color: Colors.black, fontWeight: FontWeight.w700),
                        ),
                        icon: const Icon(
                          FontAwesomeIcons.camera,
                          color: Colors.black,
                        ))),
              ),
              Container(
                margin: const EdgeInsets.all(10),
                child: Ink(
                    decoration: BoxDecoration(
                      gradient: const LinearGradient(colors: [
                        const Color(0xff00b09b),
                        const Color(0xff96c93d)
                      ]),
                      //   border: Border.all(color: Colors.black),
                      borderRadius: BorderRadius.circular(6),
                    ),
                    child: TextButton.icon(
                      autofocus: true,
                      onPressed: () {
                        pickImage(ImageSource.gallery);
                      },
                      label: const Text(
                        "Gallery",
                        style: const TextStyle(
                            color: Colors.black, fontWeight: FontWeight.w700),
                      ),
                      icon: const Icon(
                        FontAwesomeIcons.fileImage,
                        color: Colors.black,
                      ),
                    )),
              ),
              image != null
                  ? Image.file(
                      image!,
                      fit: BoxFit.cover,
                    )
                  : const Image(
                      image: AssetImage("assest/snakeEyeLogo.jpg"),
                    ),
              Container(
                child: Text("Name : $name \n Confidence : $confidence"),
              )
            ],
          ),
        ),
      ),
    );
  }

  bool _loading = false;

  @override
  void initState() {
    super.initState();
    _loading = true;

    loadModel().then((value) {
      setState(() {
        _loading = false;
      });
    });
  }

  loadModel() async {
    await Tflite.loadModel(
      model: "Frontend/assest/tensorflow/model_unquant3.tflite",
      labels: "Frontend/assest/tensorflow/labels3.txt",
      numThreads: 1,
    );
  }

  Future classifyImage(File image) async {
   var output = await Tflite.runModelOnImage(
        path: image.path,
        imageMean: 117.0,
        imageStd: 255.0,
        numResults: 4,
        threshold: 0.9,
        asynch: true);


    /** var output = await Tflite.detectObjectOnImage(
        path: image.path,       // required
        //  model: "YOLOv4",
        imageMean: 0.0,
        imageStd: 255.0,
        threshold: 0.3,       // defaults to 0.1
        numResultsPerClass: 2,// defaults to 5
        // anchors: anchors,     // defaults to [0.57273,0.677385,1.87446,2.06253,3.33843,5.47434,7.88282,3.52778,9.77052,9.16828]
        blockSize: 32,        // defaults to 32
        numBoxesPerBlock: 5,  // defaults to 5
        asynch: true          // defaults to true
    ); **/
    setState(() {
      _loading = false;
      _outputs = output!;
      String str = _outputs![0]["label"];
      name=str.substring(2);
      confidence=(_outputs![0]["confidence"]*100).toString().substring(0,2)+"%";
      print("Output is :" + _outputs.toString());
    });
  }

  @override
  void dispose() {
    Tflite.close();
    super.dispose();
  }
/** pickImage() async {
    var image = await ImagePicker().pickImage(source: ImageSource.gallery);
    if (image == null) return null;
    setState(() {
    _loading = true;
    _image = image as File;
    });
    classifyImage(_image);
    } **/

}
