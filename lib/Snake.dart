import 'package:flutter/cupertino.dart';

class Snake{
  final String name;
  final String snakeType;
  final String data;
  final String path;
  final double toxicLevel;
  final String ScientificName;
  final String family;
  Snake( this.name, this.path,this.toxicLevel, this.ScientificName, this.family,this.snakeType,this.data);}

final Snake Cobra =
Snake("Cobra", snakesImages[0], 0.97, "Naja Naja", "Elapidae","Highly-Venomous",snakedata[0]);
final Snake Common_Krait = Snake(
    "Common Krait", snakesImages[1], 0.9, "Bungarus Caeruleus", "Elapidae","Highly-Venomous",snakedata[1]);
final Snake Hump_Nosed_PitViper = Snake("Hump Nosed PitViper", snakesImages[2],
    0.9, "Hypnale Hypnale", "Viperidae","Highly-Venomous",snakedata[2]);
final Snake Rat_Snake =
Snake("Rat Snake", snakesImages[3], 0.1, "Aesculapian Snake", "Colubridae","Non-Venomous",snakedata[3]);
final Snake Rusellas_Viper = Snake(
    "Rusellas Viper", snakesImages[4], 0.8, "Daboia Russelii", "Viperidae","Highly-Venomous",snakedata[4]);
final Snake Saw_Scaled_Viper = Snake(
    "Saw Scaled Viper", snakesImages[5], 0.8, "Echis Carinatus", "Viperidae","Highly-Venomous",snakedata[5]);
final Snake Green_Tree_Vine = Snake(
    "Green Tree Vine", snakesImages[6], 0.5, "Ahaetulla Nasuta", "Colubridae","Midly-Venomous",snakedata[6]);
final Snake Indian_Rock_Python = Snake(
    "Indian Rock Python", snakesImages[7], 0.1, "Python Molurus", "Pythonidae","Non-Venomous",snakedata[7]);
final Snake Common_Sand_Boa = Snake(
    "Common Sand Boa", snakesImages[8], 0.1, "Gongylophis Conicus", "Boidae","Non-Venomous",snakedata[8]);


List snakesImages = [
  "assest/snakes/cobra.jpeg",
  "assest/snakes/commonKrait.jpeg",
  "assest/snakes/humpNosedPitViper.jpeg",
  "assest/snakes/ratsnake.jpeg",
  "assest/snakes/rusellasViper.jpeg",
  "assest/snakes/sawScaledViper.jpeg",
  "assest/snakes/greentreeVine.jpeg",
  "assest/snakes/indianrockpython.jpeg",
  "assest/snakes/commonsandboa.jpeg"
];

List snakedata =[
  "The Indian cobra (Naja naja), also known as the spectacled cobra, Asian cobra, or bioccelate cobra, is a species of the genus Naja found, in India, Pakistan, Bangladesh, Sri Lanka. Naja are capable of delivering a fatal bite to a human. Most species have strongly neurotoxic venom, which attacks the nervous system, causing paralysis, but many also have cytotoxic features which cause swelling and necrosis, and have a significant anticoagulant effect.  Indian cobras are oviparous and lay their eggs between the months of April and July. The female snake usually lays between 10 and 30 eggs in rat holes or termite mounds and the eggs hatch 48 to 69 days later.",
  "The common krait also known as blue krait, is a species of highly venomous snake native to the Indian subcontinents.  This snake can be found in dry zone of Sri Lanka.  The bite occurred at night while the victims were asleep on the floor. In 99 (47%) situations killed specimens were available for identification. The cardinal symptom was abdominal pain developing within hours of the bite. Common krait bites cause muscular paralysis due to the venom disrupting communication between the nerves and muscles. This becomes life-threatening for the patient if there is paralysis of the muscles used for breathing. Irrespective of Krait, its venom is 10 times more lethal than cobra. ",
  "Hump Nosed Pit Viper can be found in peninsular India and in Sri Lanka in dense jungle and coffee plantations in hilly areas. This snake were considered moderately venomous snakes whose bites result mainly in local envenoming. However, a variety of severe local effects, hemostatic dysfunction, microangiopathic hemolysis, kidney injury and death have been reported following envenoming by Hypnale species. The hump-nosed viper is widely distributed in all the peneplanes of the country and is commonly found in coconut, rubber and tea plantations. ",
  "Rat snakes pose no threat to humans. Although rat snakes were long believed to be completely nonvenomous, recent studies have shown that some Old World species do possess small amounts of venom, though the amount is negligible relative to human. Rat snakes usually hunt and kill mice by biting with their teeth and suffocate them by constriction of its own body. Night time environment more thermally suitable for rat snakes to hunt, thereby making them more active at night. ",
  "404 ERROR",
  "Saw scaled viper also know as Vali polonga, found in India, Sri Lanka, Bangladesh, and Pakistan on a range of different substrates, including sand, rock, soft soil and in scrublands. Often found hiding under loose rocks in daylight. They are most active after rains or on humid nights also consider to be highly venomous snakes in Sri Lanka. This snake is one of the species responsible for causing the most snakebite cases due to their inconspicuous and extremely aggressive nature. Also they feeds on rodents, lizards, frogs, and a variety of arthropods, such as scorpions, centipedes and large insects. Produces on average about 18 mg of dry venom by weight, with a recorded maximum of 72 mg. Envenomation results in local symptoms as well as severe systemic symptoms that may prove fatal. Local symptoms include swelling and pain, which appear within minutes of a bite. In very bad cases the swelling may extend up the entire affected limb within 12–24 hours and blisters form on the skin. ",
  "Vine snake native to Sri Lanka. Its common names include Asian vine snake, Boie's whip snake, Gunther's whip snake, Oriental whip snake. The body form is extremely slender with a long, pointed, projecting snout which is rather more than twice as long as the eye. Asian vine snakes hunt using their camouflage to move in the branches of trees, sometimes swaying with the wind to further their mimicry.  Even the tongue flicking is more subdued than in other snake species, with the tongue poking out very slowly, sometimes without the forked flair. When they smell prey, they slowly approach and follow until the right moment to strike, usually aiming for the neck. The Asian vine snake feeds on small reptiles and amphibians, particularly lizards and tree frogs. Asian vine snakes are ovoviviparous, meaning the eggs develop inside the mother’s body and when they hatch, the snakes give live birth. They give birth to about 7-10 young at a time. ",
  "Python molurus is a large, nonvenomous python species native to tropical and subtropical regions of the Indian subcontinent and Southeast Asia. Lethargic and slow moving even in their native habitat, they exhibit timidity and rarely try to attack even when attacked. They are excellent swimmers and are quite at home in water. Like all snakes, Indian pythons are strict carnivores and feed on mammals, birds, and reptiles indiscriminately, but seem to prefer mammals. After a heavy meal, they are disinclined to move. If forced to, hard parts of the meal may tear through the body. After a heavy meal, an individual may fast for weeks, the longest recorded duration being 2 years.",
  "Sand boas are ambush predators, which means they hide and wait for their prey to come close to the snake's concealed body. The Kenyan sand is a non-venomous snake that uses constriction to subdue its prey. Sand boas typically live into their mid-teens. Some in captivity have lived up to 20 years. In India it can be mistaken at first glance for either the Indian python or the deadly Russell's viper. Sand Boas will continue to grow as they age but will have to shed their skin because their old skin won't grow together with their bodies. Sand Boas will constantly shed their skin and may end up shedding them once every 3 or 4 months depending on the season and how fast the snake grows. "
];
