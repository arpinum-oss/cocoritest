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

import fr.arpinum.cocoritest.affirmation.objet.AffirmationObjetAuMasculin;
import fr.arpinum.cocoritest.conjonction.objet.ConjonctionObjetAuMasculin;
import fr.arpinum.cocoritest.interne.conjonction.objet.ConjonctionObjetAuMasculinDeBase;

public class AffirmationObjetAuMasculinDeBase<TObjet> extends AffirmationObjetDeBase<TObjet,
		ConjonctionObjetAuMasculin<TObjet>> implements
		AffirmationObjetAuMasculin<TObjet> {

	public AffirmationObjetAuMasculinDeBase(TObjet objet) {
		super(objet);
	}

	@Override
	public ConjonctionObjetAuMasculin<TObjet> estNul() {
		return est(null);
	}

	@Override
	public ConjonctionObjetAuMasculin<TObjet> nEstPasNul() {
		return nEstPas(null);
	}

	@Override
	protected ConjonctionObjetAuMasculin<TObjet> créeConjonction() {
		return new ConjonctionObjetAuMasculinDeBase<>(this);
	}
}
