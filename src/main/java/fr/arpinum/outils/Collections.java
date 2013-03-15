package fr.arpinum.outils;

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
		for (Iterator<T> premierIterateur = gauche.iterator(), secondIterateur = droite.iterator(); premierIterateur.hasNext(); ) {
			if (Objets.différents(premierIterateur.next(), secondIterateur.next())) {
				return false;
			}
		}
		return true;
	}
}
