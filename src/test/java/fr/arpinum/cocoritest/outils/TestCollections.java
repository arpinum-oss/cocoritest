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

package fr.arpinum.cocoritest.outils;

import static fr.arpinum.cocoritest.affirmation.Affirmations.*;

import java.util.List;

import org.junit.Test;

public class TestCollections {

	@Test
	public void deuxCollectionsDeTaillesDifférentesSontDifférentes() {
		List<Integer> première = Listes.cree(1, 2, 3);
		List<Integer> seconde = Listes.cree(1, 2);

		boolean égalité = Collections.egales(première, seconde);

		alors().cette(égalité).estFausse();
	}

	@Test
	public void deuxCollectionsAvecLesMêmesElémentsSontEgales() {
		List<Integer> première = Listes.cree(1, 2, 3);
		List<Integer> seconde = Listes.cree(1, 2, 3);

		boolean égalité = Collections.egales(première, seconde);

		alors().cette(égalité).estVraie();
	}

	@Test
	public void deuxCollectionsAvecDesElémentsDifférentsSontDifférentes() {
		List<Integer> première = Listes.cree(1, 2, 3);
		List<Integer> seconde = Listes.cree(1, 2, 4);

		boolean égalité = Collections.egales(première, seconde);

		alors().cette(égalité).estFausse();
	}

	@Test
	public void deuxCollectionsNullesSontEgales() {
		boolean égalité = Collections.egales(null, null);

		alors().cette(égalité).estVraie();
	}

	@Test
	public void uneCollectionNulleNEstJamaisEgaleAUneNonNulle() {
		boolean égalitéNulleNonNulle = Collections.egales(null, Listes.cree(1));
		alors().cette(égalitéNulleNonNulle).estFausse();

		boolean égalitéNonNulleNulle = Collections.egales(Listes.cree(1), null);
		alors().cette(égalitéNonNulleNulle).estFausse();
	}
}
