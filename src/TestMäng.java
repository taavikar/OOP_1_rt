import java.util.ArrayList;
import java.util.Scanner;

public class TestMäng {
    public static void main(String[] args) {
        System.out.println("Tähelepanu! Tegemist on hasartmänguga, hasartmäng ei ole sobilik viis rahaliste probleemide lahendamiseks!");
        Scanner sc = new Scanner(System.in);
        System.out.println("Sisesta oma nimi: ");
        String kasutaja = sc.nextLine();
        System.out.println("Sisesta oma sünni kuupäev: (YYYY-MM-DD)");
        String sünnikuupäev = sc.nextLine();
        Mängija mängija= new Mängija(kasutaja, sünnikuupäev);
        if (mängija.vanus()<21) {
            System.out.println("Olete kahjuks liiga noor, et antud mängu mängida. Palun tulge tagasi, kui olete 21. aasta vanune.");
            System.exit(0);
        }
        System.out.println("Tere "+ mängija.getNimi() +", oled valmis mängima Blackjacki!");
        System.out.println("Sisesta algsumma, mille eest sooviksid mängida: ");
        String raha = sc.nextLine();
        sc.close();
        mängija.setRaha(Integer.parseInt(raha));

        Kaardipakk segatudkaardipakid = new Kaardipakk(1);
        System.out.println("Segatud kaardipakk: "+segatudkaardipakid.getPakk());

    }
}
