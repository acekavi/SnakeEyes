import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:snake_eyes/CommonSnakesPage.dart';
import 'package:snake_eyes/MenuPage.dart';
import 'package:google_fonts/google_fonts.dart';

class aboutUsPage extends StatelessWidget {
  const aboutUsPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          leading: IconButton(
            icon: const Icon(Icons.arrow_back, color: Colors.white),
            onPressed: () => Navigator.of(context).pop(),
          ),
          title: const Text("About Us"),
          centerTitle: true,
          backgroundColor: Color(0xFF0C3823),
        ),
        resizeToAvoidBottomInset: false,
        // appBar: AppBar(backgroundColor: Colors.teal,),
        body: SafeArea(

          child: Container(
            decoration: const BoxDecoration(
                image: DecorationImage(
                    image: AssetImage('assest/leavesbackground.jpg'),
                    fit: BoxFit.cover)),
            child: ListView(
              children: [
                Container(
                  decoration: BoxDecoration(
                   // gradient: const LinearGradient(colors: [const Color(0xff00b09b),Color(0xFF0C3823),const Color(0xff00b09b)]),
                    borderRadius: BorderRadius.circular(25.0),
                    color: const Color(0xFF0C3823),
                  ),
                  margin: const EdgeInsets.fromLTRB(5, 20, 5, 20),
                  child: Column(children: [
                    const SizedBox(
                      height: 20,
                    ),
                    Text(
                      "WE ARE ",
                      style: GoogleFonts.amarante(color: Colors.white),
                    ),
                    Text(
                      "CYBER KNIGHTS",
                      style: GoogleFonts.tradeWinds(
                          fontSize: 40, color: Colors.white),
                    ),
                   /*const Icon(
                      FontAwesomeIcons.chessKnight,
                      color: Colors.white,
                    ),*/
                    const SizedBox(
                      height: 20,
                    ),
                  ]),
                ),
                personalCard(
                  name: "A.D.R Fernandopulle    ",
                  path: 'assest/profilePictures/dimuth.jpeg',
                  uowId: 'w18102011',
                  iitId: 20200969,
                  color: const Color(0xFF0C3823),
                  degree: "Software Engineering",
                ),
                personalCard(
                  name: "H. K. D Silva",
                  path: 'assest/profilePictures/deshal.jpeg',
                  uowId: 'w1839723/1',
                  iitId: 20200969,
                  color: const Color(0xFF0C3823),
                  degree: "Software Engineering",
                ),
                personalCard(
                  name: "D. G. A. Kavinda",
                  path: 'assest/profilePictures/avishka.jpeg',
                  uowId: 'w18101955',
                  iitId: 20200969,
                  color: const Color(0xFF0C3823),
                  degree: "Computer Science",
                ),
                personalCard(
                  name: "K.K.C.S.Sarathchandra",
                  path: 'assest/profilePictures/profile.jpg',
                  uowId: 'w18098547',
                  iitId: 20200969,
                  color: const Color(0xFF0C3823),
                  degree: "Software Engineering",
                ),
                personalCard(
                  name: "A.L.S.D.Kumarasinghe",
                  path: 'assest/profilePictures/saumya.jpeg',
                  uowId: 'w18105698',
                  iitId: 20200969,
                  color: const Color(0xFF0C3823),
                  degree: "Software Engineering",
                ),
              ],
            ),
          ),
        ),
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

class personalCard extends StatelessWidget {
  final String path;
  final String name;
  final String uowId;
  final int iitId;
  final Color color;
  final String degree;

  personalCard(
      {required this.path,
      required this.name,
      required this.uowId,
      required this.iitId,
      required this.color,
       required this.degree});

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: const EdgeInsets.only(right: 5, left: 5, bottom: 8, top: 8),
      decoration: BoxDecoration(
        borderRadius: BorderRadius.circular(0.0),
        backgroundBlendMode: BlendMode.color,
        color: color,
      ),
      child: SingleChildScrollView(
        child: Row(
          children: [
            Container(
              margin: const EdgeInsets.all(18.0),
              child: CircleAvatar(
                backgroundColor:color,
                radius: 52.0,
                child: CircleAvatar(
                  backgroundImage: AssetImage(path),
                  maxRadius: 50,
                  minRadius: 20,

                ),
              ),
            ),
            const SizedBox(
              width:10 ,),

            Expanded(
              flex: 20,
              // margin: EdgeInsets.fromLTRB(7, 10, 2, 10),
              child: Column(
               mainAxisAlignment: MainAxisAlignment.start,
                children: [
                  Align(
                    alignment: Alignment.topLeft,
                    child: Text(
                      name,
                      style: GoogleFonts.oswald(fontSize: 25),textAlign: TextAlign.left,
                    ),
                  ),
                  Align(
                    alignment: Alignment.topLeft,
                    child: Text(
                      "UOW ID : $uowId\nIIT ID : $iitId",
                      style:
                          GoogleFonts.sourceCodePro(fontWeight: FontWeight.w800,),textAlign: TextAlign.left
                    ),
                  ),
                  Align(
                    alignment: Alignment.topLeft,
                    child: Text(
                      degree,
                      style:
                          GoogleFonts.sourceCodePro(fontWeight: FontWeight.w400),
                    ),
                  )
                ],
              ),
            )
          ],
        ),
      ),
    );
  }
}
