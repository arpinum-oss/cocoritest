package fr.arpinum.affirmation.collection;

import java.util.Collection;

import fr.arpinum.affirmation.ExceptionAffirmation;
import fr.arpinum.outils.Collections;

public class AffirmationCollection<T> {

	public AffirmationCollection(Collection<T> valeurs) {
		this.valeurs = valeurs;
	}

	public void sont(Collection<T> valeursAttendues) {
		if (!Collections.egales(valeurs, valeursAttendues)) {
			throw new ExceptionAffirmation(String.format("Les éléments sont %s et non %s.", this.valeurs, valeursAttendues));
		}
	}

	public void sontAuNombreDe(int nombre) {
		if (valeurs == null) {
			throw new ExceptionAffirmation(String.format("La collection est nulle et ne possède donc pas un nombre d'éléments de %s.", nombre));
		}
		if (valeurs.size() != nombre) {
			throw new ExceptionAffirmation(String.format("Les éléments sont au nombre de %s et non %s.", valeurs.size(), nombre));
		}
	}

	private final Collection<T> valeurs;
}
