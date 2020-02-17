package domain;

import org.junit.Before;
import org.junit.Test;

import java.awt.geom.Point2D;

import static org.junit.Assert.*;

public class CirkelTest {
    private Point2D.Double geldigMiddelpunt;
    private double geldigStraal;


    @Before
    public void setUp() throws Exception {
    geldigMiddelpunt = new Point2D.Double(5,4);
    geldigStraal = 2;

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
        new Cirkel(geldigMiddelpunt, 6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_cirkel_met_geldig_middelpunt_en_grotere_straal_dan_y_gooit_exception(){
        new Cirkel(geldigMiddelpunt, 5);
    }
    @Test
    public void test_cirkel_met_geldig_middelpunt_en_geldig_straal_maakt_nieuwe_cirkel(){
        Cirkel c = new Cirkel(new Point2D.Double(6,4), 3);

    }
    



}