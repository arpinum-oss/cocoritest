package fr.arpinum.cocoritest.affirmation;

import java.util.Collection;

import fr.arpinum.cocoritest.affirmation.booleene.AffirmationBooleene;
import fr.arpinum.cocoritest.affirmation.booleene.AffirmationBooleeneAuFeminin;
import fr.arpinum.cocoritest.affirmation.booleene.AffirmationBooleeneDeBase;
import fr.arpinum.cocoritest.affirmation.collection.AffirmationCollection;
import fr.arpinum.cocoritest.affirmation.collection.AffirmationCollectionDeBase;
import fr.arpinum.cocoritest.affirmation.objet.AffirmationObjet;
import fr.arpinum.cocoritest.affirmation.objet.AffirmationObjetAuFeminin;
import fr.arpinum.cocoritest.affirmation.objet.AffirmationObjetDeBase;

/**
 * Cette fabrique permet de construire les différentes affirmations.
 * <p>
 * Exemples :
 * <pre>
 * 		alorsLe(résultat).estVrai();
 * 		alorsLa(chaîne).est("toto");
 * 		alorsLes(valeurs).sont("a", "b");
 * 	</pre>
 * </p>
 */
public class Affirmations {

	/**
	 * Crée une nouvelle instance de <code>{@link AffirmationBooleene}</code>.
	 *
	 * @param booléen la cible de l'affirmation.
	 * @return l'affirmation créée.
	 */
	public static AffirmationBooleene alorsLe(boolean booléen) {
		return new AffirmationBooleeneDeBase(booléen);
	}

	/**
	 * Crée une nouvelle instance de <code>{@link AffirmationBooleene}</code>.
	 *
	 * @param booléen la cible de l'affirmation.
	 * @return l'affirmation créée.
	 */
	public static AffirmationBooleene alorsCet(boolean booléen) {
		return alorsLe(booléen);
	}

	/**
	 * Crée une nouvelle instance de <code>{@link AffirmationBooleeneAuFeminin}</code>.
	 *
	 * @param booléen la cible de l'affirmation.
	 * @return l'affirmation créée.
	 */
	public static AffirmationBooleeneAuFeminin alorsLa(boolean booléen) {
		return new AffirmationBooleeneDeBase(booléen);
	}

	/**
	 * Crée une nouvelle instance de <code>{@link AffirmationBooleeneAuFeminin}</code>.
	 *
	 * @param booléen la cible de l'affirmation.
	 * @return l'affirmation créée.
	 */
	public static AffirmationBooleeneAuFeminin alorsCette(boolean booléen) {
		return alorsLa(booléen);
	}

	/**
	 * Crée une nouvelle instance de <code>{@link AffirmationObjet}</code>.
	 *
	 * @param objet la cible de l'affirmation.
	 * @return l'affirmation créée.
	 */
	public static <T> AffirmationObjet<T> alorsLe(T objet) {
		return new AffirmationObjetDeBase<T>(objet);
	}

	/**
	 * Crée une nouvelle instance de <code>{@link AffirmationObjet}</code>.
	 *
	 * @param objet la cible de l'affirmation.
	 * @return l'affirmation créée.
	 */
	public static <T> AffirmationObjet<T> alorsCet(T objet) {
		return alorsLe(objet);
	}

	/**
	 * Crée une nouvelle instance de <code>{@link AffirmationObjetAuFeminin}</code>.
	 *
	 * @param objet la cible de l'affirmation.
	 * @return l'affirmation créée.
	 */
	public static <T> AffirmationObjetAuFeminin<T> alorsLa(T objet) {
		return new AffirmationObjetDeBase<T>(objet);
	}

	/**
	 * Crée une nouvelle instance de <code>{@link AffirmationObjetAuFeminin}</code>.
	 *
	 * @param objet la cible de l'affirmation.
	 * @return l'affirmation créée.
	 */
	public static <T> AffirmationObjetAuFeminin<T> alorsCette(T objet) {
		return alorsLa(objet);
	}

	/**
	 * Crée une nouvelle instance de <code>{@link AffirmationCollection}</code>.
	 *
	 * @param éléments les cibles de l'affirmation.
	 * @return l'affirmation créée.
	 */
	public static <T> AffirmationCollection<T> alorsLes(Collection<T> éléments) {
		return AffirmationCollectionDeBase.cree(éléments);
	}
}
