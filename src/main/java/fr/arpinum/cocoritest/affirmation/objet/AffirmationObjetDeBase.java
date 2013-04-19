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

package fr.arpinum.cocoritest.affirmation.objet;

import fr.arpinum.cocoritest.affirmation.Affirmation;
import fr.arpinum.cocoritest.specification.Specification;
import fr.arpinum.cocoritest.specification.objet.SpecificationAutreObjet;
import fr.arpinum.cocoritest.specification.objet.SpecificationObjet;

public class AffirmationObjetDeBase<T> extends Affirmation implements AffirmationObjet<T>,
		AffirmationObjetAuFeminin<T> {

	public AffirmationObjetDeBase(T objet) {
		this.objet = objet;
	}

	@Override
	public void est(T objetAttendu) {
		respecte(new SpecificationObjet<T>(objetAttendu));
	}

	@Override
	public void nEstPas(T objetNonAttendu) {
		respecte(new SpecificationAutreObjet<T>(objetNonAttendu));
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
		if (spécification.estInsatisfaitePar(objet)) {
			échoue(spécification.messageInsatisfactionPour(objet));
		}
	}

	private final T objet;
}
