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

package fr.arpinum.cocoritest.interne.affirmation.collection;

import static fr.arpinum.cocoritest.Affirmations.*;
import static fr.arpinum.cocoritest.FabriquePourTest.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.arpinum.cocoritest.exception.Action;
import fr.arpinum.cocoritest.interne.exception.CapteurExceptionDeBase;
import fr.arpinum.cocoritest.interne.extensionlangage.Listes;
import fr.arpinum.cocoritest.specification.Specification;

public class TestAffirmationCollectionDeBase {

	@Before
	public void avantChaqueTest() {
		capteur = new CapteurExceptionDeBase();
	}

	@Test
	public void onPeutAffirmerQuUneCollectionEstEgaleAUneAutre() {
		List<Integer> valeursTestées = Listes.cree(1, 2, 3);
		List<Integer> valeursAttendues = Listes.cree(1, 2, 3);

		new AffirmationCollectionDeBase<Integer>(valeursTestées).sont(valeursAttendues);
		new AffirmationCollectionDeBase<Integer>(valeursTestées).sont(1, 2, 3);
	}

	@Test
	public void onNePeutPasAffirmerQUneCollectionEstEgaleAUneCollectionDifférente() {
		final List<Integer> valeursTestées = Listes.cree(1, 2, 3);
		final List<Integer> valeursAttendues = Listes.cree(2, 3);

		Exception exception = capteur.capte(new Action() {
			@Override
			public void exécute() {
				new AffirmationCollectionDeBase<Integer>(valeursTestées).sont(valeursAttendues);
			}
		});

		String messageAttendu = "Les éléments sont <[1, 2, 3]> au lieu de <[2, 3]>.";
		alors().cette(exception).respecte(créeSpécificationException(messageAttendu));
	}

	@Test
	public void onNePeutPasAffirmerQUneCollectionEstEgaleADesElémentsNonContenus() {
		final List<Integer> valeursTestées = Listes.cree(1, 2, 3);

		Exception exception = capteur.capte(new Action() {
			@Override
			public void exécute() {
				new AffirmationCollectionDeBase<Integer>(valeursTestées).sont(2, 3);
			}
		});

		String messageAttendu = "Les éléments sont <[1, 2, 3]> au lieu de <[2, 3]>.";
		alors().cette(exception).respecte(créeSpécificationException(messageAttendu));
	}

	@Test
	public void onPeutAffirmerQuUneCollectionPossèdeUnCertainsNombreDElements() {
		new AffirmationCollectionDeBase<Integer>(Listes.cree(1, 2)).sontAuNombreDe(2);
	}

	@Test
	public void onNePeutPasAffirmerQuUneCollectionPossèdeUnNombreErronéDElements() {
		Exception exception = capteur.capte(new Action() {
			@Override
			public void exécute() {
				new AffirmationCollectionDeBase<String>(Listes.cree("a", "b")).sontAuNombreDe(10);
			}
		});

		String messageAttendu = "Les éléments sont au nombre de <2> au lieu de <10>.";
		alors().cette(exception).respecte(créeSpécificationException(messageAttendu));
	}

	@Test
	public void onNePeutPasAffirmerQuUneCollectionNullePossedeUnQuelconqueNombreDEléments() {
		Exception exception = capteur.capte(new Action() {
			@Override
			public void exécute() {
				new AffirmationCollectionDeBase<Object>(null).sontAuNombreDe(10);
			}
		});

		String messageAttendu = "La collection est <nulle> et ne possède donc pas un nombre d'éléments de <10>.";
		alors().cette(exception).respecte(créeSpécificationException(messageAttendu));
	}

	@Test
	public void onPeutAffirmerQuUneCollectionNonVideEstNonVide() {
		new AffirmationCollectionDeBase<Integer>(Listes.cree(3)).existent();
	}

	@Test
	public void onNePeutPasAffirmerQuUneCollectionVideEstNonVide() {
		Exception exception = capteur.capte(new Action() {
			@Override
			public void exécute() {
				new AffirmationCollectionDeBase<Object>(new ArrayList<Object>()).existent();
			}
		});

		alors().cette(exception).respecte(créeSpécificationException("Il n'y a aucun élément."));
	}

	@Test
	public void onNePeutPasAffirmerQuUneCollectionNulleEstNonVide() {
		Exception exception = capteur.capte(new Action() {
			@Override
			public void exécute() {
				new AffirmationCollectionDeBase<Object>(null).existent();
			}
		});

		String messageAttendu = "La collection est <nulle> et ne possède donc pas d'éléments.";
		alors().cette(exception).respecte(créeSpécificationException(messageAttendu));
	}

	@Test
	public void onPeutAffirmerQuUneCollectionVideEstVide() {
		new AffirmationCollectionDeBase<Object>(new ArrayList<Object>()).nExistentPas();
	}

	@Test
	public void onNePeutPasAffirmerQuUneCollectionNonVideEstVide() {
		Exception exception = capteur.capte(new Action() {
			@Override
			public void exécute() {
				new AffirmationCollectionDeBase<Integer>(Listes.cree(3)).nExistentPas();
			}
		});

		String messageAttendu = "Les éléments sont au nombre de <1> au lieu de <0>.";
		alors().cette(exception).respecte(créeSpécificationException(messageAttendu));
	}

	@Test
	public void onNePeutPasAffirmerQuUneCollectionNulleEstVide() {
		Exception exception = capteur.capte(new Action() {
			@Override
			public void exécute() {
				new AffirmationCollectionDeBase<Object>(null).nExistentPas();
			}
		});

		String messageAttendu = "La collection est <nulle> et ne possède donc pas un nombre d'éléments de <0>.";
		alors().cette(exception).respecte(créeSpécificationException(messageAttendu));
	}

	@Test
	public void onPeutAffirmerQuUneCollectionAUnElément() {
		new AffirmationCollectionDeBase<Integer>(Listes.cree(1, 3, 13)).ont(13);
	}

	@Test
	public void onPeutAffirmerQuUneCollectionADesEléments() {
		new AffirmationCollectionDeBase<Integer>(Listes.cree(1, 3, 13)).ont(13, 3);
	}

	@Test
	public void onNePeutPasAffirmerQuUneCollectionAUnElémentQuElleNAPas() {
		Exception exception = capteur.capte(new Action() {
			@Override
			public void exécute() {
				new AffirmationCollectionDeBase<Integer>(Listes.cree(1, 2)).ont(13, 12);
			}
		});

		String messageAttendu = "Les éléments sont <[1, 2]> et ne contiennent pas <[13, 12]>.";
		alors().cette(exception).respecte(créeSpécificationException(messageAttendu));
	}

	@Test
	public void onNePeutPasAffirmerQuUneCollectionNulleAUnElément() {
		Exception exception = capteur.capte(new Action() {
			@Override
			public void exécute() {
				new AffirmationCollectionDeBase<Object>(null).ont(13, 12);
			}
		});

		String messageAttendu = "La collection est <nulle>, <[13, 12]> ne sont donc pas présents dedans.";
		alors().cette(exception).respecte(créeSpécificationException(messageAttendu));
	}

	@Test
	public void onPeutAffirmerQuUneCollectionRespecteUneSpécification() {
		Specification<Collection<Integer>> spécification = créeSpécificationSatisfaite();

		new AffirmationCollectionDeBase<Integer>(Listes.cree(1, 2)).respectent(spécification);
	}

	@Test
	public void onNePeutPasAffirmerATortQuUneCollectionRespecteUneSpécification() {
		final Specification<Collection<Integer>> spécification = créeSpécificationInsatisfaite();

		Exception exception = capteur.capte(new Action() {
			@Override
			public void exécute() {
				new AffirmationCollectionDeBase<Integer>(Listes.cree(1, 2)).respectent(spécification);
			}
		});

		alors().cette(exception).respecte(créeSpécificationException("[1, 2] ne respecte pas la spécification."));
	}

	private CapteurExceptionDeBase capteur;
}
