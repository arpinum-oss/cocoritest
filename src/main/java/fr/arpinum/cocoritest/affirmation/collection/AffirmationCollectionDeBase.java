package fr.arpinum.cocoritest.affirmation.collection;

import java.util.Collection;

import fr.arpinum.cocoritest.affirmation.Affirmation;
import fr.arpinum.cocoritest.outils.Listes;
import fr.arpinum.cocoritest.specification.Specification;
import fr.arpinum.cocoritest.specification.SpecificationCollection;
import fr.arpinum.cocoritest.specification.SpecificationTailleDeCollection;

public class AffirmationCollectionDeBase<E> extends Affirmation implements AffirmationCollection<E> {

	public static <T> AffirmationCollection<T> cree(Collection<T> éléments) {
		if (éléments == null) {
			return new AffirmationCollectionNulle<T>();
		}
		return new AffirmationCollectionDeBase<T>(éléments);
	}

	AffirmationCollectionDeBase(Collection<E> éléments) {
		this.éléments = éléments;
	}

	@Override
	public void sont(Collection<E> élémentsAttendus) {
		respectent(new SpecificationCollection<E, Collection<E>>(élémentsAttendus));
	}

	@Override
	public void sont(E... élémentsAttendus) {
		sont(Listes.cree(élémentsAttendus));
	}

	@Override
	public void sontAuNombreDe(int nombre) {
		assureInvariant();
		respectent(new SpecificationTailleDeCollection<E, Collection<E>>(nombre));
	}

	@Override
	public void nExistentPas() {
		sontAuNombreDe(0);
	}

	@Override
	public void ont(Collection<E> élémentsAttendus) {
		assureInvariant();
		if (!éléments.containsAll(élémentsAttendus)) {
			échoue("%s ne sont pas présents dans %s.", élémentsAttendus, éléments);
		}
	}

	@Override
	public void ont(E... élémentsAttendus) {
		ont(Listes.cree(élémentsAttendus));
	}

	private void assureInvariant() {
		assert éléments != null;
	}

	private void respectent(Specification<Collection<E>> spécification) {
		if (!spécification.estSatisfaitePar(éléments)) {
			échoue(spécification.messageInsatisfactionPour(éléments));
		}
	}

	private final Collection<E> éléments;
}
