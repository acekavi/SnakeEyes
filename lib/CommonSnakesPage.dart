import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:percent_indicator/percent_indicator.dart';

import 'MenuPage.dart';
import 'Snake.dart';


class CommonSnakesPage extends StatefulWidget {
  const CommonSnakesPage({Key? key}) : super(key: key);

  @override
  _CommonSnakesPageState createState() => _CommonSnakesPageState();
}

class _CommonSnakesPageState extends State<CommonSnakesPage> {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(
          leading: IconButton(
            icon: const Icon(Icons.arrow_back, color: Colors.white),
            onPressed: () => Navigator.of(context).pop(),
          ),
          title: const Text("Common Snakes"),
          centerTitle: true,
          backgroundColor: const Color(0xFF0C3823),
        ),
        body: SafeArea(
          child: ListView(
            children: [
              Snakes(Cobra.name, "", Cobra.path, Cobra.toxicLevel,
                  Cobra.ScientificName, Cobra.family, Cobra),
              Snakes(
                  Common_Krait.name,
                  "",
                  Common_Krait.path,
                  Common_Krait.toxicLevel,
                  Common_Krait.ScientificName,
                  Common_Krait.family,
                  Common_Krait),
              Snakes(
                  Hump_Nosed_PitViper.name,
                  "",
                  Hump_Nosed_PitViper.path,
                  Hump_Nosed_PitViper.toxicLevel,
                  Hump_Nosed_PitViper.ScientificName,
                  Hump_Nosed_PitViper.family,
                  Hump_Nosed_PitViper),
              Snakes(Rat_Snake.name, "", Rat_Snake.path, Rat_Snake.toxicLevel,
                  Rat_Snake.ScientificName, Rat_Snake.family, Rat_Snake),
              Snakes(
                  Rusellas_Viper.name,
                  "",
                  Rusellas_Viper.path,
                  Rusellas_Viper.toxicLevel,
                  Rusellas_Viper.ScientificName,
                  Rusellas_Viper.family,
                  Rusellas_Viper),
              Snakes(
                  Saw_Scaled_Viper.name,
                  "",
                  Saw_Scaled_Viper.path,
                  Saw_Scaled_Viper.toxicLevel,
                  Saw_Scaled_Viper.ScientificName,
                  Saw_Scaled_Viper.family,
                  Saw_Scaled_Viper),
              Snakes(
                  Green_Tree_Vine.name,
                  "",
                  Green_Tree_Vine.path,
                  Green_Tree_Vine.toxicLevel,
                  Green_Tree_Vine.ScientificName,
                  Green_Tree_Vine.family,
                  Green_Tree_Vine),
              Snakes(
                  Indian_Rock_Python.name,
                  "",
                  Indian_Rock_Python.path,
                  Indian_Rock_Python.toxicLevel,
                  Indian_Rock_Python.ScientificName,
                  Indian_Rock_Python.family,
                  Indian_Rock_Python),
              Snakes(
                  Common_Sand_Boa.name,
                  "",
                  Common_Sand_Boa.path,
                  Common_Sand_Boa.toxicLevel,
                  Common_Sand_Boa.ScientificName,
                  Common_Sand_Boa.family,
                  Common_Sand_Boa),
            ],
          ),
        ),
        bottomNavigationBar: BottomNavigationBar(
          currentIndex: 2,
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
                  return const MenuPage();
                }));
                break;
              case 2:
                Navigator.push(context, MaterialPageRoute(builder: (context) {
                  return const CommonSnakesPage();
                }));
                break;
            }
          },
        ),
      ),
    );
  }
}

class Snakes extends StatelessWidget {
  late String name;
  String data;
  String path;
  double toxicLevel;
  String ScientificName;
  String family;
  Snake snake;

  Snakes(this.name, this.data, this.path, this.toxicLevel, this.ScientificName,
      this.family, this.snake);

  @override
  Widget build(BuildContext context) {
    Color fontColor=Colors.black;
    return Container(
      margin: const EdgeInsets.all(10),
      decoration: BoxDecoration(
       // border: Border.all(color: Colors.black),
        color: const Color(0xFF99CC99 ),
        borderRadius: BorderRadius.circular(15),
      ),
      child: Row(
        children: [
          Expanded(
            child: Column(
              children: <Widget>[
                Container(
                  margin: const EdgeInsets.only(left: 6, bottom: 5),
                  child: Align(
                    alignment: Alignment.topLeft,
                    child: Text(
                      name,
                      style: GoogleFonts.breeSerif(
                          fontSize: 25, color: fontColor),
                      textAlign: TextAlign.left,
                    ),
                  ),
                ),
                Row(
                  children: [
                    Container(
                      margin: const EdgeInsets.only(left: 5),
                      child:  Align(
                        child: Text(
                          "Toxicity Level :",
                          style: TextStyle(color: fontColor),
                          textAlign: TextAlign.left,
                        ),
                        alignment: Alignment.topLeft,
                      ),
                    ),
                    Expanded(
                      child: LinearPercentIndicator(

                        animation: true,
                        animationDuration: 2500,
                        linearStrokeCap: LinearStrokeCap.roundAll,
                        lineHeight: 10.0,
                        percent: toxicLevel,
                        backgroundColor: Colors.grey,
                        progressColor: Colors.red,
                      ),
                    ),
                  ],
                ),
                Row(
                  children: [
                    Expanded(
                        flex: 2,
                        child: Container(
                            margin: const EdgeInsets.only(left: 7),
                            child:  Text(
                              "Scientific Name :",
                              style:  TextStyle(color: fontColor),
                            ))),
                    Expanded(
                        flex: 2,
                        child: Text(
                          ScientificName,
                          style: GoogleFonts.abel(color: fontColor,fontStyle: FontStyle.italic),
                        ))
                  ],
                ),
                Row(
                  children: [
                    Expanded(
                        flex: 2,
                        child: Container(
                            margin: const EdgeInsets.only(left: 7),
                            child:  Text(
                              "Family  :",
                              style:  TextStyle(color: fontColor),
                            ))),
                    Expanded(
                        flex: 2,
                        child: Text(
                          family,
                          style: GoogleFonts.abel(color: fontColor),
                        ))
                  ],
                ),
                Container(
                    margin: const EdgeInsets.only(left: 6),
                    child:
                        Align(alignment: Alignment.center, child: Text(data))),
                Align(
                    alignment: Alignment.topLeft,
                    child: Container(

                    //  margin: const EdgeInsets.only(left: 8),
                      child: TextButton(
                        onPressed: () {
                          Navigator.push(
                            context,
                            MaterialPageRoute(
                              builder: (context) => DetailScreen(snake: snake),
                            ),
                          );
                          print(snake.snakeType.toString());
                        },
                        child:
                            Container(decoration: BoxDecoration(
                                border: Border.all(color: const Color(0xFF0C3823)   ),
                                borderRadius: BorderRadius.circular(10)
                            ),child: const Padding(
                              padding: EdgeInsets.all(6.0),
                              child: Text("See More", style: TextStyle()),
                            )),
                      ),
                    ))
              ],
            ),
            flex: 20,
          ),
          Container(
              margin: const EdgeInsets.only(right: 6, top: 10, bottom: 10),
              width: 105,
              height: 150,
              child: ClipRRect(
                borderRadius: BorderRadius.circular(10), // Image border
                child: SizedBox.fromSize(
                  size: const Size.fromRadius(40), // Image radius
                  child: Image.asset(path, fit: BoxFit.cover),
                ),
              )),
        ],
      ),
    );
  }
}

class DetailScreen extends StatelessWidget {
  const DetailScreen({Key? key, required this.snake}) : super(key: key);

  final Snake snake;


  @override
  Widget build(BuildContext context) {
    Color color;

    Color getSnakeType(String snakeType){
      if(snakeType=="Highly-Venomous"){
        color=const Color(0xFFef6666 );
      }
      else if(snakeType=="Midly-Venomous"){
        color=Colors.yellow;
      }
      else{
        color=Colors.lightGreenAccent;
      }
      return color;
    }

    return Scaffold(
      appBar: AppBar(
        title: Text(snake.name),
        backgroundColor: const Color(0xFF0C3823),
      ),
      body: ListView(
        children: [
          Image(image: AssetImage(snake.path),height: 400,fit: BoxFit.cover,),
      Container(
        decoration: BoxDecoration(
          //color: Colors.grey,
         // border: Border.all(width: 0.5,color: Colors.black),
          borderRadius: BorderRadius.circular(20)
        ),

      margin: const EdgeInsets.all(5),


      child: Column(
        children: [
          Row(
            children: [


              Expanded(
                child: Container(
                    decoration: BoxDecoration(
                      borderRadius: BorderRadius.circular(15),
                      color: getSnakeType(snake.snakeType.toString()),
                    ),
                  child:Container(child: Text(snake.snakeType,textAlign: TextAlign.center,style: GoogleFonts.bebasNeue(),),margin: const EdgeInsets.all(5),)

                ),
              ),const SizedBox(child: const Text("   | "),),
              Container(
                margin: const EdgeInsets.all(7),
                child:   Align(
                  child: Text(
                    "Family :",
                    style: GoogleFonts.sansita(color: Colors.black,fontSize: 17),
                    textAlign: TextAlign.left,
                  ),
                  alignment: Alignment.topLeft,
                ),
              ),
              Container(
                margin: const EdgeInsets.all(7),
                child:  Align(
                  child: Text(
                    snake.family,
                    style: GoogleFonts.notoSerif(color: Colors.black,fontSize: 16),
                    textAlign: TextAlign.left,
                  ),
                  alignment: Alignment.topLeft,
                ),
              ),

            ],
          ),
          Row(
            children:  [
               Container(child: const Text("Scientific Name : "),margin: const EdgeInsets.all(7)),
              Expanded(flex:2,child: Text(snake.ScientificName,style: GoogleFonts.notoSerif(fontStyle: FontStyle.italic)))
            ],
          )

          ,
          Container(
            margin: const EdgeInsets.all(5),
            child:  Text(snake.data,textAlign: TextAlign.justify,),
          )
        ],
      ),
      ),

        ],
      ),
    );
  }
}
