/*
 * Copyright (C) 2013, Arpinum
 *
 * Cocoritest est un logiciel libre ; vous pouvez le redistribuer ou le modifier suivant les termes de la GNU Lesser
 * General Public License telle que publiée par la Free Software Foundation ; soit la version 3 de la licence,
 * soit (à votre gré) toute version ultérieure.
 *
 * Cocoritest est distribué dans l'espoir qu'il sera utile, mais SANS AUCUNE GARANTIE ; pas même la garantie
 * implicite de COMMERCIABILISABILITÉ ni d'ADÉQUATION à UN OBJECTIF PARTICULIER. Consultez la GNU Lesser General
 * Public License pour plus de détails.
 *
 * Vous devez avoir reçu une copie de la GNU Lesser General Public License en même temps que Cocoritest ; si ce n'est
  * pas le cas, consultez http://www.gnu.org/licenses.
 */

package fr.arpinum.cocoritest.interne.affirmation.collection;

import static fr.arpinum.cocoritest.Affirmations.*;
import static fr.arpinum.cocoritest.FabriquePourTest.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.arpinum.cocoritest.interne.exception.CapteurExceptionDeBase;
import fr.arpinum.cocoritest.interne.extensionlangage.Listes;
import fr.arpinum.cocoritest.specification.Specification;

public class TestAffirmationCollectionDeBase {

	@Before
	public void avantChaqueTest() {
		capteur = new CapteurExceptionDeBase();
	}

	@Test
	public void onPeutAffirmerQuUneCollectionEstEgaleAUneAutre() {
		List<Integer> valeursTestées = Listes.cree(1, 2, 3);
		List<Integer> valeursAttendues = Listes.cree(1, 2, 3);

		alors().les(valeursTestées).sont(valeursAttendues);
		alors().les(valeursTestées).sont(1, 2, 3);
	}

	@Test
	public void onNePeutPasAffirmerQUneCollectionEstEgaleAUneCollectionDifférente() {
		final List<Integer> valeursTestées = Listes.cree(1, 2, 3);
		final List<Integer> valeursAttendues = Listes.cree(2, 3);

		Exception exception = capteur.capte(() -> alors().les(valeursTestées).sont(valeursAttendues));

		String messageAttendu = "Les éléments sont <[1, 2, 3]> au lieu de <[2, 3]>.";
		alors().cette(exception).respecte(créeSpécificationException(messageAttendu));
	}

	@Test
	public void onNePeutPasAffirmerQUneCollectionEstEgaleADesElémentsNonContenus() {
		final List<Integer> valeursTestées = Listes.cree(1, 2, 3);

		Exception exception = capteur.capte(() -> alors().les(valeursTestées).sont(2, 3));

		String messageAttendu = "Les éléments sont <[1, 2, 3]> au lieu de <[2, 3]>.";
		alors().cette(exception).respecte(créeSpécificationException(messageAttendu));
	}

	@Test
	public void onPeutAffirmerQuUneCollectionPossèdeUnCertainsNombreDElements() {
		alors().les(Listes.cree(1, 2)).sontAuNombreDe(2);
	}

	@Test
	public void onNePeutPasAffirmerQuUneCollectionPossèdeUnNombreErronéDElements() {
		List<String> éléments = Listes.cree("a", "b");

		Exception exception = capteur.capte(() -> alors().les(éléments).sontAuNombreDe(10));

		String messageAttendu = "Les éléments sont au nombre de <2> au lieu de <10>.";
		alors().cette(exception).respecte(créeSpécificationException(messageAttendu));
	}

	@Test
	public void onNePeutPasAffirmerQuUneCollectionNullePossedeUnQuelconqueNombreDEléments() {
		List<Object> éléments = ELEMENTS_NULS;

		Exception exception = capteur.capte(() -> alors().les(éléments).sontAuNombreDe(10));

		String messageAttendu = "La collection est <nulle> et ne possède donc pas un nombre d'éléments de <10>.";
		alors().cette(exception).respecte(créeSpécificationException(messageAttendu));
	}

	@Test
	public void onPeutAffirmerQuUneCollectionNonVideEstNonVide() {
		alors().les(Listes.cree(3)).existent();
	}

	@Test
	public void onNePeutPasAffirmerQuUneCollectionVideEstNonVide() {
		List<Object> éléments = new ArrayList<>();

		Exception exception = capteur.capte(() -> alors().les(éléments).existent());

		alors().cette(exception).respecte(créeSpécificationException("Il n'y a aucun élément."));
	}

	@Test
	public void onNePeutPasAffirmerQuUneCollectionNulleEstNonVide() {
		Exception exception = capteur.capte(() -> alors().les(ELEMENTS_NULS).existent());

		String messageAttendu = "La collection est <nulle> et ne possède donc pas d'éléments.";
		alors().cette(exception).respecte(créeSpécificationException(messageAttendu));
	}

	@Test
	public void onPeutAffirmerQuUneCollectionVideEstVide() {
		alors().les(new ArrayList<>()).nExistentPas();
	}

	@Test
	public void onNePeutPasAffirmerQuUneCollectionNonVideEstVide() {
		List<Integer> quelquesEléments = Listes.cree(3);

		Exception exception = capteur.capte(() -> alors().les(quelquesEléments).nExistentPas());

		String messageAttendu = "Les éléments sont au nombre de <1> au lieu de <0>.";
		alors().cette(exception).respecte(créeSpécificationException(messageAttendu));
	}

	@Test
	public void onNePeutPasAffirmerQuUneCollectionNulleEstVide() {
		Exception exception = capteur.capte(() -> alors().les(ELEMENTS_NULS).nExistentPas());

		String messageAttendu = "La collection est <nulle> et ne possède donc pas un nombre d'éléments de <0>.";
		alors().cette(exception).respecte(créeSpécificationException(messageAttendu));
	}

	@Test
	public void onPeutAffirmerQuUneCollectionAUnElément() {
		List<Integer> élémentsDont13 = Listes.cree(1, 3, 13);

		alors().les(élémentsDont13).ont(13);
	}

	@Test
	public void onPeutAffirmerQuUneCollectionADesEléments() {
		List<Integer> élémentsDont3Et13 = Listes.cree(1, 3, 13);

		alors().les(élémentsDont3Et13).ont(13, 3);
	}

	@Test
	public void onNePeutPasAffirmerQuUneCollectionAUnElémentQuElleNAPas() {
		List<Integer> élémentsSans12Ni13 = Listes.cree(1, 2);

		Exception exception = capteur.capte(() -> alors().les(élémentsSans12Ni13).ont(13, 12));

		String messageAttendu = "Les éléments sont <[1, 2]> et ne contiennent pas <[13, 12]>.";
		alors().cette(exception).respecte(créeSpécificationException(messageAttendu));
	}

	@Test
	public void onNePeutPasAffirmerQuUneCollectionNulleAUnElément() {
		Exception exception = capteur.capte(() -> alors().les(ELEMENTS_NULS).ont(13, 12));

		String messageAttendu = "La collection est <nulle>, <[13, 12]> ne sont donc pas présents dedans.";
		alors().cette(exception).respecte(créeSpécificationException(messageAttendu));
	}

	@Test
	public void onPeutAffirmerQuUneCollectionRespecteUneSpécification() {
		Specification<Collection<Integer>> spécification = créeSpécificationSatisfaite();

		alors().les(Listes.cree(1, 2)).respectent(spécification);
	}

	@Test
	public void onNePeutPasAffirmerATortQuUneCollectionRespecteUneSpécification() {
		final Specification<Collection<Integer>> spécification = créeSpécificationInsatisfaite();
		List<Integer> éléments = Listes.cree(1, 2);

		Exception exception = capteur.capte(() -> alors().les(éléments).respectent(spécification));

		alors().cette(exception).respecte(créeSpécificationException("[1, 2] ne respecte pas la spécification."));
	}

	@Test
	public void onPeutAffirmerSurUneCollectionDeManièreFluide() {
		List<Integer> éléments = Listes.cree(1, 2);

		alors().les(éléments).sontAuNombreDe(2)
				.et().sont(1, 2)
				.et().existent()
				.et().ont(1)
				.et().sont(Listes.cree(1, 2))
				.et().respectent(créeSpécificationSatisfaite());
	}

	private static final List<Object> ELEMENTS_NULS = null;

	private CapteurExceptionDeBase capteur;
}
