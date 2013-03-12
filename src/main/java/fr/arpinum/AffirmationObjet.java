package fr.arpinum;

public class AffirmationObjet<T> {

	public AffirmationObjet(T valeur) {
		this.valeur = valeur;
	}

	public <T2> void est(T2 valeur) {
		if (!this.valeur.equals(valeur)) {
			throw new ExceptionAssertion(String.format("attendu: <%s>, obtenu: <%s>", this.valeur, valeur));
		}
	}

	private T valeur;
}
