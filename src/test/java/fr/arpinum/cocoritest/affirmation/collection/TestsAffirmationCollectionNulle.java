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

package fr.arpinum.cocoritest.affirmation.collection;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fr.arpinum.cocoritest.affirmation.ExceptionAffirmation;

public class TestsAffirmationCollectionNulle {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void onNePeutPasAffirmerQuUneCollectionNullePossedeUnQuelconqueNombreDEléments() {
		exception.expect(ExceptionAffirmation.class);
		exception.expectMessage("La collection est nulle et ne possède donc pas un nombre d'éléments de 10.");

		AffirmationCollectionDeBase.cree(null).sontAuNombreDe(10);
	}

	@Test
	public void onNePeutPasAffirmerQuUneCollectionNulleEstNonVide() {
		exception.expect(ExceptionAffirmation.class);
		exception.expectMessage("La collection est nulle et ne possède donc pas d'éléments.");

		AffirmationCollectionDeBase.cree(null).existent();
	}

	@Test
	public void onNePeutPasAffirmerQuUneCollectionNulleEstVide() {
		exception.expect(ExceptionAffirmation.class);
		exception.expectMessage("La collection est nulle et ne possède donc pas un nombre d'éléments de 0.");

		AffirmationCollectionDeBase.cree(null).nExistentPas();
	}

	@Test
	public void onNePeutPasAffirmerQuUneCollectionNulleAUnElément() {
		exception.expect(ExceptionAffirmation.class);
		exception.expectMessage("La collection est nulle, [13, 12] ne sont donc pas présents dedans.");

		AffirmationCollectionDeBase.cree(null).ont(13, 12);
	}

	@Test
	public void onPeutAffirmerQuUneCollectionEstVide() {
		AffirmationCollectionDeBase.cree(new ArrayList<Integer>()).nExistentPas();
	}
}
