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

package fr.arpinum.cocoritest.affirmation.collection;

import java.util.Collection;

public class AffirmationCollectionNulle<T> extends AffirmationCollectionDeBase<T> {

	AffirmationCollectionNulle() {
		super(null);
	}

	public void sontAuNombreDe(int nombre) {
		échoue("La collection est nulle et ne possède donc pas un nombre d'éléments de %s.", nombre);
	}

	public void ont(Collection<T> élémentsAttendus) {
		échoue("La collection est nulle, %s ne sont donc pas présents dedans.", élémentsAttendus);
	}
}
