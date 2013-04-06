package fr.arpinum.cocoritest.outils;

public class Objets {

	public static boolean egaux(Object gauche, Object droite) {
		if (gauche == null) {
			return droite == null;
		}
		return gauche.equals(droite);
	}

	public static boolean différents(Object gauche, Object droite) {
		return !egaux(gauche, droite);
	}

	public static String enChaîne(Object objet) {
		if (objet == null) {
			return "nul";
		}
		if (objet instanceof Boolean) {
			return ((Boolean) objet) ? "vrai" : "faux";
		}
		return objet.toString();
	}
}
