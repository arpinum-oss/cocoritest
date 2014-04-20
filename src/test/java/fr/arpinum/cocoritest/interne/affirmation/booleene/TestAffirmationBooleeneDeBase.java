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

package fr.arpinum.cocoritest.interne.affirmation.booleene;

import static fr.arpinum.cocoritest.Affirmations.*;
import static fr.arpinum.cocoritest.FabriquePourTest.*;
import static fr.arpinum.cocoritest.Outils.*;

import org.junit.Before;
import org.junit.Test;

import fr.arpinum.cocoritest.exception.CapteurException;

public class TestAffirmationBooleeneDeBase {

	@Before
	public void avantChaqueTest() {
		capteur = créeCapteur();
	}

	@Test
	public void onPeutAffirmerQueVraiEstVrai() {
		alors().le(BOOLEEN_VRAI).estVrai();
		alors().la(VALEUR_VRAIE).estVraie();
	}

	@Test
	public void onNePeutPasAffirmerQueFauxEstVrai() {
		Exception exception = capteur.capte(() -> alors().le(BOOLEEN_FAUX).estVrai());

		alors().cette(exception).respecte(créeSpécificationException("L'objet est <faux> au lieu de <vrai>."));
	}

	@Test
	public void onNePeutPasAffirmerAuFémininQueFauxEstVrai() {
		Exception exception = capteur.capte(() -> alors().la(VALEUR_FAUSSE).estVraie());

		alors().cette(exception).respecte(créeSpécificationException("L'objet est <faux> au lieu de <vrai>."));
	}

	@Test
	public void onNePeutPasAffirmerQueNullEstVrai() {
		Exception exception = capteur.capte(() -> alorsLeBooléenNul().estVrai());

		alors().cette(exception).respecte(créeSpécificationException("L'objet est <nul> au lieu de <vrai>."));
	}

	private AffirmationBooleeneDeBase alorsLeBooléenNul() {
		return new AffirmationBooleeneDeBase(BOOLEEN_NUL);
	}

	@Test
	public void onPeutAffirmerQueFauxEstFaux() {
		alors().le(BOOLEEN_FAUX).estFaux();
		alors().la(VALEUR_FAUSSE).estFausse();
	}

	@Test
	public void onNePeutPasAffirmerQueVraiEstFaux() {
		Exception exception = capteur.capte(() -> alors().le(BOOLEEN_VRAI).estFaux());

		alors().cette(exception).respecte(créeSpécificationException("L'objet est <vrai> au lieu de <faux>."));
	}

	@Test
	public void onNePeutPasAffirmerAuFémininQueVraiEstFaux() {
		Exception exception = capteur.capte(() -> alors().la(VALEUR_VRAIE).estFausse());

		alors().cette(exception).respecte(créeSpécificationException("L'objet est <vrai> au lieu de <faux>."));
	}

	private static final boolean BOOLEEN_VRAI = true;
	private static final boolean VALEUR_VRAIE = true;
	private static final boolean BOOLEEN_FAUX = false;
	private static final boolean VALEUR_FAUSSE = false;
	private static final Boolean BOOLEEN_NUL = null;
	private CapteurException capteur;
}
