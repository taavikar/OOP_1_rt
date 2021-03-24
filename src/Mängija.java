import java.time.LocalDate;

public class Mängija {
    private String nimi;
    private String sünnikuupäev;
    //private int raha;

    public Mängija(String nimi, String sünnikuupäev){
        this.nimi = nimi;
        this.sünnikuupäev = sünnikuupäev;
    }

    public String getNimi() {
        return nimi;
    }

    public String getSünnikuupäev() {
        return sünnikuupäev;
    }

    /**
    public int getRaha() {
        return raha;
    }

    public void setRaha(int raha) {
        this.raha = raha;
    }
     **/

    public int vanus(){
        String sp = sünnikuupäev.replace("-","");
        String täna = String.valueOf(LocalDate.now());
        String tänaf = täna.replace("-","");
        int sünnip = Integer.parseInt(sp);
        int tänap = Integer.parseInt(tänaf);
        //Oma 21. sünnipäeval ei tohiks saada ka mängida, seega paneme vanuse ühe päevaga nihkesse
        int vanus = (int) Math.floor((tänap-sünnip-1)/10000.0);
        return vanus;
    }
}
