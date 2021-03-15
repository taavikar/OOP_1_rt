import java.util.ArrayList;
import java.util.Collections;

public class Kaardipakk {
    private ArrayList<Kaart> pakk= new ArrayList<Kaart>();
    //String[] mastid = {"Risti","Ruutu","Ärtu","Poti"};
    //String[] suurused = {"2","3","4","5","6","7","8","9","10","Poiss","Emand","Kuningas","Äss"};
    String[] mastid = {"C","D","H","S"};
    String[] suurused = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
    int[] väärutus = {2,3,4,5,6,7,8,9,10,10,10,10,11};

    public Kaardipakk(int pakke){
        for (int p = 0; p < pakke; p++) {
            for (int i = 0; i < mastid.length; i++) {
                for (int j = 0; j < suurused.length; j++) {
                    pakk.add(new Kaart(mastid[i],suurused[j],väärutus[j]));
                }
            }
        }
        //https://www.geeksforgeeks.org/shuffle-or-randomize-a-list-in-java/
        Collections.shuffle(pakk);
    }
    public ArrayList<Kaart> getPakk(){
        return pakk;
    }
}
