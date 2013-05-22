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

package fr.arpinum.cocoritest.exemples;

import static fr.arpinum.cocoritest.Affirmations.*;
import static fr.arpinum.cocoritest.Outils.*;

import org.junit.Test;

import fr.arpinum.cocoritest.injection.Injecteur;

public class TestInjection {

	@Test
	public void leServicePeutDonnerUnMotDePasseAléatoireSur8Caractères() {
		ServiceMotDePasse service = new ServiceMotDePasse();
		Injecteur injecteur = créeInjecteur(service);
		injecteur.injecte(new DoublureServiceCaractereAleatoire('X'));

		String motDePasse = service.creeMotDePasse();

		alors().le(motDePasse).nEstPasNul();
		alors().le(motDePasse).est("XXXXXXXX");
	}

	private static class ServiceMotDePasse {

		public String creeMotDePasse() {
			StringBuilder builder = new StringBuilder(8);
			for (int i = 0; i < 8; i++) {
				builder.append(serviceCaractereAleatoire.crée());
			}
			return builder.toString();
		}

		private final ServiceCaractereAleatoire serviceCaractereAleatoire = null;
	}

	private static interface ServiceCaractereAleatoire {
		char crée();
	}

	private static class DoublureServiceCaractereAleatoire implements ServiceCaractereAleatoire {
		@SuppressWarnings("SameParameterValue")
		public DoublureServiceCaractereAleatoire(char valeur) {
			this.valeur = valeur;
		}

		@Override
		public char crée() {
			return valeur;
		}

		private final char valeur;
	}
}
