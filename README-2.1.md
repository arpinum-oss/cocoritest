# Cocoritest [![Etat build]](https://travis-ci.org/arpinum/cocoritest)

> Mal nommer les choses c'est ajouter au malheur du monde.
> <cite>(Albert Camus)</cite>

**Cocoritest** est une api **Java 8** permettant d'écrire des affirmations de test unitaire dans une syntaxe proche du **français**.

Elle s'inspire des excellents et complets [Hamcrest] ou [FEST] et n'a pas pour prétention d'être une quelconque alternative. Toutefois, **Cocoritest** convient parfaitement pour s'exercer en TDD sur des katas.

Avec **Cocoritest** vous pouvez :
* affirmer sur des booléens,
* affirmer sur des objets,
* affirmer sur des collections,
* chaîner les affirmations de façon fluide,
* capturer des exceptions pour affirmer dessus,
* injecter des dépendances à un objet,
* frimer dans les diners mondains.

Il est possible de consulter le [journal des modifications] pour se tenir au courant des nouveautés.

## Exemples
*(certains caractères qui font la richesse du français sont mal gérés par le moteur de rendu de code utilisé par Github... une fée vient de s'éteindre quelque part dans le monde...)*

### Affirmations sur un objet

```java
@Test
public void unBooléenVraiEnChaîneEstEnFrancais() {
    String chaîne = Objets.enChaîne(true);

    alors().la(chaîne).nEstPasNulle();
    alors().la(chaîne).est("vrai");
}
```

### Affirmations sur un booléen

```java
@Test
public void deuxCollectionsNullesSontEgales() {
    boolean résultat = Collections.égales(null, null);

    alors().le(résultat).estVrai();
}
```

### Affirmations sur une collection

Les affirmations concernant les collections sont accessibles depuis la fabrique `les(...)` ce qui sous-entend que vos collections ne doivent pas être nommées `listeChaine` ou `entierList` mais en plaçant les éléments au pluriel comme `chaines` ou `entiers`.
D'une façon général en français nous disons *j'ai acheté des bonbons à mes enfants* et non *j'ai acheté une collection de bonbons à ma liste d'enfants*.

```java
@Test
public void peutCréerUneListe() {
    List<String> éléments = Listes.crée("a", "b");
 
    alors().les(éléments).sontAuNombreDe(2); 
    alors().les(éléments).sont("a", "b");
}
```

### Affirmations sur une instruction

Pour toutes les autres situations où il ne semble pas possible de construire une phrase syntaxiquement correcte il reste possible d'utiliser la fabrique `ceci(...)`.

```java
@Test
public void ilEstPossibleDeTesterLEgalitéDeDeuxObjets() {
    alors().ceci(Objets.égaux("toto", "toto")).estVrai();
    alors().ceci(Objets.égaux("toto", 3)).estFaux();
}
```

Notez qu'une extraction de méthode ou variable peut dans la plupart des cas aider à retrouver une phrase correcte et permettre d'utiliser un `le(...)` ou `la(...)`.

```java
@Test
public void ilEstPossibleDeTesterLEgalitéDeDeuxObjets() {
	alors().cette(égalitéEntre("toto", "toto")).estVraie();
	alors().cette(égalitéEntre("toto", 3)).estFausse();
}

private boolean égalitéEntre(Object gauche, Object droite) {
    return Objets.égaux(gauche, droite);
}
```

### Chaîner les affirmations

```java
@Test
public void unBooléenVraiEnChaîneEstEnFrancais() {
    String chaîne = Objets.enChaîne(true);

    alors().la(chaîne).nEstPasNulle().et().est("vrai");
}
```

### Affirmations sur une exception

```java
@Test
public void peutCapturerUneException() {
	CapteurException capteur = Outils.créeCapteur();

	Exception exception = capteur.capte(() -> throw new RuntimeException("le message"));

	alors().cette(exception).nEstPasNulle();
	alors().ceci(exception.getMessage()).est("le message");
	alors().ceci(exception instanceof RuntimeException).estVrai();
}
```

Les affirmations sur l'exception capturée se font en fin de test. **Cocoritest** respecte donc la disposition standard Arrange Act Assert (AAA) des tests. \o/

### Injecter des dépendances de test

Utiliser de l'injection de dépendance dans le code de production est très courant. Certains frameworks peuvent fonctionner directement sur les champs et les objets n'exposent donc aucun accesseur pour modifier les dépendances. De fait, il est très difficile d'utiliser des doublures (mocks ou stubs) dans les tests. 

Quelques solutions existent avec leurs avantages et inconvénients :

* créer des constructeurs ou setter en visibilité package private pour les tests,
* utiliser le moteur d'injection de production pour les tests,
* assigner les dépendances par réflexion.

**Cocoritest** propose un injecteur qui s'appuie sur la dernière solution. Il se base sur les types et non des chaînes de caractères. Bien que violant quelque peu l'encapsulation il reste plus tendre avec le refactoring que d'autres approches.

```java
@Test
public void leServicePeutDonnerUnMotDePasseAléatoireSur8Caractères() {
	ServiceMotDePasse service = new ServiceMotDePasse();
	Injecteur injecteur = créeInjecteur(service);
	injecteur.injecte(new DoublureServiceCaractereAleatoire('X'));

	String motDePasse = service.créeMotDePasse();

	alors().le(motDePasse).nEstPasNul();
	alors().le(motDePasse).est("XXXXXXXX");
}
```

L'exemple complet ici : [TestInjection.java]

## Utilisation

Télécharger la dépendance ici : [cocoritest-2.1.jar].

Ou ajouter **Cocoritest** dans les dépendances d'un pom.xml :

```
<dependency>
	<groupId>fr.arpinum</groupId>
	<artifactId>cocoritest</artifactId>
	<version>2.1</version>
	<scope>test</scope>
</dependency>
```

Ou consulter la configuration des autres gestionnaires de dépendances sur [l'entrepôt Maven].

Ajouter **Cocoritest** au niveau des imports Java :

```java
import static fr.arpinum.cocoritest.Affirmations.*;
import static fr.arpinum.cocoritest.Outils.*;
```
`Affirmations` permet d'accéder à tous les affirmations.
`Outils` est optionnelle, elle contient, entre autre, le capteur d'exception et l'injecteur.

## Archéologie ##

La dernière version disponible en **Java 6** est la **1.2**. Voici un lien vers le [README 1.2].

## Documentation

Une belle [javadoc] est disponible!

Seules les classes manipulées par l'utilisateur sont documentées. Le package `fr.arpinum.cocoritest.interne.*` qui représente la popote interne ne contient aucune documentation.

## Licence

Copyright (C) 2013, Arpinum

**Cocoritest** est un logiciel libre ; vous pouvez le redistribuer ou le modifier suivant les termes de la GNU Lesser General Public License telle que publiée par la Free Software Foundation ; soit la version 3 de la licence, soit (à votre gré) toute version ultérieure.

**Cocoritest** est distribué dans l'espoir qu'il sera utile, mais SANS AUCUNE GARANTIE ; pas même la garantie implicite de COMMERCIABILISABILITÉ ni d'ADÉQUATION à UN OBJECTIF PARTICULIER. Consultez la GNU Lesser General Public License pour plus de détails.

Vous devez avoir reçu une copie de la GNU Lesser General Public License en même temps que **Cocoritest** ; si ce n'est pas le cas, consultez [http://www.gnu.org/licenses/lgpl.html].

[Hamcrest]: http://hamcrest.org/
[FEST]: https://code.google.com/p/fest/
[http://www.gnu.org/licenses/lgpl.html]: http://www.gnu.org/licenses/lgpl.html
[TestInjection.java]: src/test/java/fr/arpinum/cocoritest/exemples/TestInjection.java
[cocoritest-2.1.jar]: http://repo1.maven.org/maven2/fr/arpinum/cocoritest/2.1/cocoritest-2.1.jar
[l'entrepôt Maven]: http://mvnrepository.com/artifact/fr.arpinum/cocoritest/2.1
[Etat build]: https://travis-ci.org/arpinum/cocoritest.png?branch=master
[javadoc]: http://arpinum.github.io/cocoritest/apidocs
[README 1.2]: https://github.com/arpinum/cocoritest/blob/derniere-version-jdk6/README.md
[journal des modifications]: https://github.com/arpinum/cocoritest/blob/master/documentation/journalDesModifications.md
