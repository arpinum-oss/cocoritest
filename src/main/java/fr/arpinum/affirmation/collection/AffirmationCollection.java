package fr.arpinum.affirmation.collection;

import java.util.Collection;

import fr.arpinum.affirmation.Affirmation;
import fr.arpinum.outils.Collections;
import fr.arpinum.outils.Listes;

public class AffirmationCollection<T> extends Affirmation {

	public AffirmationCollection(Collection<T> éléments) {
		this.éléments = éléments;
	}

	public void sont(Collection<T> élémentsAttendus) {
		if (!Collections.egales(éléments, élémentsAttendus)) {
			échoue("Les éléments sont %s et non %s.", éléments, élémentsAttendus);
		}
	}

	public void sont(T... élémentsAttendus) {
		sont(Listes.cree(élémentsAttendus));
	}

	public void sontAuNombreDe(int nombre) {
		if (éléments == null) {
			échoue("La collection est nulle et ne possède donc pas un nombre d'éléments de %s.", nombre);
		}
		assert éléments != null;
		if (éléments.size() != nombre) {
			échoue("Les éléments sont au nombre de %s et non %s.", éléments.size(), nombre);
		}
	}

	public void ont(Collection<T> élémentsAttendus) {
		if (éléments == null) {
			échoue("La collection est nulle, %s ne sont donc pas présents dedans.", élémentsAttendus);
		}
		assert éléments != null;
		if (!éléments.containsAll(élémentsAttendus)) {
			échoue("%s ne sont pas présents dans %s.", élémentsAttendus, éléments);
		}
	}

	public void ont(T... élémentsAttendus) {
		ont(Listes.cree(élémentsAttendus));
	}

	private final Collection<T> éléments;
}
