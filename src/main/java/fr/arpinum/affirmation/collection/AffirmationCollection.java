package fr.arpinum.affirmation.collection;

import java.util.Collection;

import fr.arpinum.affirmation.Affirmation;
import fr.arpinum.outils.Collections;

public class AffirmationCollection<T> extends Affirmation {

	public AffirmationCollection(Collection<T> valeurs) {
		this.valeurs = valeurs;
	}

	public void sont(Collection<T> valeursAttendues) {
		if (!Collections.egales(valeurs, valeursAttendues)) {
			échoue("Les éléments sont %s et non %s.", this.valeurs, valeursAttendues);
		}
	}

	public void sontAuNombreDe(int nombre) {
		if (valeurs == null) {
			échoue("La collection est nulle et ne possède donc pas un nombre d'éléments de %s.", nombre);
		}
		assert valeurs != null;
		if (valeurs.size() != nombre) {
			échoue("Les éléments sont au nombre de %s et non %s.", valeurs.size(), nombre);
		}
	}

	private final Collection<T> valeurs;
}
