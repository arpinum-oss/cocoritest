package fr.arpinum.affirmations;

import java.util.Collection;
import java.util.Iterator;

import fr.arpinum.outils.Objets;

public class AffirmationCollection<T> {

	public AffirmationCollection(Collection<T> valeurs) {
		this.valeurs = valeurs;
	}

	public void sont(Collection<T> valeursAttendues) {
		if (lesCollectionsSontDifférentes(valeursAttendues)) {
			throw new ExceptionAffirmation(String.format("Les éléments sont %s et non %s.", this.valeurs, valeursAttendues));
		}
	}

	private boolean lesCollectionsSontDifférentes(Collection<T> valeursAttendues) {
		if (valeurs == null || valeursAttendues == null) {
			return valeurs != valeursAttendues;
		}
		return lesTaillesSontDifférentes(valeursAttendues) || lesCollectionsDeMêmeTailleSontDifférentes(valeursAttendues);
	}

	private boolean lesTaillesSontDifférentes(Collection<T> valeursAttendues) {
		return valeurs.size() != valeursAttendues.size();
	}

	private boolean lesCollectionsDeMêmeTailleSontDifférentes(Collection<T> valeursAttendues) {
		for (Iterator<T> premierIterateur = valeurs.iterator(), secondIterateur = valeursAttendues.iterator(); premierIterateur.hasNext(); ) {
			if (Objets.différents(premierIterateur.next(), secondIterateur.next())) {
				return true;
			}
		}
		return false;
	}

	public void sontAuNombreDe(int nombre) {
		if(valeurs == null) {
			throw new ExceptionAffirmation(String.format("La collection est nulle et ne possède donc pas un nombre d'éléments de %s.", nombre));
		}
		if (valeurs.size() != nombre) {
			throw new ExceptionAffirmation(String.format("Les éléments sont au nombre de %s et non %s.", valeurs.size(), nombre));
		}
	}

	private final Collection<T> valeurs;
}
