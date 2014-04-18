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

package fr.arpinum.cocoritest.interne.extensionlangage;

import java.util.ArrayList;
import java.util.List;

public class Listes {

    public static <E> List<E> cree() {
        return new ArrayList<>();
    }

    public static <E> List<E> cree(E élément) {
        List<E> liste = cree();
        liste.add(élément);
        return liste;
    }

    public static <E> List<E> cree(E élément, E élémentBis) {
        List<E> liste = cree(élément);
        liste.add(élémentBis);
        return liste;
    }

    public static <E> List<E> cree(E élément, E élémentBis, E élémentTer) {
        List<E> liste = cree(élément, élémentBis);
        liste.add(élémentTer);
        return liste;
    }

    public static <E> List<E> cree(E[] éléments) {
        List<E> liste = new ArrayList<>();
        java.util.Collections.addAll(liste, éléments);
        return liste;
    }
}
