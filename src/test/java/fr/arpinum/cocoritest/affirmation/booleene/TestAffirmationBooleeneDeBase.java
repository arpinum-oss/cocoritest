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

import static fr.arpinum.cocoritest.Affirmations.*;
import static fr.arpinum.cocoritest.Fabrique.*;

import org.junit.Before;
import org.junit.Test;

import fr.arpinum.cocoritest.exception.Action;
import fr.arpinum.cocoritest.exception.CapteurExceptionDeBase;

public class TestAffirmationBooleeneDeBase {

	@Before
	public void avantChaqueTest() {
		capteur = new CapteurExceptionDeBase();
	}

	@Test
	public void onPeutAffirmerQueVraiEstVrai() {
		new AffirmationBooleeneDeBase(true).estVrai();
		new AffirmationBooleeneDeBase(true).estVraie();
	}

	@Test
	public void onNePeutPasAffirmerQueFauxEstVrai() {
		Exception exception = capteur.capte(new Action() {
			@Override
			public void exécute() {
				new AffirmationBooleeneDeBase(false).estVrai();
			}
		});

		alors().cette(exception).respecte(spécificationException("L'objet est <faux> au lieu de <vrai>."));
	}

	@Test
	public void onNePeutPasAffirmerAuFémininQueFauxEstVrai() {
		Exception exception = capteur.capte(new Action() {
			@Override
			public void exécute() {
				new AffirmationBooleeneDeBase(false).estVraie();
			}
		});

		alors().cette(exception).respecte(spécificationException("L'objet est <faux> au lieu de <vrai>."));
	}

	@Test
	public void onNePeutPasAffirmerQueNullEstVrai() {
		Exception exception = capteur.capte(new Action() {
			@Override
			public void exécute() {
				new AffirmationBooleeneDeBase(null).estVrai();
			}
		});

		alors().cette(exception).respecte(spécificationException("L'objet est <nul> au lieu de <vrai>."));
	}

	@Test
	public void onPeutAffirmerQueFauxEstFaux() {
		new AffirmationBooleeneDeBase(false).estFaux();
		new AffirmationBooleeneDeBase(false).estFausse();
	}

	@Test
	public void onNePeutPasAffirmerQueVraiEstFaux() {
		Exception exception = capteur.capte(new Action() {
			@Override
			public void exécute() {
				new AffirmationBooleeneDeBase(true).estFaux();
			}
		});

		alors().cette(exception).respecte(spécificationException("L'objet est <vrai> au lieu de <faux>."));
	}

	@Test
	public void onNePeutPasAffirmerAuFémininQueVraiEstFaux() {
		Exception exception = capteur.capte(new Action() {
			@Override
			public void exécute() {
				new AffirmationBooleeneDeBase(true).estFausse();
			}
		});

		alors().cette(exception).respecte(spécificationException("L'objet est <vrai> au lieu de <faux>."));
	}

	private CapteurExceptionDeBase capteur;
}
