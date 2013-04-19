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

package fr.arpinum.cocoritest.specification.objet;

import fr.arpinum.cocoritest.outils.Objets;
import fr.arpinum.cocoritest.specification.Specification;

public class SpecificationObjet<T> implements Specification<T> {

	public SpecificationObjet(T objetSpécifié) {
		this.objetSpécifié = objetSpécifié;
	}

	@Override
	public boolean estInsatisfaitePar(T objet) {
		return Objets.différents(objetSpécifié, objet);
	}

	@Override
	public String messageInsatisfactionPour(T objet) {
		return String.format("L'objet est <%s> au lieu de <%s>.", Objets.enChaîne(objet), Objets.enChaîne(objetSpécifié));
	}

	private final T objetSpécifié;
}
