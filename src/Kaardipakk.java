import java.util.ArrayList;
import java.util.Collections;

public class Kaardipakk {
    private ArrayList<Kaart> pakk;

    //konstruktor uue paki või käe loomiseks
    public Kaardipakk() {
        this.pakk = new ArrayList<Kaart>();
    }

    //kaardipaki täitmine ja segamine
    public void täisPakk(int pakke){
        for (int p = 0; p < pakke; p++) {
            for (int i = 0; i < mastid.length; i++) {
                for (int j = 0; j < suurused.length; j++) {
                    pakk.add(new Kaart(mastid[i],suurused[j]));
                }
            }
        }
        //https://www.geeksforgeeks.org/shuffle-or-randomize-a-list-in-java/
        Collections.shuffle(pakk);
    }

    String[] mastid = {"Risti","Ruutu","Ärtu","Poti"};
    String[] suurused = {"2","3","4","5","6","7","8","9","10","Poiss","Emand","Kuningas","Äss"};
    //String[] mastid = {"C","D","H","S"};
    //String[] suurused = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
    //int[] väärutus = {2,3,4,5,6,7,8,9,10,10,10,10,11};

    //käe väärtuse arvutamine
    public int käeVäärtus(){
        int kokku = 0;
        int äss = 0;
        for (Kaart kaart : this.pakk){
            switch (kaart.getSuurus()){
                case "2": kokku += 2; break;
                case "3": kokku += 3; break;
                case "4": kokku += 4; break;
                case "5": kokku += 5; break;
                case "6": kokku += 6; break;
                case "7": kokku += 7; break;
                case "8": kokku += 8; break;
                case "9": kokku += 9; break;
                case "10": kokku += 10; break;
                case "Poiss": kokku += 10; break;
                case "Emand": kokku += 10; break;
                case "Kuningas": kokku += 10; break;
                case "Äss": äss += 1; break;
            }
        }
        //for tsükkel ässade väärtuse lisamiseks (arvestab mitu ässa käes on ja vastavalt kasutab kas väärtust 1 või 11)
        for (int i = 0; i < äss; i++){
            if (kokku > 10){
                kokku += 1;
            }
            else{
                kokku += 11;
            }
        }
        return kokku;
    }

    //tagastab käes olevate kaartide arvu, et saaks teada indeksi viimase kaardi jaoks
    public int kaarteKäes(){
        return this.pakk.size();
    }

    //tagastab kogu paki või käe
    public ArrayList<Kaart> getPakk(){
        return pakk;
    }

    //tostring meetod pakile või käele
    public String toString(){
        String kaardiList = "";
        for (Kaart kaart : this.pakk) {
            kaardiList += "\n" + kaart.toString();
        }
        return kaardiList;
    }

    //eemaldab pakist või käest ühe kaardi
    public void eemaldaKaart(int i){
        pakk.remove(i);
    }

    //vaatab, mis kaart on pakis või käes mingil indeksil
    public Kaart getKaart(int i){
        return this.pakk.get(i);
    }

    //eemaldab kaardi ühest pakist või käest ja lisab selle teise
    public void diilimine(Kaardipakk kust){
        this.pakk.add(kust.getKaart(0));
        kust.eemaldaKaart(0);
    }
}
