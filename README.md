# MowItNow

##Problem definition

La soci�t� MowItNow a d�cid� de d�velopper une tondeuse � gazon automatique, destin�e aux surfaces rectangulaires.La tondeuse peut �tre programm�e pour parcourir l&#39;int�gralit� de la surface.La position de la tondeuse est repr�sent�e par une combinaison de coordonn�es (x,y) et d&#39;une lettre indiquant l&#39;orientation selon la notation cardinale anglaise (N,E,W,S). La pelouse est divis�e en grille pour simplifier la navigation.

Par exemple, la position de la tondeuse peut �tre � 0, 0, N �, ce qui signifie qu&#39;elle se situe dans le coin inf�rieur gauche de la pelouse, et orient�e vers le Nord.

Pour contr�ler la tondeuse, on lui envoie une s�quence simple de lettres. Les lettres possibles sont � D �, � G � et � A �. � D � et � G � font pivoter la tondeuse de 90� � droite ou � gauche respectivement, sans la d�placer. � A � signifie que l&#39;on avance la tondeuse d&#39;une case dans la direction � laquelle elle fait face, et sans modifier son orientation.

Si la position apr�s mouvement est en dehors de la pelouse, la tondeuse ne bouge pas,
conserve son orientation et traite la commande suivante.

On assume que la case directement au Nord de la position (x, y) a pour coordonn�es (x, y+1).

Pour programmer la tondeuse, on lui fournit un fichier d&#39;entr�e construit comme suit :

 - La premi�re ligne correspond aux coordonn�es du coin sup�rieur droit de la pelouse, celles du coin inf�rieur gauche sont suppos�es �tre (0,0)

 - La suite du fichier permet de piloter toutes les tondeuses qui ont �t� d�ploy�es. Chaque tondeuse a deux lignes la concernant :

    - la premi�re ligne donne la position initiale de la tondeuse, ainsi que son orientation. La position et l&#39;orientation sont fournies sous la forme de 2 chiffres et une lettre, s�par�s par un espace

    - la seconde ligne est une s�rie d&#39;instructions ordonnant � la tondeuse d&#39;explorer la pelouse. Les instructions sont une suite de caract�res sans espaces.

Chaque tondeuse se d�place de fa�on s�quentielle, ce qui signifie que la seconde tondeuse ne bouge que lorsque la premi�re a ex�cut� int�gralement sa s�rie d&#39;instructions.

Lorsqu&#39;une tondeuse ach�ve une s�rie d&#39;instruction, elle communique sa position et son orientation.

**OBJECTIF**

Concevoir et �crire un programme s&#39;ex�cutant sur une JVM >= 1.7 ou un serveur node.js, et impl�mentant la sp�cification ci-dessus et passant le test ci-apr�s

TEST

Le fichier suivant est fourni en entr�e :

5 5<br/>
1 2 N<br/>
GAGAGAGAA<br/>
3 3 E<br/>
AADAADADDA<br/>

On attend le r�sultat suivant (position finale des tondeuses) :

1 3 N<br/>
5 1 E

NB: Les donn�es en entr�e peuvent �tre inject�e sous une autre forme qu&#39;un fichier (par exemple un test automatis�).

##Technical env used

    - Scala version 2.11
    - SBT(Scala build tool) version 0.13.8
    - Scalafx (GUI library based on JavaFX) version 8.0.92-R10
    