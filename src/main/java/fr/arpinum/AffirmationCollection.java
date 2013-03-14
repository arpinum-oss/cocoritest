package fr.arpinum;

import java.util.Collection;

public class AffirmationCollection<T> {

	public AffirmationCollection(Collection<T> valeurs) {
		this.valeurs = valeurs;
	}

	public void sont(Collection<Integer> valeursAttendues) {
		if (valeurs.size() != valeursAttendues.size()) {
			throw new ExceptionAssertion(String.format("attendu: <%s>, obtenu: <%s>", this.valeurs, valeursAttendues));
		}
	}

	private Collection<T> valeurs;
}
