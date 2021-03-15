public class Kaart {
    private String mast;
    private String suurus;
    private int väärtus;

    public Kaart(String mast, String suurus, int väärtus) {
        this.mast = mast;
        this.suurus = suurus;
        this.väärtus = väärtus;
    }

    public String getMast() {
        return mast;
    }

    public void setMast(String mast) {
        this.mast = mast;
    }

    public String getSuurus() {
        return suurus;
    }

    public void setSuurus(String suurus) {
        this.suurus = suurus;
    }

    public int getVäärtus() {
        return väärtus;
    }

    public void setVäärtus(int väärtus) {
        this.väärtus = väärtus;
    }

    public String toString() {
        return suurus+""+mast;
    }
}
