package fr.arpinum.outil;

import java.util.ArrayList;
import java.util.List;

public class Listes {

	public static <T> List<T> cree(T... éléments) {
		List<T> liste = new ArrayList<T>();
		for (T élément : éléments) {
			liste.add(élément);
		}
		return liste;
	}
}
