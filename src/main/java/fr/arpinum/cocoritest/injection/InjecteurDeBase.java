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

import java.lang.reflect.Field;
import java.util.List;

import fr.arpinum.cocoritest.extensionlangage.Listes;

public class InjecteurDeBase implements Injecteur {

	public InjecteurDeBase(Object objet) {
		this.objet = objet;
	}

	@Override
	public Injecteur injecte(Object dépendance) {
		List<Field> champsAssignables = récupèreChampsAssignables(dépendance);
		if (champsAssignables.size() == 0) {
			throw new IllegalArgumentException(String.format("Impossible d'assigner la dépendance %s", dépendance));
		}
		assigneLesChampsAssignables(dépendance, champsAssignables);
		return this;
	}

	@Override
	public void injecte(Object première, Object secondeDépendance) {
		injecte(première);
		injecte(secondeDépendance);
	}

	@Override
	public void injecte(Object premièreDépendance, Object deuxièmeDépendance, Object troisèmeDépendance) {
		injecte(premièreDépendance, deuxièmeDépendance);
		injecte(troisèmeDépendance);
	}

	private void assigneLesChampsAssignables(Object dépendance, List<Field> champsAssignables) {
		for (Field champ : champsAssignables) {
			champ.setAccessible(true);
			try {
				champ.set(objet, dépendance);
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			}
		}
	}

	private List<Field> récupèreChampsAssignables(Object dépendance) {
		List<Field> champsAssignables = Listes.cree();
		for (Field champ : récupèreTousLesChamps()) {
			if (champ.getType().isAssignableFrom(dépendance.getClass())) {
				champsAssignables.add(champ);
			}
		}
		return champsAssignables;
	}

	private List<Field> récupèreTousLesChamps() {
		Class<?> classe = objet.getClass();
		List<Field> résultat = récupèreTousLesChamps(classe);
		if (classe.getSuperclass() != null) {
			résultat.addAll(récupèreTousLesChamps(classe.getSuperclass()));
		}
		return résultat;
	}

	private List<Field> récupèreTousLesChamps(Class<?> classe) {
		return Listes.cree(classe.getDeclaredFields());
	}

	private final Object objet;
}
