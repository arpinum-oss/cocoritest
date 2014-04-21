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

import fr.arpinum.cocoritest.exception.CapteurException;
import fr.arpinum.cocoritest.injection.Injecteur;
import fr.arpinum.cocoritest.interne.exception.CapteurExceptionDeBase;
import fr.arpinum.cocoritest.interne.injection.InjecteurDeBase;

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
}
