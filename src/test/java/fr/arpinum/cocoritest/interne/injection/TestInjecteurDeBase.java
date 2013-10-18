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

import static fr.arpinum.cocoritest.Affirmations.*;
import static fr.arpinum.cocoritest.Outils.*;
import static fr.arpinum.cocoritest.interne.injection.ClassesPourTest.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.arpinum.cocoritest.exception.Action;
import fr.arpinum.cocoritest.exception.CapteurException;
import fr.arpinum.cocoritest.injection.Injecteur;

public class TestInjecteurDeBase {

	@Before
	public void avantChaqueTest() {
		classe = new Classe();
		injecteur = créeInjecteur(classe);
		premièreDépendance = new PremiereDependanceSimple();
		deuxièmeDépendance = new DeuxiemeDependanceSimple();
	}

	@Test
	public void peutInjecterUneDépendance() {
		injecteur.injecte(premièreDépendance);

		alors().la(classe.premièreDépendance()).est(premièreDépendance);
	}

	@Test
	public void peutInjecterPlusieursDépendances() {
		injecteur.injecte(premièreDépendance);
		injecteur.injecte(deuxièmeDépendance);

		alors().la(classe.premièreDépendance()).est(premièreDépendance);
		alors().la(classe.deuxièmeDépendance()).est(deuxièmeDépendance);
	}

	@Test
	public void peutInjecterPlusieursDépendancesDeFaçonFluide() {
		injecteur.injecte(premièreDépendance).injecte(deuxièmeDépendance);

		alors().la(classe.premièreDépendance()).est(premièreDépendance);
		alors().la(classe.deuxièmeDépendance()).est(deuxièmeDépendance);
	}

	@Test
	public void peutInjecterDeuxDépendancesEnUneSeuleFois() {
		injecteur.injecte(premièreDépendance, deuxièmeDépendance);

		alors().la(classe.premièreDépendance()).est(premièreDépendance);
		alors().la(classe.deuxièmeDépendance()).est(deuxièmeDépendance);
	}

	@Test
	public void peutInjecterTroisDépendancesEnUneSeuleFois() {
		TroisiemeDependanceSimple troisièmeDépendance = new TroisiemeDependanceSimple();

		injecteur.injecte(premièreDépendance, deuxièmeDépendance, troisièmeDépendance);

		alors().la(classe.premièreDépendance()).est(premièreDépendance);
		alors().la(classe.deuxièmeDépendance()).est(deuxièmeDépendance);
		alors().la(classe.troisièmeDépendance()).est(troisièmeDépendance);
	}

	@Test
	public void peutInjecterUneDépendanceDansUneSousClasse() {
		SousClasse sousClasse = new SousClasse();
		Injecteur autreInjecteur = new InjecteurDeBase(sousClasse);

		autreInjecteur.injecte(premièreDépendance);

		alors().la(sousClasse.premièreDépendance()).est(premièreDépendance);
	}

	@Test
	public void peutInjecterUneDépendanceDansUneSousSousClasse() {
		SousSousClasse sousSousClasse = new SousSousClasse();
		Injecteur autreInjecteur = new InjecteurDeBase(sousSousClasse);

		autreInjecteur.injecte(premièreDépendance);

		alors().la(sousSousClasse.premièreDépendance()).est(premièreDépendance);
	}

	@Test
	public void uneErreurEstLevéeSiLaDépendanceNePeutPasEtreInjectée() {
		CapteurException capteur = créeCapteur();
		final List<String> liste = new ArrayList<String>();

		Exception exception = capteur.capte(new Action() {
			@Override
			public void exécute() {
				injecteur.injecte(liste);
			}
		});

		alors().cette(exception).nEstPasNulle();
		alors().ceci(exception instanceof IllegalArgumentException).estVrai();
		alors().le(exception.getMessage()).est("Impossible d'assigner la dépendance " + liste);
	}

	private Injecteur injecteur;
	private Classe classe;
	private PremiereDependanceSimple premièreDépendance;
	private DeuxiemeDependanceSimple deuxièmeDépendance;
}
