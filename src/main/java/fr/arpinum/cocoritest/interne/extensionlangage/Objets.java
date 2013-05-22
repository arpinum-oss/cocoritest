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

package fr.arpinum.cocoritest.interne.extensionlangage;

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
