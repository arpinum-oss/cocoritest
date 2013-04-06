package fr.arpinum.cocoritest.affirmation.objet;

import fr.arpinum.cocoritest.affirmation.Affirmation;
import fr.arpinum.cocoritest.specification.Specification;
import fr.arpinum.cocoritest.specification.SpecificationObjetsDifferents;
import fr.arpinum.cocoritest.specification.SpecificationObjetsEgaux;

public class AffirmationObjetDeBase<T> extends Affirmation implements AffirmationObjet<T>, AffirmationObjetAuFeminin<T> {

	public AffirmationObjetDeBase(T valeur) {
		this.valeur = valeur;
	}

	@Override
	public void est(T valeurAttendue) {
		Specification<T> spécification = new SpecificationObjetsEgaux<T>(valeur);
		if (!spécification.estSatisfaitPar(valeurAttendue)) {
			échoue(spécification.messageInsatisfactionPour(valeurAttendue));
		}
	}

	@Override
	public void nEstPas(T valeurNonAttendue) {
		Specification<T> spécification = new SpecificationObjetsDifferents<T>(valeur);
		if (!spécification.estSatisfaitPar(valeurNonAttendue)) {
			échoue(spécification.messageInsatisfactionPour(valeurNonAttendue));
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
		if (!spécification.estSatisfaitPar(valeur)) {
			échoue(spécification.messageInsatisfactionPour(valeur));
		}
	}

	private final T valeur;
}
