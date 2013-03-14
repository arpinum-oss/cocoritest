package fr.arpinum;

import java.util.Collection;

public class Affirmations {

	public static AffirmationBooleeneAuMasculin alors(boolean valeur) {
		return new AffirmationBooleeneAuMasculin(valeur);
	}

	public static AffirmationBooleeneAuMasculin alorsLe(boolean booléen) {
		return alors(booléen);
	}

	public static AffirmationBooleeneAuFeminin alorsLa(boolean booléen) {
		return new AffirmationBooleeneAuFeminin(booléen);
	}

	public static <T> AffirmationObjet alors(T valeur) {
		return new AffirmationObjet(valeur);
	}

	public static <T> AffirmationObjet alorsLe(T valeur) {
		return alors(valeur);
	}

	public static <T> AffirmationObjet alorsLa(T valeur) {
		return alors(valeur);
	}

	public static <T> AffirmationCollection alors(Collection<T> valeurs) {
		return new AffirmationCollection(valeurs);
	}

	public static <T> AffirmationCollection alorsLes(Collection<T> valeurs) {
		return alors(valeurs);
	}
}
