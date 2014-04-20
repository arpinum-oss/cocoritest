/*
 * Copyright (C) 2013, Arpinum
 *
 * Cocoritest est un logiciel libre ; vous pouvez le redistribuer ou le modifier suivant les termes de la GNU Lesser
 * General Public License telle que publiée par la Free Software Foundation ; soit la version 3 de la licence,
 * soit (à votre gré) toute version ultérieure.
 *
 * Cocoritest est distribué dans l'espoir qu'il sera utile, mais SANS AUCUNE GARANTIE ; pas même la garantie
 * implicite de COMMERCIABILISABILITÉ ni d'ADÉQUATION à UN OBJECTIF PARTICULIER. Consultez la GNU Lesser General
 * Public License pour plus de détails.
 *
 * Vous devez avoir reçu une copie de la GNU Lesser General Public License en même temps que Cocoritest ; si ce n'est
  * pas le cas, consultez http://www.gnu.org/licenses.
 */

package fr.arpinum.cocoritest;

import java.util.List;

import fr.arpinum.cocoritest.exception.CapteurException;
import fr.arpinum.cocoritest.injection.Injecteur;
import fr.arpinum.cocoritest.interne.exception.CapteurExceptionDeBase;
import fr.arpinum.cocoritest.interne.injection.InjecteurDeBase;
import fr.arpinum.cocoritest.interne.specification.SpecificationCombinee;
import fr.arpinum.cocoritest.specification.Specification;

/**
 * Fabrique qui permet de construire les différents outils.
 */
public class Outils {

	/**
	 * Crée une nouvelle instance d'un capteur d'exception.
	 *
	 * @return le capteur créé.
	 */
	public static CapteurException créeCapteur() {
		return new CapteurExceptionDeBase();
	}

	/**
	 * Crée une nouvelle instance de l'injecteur de dépendance.
	 *
	 * @param objet la cible de l'injection.
	 * @return l'injecteur créé.
	 */
	public static Injecteur créeInjecteur(Object objet) {
		return new InjecteurDeBase(objet);
	}

	/**
	 * Crée une spécification qui combine un ensemble de spécifications.
	 *
	 * @param spécifications les spécifications à combiner.
	 * @param <T>            le type de l'objet concerné par la spécification.
	 * @return la spécification créée.
	 */
	public static <T> Specification<T> combine(final List<Specification<T>> spécifications) {
		return new SpecificationCombinee<>(spécifications);
	}
}
