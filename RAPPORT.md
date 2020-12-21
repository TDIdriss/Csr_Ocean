RAPPORT PROJET CSR

Binôme :      Rahima KONE  &  Idriss TRAORE

Ce projet consistait à simuler de façon simpliste quelques aspects de la vie océanique, l’important ´étant d’abord d’assurer l’intégrité des données et la correction des comportements dans un monde parallèle.
Dans un premier temps nous avons choisi de créer 4 classes à savoir les classes : poissons, zone, requins et océan
Ces classes contiennent entre autre :
1.	Océan

Classe qui va nous servir de main. Elle servira à la création de nos différentes zones. Ces zones seront sauvegardées dans un tableau.

2.	Zone

Classe qui va contenir des attribut tel que le nombre de poissons dans une zone, une variable requin qui nous dira si on a bien un requin dans la zone ou pas , le nombre de sardine dans la zone et une liste contenant l’ensemble de nos différents poissons pilotes.
Ici on de terminera de façon aléatoire les zones qui auront un requin et pour faciliter la taches ses zones seront celles à qui on mettra des poissons pilotes. Le nombre de sardine dans chaque zone sera défini de manière aléatoire. On aura des méthodes comme entrer dans une zone ou sortir de cette zone qui matérialiseront l’entré et la sortie des requins bien entendu aussi des poissons

3.	Requins

Il faut savoir que les requins sont créés à la création de leur zone. Un requin étant dans une zone bien précise la classe requin a pour paramètre un  attribut zone mais aussi une variable contenant le nombre de place maximum de poissons pilote pouvant s’attacher au requin et le nombre de cycle du requin.
Une méthode manger matérialisant le faite que les requins mange les sardines de sa zone. Ici nous avons choisi de laisser le requin manger les sardines uniquement lorsqu’elles sont supérieur ou égale 2 et par quantité de 2 pour éviter de se retrouver avec un nombre de sardine négatif dans une zone.
On aura aussi une méthode transporté pour matérialiser le transport des poissons pilotes vers une autre zone par les requins.

4.	Poissons

Elle contiendra aussi la zone dans laquelle les poissons sont comme variable, des méthodes Attacher et détacher pour matérialiser l’action de s’accrocher a un requin pour aller dans une autre zone et se décrocher une fois arrivé.
PROBLEME DE SYNCHRONISATION

Comme problème de synchro on a eu :

-	L’accès a une zone par un requin : Etant donné qu’il ne doit avoir qu’un seul requin par zone on se devait de bloquer l’accès à celle-ci aux autres requins quand il  y en avait déjà un et les réveiller une fois que celui-ci était sorti de la zone
-	Le nombre de Sardine dans une zone : Etant donné que le nombre de sardine dans une zone ne se réinitialise pas après le passage d’un requin on pourrait se retrouver avec un nombre de sardine négatifs dans une zone après plusieurs passages de requin ou tout simplement après le passage d’un requin un peu trop gourmand. De ce faite on a mis en place un seuil à partir duquel le requin ne pourra pas manger et aussi définir un nombre précis de sardine mangé à chaque passage
-	On devait aussi s’assurer que le nombre de place sur le requin soit respecté afin de ne pas en transporter plus dans une nouvelle zone
-	Le cycle de vie des requins : il s’avère qu’une fois attacher le cycle de vie de certains requins arrivait à son terme bien avant que les poissons pilotes ne sont pouvoir se détacher ce qui crée d’énorme probleme.il a fallu s’arranger à ce que les poissons se détachent avant que le requin ne meurt.
