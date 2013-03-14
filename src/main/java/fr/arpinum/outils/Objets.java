package fr.arpinum.outils;

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
}
