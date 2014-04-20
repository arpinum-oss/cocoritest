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

package fr.arpinum.cocoritest.conjonction.objet;

import fr.arpinum.cocoritest.affirmation.objet.AffirmationObjetAuFeminin;

/**
 * Représente une conjonction utilisée pour chaîner une affirmation au féminin de façon fluide.
 *
 * @param <TObjet> le type de l'objet concerné par l'affirmation.
 */
public interface ConjonctionObjetAuFeminin<TObjet> extends ConjonctionObjet<TObjet, AffirmationObjetAuFeminin<TObjet>> {

}
