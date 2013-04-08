package fr.arpinum.cocoritest.outils;

import static fr.arpinum.cocoritest.affirmation.Affirmations.*;

import org.junit.Test;

public class TestObjets {

	@Test
	public void ilEstPossibleDeTesterLEgaliteDeDeuxObjets() {
		alorsCette(égalitéEntre("toto", "toto")).estVraie();
		alorsCette(égalitéEntre(3, 3)).estVraie();
		alorsCette(égalitéEntre("toto", 3)).estFausse();
		alorsCette(égalitéEntre(null, null)).estVraie();
		alorsCette(égalitéEntre(null, 3)).estFausse();
		alorsCette(égalitéEntre(3, null)).estFausse();
	}

	private boolean égalitéEntre(Object gauche, Object droite) {
		return Objets.egaux(gauche, droite);
	}

	@Test
	public void deuxObjetsDifférentsLeSontVraiment() {
		boolean inégalité = Objets.différents("toto", "tutu");

		alorsCette(inégalité).estVraie();
	}

	@Test
	public void deuxObjetEgauxNeSontPasDifférents() {
		boolean inégalité = Objets.différents(13, 13);

		alorsCette(inégalité).estFausse();
	}

	@Test
	public void unBooléenVraiEnChaîneEstEnFrançais() {
		String chaîne = Objets.enChaîne(true);

		alorsLa(chaîne).est("vrai");
	}

	@Test
	public void unBooléenFauxEnChaîneEstEnFrançais() {
		String chaîne = Objets.enChaîne(false);

		alorsLa(chaîne).est("faux");
	}

	@Test
	public void unObjetNulEnChaîneEstEnFrançais() {
		String chaîne = Objets.enChaîne(null);

		alorsLa(chaîne).est("nul");
	}

	@Test
	public void unObjetNonNulEnChaîneEstSonToString() {
		Object objet = new Object();

		String chaîne = Objets.enChaîne(objet);

		alorsLa(chaîne).est(objet.toString());
	}
}
