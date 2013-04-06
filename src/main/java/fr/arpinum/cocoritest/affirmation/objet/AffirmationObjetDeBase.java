package fr.arpinum.cocoritest.affirmation.objet;

import fr.arpinum.cocoritest.affirmation.Affirmation;
import fr.arpinum.cocoritest.specification.Specification;
import fr.arpinum.cocoritest.specification.SpecificationAutreObjet;
import fr.arpinum.cocoritest.specification.SpecificationObjet;

public class AffirmationObjetDeBase<T> extends Affirmation implements AffirmationObjet<T>, AffirmationObjetAuFeminin<T> {

	public AffirmationObjetDeBase(T objet) {
		this.objet = objet;
	}

	@Override
	public void est(T objetAttendu) {
		Specification<T> spécification = new SpecificationObjet<T>(objet);
		if (!spécification.estSatisfaitePar(objetAttendu)) {
			échoue(spécification.messageInsatisfactionPour(objetAttendu));
		}
	}

	@Override
	public void nEstPas(T objetNonAttendu) {
		Specification<T> spécification = new SpecificationAutreObjet<T>(objet);
		if (!spécification.estSatisfaitePar(objetNonAttendu)) {
			échoue(spécification.messageInsatisfactionPour(objetNonAttendu));
		}
	}

	@Override
	public void estNul() {
		est(null);
	}

	@Override
	public void nEstPasNul() {
		nEstPas(null);
	}

	@Override
	public void estNulle() {
		estNul();
	}

	@Override
	public void nEstPasNulle() {
		nEstPasNul();
	}

	@Override
	public void respecte(Specification<T> spécification) {
		if (!spécification.estSatisfaitePar(objet)) {
			échoue(spécification.messageInsatisfactionPour(objet));
		}
	}

	private final T objet;
}
