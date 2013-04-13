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

package fr.arpinum.cocoritest.outils;

import java.util.Collection;
import java.util.Iterator;

public class Collections {

	public static <T> boolean egales(Collection<T> gauche, Collection<T> droite) {
		if (gauche == null || droite == null) {
			return gauche == droite;
		}
		return mêmesTailles(gauche, droite) && lesCollectionsDeMêmeTailleSontEgales(gauche, droite);
	}

	private static <T> boolean mêmesTailles(Collection<T> gauche, Collection<T> droite) {
		return gauche.size() == droite.size();
	}

	private static <T> boolean lesCollectionsDeMêmeTailleSontEgales(Collection<T> gauche, Collection<T> droite) {
		for (Iterator<T> premierIterateur = gauche.iterator(), secondIterateur = droite.iterator(); premierIterateur.hasNext
				(); ) {
			if (Objets.différents(premierIterateur.next(), secondIterateur.next())) {
				return false;
			}
		}
		return true;
	}
}
