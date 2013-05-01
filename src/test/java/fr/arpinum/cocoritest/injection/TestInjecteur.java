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

package fr.arpinum.cocoritest.injection;

import static fr.arpinum.cocoritest.affirmation.Affirmations.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.arpinum.cocoritest.exception.Action;
import fr.arpinum.cocoritest.exception.CapteurException;

public class TestInjecteur {

	@Before
	public void avantChaqueTest() {
		client = new Client();
		injecteur = new Injecteur(client);
	}

	@Test
	public void peutInjecterUneDépendance() {
		DependanceSimple dépendance = new DependanceSimple();

		injecteur.injecte(dépendance);

		alors().la(client.dépendance()).est(dépendance);
	}

	@Test
	public void peutInjecterPlusieursDépendances() {
		DependanceSimple dépendance = new DependanceSimple();
		AutreDependanceSimple autreDépendanceSimple = new AutreDependanceSimple();

		injecteur.injecte(dépendance);
		injecteur.injecte(autreDépendanceSimple);

		alors().la(client.dépendance()).est(dépendance);
		alors().la(client.autreDépendance()).est(autreDépendanceSimple);
	}

	@Test
	public void uneErreurEstLevéeSiLaDépendanceNePeutPasEtreInjectée() {
		CapteurException capteur = new CapteurException();
		final List<String> dépendance = new ArrayList<String>();

		Exception exception = capteur.capte(new Action() {
			@Override
			public void démarre() {
				injecteur.injecte(dépendance);
			}
		});

		alors().cette(exception).nEstPasNulle();
		alors().ceci(exception instanceof IllegalArgumentException).estVrai();
		alors().le(exception.getMessage()).est("Impossible d'assigner la dépendance " + dépendance);
	}

	private static class Client {
		private Dependance dépendance = null;
		private AutreDependance autreDépendance = null;

		public Dependance dépendance() {
			return dépendance;
		}

		public AutreDependance autreDépendance() {
			return autreDépendance;
		}
	}

	private static interface Dependance {
	}

	private static class DependanceSimple implements Dependance {
	}

	private static interface AutreDependance {
	}

	private static class AutreDependanceSimple implements AutreDependance {
	}

	private Injecteur injecteur;
	private Client client;
}
