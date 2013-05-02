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

package fr.arpinum.cocoritest.extensionlangage;

import static fr.arpinum.cocoritest.Affirmations.*;

import org.junit.Test;

public class TestObjets {

	@Test
	public void ilEstPossibleDeTesterLEgaliteDeDeuxObjets() {
		alors().cette(égalitéEntre("toto", "toto")).estVraie();
		alors().cette(égalitéEntre(3, 3)).estVraie();
		alors().cette(égalitéEntre("toto", 3)).estFausse();
		alors().cette(égalitéEntre(null, null)).estVraie();
		alors().cette(égalitéEntre(null, 3)).estFausse();
		alors().cette(égalitéEntre(3, null)).estFausse();
	}

	private boolean égalitéEntre(Object gauche, Object droite) {
		return Objets.egaux(gauche, droite);
	}

	@Test
	public void deuxObjetsDifférentsLeSontVraiment() {
		boolean inégalité = Objets.différents("toto", "tutu");

		alors().cette(inégalité).estVraie();
	}

	@Test
	public void deuxObjetEgauxNeSontPasDifférents() {
		boolean inégalité = Objets.différents(13, 13);

		alors().cette(inégalité).estFausse();
	}

	@Test
	public void unBooléenVraiEnChaîneEstEnFrançais() {
		String chaîne = Objets.enChaîne(true);

		alors().la(chaîne).nEstPasNulle();
		alors().la(chaîne).est("vrai");
	}

	@Test
	public void unBooléenFauxEnChaîneEstEnFrançais() {
		String chaîne = Objets.enChaîne(false);

		alors().la(chaîne).est("faux");
	}

	@Test
	public void unObjetNulEnChaîneEstEnFrançais() {
		String chaîne = Objets.enChaîne(null);

		alors().la(chaîne).est("nul");
	}

	@Test
	public void unObjetNonNulEnChaîneEstSonToString() {
		Object objet = new Object();

		String chaîne = Objets.enChaîne(objet);

		alors().la(chaîne).est(objet.toString());
	}
}
