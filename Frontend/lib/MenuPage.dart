import 'package:snake_eyes/AboutUsPage.dart';
import 'package:snake_eyes/CapturePage.dart';
import 'package:snake_eyes/FirstAidPage.dart';

import 'CommonSnakesPage.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'AboutUsPage.dart';
class MenuPage extends StatefulWidget {
  const MenuPage({Key? key}) : super(key: key);

  @override
  _MenuPageState createState() => _MenuPageState();
}

class _MenuPageState extends State<MenuPage> {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        body: SafeArea(
            child: Container(
          decoration: const BoxDecoration(
              image: DecorationImage(
                  image: AssetImage('assest/menuBackground.jpg'),
                  fit: BoxFit.cover)),
          child: ListView(
            padding: const EdgeInsets.all(20.0),
            // mainAxisAlignment: MainAxisAlignment.center,

            children: <Widget>[
              const Image(
                  image: AssetImage('assest/snakeEyeLogo.jpg'),
                  height: 170,
                  width: 170),
              const SizedBox(
                height: 20,
              ),
              Container(
                margin:const EdgeInsets.only(top: 50),
                decoration: BoxDecoration(
                    color: const Color(0xFF81a55f),
                    borderRadius: BorderRadius.circular(10.0)),
                height: 60,
                child: menuButton(
                  text: "COMMON SNAKES",
                  icon: FontAwesomeIcons.book,
                  objectKey:  const CommonSnakesPage(),
                ),
              ),
              Container(
                margin: const EdgeInsets.only(top: 50),
                decoration: BoxDecoration(
                    color:const Color(0xFF89ab6a),
                    borderRadius: BorderRadius.circular(10.0)),
                height: 60,
                child: menuButton(
                  text: "CAPTURE",
                  icon: FontAwesomeIcons.camera,
                  objectKey: const capturePage(),
                ),
              ),
              Container(
                margin:const EdgeInsets.only(top: 50),
                decoration: BoxDecoration(
                    color:const Color(0xFFa6bf8e),
                    borderRadius: BorderRadius.circular(10.0)),
                height: 60,
                child: menuButton(
                  text: "FIRST-AID",
                  icon: FontAwesomeIcons.firstAid,
                  objectKey:const FirstAidPage(),
                ),
              ),
              Container(
                margin:const EdgeInsets.only(top: 50),
                decoration: BoxDecoration(
                    color:const Color(0xFFaec599),
                    borderRadius: BorderRadius.circular(10.0)),
                height: 60,
                child: menuButton(
                  text: "ABOUT US",
                  icon: FontAwesomeIcons.solidIdCard,
                  objectKey:const aboutUsPage(),
                ),
              )
            ],
          ),
        )),

        bottomNavigationBar: BottomNavigationBar(
          backgroundColor: const Color(0xFF0C3823),
          items: const <BottomNavigationBarItem>[
            BottomNavigationBarItem(
                icon: Icon(
                  Icons.home,
                  color: Colors.white,
                ),
                label: "Home"),
            BottomNavigationBarItem(
              icon: Icon(
                Icons.camera,
                color: Colors.white,
              ),
              label: 'Capture',
            ),
            BottomNavigationBarItem(
              icon: Icon(
                FontAwesomeIcons.database,
                color: Colors.white,
              ),
              label: 'Snakes',
            ),
          ],
          selectedItemColor: Colors.amber[800],
          unselectedItemColor: Colors.white,
          onTap: (index) {
            switch (index) {
              case 0:
                Navigator.push(context, MaterialPageRoute(builder: (context) {
                  return MenuPage();
                }));
                break;
              case 2:
                Navigator.push(context, MaterialPageRoute(builder: (context) {
                  return CommonSnakesPage();
                }));
                break;
            }
          },
        ),
      ),
    );
  }
}

class menuButton extends StatelessWidget {
  final String text;
  final IconData icon;
  final Widget objectKey;

  menuButton({required this.text, required this.icon, required this.objectKey});

  @override
  Widget build(BuildContext context) {
    return FlatButton(
        child: Row(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          children: [
            Container(
                margin: const EdgeInsets.only(
                  left: 10,
                ),
                child: Icon(icon)),
            Text(
              text,
              style: GoogleFonts.openSans(fontSize: 20),
            ),
            Container(
                margin: const EdgeInsets.only(right: 5),
                child: const Icon(FontAwesomeIcons.arrowRight)),
          ],
        ),
        onPressed: () {
          Navigator.push(context, MaterialPageRoute(builder: (context) {
            return objectKey;
          }));
        });
  }
}
