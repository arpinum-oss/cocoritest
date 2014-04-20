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

import fr.arpinum.cocoritest.conjonction.Conjonction;

/**
 * Représente une affirmation concernant un objet typé.
 *
 * @param <TObjet> le type de l'objet concerné par l'affirmation.
 */
public interface AffirmationObjetAuMasculin<TObjet> extends AffirmationObjet<TObjet,
		Conjonction<AffirmationObjetAuMasculin<TObjet>>> {

	/**
	 * Affirme que l'objet est nul.
	 *
	 * @return une conjonction pour chaîner d'autres affirmations
	 * @throws fr.arpinum.cocoritest.interne.affirmation.ExceptionAffirmation si l'affirmation est erronée.
	 */
	Conjonction<AffirmationObjetAuMasculin<TObjet>> estNul();

	/**
	 * Affirme que l'objet n'est pas nul.
	 *
	 * @return une conjonction pour chaîner d'autres affirmations
	 * @throws fr.arpinum.cocoritest.interne.affirmation.ExceptionAffirmation si l'affirmation est erronée.
	 */
	Conjonction<AffirmationObjetAuMasculin<TObjet>> nEstPasNul();
}
