package fr.arpinum.affirmation.collection;

import java.util.Collection;

public class AffirmationCollectionNulle<T> extends AffirmationCollectionDeBase<T> {

	AffirmationCollectionNulle() {
		super(null);
	}

	public void sontAuNombreDe(int nombre) {
		échoue("La collection est nulle et ne possède donc pas un nombre d'éléments de %s.", nombre);
	}

	public void ont(Collection<T> élémentsAttendus) {
		échoue("La collection est nulle, %s ne sont donc pas présents dedans.", élémentsAttendus);
	}
}
