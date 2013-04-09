package fr.arpinum.cocoritest.affirmation.collection;

import java.util.Collection;

import fr.arpinum.cocoritest.affirmation.Affirmation;
import fr.arpinum.cocoritest.outils.Listes;
import fr.arpinum.cocoritest.specification.Specification;
import fr.arpinum.cocoritest.specification.SpecificationCollection;
import fr.arpinum.cocoritest.specification.SpecificationElementsDansLaCollection;
import fr.arpinum.cocoritest.specification.SpecificationTailleDeCollection;

public class AffirmationCollectionDeBase<E> extends Affirmation implements AffirmationCollection<E> {

	public static <E> AffirmationCollection<E> cree(Collection<E> éléments) {
		if (éléments == null) {
			return new AffirmationCollectionNulle<E>();
		}
		return new AffirmationCollectionDeBase<E>(éléments);
	}

	AffirmationCollectionDeBase(Collection<E> éléments) {
		this.éléments = éléments;
	}

	@Override
	public void sont(Collection<E> élémentsAttendus) {
		respectent(new SpecificationCollection<E>(élémentsAttendus));
	}

	@Override
	public void sont(E... élémentsAttendus) {
		sont(Listes.cree(élémentsAttendus));
	}

	@Override
	public void sontAuNombreDe(int nombre) {
		assureInvariant();
		respectent(new SpecificationTailleDeCollection<E>(nombre));
	}

	@Override
	public void nExistentPas() {
		sontAuNombreDe(0);
	}

	@Override
	public void ont(Collection<E> élémentsAttendus) {
		assureInvariant();
		respectent(new SpecificationElementsDansLaCollection<E>(élémentsAttendus));
	}

	@Override
	public void ont(E... élémentsAttendus) {
		ont(Listes.cree(élémentsAttendus));
	}

	private void assureInvariant() {
		assert éléments != null;
	}

	@Override
	public void respectent(Specification<Collection<E>> spécification) {
		if (!spécification.estSatisfaitePar(éléments)) {
			échoue(spécification.messageInsatisfactionPour(éléments));
		}
	}

	private final Collection<E> éléments;
}
