package fr.arpinum.cocoritest.affirmation;

/**
 * Le point d'entrée qui permet d'avoir accès à la fabrique d'affirmations.
 * <p>
 * Exemples :
 * <pre>
 * 		alors().le(résultat).estVrai();
 * 		alors().la(chaîne).est("toto");
 * 		alors().les(valeurs).sont("a", "b");
 * 	</pre>
 * </p>
 */
public abstract class Affirmations {

	public static FabriqueAffirmation alors() {
		return new FabriqueAffirmation();
	}
}
