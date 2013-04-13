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

package fr.arpinum.cocoritest.affirmation.booleene;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fr.arpinum.cocoritest.affirmation.ExceptionAffirmation;

public class TestAffirmationBooleeneDeBase {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void onPeutAffirmerQueVraiEstVrai() {
		new AffirmationBooleeneDeBase(true).estVrai();
		new AffirmationBooleeneDeBase(true).estVraie();
	}

	@Test
	public void onNePeutPasAffirmerQueFauxEstVrai() {
		exception.expect(ExceptionAffirmation.class);
		exception.expectMessage("L'objet est faux au lieu de vrai.");

		new AffirmationBooleeneDeBase(false).estVrai();
	}

	@Test
	public void onNePeutPasAffirmerAuFémininQueFauxEstVrai() {
		exception.expect(ExceptionAffirmation.class);
		exception.expectMessage("L'objet est faux au lieu de vrai.");

		new AffirmationBooleeneDeBase(false).estVraie();
	}

	@Test
	public void onNePeutPasAffirmerQueNullEstVrai() {
		exception.expect(ExceptionAffirmation.class);

		new AffirmationBooleeneDeBase(null).estVrai();
	}

	@Test
	public void onPeutAffirmerQueFauxEstFaux() {
		new AffirmationBooleeneDeBase(false).estFaux();
		new AffirmationBooleeneDeBase(false).estFausse();
	}

	@Test
	public void onNePeutPasAffirmerQueVraiEstFaux() {
		exception.expect(ExceptionAffirmation.class);
		exception.expectMessage("L'objet est vrai au lieu de faux.");

		new AffirmationBooleeneDeBase(true).estFaux();
	}

	@Test
	public void onNePeutPasAffirmerAuFémininQueVraiEstFaux() {
		exception.expect(ExceptionAffirmation.class);
		exception.expectMessage("L'objet est vrai au lieu de faux.");

		new AffirmationBooleeneDeBase(true).estFausse();
	}
}
