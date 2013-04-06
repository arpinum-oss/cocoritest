package fr.arpinum.cocoritest.specification;

/**
 * Représente une spécification d'un objet.
 *
 * @param <T> le type d'objet concerné.
 */
public interface Specification<T> {

	/**
	 * Informe si la spécification est satisfaite par l'objet.
	 *
	 * @param objet l'objet sur lequel est vérifiée la satisfaction de la spécification.
	 * @return true si la spécification est satisfaite par l'objet, faux sinon.
	 */
	boolean estSatisfaitPar(T objet);

	/**
	 * Le message décrivant pourquoi la spécification n'est pas satisfaite par l'objet.
	 *
	 * @param objet l'objet qui ne satisfait pas la spécification.
	 * @return le message décrivant pourquoi la spécification n'est pas satisfaite.
	 */
	String messageInsatisfactionPour(T objet);
}
