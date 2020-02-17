package domain;

import java.awt.geom.Point2D;

public class Cirkel {
    private Point2D.Double middelpunt;
    private double straal;


    public Cirkel(Point2D.Double middelpunt, double straal) {
        if (middelpunt == null) throw new IllegalArgumentException("mag niet leeg zijn");
        if (straal < 0 || straal > middelpunt.x || straal > middelpunt.y) throw new IllegalArgumentException("moet groter zijn dan nul en kleiner dan elk van de coordinaten van middelpunt");
        this.middelpunt = middelpunt;
        this.straal = straal;
    }

    public Point2D.Double getMiddelpunt() {
        return middelpunt;
    }

    public double getStraal() {
        return straal;
    }



}
