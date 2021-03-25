public class Kaart {
    private String mast;
    private String suurus;

    public Kaart(String mast, String suurus){
        this.mast = mast;
        this.suurus = suurus;
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

    public String toString(){
        return "[" + mast + " " + suurus + "]";
    }
}
