package fr.arpinum;

import java.util.Collection;
import java.util.Iterator;

import fr.arpinum.outil.Objets;

public class AffirmationCollection<T> {

	public AffirmationCollection(Collection<T> valeurs) {
		this.valeurs = valeurs;
	}

	public void sont(Collection<T> valeursAttendues) {
		if (!estSatisfaite(valeursAttendues)) {
			throw new ExceptionAssertion(String.format("Les éléments sont <%s> et non <%s>.", this.valeurs, valeursAttendues));
		}
	}

	private boolean estSatisfaite(Collection<T> valeursAttendues) {
		if (valeurs == null || valeursAttendues == null) {
			return valeurs == valeursAttendues;
		}
		if (valeurs.size() != valeursAttendues.size()) {
			return false;
		}
		return lesElementsSontEgaux(valeursAttendues);
	}

	private boolean lesElementsSontEgaux(Collection<T> valeursAttendues) {
		for (Iterator<T> premierIterateur = valeurs.iterator(), secondIterateur = valeursAttendues.iterator(); premierIterateur.hasNext(); ) {
			if (!Objets.egaux(premierIterateur.next(), secondIterateur.next())) {
				return false;
			}
		}
		return true;
	}

	public void sontAuNombreDe(int nombre) {
		if(valeurs == null) {
			throw new ExceptionAssertion(String.format("La collection est nulle et ne possède donc pas un nombre d'éléments de <%s>.", nombre));
		}
		if (valeurs.size() != nombre) {
			throw new ExceptionAssertion(String.format("Les éléments sont au nombre de <%s> et non <%s>.", valeurs.size(), nombre));
		}
	}

	private Collection<T> valeurs;
}
