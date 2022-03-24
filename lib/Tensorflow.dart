import 'dart:io';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:image_picker/image_picker.dart';
import 'package:permission_handler/permission_handler.dart';
import 'package:tflite/tflite.dart';

class Tensorflow extends StatefulWidget {
  @override
  _TensorflowState createState() => _TensorflowState();
}

class _TensorflowState extends State<Tensorflow> {
  late List _outputs;
   late File _image;
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
      model: "Frontend/assest/tensorflow/model_unquant.tflite",
      labels: "Frontend/assest/tensorflow/labels.txt",
      numThreads: 1,
        isAsset: true, // defaults to true, set to false to load resources outside assets
        useGpuDelegate: false
    );
  }
  Future classifyImage(File image) async {
    var output = await Tflite.detectObjectOnImage(
        path: image.path,       // required
        model: "YOLOv4",
        imageMean: 0.0,
        imageStd: 255.0,
        threshold: 0.3,       // defaults to 0.1
        numResultsPerClass: 2,// defaults to 5
        // defaults to [0.57273,0.677385,1.87446,2.06253,3.33843,5.47434,7.88282,3.52778,9.77052,9.16828]
        blockSize: 32,        // defaults to 32
        numBoxesPerBlock: 5,  // defaults to 5
        asynch: true          // defaults to true
    );
    setState(() {
      _loading = false;
      _outputs = output!;
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
  Future pickImage() async{
    try {
      var status = await Permission.camera.status;


      if (status.isDenied) {
        // We didn't ask for permission yet or the permission has been denied before but not permanently.
      }

// You can can also directly ask the permission about its status.
      if (await Permission.location.isRestricted) {
        // The OS restricts access, for example because of parental controls.
      }



      var image = await ImagePicker().pickImage(source: ImageSource.gallery);
      if (image == null) return null;
      setState(() {
        _loading = true;
        _image = File(image.path);
      });
      classifyImage(_image);
    } on PlatformException catch (e)
    {
      print("Failed to pick image $e!");
    }


  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        centerTitle: true,
        title: Text(
          "Tensorflow Lite",
          style: TextStyle(color: Colors.white, fontSize: 25),
        ),
        backgroundColor: Colors.amber,
        elevation: 0,
      ),
      body: Container(
        color: Colors.white,
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            _loading ? Container(
              height: 300,
              width: 300,
            ):
            Container(
              margin: EdgeInsets.all(20),
              width: MediaQuery.of(context).size.width,
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.center,
                mainAxisAlignment: MainAxisAlignment.center,
                children: <Widget>[
                  _image == null ? Container() : Image.file(_image),
                  SizedBox(
                    height: 20,
                  ),
                  _image == null ? Container() : _outputs != null ?
                  Text(_outputs[0]["label"],style: TextStyle(color: Colors.black,fontSize: 20),
                  ) : Container(child: Text(""))
                ],
              ),
            ),
            SizedBox(
              height: MediaQuery.of(context).size.height * 0.01,
            ),
            FloatingActionButton(
              tooltip: 'Pick Image',
              onPressed: pickImage,
              child: Icon(Icons.add_a_photo,
                size: 20,
                color: Colors.white,
              ),
              backgroundColor: Colors.amber,
            ),
          ],
        ),
      ),
    );
  }
}