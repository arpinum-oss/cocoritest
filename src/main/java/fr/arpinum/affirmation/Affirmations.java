package fr.arpinum.affirmation;

import java.util.Collection;

import fr.arpinum.affirmation.booleene.AffirmationBooleene;
import fr.arpinum.affirmation.booleene.AffirmationBooleeneAuFeminin;
import fr.arpinum.affirmation.booleene.AffirmationBooleeneDeBase;
import fr.arpinum.affirmation.collection.AffirmationCollection;
import fr.arpinum.affirmation.objet.AffirmationObjet;
import fr.arpinum.affirmation.objet.AffirmationObjetAuFeminin;
import fr.arpinum.affirmation.objet.AffirmationObjetDeBase;

public class Affirmations {

	public static AffirmationBooleene alorsLe(boolean booléen) {
		return new AffirmationBooleeneDeBase(booléen);
	}

	public static AffirmationBooleeneAuFeminin alorsLa(boolean booléen) {
		return new AffirmationBooleeneDeBase(booléen);
	}

	public static <T> AffirmationObjet<T> alorsLe(T valeur) {
		return new AffirmationObjetDeBase<T>(valeur);
	}

	public static <T> AffirmationObjetAuFeminin<T> alorsLa(T valeur) {
		return new AffirmationObjetDeBase<T>(valeur);
	}

	public static <T> AffirmationCollection<T> alorsLes(Collection<T> valeurs) {
		return new AffirmationCollection<T>(valeurs);
	}
}
