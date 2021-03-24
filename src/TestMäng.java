import java.util.ArrayList;
import java.util.Scanner;

public class TestMäng {
    public static void main(String[] args){
        System.out.println("Tähelepanu! Tegemist on hasartmänguga, hasartmäng ei ole sobilik viis rahaliste probleemide lahendamiseks!");
        Scanner sc = new Scanner(System.in);
        System.out.println("Sisesta oma nimi: ");
        String kasutaja = sc.nextLine();
        System.out.println("Sisesta oma sünni kuupäev: (YYYY-MM-DD)");
        String sünnikuupäev = sc.nextLine();
        Mängija mängija= new Mängija(kasutaja, sünnikuupäev);
        if (mängija.vanus()<21){
            System.out.println("Olete kahjuks liiga noor, et antud mängu mängida. Palun tulge tagasi, kui olete 21. aasta vanune.");
            System.exit(0);
        }
        System.out.println("Tere "+ mängija.getNimi() +", oled valmis mängima Blackjacki!");
        System.out.println("Sisesta summa, mida oled täna valmis kaotama: ");
        int mraha = sc.nextInt();
        System.out.println(" ");


        //mängutsükkel--------------------------------------------------------------------------------------------------
        while (mraha > 0){
            //uue segatud paki loomine
            Kaardipakk segatudkaardipakid = new Kaardipakk();
            segatudkaardipakid.täisPakk(1);
            //System.out.println("Segatud kaardipakk: "+segatudkaardipakid.getPakk()); //rida et väljastada terve segatud pakk

            //mängija käe ja maja käe loomine
            Kaardipakk mängijaKäsi = new Kaardipakk();
            Kaardipakk majaKäsi = new Kaardipakk();

            System.out.println("Sinu kontoseis: " + mraha);

            System.out.println("Sisesta panus, mille eest sooviksid mängida: ");
            int panus = sc.nextInt();

            boolean mänguLõpp = false;
            if (panus > mraha){
                System.out.println("sellise panusega ei saa mängida");
                continue;
            }

            //mängu algus
            //mängija käsi
            mängijaKäsi.diilimine(segatudkaardipakid);
            mängijaKäsi.diilimine(segatudkaardipakid);

            //maja käsi
            majaKäsi.diilimine(segatudkaardipakid);
            majaKäsi.diilimine(segatudkaardipakid);

            while (true){
                System.out.print("Sinu käsi:");
                System.out.print(mängijaKäsi.toString() + "\n");
                System.out.println("Sinu käe väärtus: " + mängijaKäsi.käeVäärtus() + "\n");

                System.out.println("Maja käsi:");
                System.out.println(majaKäsi.getKaart(0).toString() + "\n[*]\n");

                System.out.println("Kas võtad juurde (Sisesta '1') või jätad (Sisesta '2')");
                int mängijavastus = sc.nextInt();

                if (mängijavastus == 1){
                    mängijaKäsi.diilimine(segatudkaardipakid);
                    System.out.println("Uus kaart: " + mängijaKäsi.getKaart(mängijaKäsi.kaarteKäes()-1));
                    if (mängijaKäsi.käeVäärtus() > 21){
                        System.out.print("Sinu käsi:");
                        System.out.print(mängijaKäsi.toString() + "\n");
                        System.out.println("Sinu käe väärtus: " + mängijaKäsi.käeVäärtus() + "\n");
                        System.out.println("Üle 21! Kaotasid");
                        mraha -= panus;
                        mänguLõpp = true;
                        break;
                    }
                }

                if (mängijavastus == 2){
                    break;
                }
            }

            if (mängijaKäsi.käeVäärtus() < 22) {

                //maja käsi ja kontrollimine, kes võitis
                System.out.println("Maja käsi: " + majaKäsi.toString());
                if (mängijaKäsi.käeVäärtus() < majaKäsi.käeVäärtus() && mänguLõpp == false) {
                    System.out.println("Maja käe väärtus: " + majaKäsi.käeVäärtus());
                    System.out.println("Maja võitis");
                    mraha -= panus;
                    mänguLõpp = true;
                }

                //majale kaardi jagamine
                while (majaKäsi.käeVäärtus() < 17 && mänguLõpp == false) {
                    majaKäsi.diilimine(segatudkaardipakid);
                    System.out.println("Maja tõmbab kaardi: " + majaKäsi.getKaart(majaKäsi.kaarteKäes() - 1).toString());
                }

                //maja käe lõhki minek
                if (majaKäsi.käeVäärtus() > 21 && mänguLõpp == false) {
                    System.out.println("Maja käe väärtus: " + majaKäsi.käeVäärtus());
                    System.out.println("Maja läks lõhki. Sinu võit!");
                    mraha += panus;
                    mänguLõpp = true;
                }

                //viigikonditsioon
                if (majaKäsi.käeVäärtus() == mängijaKäsi.käeVäärtus() && mänguLõpp == false) {
                    System.out.println("Maja käe väärtus: " + majaKäsi.käeVäärtus());
                    System.out.println("Viik");
                    mänguLõpp = true;
                }

                //mängija võit kui kumbki ei lähe lõhki
                if (majaKäsi.käeVäärtus() < mängijaKäsi.käeVäärtus() && mänguLõpp == false) {
                    System.out.println("Maja käe väärtus: " + majaKäsi.käeVäärtus());
                    System.out.println("Sinu võit");
                    mraha += panus;
                    mänguLõpp = true;
                }
                else if (mänguLõpp == false) {
                    System.out.println("Maja käe väärtus: " + majaKäsi.käeVäärtus());
                    System.out.println("Maja võitis");
                    mraha -= panus;
                    mänguLõpp = true;
                }
            }

            System.out.println("Käe lõpp!\n");
        }

        System.out.println("Mäng läbi, raha otsas");
    }
}
