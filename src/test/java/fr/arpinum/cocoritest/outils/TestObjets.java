package fr.arpinum.cocoritest.outils;

import static fr.arpinum.cocoritest.affirmation.Affirmations.*;

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
