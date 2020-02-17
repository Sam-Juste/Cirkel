package domain;

import org.junit.Before;
import org.junit.Test;

import java.awt.geom.Point2D;

import static org.junit.Assert.*;

public class CirkelTest {
    private Point2D.Double geldigMiddelpunt, geldigMiddelpuntMetNegatievePunten, puntInGeldigeCirkel, puntBuitenGeldigeCirkel;
    private double geldigStraal;
    private Cirkel geldigeCirkel;
    private double delta = 1E-2;

    @Before
    public void setUp() throws Exception {
    geldigMiddelpunt = new Point2D.Double(10,6);
    geldigMiddelpuntMetNegatievePunten = new Point2D.Double(-6,-7);
    geldigStraal = 2;
    geldigeCirkel = new Cirkel(geldigMiddelpunt, geldigStraal);
    puntInGeldigeCirkel = new Point2D.Double(11,7);
    puntBuitenGeldigeCirkel = new Point2D.Double(7,7);
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_cirkel_met_lege_middelpunt_en_geldige_straal_gooit_exception(){
        new Cirkel(null, geldigStraal);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_cirkel_met_geldig_middelpunt_en_negatieve_straal_gooit_exception(){
        new Cirkel(geldigMiddelpunt, -5);
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_cirkel_met_geldig_middelpunt_en_grotere_straal_dan_x_gooit_exception(){
        new Cirkel(geldigMiddelpunt, 15);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_cirkel_met_geldig_middelpunt_en_grotere_straal_dan_y_gooit_exception(){
        new Cirkel(geldigMiddelpunt, 12);
    }
    @Test
    public void test_cirkel_met_geldig_middelpunt_en_geldig_straal_maakt_nieuwe_cirkel(){
        Cirkel c = new Cirkel(new Point2D.Double(6,4), 3);
        assertEquals(c.getMiddelpunt(), new Point2D.Double(6,4));
        assertEquals(c.getStraal(), 3, delta);
    }


    @Test
    public void test_berekenOppervlakte_geeft_verwacht_resultaat(){
        double oppervlakte =  geldigeCirkel.berekenOppervlakte();
        assertEquals(12.566370614359, oppervlakte, delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_bevatPunt_met_null_als_punt_gooit_exception(){
        geldigeCirkel.bevatPunt(null);
    }
    @Test
    public void test_bevatPunt_met_geldigeCirkel_en_geldig_punt_in_cirkel_geeft_true(){
        assertTrue(geldigeCirkel.bevatPunt(puntInGeldigeCirkel));
    }

    @Test
    public void test_bevatPunt_met_geldigeCirkel_en_geldig_punt_buiten_cirkel_geeft_false(){
        assertFalse(geldigeCirkel.bevatPunt(puntBuitenGeldigeCirkel));
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_vergrootStraal_met_negatieve_factor_als_input_gooit_exception(){
        geldigeCirkel.vergrootStraal(-1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_vergrootStraal_met_nul_factor_als_input_gooit_exception(){
        geldigeCirkel.vergrootStraal(0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_vergrootStraal_met_te_grote_factor_als_input_gooit_exception(){
        geldigeCirkel.vergrootStraal(5);
    }

    @Test
    public void test_vergrootStraal_geeft_verwacht_resultaat_met_geldige_cirkel(){
        geldigeCirkel.vergrootStraal(2);
    }



}