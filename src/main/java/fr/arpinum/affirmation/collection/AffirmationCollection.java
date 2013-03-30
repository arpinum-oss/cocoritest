package fr.arpinum.affirmation.collection;

import java.util.Collection;

import fr.arpinum.affirmation.Affirmation;
import fr.arpinum.outils.Collections;
import fr.arpinum.outils.Listes;

public class AffirmationCollection<T> extends Affirmation {

	public static <T> AffirmationCollection<T> cree(Collection<T> éléments) {
		if (éléments == null) {
			return new AffirmationCollectionNulle<T>();
		}
		return new AffirmationCollection<T>(éléments);
	}

	AffirmationCollection(Collection<T> éléments) {
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
		assureInvariant();
		if (éléments.size() != nombre) {
			échoue("Les éléments sont au nombre de %s et non %s.", éléments.size(), nombre);
		}
	}

	public void nExistentPas() {
		sontAuNombreDe(0);
	}

	public void ont(Collection<T> élémentsAttendus) {
		assureInvariant();
		if (!éléments.containsAll(élémentsAttendus)) {
			échoue("%s ne sont pas présents dans %s.", élémentsAttendus, éléments);
		}
	}

	public void ont(T... élémentsAttendus) {
		ont(Listes.cree(élémentsAttendus));
	}

	private void assureInvariant() {
		assert éléments != null;
	}

	private final Collection<T> éléments;
}
