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

import java.lang.reflect.Field;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import fr.arpinum.cocoritest.injection.Injecteur;
import fr.arpinum.cocoritest.interne.extensionlangage.Listes;

public class InjecteurDeBase implements Injecteur {

	public InjecteurDeBase(Object objet) {
		this.objet = objet;
	}

	@Override
	public Injecteur injecte(Object... dépendances) {
		Listes.cree(dépendances).forEach(this::injecte);
		return this;
	}

	private void injecte(Object dépendance) {
		List<Field> champsAssignables = récupèreChampsAssignables(dépendance);
		if (champsAssignables.size() == 0) {
			throw new IllegalArgumentException(String.format("Impossible d'assigner la dépendance %s",
					dépendance));
		}
		assigneLesChampsAssignables(dépendance, champsAssignables);
	}

	private void assigneLesChampsAssignables(Object dépendance, List<Field> champsAssignables) {
		champsAssignables.forEach((champ) -> forceLAssignation(dépendance, champ));
	}

	private void forceLAssignation(Object dépendance, Field champ) {
		champ.setAccessible(true);
		assigne(dépendance, champ);
	}

	private void assigne(Object dépendance, Field champ) {
		try {
			champ.set(objet, dépendance);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	private List<Field> récupèreChampsAssignables(Object dépendance) {
		return récupèreTousLesChamps().stream().filter(champAssignableDepuis(dépendance)).collect(Collectors.toList());
	}

	private Predicate<Field> champAssignableDepuis(Object dépendance) {
		return (champ) -> champ.getType().isAssignableFrom(dépendance.getClass());
	}

	private List<Field> récupèreTousLesChamps() {
		return récupèreTousLesChampsPour(objet.getClass());
	}

	private List<Field> récupèreTousLesChampsPour(Class<?> classe) {
		List<Field> résultat = récupèreTousLesChampsDéclarés(classe);
		if (classe.getSuperclass() != null) {
			résultat.addAll(récupèreTousLesChampsPour(classe.getSuperclass()));
		}
		return résultat;
	}

	private List<Field> récupèreTousLesChampsDéclarés(Class<?> classe) {
		return Listes.cree(classe.getDeclaredFields());
	}

	private final Object objet;
}
