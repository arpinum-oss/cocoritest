# Cocoritest

> Mal nommer les choses c'est ajouter au malheur du monde.
> <cite>(Albert Camus)</cite>

**Cocoritest** est une api Java permettant d'écrire des affirmations de test unitaire dans une syntaxe proche du **français**. 

Elle s'inspire des excellents et complets [Hamcrest] ou [FEST] et n'a pas pour prétention d'être une quelconque alternative. Toutefois, **Cocoritest** convient parfaitement pour s'exercer en TDD sur des Katas.

## Exemples ##
*(les accents ou cédilles sont retirés des exemples car ils sont mal gérés par le moteur de rendu de code utilisé par Github)*

* Affirmations sur un objet :
```java
@Test
public void unBooleenVraiEnChaineEstEnFrancais() {
    String chaine = Objets.enChaine(true);

    alors().la(chaine).nEstPasNulle();
    alors().la(chaine).est("vrai");
}
```

* Affirmations sur un booléen :
```java
@Test
public void deuxCollectionsNullesSontEgales() {
    boolean resultat = Collections.egales(null, null);

    alors().le(resultat).estVrai();
}
```

* Affirmations sur une collection :
```java
@Test
public void peutCreerUneListe() {
    List<String> elements = Listes.cree("a", "b");
 
    alors().les(elements).sontAuNombreDe(2); 
    alors().les(elements).sont("a", "b");
}
```

Les affirmations concernant les collections sont accessibles depuis la fabrique `les(...)` ce qui sous-entend que vos collections ne doivent pas être nommées `listeChaine` ou `entierList` mais en plaçant les éléments au pluriel comme `chaines` ou `entiers`.
D'une façon général en français nous disons *j'ai acheté des bonbons à mes enfants* et non *j'ai acheté une liste de bonbons à ma liste d'enfants*.

## Utilisation ##
* Au niveau d'un pom.xml de Maven :
```
todo
```

* Au niveau des imports Java :
```java
import static fr.arpinum.cocoritest.affirmation.Affirmations.*;
```

## Cartographie de l'api ##
![alt text](http://www.arpinum.fr/images/cocoritest/cartographie.jpg "Cartographie de Cocoritest")

[Hamcrest]: http://hamcrest.org/
[FEST]: https://code.google.com/p/fest/
