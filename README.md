# Cocoritest

> Mal nommer les choses c'est ajouter au malheur du monde.
> <cite>(Albert Camus)</cite>

**Cocoritest** est une api Java permettant d'écrire des affirmations de test unitaire dans une syntaxe proche du **français**. 

Elle s'inspire des excellents et complets [Hamcrest] ou [FEST] et n'a pas pour prétention d'être une quelconque alternative. Toutefois, **Cocoritest** convient parfaitement pour s'exercer en TDD sur des Katas.

## Exemples ##
*(les accents ou cédilles sont retirés des exemples car ils sont mal gérés par le moteur de rendu de code utilisé par Github)*

### Affirmations sur un objet ###

```java
@Test
public void unBooleenVraiEnChaineEstEnFrancais() {
    String chaine = Objets.enChaine(true);

    alors().la(chaine).nEstPasNulle();
    alors().la(chaine).est("vrai");
}
```

### Affirmations sur un booléen ###

```java
@Test
public void deuxCollectionsNullesSontEgales() {
    boolean resultat = Collections.egales(null, null);

    alors().le(resultat).estVrai();
}
```

### Affirmations sur une collection ###

Les affirmations concernant les collections sont accessibles depuis la fabrique `les(...)` ce qui sous-entend que vos collections ne doivent pas être nommées `listeChaine` ou `entierList` mais en plaçant les éléments au pluriel comme `chaines` ou `entiers`.
D'une façon général en français nous disons *j'ai acheté des bonbons à mes enfants* et non *j'ai acheté une liste de bonbons à ma liste d'enfants*.

```java
@Test
public void peutCreerUneListe() {
    List<String> elements = Listes.cree("a", "b");
 
    alors().les(elements).sontAuNombreDe(2); 
    alors().les(elements).sont("a", "b");
}
```

### Affirmations sur une instruction ###

Pour toutes les autres situations où il ne semble pas possible de construire une phrase syntaxiquement correcte il reste possible d'utiliser la fabrique `ceci(...)`.

```java
@Test
public void ilEstPossibleDeTesterLEgaliteDeDeuxObjets() {
    alors().ceci(Objets.egaux("toto", "toto")).estVrai();
    alors().ceci(Objets.egaux("toto", 3)).estFaux();
}
```

Notez qu'une extraction de méthode ou variable peut dans la plupart des cas aider à retrouver une phrase correcte et permettre d'utiliser un `le(...)` ou `la(...)`.

```java
@Test
public void ilEstPossibleDeTesterLEgaliteDeDeuxObjets() {
    alors().cette(egaliteEntre("toto", "toto")).estVraie();
	alors().cette(egaliteEntre("toto", 3)).estFausse();
}

private boolean egaliteEntre(Object gauche, Object droite) {
    return Objets.egaux(gauche, droite);
}
```

## Utilisation ##

* Au niveau d'un pom.xml de Maven :

```
todo
```


* Au niveau des imports Java :

```java
import static fr.arpinum.cocoritest.affirmation.Affirmations.*;
```

## Plus d'informations ##
N'hésitez pas à consulter la [cartographie] de l'api.

## Licence ##

Copyright (C) 2013, Arpinum

**Cocoritest** est un logiciel libre ; vous pouvez le redistribuer ou le modifier suivant les termes de la GNU Lesser General Public License telle que publiée par la Free Software Foundation ; soit la version 3 de la licence, soit (à votre gré) toute version ultérieure.

**Cocoritest** est distribué dans l'espoir qu'il sera utile, mais SANS AUCUNE GARANTIE ; pas même la garantie implicite de COMMERCIABILISABILITÉ ni d'ADÉQUATION à UN OBJECTIF PARTICULIER. Consultez la GNU Lesser General Public License pour plus de détails.

Vous devez avoir reçu une copie de la GNU Lesser General Public License en même temps que **Cocoritest** ; si ce n'est pas le cas, consultez [http://www.gnu.org/licenses].

[Hamcrest]: http://hamcrest.org/
[FEST]: https://code.google.com/p/fest/
[cartographie]: http://www.arpinum.fr/images/cocoritest/cartographie.jpg
[http://www.gnu.org/licenses/lgpl.html]: http://www.gnu.org/licenses/lgpl.html
