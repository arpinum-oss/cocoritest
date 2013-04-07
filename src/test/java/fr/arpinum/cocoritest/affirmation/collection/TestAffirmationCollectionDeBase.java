package fr.arpinum.cocoritest.affirmation.collection;

import java.util.Collection;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fr.arpinum.cocoritest.affirmation.ExceptionAffirmation;
import fr.arpinum.cocoritest.outils.Listes;
import fr.arpinum.cocoritest.specification.Specification;

public class TestAffirmationCollectionDeBase {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void onPeutAffirmerQuUneCollectionEstEgaleAUneAutre() {
		List<Integer> valeursTestées = Listes.cree(1, 2, 3);
		List<Integer> valeursAttendues = Listes.cree(1, 2, 3);

		AffirmationCollectionDeBase.cree(valeursTestées).sont(valeursAttendues);
		AffirmationCollectionDeBase.cree(valeursTestées).sont(1, 2, 3);
	}

	@Test
	public void onNePeutPasAffirmerQUneCollectionEstEgaleAUneCollectionDifférente() {
		List<Integer> valeursTestées = Listes.cree(1, 2, 3);
		List<Integer> valeursAttendues = Listes.cree(2, 3);
		exception.expect(ExceptionAffirmation.class);
		exception.expectMessage("Les éléments sont [1, 2, 3] et non [2, 3].");

		AffirmationCollectionDeBase.cree(valeursTestées).sont(valeursAttendues);
	}

	@Test
	public void onNePeutPasAffirmerQUneCollectionEstEgaleADesElémentsNonContenus() {
		List<Integer> valeursTestées = Listes.cree(1, 2, 3);
		exception.expect(ExceptionAffirmation.class);
		exception.expectMessage("Les éléments sont [1, 2, 3] et non [2, 3].");

		AffirmationCollectionDeBase.cree(valeursTestées).sont(2, 3);
	}

	@Test
	public void onPeutAffirmerQuUneCollectionPossèdeUnCertainsNombreDElements() {
		AffirmationCollectionDeBase.cree(Listes.cree(1, 2)).sontAuNombreDe(2);
	}

	@Test
	public void onNePeutPasAffirmerQuUneCollectionPossèdeUnNombreErronéDElements() {
		exception.expect(ExceptionAffirmation.class);
		exception.expectMessage("Les éléments sont au nombre de 2 et non 10.");

		AffirmationCollectionDeBase.cree(Listes.cree("a", "b")).sontAuNombreDe(10);
	}

	@Test
	public void onNePeutPasAffirmerQuUneCollectionNonVideEstVide() {
		exception.expect(ExceptionAffirmation.class);
		exception.expectMessage("Les éléments sont au nombre de 1 et non 0.");

		AffirmationCollectionDeBase.cree(Listes.cree(3)).nExistentPas();
	}

	@Test
	public void onPeutAffirmerQuUneCollectionAUnElément() {
		AffirmationCollectionDeBase.cree(Listes.cree(1, 3, 13)).ont(13);
	}

	@Test
	public void onPeutAffirmerQuUneCollectionADesEléments() {
		AffirmationCollectionDeBase.cree(Listes.cree(1, 3, 13)).ont(13, 3);
	}

	@Test
	public void onNePeutPasAffirmerQuUneCollectionAUnElémentQuElleNAPas() {
		exception.expect(ExceptionAffirmation.class);
		exception.expectMessage("[13, 12] ne sont pas présents dans [1, 2].");

		AffirmationCollectionDeBase.cree(Listes.cree(1, 2)).ont(13, 12);
	}

	@Test
	public void onPeutAffirmerQuUneCollectionRespecteUneSpécification() {
		AffirmationCollectionDeBase.cree(Listes.cree(1, 2)).respectent(créeSpecificationToujoursSatisfaite());
	}

	private Specification<Collection<Integer>> créeSpecificationToujoursSatisfaite() {
		return new Specification<Collection<Integer>>() {
			@Override
			public boolean estSatisfaitePar(Collection<Integer> objet) {
				return true;
			}

			@Override
			public String messageInsatisfactionPour(Collection<Integer> objet) {
				return "non utilisé";
			}
		};
	}

	@Test
	public void onNePeutPasAffirmerATortQuUneCollectionRespecteUneSpécification() {
		exception.expect(ExceptionAffirmation.class);
		exception.expectMessage("[1, 2] ne respectent pas la spécification.");

		AffirmationCollectionDeBase.cree(Listes.cree(1, 2)).respectent(créeSpecificationJamaisSatisfaite());
	}

	private Specification<Collection<Integer>> créeSpecificationJamaisSatisfaite() {
		return new Specification<Collection<Integer>>() {
			@Override
			public boolean estSatisfaitePar(Collection<Integer> objet) {
				return false;
			}

			@Override
			public String messageInsatisfactionPour(Collection<Integer> objet) {
				return objet + " ne respectent pas la spécification.";
			}
		};
	}
}
