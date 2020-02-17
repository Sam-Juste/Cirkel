package domain;

import java.awt.geom.Point2D;

public class Cirkel {
    private Point2D.Double middelpunt;
    private double straal;


    public Cirkel(Point2D.Double middelpunt, double straal) {
        if (middelpunt == null) throw new IllegalArgumentException("mag niet leeg zijn");
        if (straal < 0 || straal > Math.min(Math.abs(middelpunt.x), Math.abs(middelpunt.y))) throw new IllegalArgumentException("moet groter zijn dan nul en kleiner dan elk van de coordinaten van middelpunt");
        this.middelpunt = middelpunt;
        this.straal = straal;
    }

    public Point2D.Double getMiddelpunt() {
        return middelpunt;
    }

    public double getStraal() {
        return straal;
    }

    public double berekenOppervlakte(){
        double oppervlakte = ((straal*straal)* 3.14);
        return oppervlakte;
    }
    public boolean bevatPunt(Point2D.Double p){
        if(p == null){
            throw new IllegalArgumentException("Mag niet leeg zijn");
        } else {
            if(p.distance(middelpunt) <= straal){
                return true;
            } else {
                return false;
            }
        }
    }
    public void vergrootStraal(int factor){
        if(factor <= 0)throw new IllegalArgumentException("factor moet positief zijn.");
        if(this.straal*factor > Math.min(Math.abs(middelpunt.x), Math.abs(middelpunt.y)))throw new IllegalArgumentException("Straal mag niet groter zijn dan de coordinaten");
        this.straal = this.straal*factor;
    }
}
