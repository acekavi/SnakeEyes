import 'package:flutter/material.dart';
import 'package:snake_eyes/CommonSnakesPage.dart';
import 'package:snake_eyes/MenuPage.dart';
import 'HomePage.dart';
import 'CommonSnakesPage.dart';
import 'MenuPage.dart';
import 'AboutUsPage.dart';
import 'FirstAidPage.dart';
import 'CapturePage.dart';

void main() {
  runApp(const MyApp());
}


class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Flutter Demo',
      theme: ThemeData(
        primaryColor: Colors.green,
        primarySwatch: Colors.blue,
      ),
      initialRoute: '/',
      routes: {
        '/': (context) => const HomePage(),
        '/first': (context) => const MenuPage(),
        '/commonsnakes': (context) => const CommonSnakesPage(),
        '/firstaid': (context) => const FirstAidPage(),
        '/aboutus': (context) =>  aboutUsPage(),
        '/capture': (context) =>  capturePage(),
      },
    );
  }
}

