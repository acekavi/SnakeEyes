import 'dart:async';

import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'MenuPage.dart';
import 'package:google_fonts/google_fonts.dart';

class HomePage extends StatefulWidget {
  const HomePage({Key? key}) : super(key: key);

  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  @override
  initState() {
    super.initState();
    Timer(const Duration(seconds: 5), () {
      Navigator.of(context).pushReplacement(MaterialPageRoute(builder: (_) {
        return MenuPage();
      }));
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      resizeToAvoidBottomInset: false,
      body: Center(
        child: Container(
          color: Color(0xFF429B46),
          child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: <Widget>[
                Icon(FontAwesomeIcons.solidEye),
                SizedBox(
                  width: double.infinity,
                  child: Text(
                    "Snake Eyes",
                    textAlign: TextAlign.center,
                    style: GoogleFonts.staatliches(
                      textStyle: const TextStyle(
                          color: Colors.black, letterSpacing: .5, fontSize: 50),
                    ),
                  ),
                ),

                const Padding(
                  padding: EdgeInsets.only(left: 50,right: 50),
                  child: LinearProgressIndicator(
                    minHeight: 2,

                    backgroundColor: Colors.black,
                    valueColor: AlwaysStoppedAnimation<Color>(Colors.white),
                    //strokeWidth: 8,
                  ),
                ),


              /*  Expanded(
                  child: const Image(
                    image: AssetImage('assest/homePgGrass.webp'),
                    fit: BoxFit.fill,
                  ),
                ) */

              ]),

        ),

      ),
    );
  }
}
