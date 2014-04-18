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

import fr.arpinum.cocoritest.affirmation.booleene.AffirmationBooleene;
import fr.arpinum.cocoritest.affirmation.booleene.AffirmationBooleeneAuFeminin;
import fr.arpinum.cocoritest.affirmation.collection.AffirmationCollection;
import fr.arpinum.cocoritest.affirmation.objet.AffirmationObjet;
import fr.arpinum.cocoritest.affirmation.objet.AffirmationObjetAuFeminin;
import fr.arpinum.cocoritest.interne.affirmation.booleene.AffirmationBooleeneDeBase;
import fr.arpinum.cocoritest.interne.affirmation.collection.AffirmationCollectionDeBase;
import fr.arpinum.cocoritest.interne.affirmation.objet.AffirmationObjetDeBase;
import fr.arpinum.cocoritest.interne.extensionlangage.Listes;

import java.util.Collection;

/**
 * Le point d'entrée qui permet de créer les différentes affirmations. Exemples :
 * <blockquote><pre>
 * alors().le(résultat).estVrai();
 * alors().la(chaîne).est("toto");
 * alors().les(valeurs).sont("a", "b");
 * </pre></blockquote>
 */
public class Affirmations {

    /**
     * Crée une fabrique d'affirmations pour différents types d'objets.
     *
     * @return la fabrique d'affirmation
     */
    public static Affirmations alors() {
        return new Affirmations();
    }

    private Affirmations() {
    }

    /**
     * Crée une affirmation concernant un booléen.
     *
     * @param booléen la cible de l'affirmation.
     * @return l'affirmation créée.
     */
    public AffirmationBooleene le(boolean booléen) {
        return new AffirmationBooleeneDeBase(booléen);
    }

    /**
     * Crée une affirmation concernant un booléen. A utiliser quand le mot commence par une voyelle :
     * <blockquote><pre>
     * alors().cet(objet).estVrai();
     * </pre></blockquote>
     *
     * @param booléen la cible de l'affirmation.
     * @return l'affirmation créée.
     */
    public AffirmationBooleene cet(boolean booléen) {
        return le(booléen);
    }

    /**
     * Crée une affirmation concernant un booléen. A utiliser pour une instruction entière :
     * <blockquote><pre>
     * alors().ceci(maVariable.estSuper()).estVrai();
     * </pre></blockquote>
     *
     * @param booléen la cible de l'affirmation.
     * @return l'affirmation créée.
     */
    public AffirmationBooleene ceci(boolean booléen) {
        return le(booléen);
    }

    /**
     * Crée une affirmation concernant un booléen. L'affirmation est au féminin.
     *
     * @param booléen la cible de l'affirmation.
     * @return l'affirmation créée.
     */
    public AffirmationBooleeneAuFeminin la(boolean booléen) {
        return new AffirmationBooleeneDeBase(booléen);
    }

    /**
     * Crée une affirmation concernant un booléen. L'affirmation est au féminin. A utiliser quand le mot commence par une voyelle :
     * <blockquote><pre>
     * alors().cette(histoire).estVraie();
     * </pre></blockquote>
     *
     * @param booléen la cible de l'affirmation.
     * @return l'affirmation créée.
     */
    public AffirmationBooleeneAuFeminin cette(boolean booléen) {
        return la(booléen);
    }

    /**
     * Crée une affirmation concernant un objet.
     *
     * @param <T>   le type de l'objet
     * @param objet la cible de l'affirmation.
     * @return l'affirmation créée.
     */
    public <T> AffirmationObjet<T> le(T objet) {
        return new AffirmationObjetDeBase<>(objet);
    }

    /**
     * Crée une affirmation concernant un objet. A utiliser quand le mot commence par une voyelle :
     * <blockquote><pre>
     * alors().cet(objet).est(autreObjet);
     * </pre></blockquote>
     *
     * @param <T>   le type de l'objet
     * @param objet la cible de l'affirmation.
     * @return l'affirmation créée.
     */
    public <T> AffirmationObjet<T> cet(T objet) {
        return le(objet);
    }

    /**
     * Crée une affirmation concernant un objet. A utiliser pour une instruction entière :
     * <blockquote><pre>
     * alors().ceci(maVariable.getPropriété()).est(objet);
     * </pre></blockquote>
     *
     * @param <T>   le type de l'objet
     * @param objet la cible de l'affirmation.
     * @return l'affirmation créée.
     */
    public <T> AffirmationObjet<T> ceci(T objet) {
        return le(objet);
    }

    /**
     * Crée une affirmation concernant un objet. L'affirmation est au féminin.
     *
     * @param <T>   le type de l'objet
     * @param objet la cible de l'affirmation.
     * @return l'affirmation créée.
     */
    public <T> AffirmationObjetAuFeminin<T> la(T objet) {
        return new AffirmationObjetDeBase<>(objet);
    }

    /**
     * Crée une affirmation concernant un objet. L'affirmation est au féminin. A utiliser quand le mot commence par une voyelle :
     * <blockquote><pre>
     * alors().cette(annonce).est("annonce");
     * </pre></blockquote>
     *
     * @param <T>   le type de l'objet
     * @param objet la cible de l'affirmation.
     * @return l'affirmation créée.
     */
    public <T> AffirmationObjetAuFeminin<T> cette(T objet) {
        return la(objet);
    }

    /**
     * Crée une affirmation concernant une collection.
     *
     * @param <T>      le type de l'objet
     * @param éléments les cibles de l'affirmation.
     * @return l'affirmation créée.
     */
    public <T> AffirmationCollection<T> les(Collection<T> éléments) {
        return new AffirmationCollectionDeBase<>(éléments);
    }

    /**
     * Crée une affirmation concernant une collection.
     *
     * @param <T>      le type de l'objet
     * @param éléments les cibles de l'affirmation.
     * @return l'affirmation créée.
     */
    public <T> AffirmationCollection<T> les(T[] éléments) {
        return les(Listes.cree(éléments));
    }
}