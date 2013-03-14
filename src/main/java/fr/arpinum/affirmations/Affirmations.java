package fr.arpinum.affirmations;

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

	public static <T> AffirmationObjet<T> alors(T valeur) {
		return new AffirmationObjet<T>(valeur);
	}

	public static <T> AffirmationObjet<T> alorsLe(T valeur) {
		return alors(valeur);
	}

	public static <T> AffirmationObjet<T> alorsLa(T valeur) {
		return alors(valeur);
	}

	public static <T> AffirmationCollection<T> alors(Collection<T> valeurs) {
		return new AffirmationCollection<T>(valeurs);
	}

	public static <T> AffirmationCollection<T> alorsLes(Collection<T> valeurs) {
		return alors(valeurs);
	}
}
