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

package fr.arpinum.cocoritest;

import fr.arpinum.cocoritest.interne.affirmation.ExceptionAffirmation;
import fr.arpinum.cocoritest.interne.extensionlangage.Objets;
import fr.arpinum.cocoritest.interne.specification.objet.SpecificationAutreObjet;
import fr.arpinum.cocoritest.specification.Specification;

public class FabriquePourTest {

	private FabriquePourTest() {
	}

	public static Specification<Exception> créeSpécificationException(String messageAttendu) {
		return new SpecificationAutreObjet<>((Exception) null)
				.et(créeSpécificationObjetDeType(ExceptionAffirmation.class))
				.et(créeSpécificationMessageException(messageAttendu));
	}

	private static Specification<Exception> créeSpécificationMessageException(final String messageAttendu) {
		return new Specification<Exception>() {
			@Override
			public boolean estSatisfaitePar(Exception objet) {
				return !Objets.différents(objet.getMessage(), messageAttendu);
			}

			@Override
			public String messageInsatisfactionPour(Exception objet) {
				return String.format("Le message est <%s> au lieu de <%s>", objet.getMessage(), messageAttendu);
			}
		};
	}

	private static Specification<Exception> créeSpécificationObjetDeType(final Class<?> classe) {
		return new Specification<Exception>() {
			@Override
			public boolean estSatisfaitePar(Exception objet) {
				return objet.getClass().equals(classe);
			}

			@Override
			public String messageInsatisfactionPour(Exception objet) {
				return String.format("Le type est <%s> au lieu de <%s>", objet.getClass(), classe);
			}
		};
	}
}
