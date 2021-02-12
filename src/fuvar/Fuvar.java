
package fuvar;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;


public class Fuvar {
    //taxi_id;indulas;idotartam;tavolsag;viteldij;borravalo;fizetes_modja
    
    private int id;
    private String indulas;
    private int idotartam;
    private double tavolsag;
    private double dij;
    private double borra;
    private String fizMod;

    public Fuvar(String sor) throws ParseException {
        String[] s = sor.split(";"); 
        this.id = Integer.parseInt(s[0]);
        this.indulas = s[1];
        this.idotartam = Integer.parseInt(s[2]);
        
        //this.tavolsag = Double.parseDouble(s[3]);
        NumberFormat format = NumberFormat.getInstance(Locale.ITALY);
        Number number = format.parse(s[3]);
        this.tavolsag = number.doubleValue();
        
        //this.dij = Double.parseDouble(s[4]);
        number = format.parse(s[4]);
        this.dij = number.doubleValue();
        
        //this.borra = Double.parseDouble(s[5]);
        number = format.parse(s[5]);
        this.borra = number.doubleValue();
        
        this.fizMod = s[6];
    }

    @Override
    public String toString() {
        return "\tFuvar hossza: " + idotartam + " másodperc " 
                + "\n\tTaxi azonosító: " + id
                + "\n\tMegtett távolság: " + tavolsag + " km"
                + "\n\tViteldij: " + dij + "$";
    }

    public int getId() {
        return id;
    }

    public String getIndulas() {
        return indulas;
    }

    public int getIdotartam() {
        return idotartam;
    }

    public double getTavolsag() {
        return tavolsag;
    }

    public double getDij() {
        return dij;
    }

    public double getBorra() {
        return borra;
    }

    public String getFizMod() {
        return fizMod;
    }
}

