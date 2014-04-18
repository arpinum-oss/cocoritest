package fr.arpinum.cocoritest.interne.specification;

import fr.arpinum.cocoritest.interne.extensionlangage.Listes;
import fr.arpinum.cocoritest.specification.Specification;
import org.junit.Test;

import static fr.arpinum.cocoritest.Affirmations.alors;
import static fr.arpinum.cocoritest.Outils.combine;

public class TestSpecificationCombinee {

    @Test
    public void laFabriquePeutCombinerPlusieursSpécifications() {
        Specification<String> spécificationCréée = combine(Listes.cree(créeContient(""), créeContient("")));

        alors().la(spécificationCréée).nEstPasNulle();
    }

    @Test
    public void uneSpécificationCombinéeEstInsatisfaiteSiUneSpécificationDeSaCombinaisonEstInsatisfaite() {
        Specification<String> spécificationCréée = combine(Listes.cree(créeContient("a"), créeContient("b")));

        alors().ceci(spécificationCréée.estInsatisfaitePar("aaeeeeaa")).estVrai();
        alors().ceci(spécificationCréée.estInsatisfaitePar("bbeeeebb")).estVrai();
    }

    @Test
    public void uneSpécificatonCombinéeALeMessageDInsatisfactionDeLaPremiereInsatisfaiteDeSaCombinaison() {
        Specification<String> spécificationCréée = combine(Listes.cree(créeContient("a"), créeContient("b")));

        alors().le(spécificationCréée.messageInsatisfactionPour("b")).est("ne contient pas a");
        alors().le(spécificationCréée.messageInsatisfactionPour("a")).est("ne contient pas b");
        alors().le(spécificationCréée.messageInsatisfactionPour("e")).est("ne contient pas a");
    }

    private Specification<String> créeContient(final String chaîneContenue) {
        return new Specification<String>() {
            @Override
            public boolean estInsatisfaitePar(String chaîne) {
                return !chaîne.contains(chaîneContenue);
            }

            @Override
            public String messageInsatisfactionPour(String chaîne) {
                return "ne contient pas " + chaîneContenue;
            }
        };
    }
}
