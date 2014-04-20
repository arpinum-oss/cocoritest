/*
 * Copyright (C) 2013, Arpinum
 *
 * Cocoritest est un logiciel libre ; vous pouvez le redistribuer ou le modifier suivant les termes de la GNU Lesser
 * General Public License telle que publiée par la Free Software Foundation ; soit la version 3 de la licence,
 * soit (à votre gré) toute version ultérieure.
 *
 * Cocoritest est distribué dans l'espoir qu'il sera utile, mais SANS AUCUNE GARANTIE ; pas même la garantie
 * implicite de COMMERCIABILISABILITÉ ni d'ADÉQUATION à UN OBJECTIF PARTICULIER. Consultez la GNU Lesser General
 * Public License pour plus de détails.
 *
 * Vous devez avoir reçu une copie de la GNU Lesser General Public License en même temps que Cocoritest ; si ce n'est
  * pas le cas, consultez http://www.gnu.org/licenses.
 */

package fr.arpinum.cocoritest.interne.affirmation.objet;

import fr.arpinum.cocoritest.affirmation.objet.AffirmationObjet;
import fr.arpinum.cocoritest.conjonction.Conjonction;
import fr.arpinum.cocoritest.interne.affirmation.Affirmation;
import fr.arpinum.cocoritest.interne.specification.objet.SpecificationAutreObjet;
import fr.arpinum.cocoritest.interne.specification.objet.SpecificationObjet;
import fr.arpinum.cocoritest.specification.Specification;

abstract class AffirmationObjetDeBase<TObjet, TConjonction extends Conjonction<? extends AffirmationObjet<TObjet,
		TConjonction>>> extends Affirmation implements
		AffirmationObjet<TObjet, TConjonction> {

	AffirmationObjetDeBase(TObjet objet) {
		this.objet = objet;
	}

	@Override
	public TConjonction est(TObjet objetAttendu) {
		return respecte(new SpecificationObjet<>(objetAttendu));
	}

	@Override
	public TConjonction nEstPas(TObjet objetNonAttendu) {
		return respecte(new SpecificationAutreObjet<>(objetNonAttendu));
	}

	@Override
	public TConjonction respecte(Specification<TObjet> spécification) {
		échoueSiSpécificationInsatisfaite(spécification);
		return créeConjonction();
	}

	void échoueSiSpécificationInsatisfaite(Specification<TObjet> spécification) {
		if (spécification.estInsatisfaitePar(objet)) {
			échoue(spécification.messageInsatisfactionPour(objet));
		}
	}

	protected abstract TConjonction créeConjonction();

	private final TObjet objet;
}
