# MowItNow

##Problem definition

La société MowItNow a décidé de développer une tondeuse à gazon automatique, destinée aux surfaces rectangulaires.La tondeuse peut être programmée pour parcourir l&#39;intégralité de la surface.La position de la tondeuse est représentée par une combinaison de coordonnées (x,y) et d&#39;une lettre indiquant l&#39;orientation selon la notation cardinale anglaise (N,E,W,S). La pelouse est divisée en grille pour simplifier la navigation.

Par exemple, la position de la tondeuse peut être « 0, 0, N », ce qui signifie qu&#39;elle se situe dans le coin inférieur gauche de la pelouse, et orientée vers le Nord.

Pour contrôler la tondeuse, on lui envoie une séquence simple de lettres. Les lettres possibles sont « D », « G » et « A ». « D » et « G » font pivoter la tondeuse de 90° à droite ou à gauche respectivement, sans la déplacer. « A » signifie que l&#39;on avance la tondeuse d&#39;une case dans la direction à laquelle elle fait face, et sans modifier son orientation.

Si la position après mouvement est en dehors de la pelouse, la tondeuse ne bouge pas,
conserve son orientation et traite la commande suivante.

On assume que la case directement au Nord de la position (x, y) a pour coordonnées (x, y+1).

Pour programmer la tondeuse, on lui fournit un fichier d&#39;entrée construit comme suit :

 - La première ligne correspond aux coordonnées du coin supérieur droit de la pelouse, celles du coin inférieur gauche sont supposées être (0,0)

 - La suite du fichier permet de piloter toutes les tondeuses qui ont été déployées. Chaque tondeuse a deux lignes la concernant :

    - la première ligne donne la position initiale de la tondeuse, ainsi que son orientation. La position et l&#39;orientation sont fournies sous la forme de 2 chiffres et une lettre, séparés par un espace

    - la seconde ligne est une série d&#39;instructions ordonnant à la tondeuse d&#39;explorer la pelouse. Les instructions sont une suite de caractères sans espaces.

Chaque tondeuse se déplace de façon séquentielle, ce qui signifie que la seconde tondeuse ne bouge que lorsque la première a exécuté intégralement sa série d&#39;instructions.

Lorsqu&#39;une tondeuse achève une série d&#39;instruction, elle communique sa position et son orientation.

**OBJECTIF**

Concevoir et écrire un programme s&#39;exécutant sur une JVM >= 1.7 ou un serveur node.js, et implémentant la spécification ci-dessus et passant le test ci-après

TEST

Le fichier suivant est fourni en entrée :

5 5<br/>
1 2 N<br/>
GAGAGAGAA<br/>
3 3 E<br/>
AADAADADDA<br/>

On attend le résultat suivant (position finale des tondeuses) :

1 3 N<br/>
5 1 E

NB: Les données en entrée peuvent être injectée sous une autre forme qu&#39;un fichier (par exemple un test automatisé).

##Technical environment used

    - Scala version 2.11
    - SBT(Scala build tool) version 0.13.8
    - ScalaFx (GUI library based on JavaFx) version 8.0.92-R10
    - Junit version 4.8.1

##How to run

Before cloning and running MowItNow on your machine make sure:

    1. You have a JDK8 installed on your machine
    2. JAVA_HOME system variable pointing to JDK8
    3. $JAVA_HOME\bin is present in your system path
    4. You have SBT installed (if not then refer: http://www.scala-sbt.org/download.html)
    5. SBT_installation_path\bin is present in your system path variable
    6. You have GIT installed on your machine

To run this application:

    1. Clone this to your machine by using the follwong command
        - git clone https://github.com/HimanshuArora1234/MowItNow.git
    2. Once cloned run the following command on the root directory of project
        - sbt run 
          
PS. `sbt run` will automatically find the `MowGuiRunner` object which is the ScalaFX GUI object to kick start this application.
And there is a test case file at your disposal in `src/test/resources`.

##Output 

![Home screen](MainScreen.JPG)

![Input file chooser screen](FileChooserScreen.JPG)

![Output screen](OutputScreen1.JPG)

![Output screen](OutputScreen2.JPG)

    

    
