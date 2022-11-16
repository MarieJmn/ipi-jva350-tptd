package com.ipi.jva350.model;

//import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.util.LinkedHashSet;

class SalarieAideADomicileTest {
/*

    @Test
    void aLegalementDroitADesCongesPayesNonInitialise() {
        // GIVEN
        SalarieAideADomicile aide = new SalarieAideADomicile();
        // WHEN
        boolean res = aide.aLegalementDroitADesCongesPayes();
        // THEN
      //  Assertions.assertThat(res).isFalse();
        Assertions.assertEquals(false, res);
    }

    @Test
    void aLegalementDroitADesCongesPayesMoinsDe10() {
        // GIVEN
        SalarieAideADomicile aide = new SalarieAideADomicile("Jeanne", LocalDate.now(), LocalDate.now(), 0, 0,
                6, 2, 2);
        // WHEN
        boolean res = aide.aLegalementDroitADesCongesPayes();
        // THEN
        Assertions.assertEquals(false, res);
    }

    @Test
    void aLegalementDroitADesCongesPayesPlusDe10() {
        // GIVEN
        SalarieAideADomicile aide = new SalarieAideADomicile("Jeanne", LocalDate.now(), LocalDate.now(), 0, 0,
                18, 2, 2);
        // WHEN
        boolean res = aide.aLegalementDroitADesCongesPayes();
        // THEN
        Assertions.assertEquals(true, res);
    }

    @Test
    void aLegalementDroitADesCongesPayesAuxLimites10() {
        // GIVEN
        SalarieAideADomicile aide = new SalarieAideADomicile("Jeanne", LocalDate.now(), LocalDate.now(), 0, 0,
                10, 2, 2);
        // WHEN
        boolean res = aide.aLegalementDroitADesCongesPayes();
        // THEN
        Assertions.assertEquals(true, res);
    }

    @Test
    void aLegalementDroitADesCongesPayesAuxLimites9() {
        // GIVEN
        SalarieAideADomicile aide = new SalarieAideADomicile("Jeanne", LocalDate.now(), LocalDate.now(), 0, 0,
                9, 2, 2);
        // plusieurs tests dans une méthode :
        // aide.setJoursTravaillesAnneeNMoins1(10);
        // WHEN
        boolean res = aide.aLegalementDroitADesCongesPayes();
        // THEN
        Assertions.assertEquals(false, res);
    }

    @Test
    void testCalculJoursCongeDecomptesPourPlage(){
        SalarieAideADomicile aide = new SalarieAideADomicile("Jeanne", LocalDate.of(2021, 7, 1), LocalDate.now(), 0, 0,
                9, 1, 0);

        LinkedHashSet<LocalDate> res = aide.calculeJoursDeCongeDecomptesPourPlage(LocalDate.of(2022, 7, 1), LocalDate.of(2022, 7, 2));

        LinkedHashSet<LocalDate> expected = new LinkedHashSet<>();
        expected.add(LocalDate.of(2022,7,1));
        expected.add(LocalDate.parse("2022-07-02"));
        Assertions.assertEquals(expected, res);
    }
*/

// Tests paramétrés
    @ParameterizedTest(name = "entre {0} et {1}, nb de expectedNbJoursDeCongesDecomptes {2}")
    @CsvSource({
            "'2022-07-01', '2022-07-02, 2",
            "'2022-07-02', '2022-07-04, 3"
    })
    void testCalculJoursCongeDecomptesPourPlageParametrized(String debut, String fin, double expectedNbJoursDeCongesDecomptes) {
// Given, When, Then
        SalarieAideADomicile aide = new SalarieAideADomicile("Jeanne", LocalDate.of(2021, 7, 1), LocalDate.now(), 0,
                0, 10, 1, 0);

        LinkedHashSet<LocalDate> res = aide.calculeJoursDeCongeDecomptesPourPlage(LocalDate.parse(debut),
                LocalDate.parse(fin));

        Assertions.assertEquals(expectedNbJoursDeCongesDecomptes, res.size());
    }

}