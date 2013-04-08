package fr.arpinum.cocoritest.outils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Listes {

	public static <T> List<T> cree(T... éléments) {
		List<T> liste = new ArrayList<>();
		Collections.addAll(liste, éléments);
		return liste;
	}
}
