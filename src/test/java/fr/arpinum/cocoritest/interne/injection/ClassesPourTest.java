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

package fr.arpinum.cocoritest.interne.injection;

public abstract class ClassesPourTest {

	private ClassesPourTest() {
	}

	static interface PremiereDependance {
	}

	static interface DeuxiemeDependance {
	}

	static interface TroisiemeDependance {
	}

	static class Client {
		private final PremiereDependance premiereDépendance = null;
		private final DeuxiemeDependance deuxièmeDépendance = null;
		private final TroisiemeDependance troisièmeDépendance = null;

		public PremiereDependance premièreDépendance() {
			return premiereDépendance;
		}

		public DeuxiemeDependance deuxièmeDépendance() {
			return deuxièmeDépendance;
		}

		public TroisiemeDependance troisièmeDépendance() {
			return troisièmeDépendance;
		}
	}

	static class SpecialisationClient extends Client {
	}

	static class PremiereDependanceSimple implements PremiereDependance {
	}

	static class DeuxiemeDependanceSimple implements DeuxiemeDependance {
	}

	static class TroisiemeDependanceSimple implements TroisiemeDependance {
	}
}
