package fr.arpinum.cocoritest.affirmation.collection;

import java.util.Collection;

import fr.arpinum.cocoritest.affirmation.Affirmation;
import fr.arpinum.cocoritest.outils.Collections;
import fr.arpinum.cocoritest.outils.Listes;

public class AffirmationCollectionDeBase<T> extends Affirmation implements AffirmationCollection<T> {

	public static <T> AffirmationCollection<T> cree(Collection<T> éléments) {
		if (éléments == null) {
			return new AffirmationCollectionNulle<T>();
		}
		return new AffirmationCollectionDeBase<T>(éléments);
	}

	AffirmationCollectionDeBase(Collection<T> éléments) {
		this.éléments = éléments;
	}

	@Override
	public void sont(Collection<T> élémentsAttendus) {
		if (!Collections.egales(éléments, élémentsAttendus)) {
			échoue("Les éléments sont %s et non %s.", éléments, élémentsAttendus);
		}
	}

	@Override
	public void sont(T... élémentsAttendus) {
		sont(Listes.cree(élémentsAttendus));
	}

	@Override
	public void sontAuNombreDe(int nombre) {
		assureInvariant();
		if (éléments.size() != nombre) {
			échoue("Les éléments sont au nombre de %s et non %s.", éléments.size(), nombre);
		}
	}

	@Override
	public void nExistentPas() {
		sontAuNombreDe(0);
	}

	@Override
	public void ont(Collection<T> élémentsAttendus) {
		assureInvariant();
		if (!éléments.containsAll(élémentsAttendus)) {
			échoue("%s ne sont pas présents dans %s.", élémentsAttendus, éléments);
		}
	}

	@Override
	public void ont(T... élémentsAttendus) {
		ont(Listes.cree(élémentsAttendus));
	}

	private void assureInvariant() {
		assert éléments != null;
	}

	private final Collection<T> éléments;
}
