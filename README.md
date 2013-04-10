# Cocoritest

> Mal nommer les choses c'est ajouter au malheur du monde.
> <cite>(Albert Camus)</cite>

**Cocoritest** est une api Java permettant d'écrire des affirmations de test unitaire dans une syntaxe proche du **français**. 

Elle s'inspire des excellents et complets [Hamcrest] ou [FEST] et n'a pas pour prétention d'être une quelconque alternative. Toutefois, **Cocoritest** convient parfaitement pour s'exercer en TDD sur des Katas.

## Exemples ##

### Affirmation sur un objet ###
```java
@Test
public void unBooleenVraiEnChaineEstEnFrancais() {
    String chaine = Objets.enChaine(true);

    alors().la(chaine).nEstPasNulle();
    alors().la(chaine).est("vrai");
}
```

### Affirmation sur un booléen ###
```java
@Test
public void deuxCollectionsNullesSontEgales() {
    boolean comparaison = Collections.egales(null, null);

    alors().cette(comparaison).estVraie();
}
```

### Affirmation sur une collection ###
```java
@Test
public void peutCreerUneListe() {
    List<String> elements = Listes.cree("a", "b");
 
    alors().les(elements).sontAuNombreDe(2); 
    alors().les(elements).sont("a", "b");
}
```

[Hamcrest]: http://hamcrest.org/
[FEST]: https://code.google.com/p/fest/
