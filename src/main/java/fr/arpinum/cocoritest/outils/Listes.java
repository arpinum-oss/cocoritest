package fr.arpinum.cocoritest.outils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Listes {

	public static <E> List<E> cree(E... éléments) {
		List<E> liste = new ArrayList<E>();
		Collections.addAll(liste, éléments);
		return liste;
	}
}
