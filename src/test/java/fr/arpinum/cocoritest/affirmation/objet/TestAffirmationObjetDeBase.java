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

package fr.arpinum.cocoritest.affirmation.objet;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fr.arpinum.cocoritest.affirmation.ExceptionAffirmation;
import fr.arpinum.cocoritest.specification.Specification;

public class TestAffirmationObjetDeBase {

	@Rule
	public ExpectedException politiqueException = ExpectedException.none();

	@Test
	public void onPeutAffirmerQuUnNombreEstLeMêmeNombre() {
		creeAffirmation(1).est(1);
	}

	@Test
	public void onNePeutPasAffirmerQuUnNombreEstUnNombreDifférent() {
		politiqueException.expect(ExceptionAffirmation.class);
		politiqueException.expectMessage("L'objet est <1> au lieu de <2>.");

		creeAffirmation(1).est(2);
	}

	@Test
	public void onPeutAffirmerQuUnNombreNEstPasUnNombreDifférent() {
		creeAffirmation(1).nEstPas(2);
	}

	@Test
	public void onNePeutPasAffirmerQuUnNombreNEstPasLeMêmeNombre() {
		politiqueException.expect(ExceptionAffirmation.class);
		politiqueException.expectMessage("L'objet est <1> alors que ce n'était pas voulu.");

		creeAffirmation(1).nEstPas(1);
	}

	@Test
	public void onNePeutPasAffirmerQuUneChaîneEstUneChaîneDifférente() {
		politiqueException.expect(ExceptionAffirmation.class);
		politiqueException.expectMessage("L'objet est <toto> au lieu de <tutu>.");

		creeAffirmation("toto").est("tutu");
	}

	@Test
	public void onPeutAffirmerQuUnObjetEstNul() {
		creeAffirmation(null).estNul();
		creeAffirmation(null).estNulle();
	}

	@Test
	public void onPeutAffirmerQuUnObjetNEstPasNul() {
		creeAffirmation("toto").nEstPasNul();
		creeAffirmation("toto").nEstPasNulle();
	}

	@Test
	public void onNePeutPasAffirmerQuUnObjetNonNulEstNul() {
		politiqueException.expect(ExceptionAffirmation.class);
		politiqueException.expectMessage("L'objet est <toto> au lieu de <nul>.");

		creeAffirmation("toto").estNul();
	}

	@Test
	public void onNePeutPasAffirmerAuFémininQuUnObjetNonNulEstNul() {
		politiqueException.expect(ExceptionAffirmation.class);
		politiqueException.expectMessage("L'objet est <toto> au lieu de <nul>.");

		creeAffirmation("toto").estNulle();
	}

	@Test
	public void onNePeutPasAffirmerQuUnObjetNulNEstPasNul() {
		politiqueException.expect(ExceptionAffirmation.class);
		politiqueException.expectMessage("L'objet est <nul> alors que ce n'était pas voulu.");

		creeAffirmation(null).nEstPasNul();
	}

	@Test
	public void onNePeutPasAffirmerAuFémininQuUnObjetNulNEstPasNul() {
		politiqueException.expect(ExceptionAffirmation.class);
		politiqueException.expectMessage("L'objet est <nul> alors que ce n'était pas voulu.");

		creeAffirmation(null).nEstPasNulle();
	}

	@Test
	public void onPeutAffirmerQuUnObjetRespecteUneSpecification() {
		creeAffirmation(1).respecte(créeSpecificationToujoursSatisfaite());
	}

	private Specification<Integer> créeSpecificationToujoursSatisfaite() {
		return new Specification<Integer>() {
			@Override
			public boolean estInsatisfaitePar(Integer objet) {
				return false;
			}

			@Override
			public String messageInsatisfactionPour(Integer objet) {
				return "non utilisé";
			}
		};
	}

	@Test
	public void onNePeutPasAffirmerATortQuUnObjetRespecteUneSpecification() {
		politiqueException.expect(ExceptionAffirmation.class);
		politiqueException.expectMessage("1 ne respecte pas la spécification");

		creeAffirmation(1).respecte(créeSpécificationJamaisSatisfaite());
	}

	private Specification<Integer> créeSpécificationJamaisSatisfaite() {
		return new Specification<Integer>() {
			@Override
			public boolean estInsatisfaitePar(Integer objet) {
				return true;
			}

			@Override
			public String messageInsatisfactionPour(Integer objet) {
				return objet + " ne respecte pas la spécification";
			}
		};
	}

	private static <T> AffirmationObjetDeBase<T> creeAffirmation(T valeur) {
		return new AffirmationObjetDeBase<T>(valeur);
	}
}
