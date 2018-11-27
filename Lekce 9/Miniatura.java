public class Miniatura {
    public static void main(String[] args) {
        String vstupniSoubor;
        int sirka = 300;
        int vyska = 150;
        String vystupniSoubor;

        if (args.length == 2) {
            vstupniSoubor = args[0];
            vystupniSoubor = args[1];
            Skalovani(vstupniSoubor, sirka, vyska, vystupniSoubor);
        } else if (args.length == 3) {
            vstupniSoubor = args[0];
            vystupniSoubor = args[2];
            String[] rozmery = args[1].split("x");
            if (rozmery.length != 2) {
                awh.Sys.die("Spatne zadane rozmery (%s).", args[1]);
            }

            sirka = Integer.parseInt(rozmery[0]);            

            if ("!".equals(rozmery[1].substring(rozmery[1].length() - 1))) { //Jestli je posledni znak !
                vyska = Integer.parseInt(rozmery[1].substring(0, rozmery[1].length() - 1)); //Odstrani ! ze stringu

                awh.Image vstup = awh.Image.loadFromFile(vstupniSoubor);
                vstup.rescale(sirka, vyska);
                vstup.saveToFile(vystupniSoubor);

            } else {
                vyska = Integer.parseInt(rozmery[1]);
                Skalovani(vstupniSoubor, sirka, vyska, vystupniSoubor);
            }

        } else {
            awh.Sys.die("Pouziti: vstup.jpg [VxS] vystup.jpg");
            // Bez returnu si bude prekladac stezovat
            return;
        }
    }

    public static void Skalovani (String vstupniSoubor, int sirka, int vyska, String vystupniSoubor) {
         
        awh.Image vstup = awh.Image.loadFromFile(vstupniSoubor);

        double pomerSirka = (double) vstup.getWidth() / sirka;
        double pomerVyska = (double) vstup.getHeight() / vyska;
         
        double koef = 0;
        if (pomerSirka > pomerVyska) {
            koef = pomerSirka;
        } else {
            koef = pomerVyska;
        }
         
        int novaSirka = (int) (vstup.getWidth() / koef);
        int novaVyska = (int) (vstup.getHeight() / koef);
         
        // System.out.printf("Skaluji na %dx%d\n", novaSirka, novaVyska);
         
        vstup.rescale(novaSirka, novaVyska);
         
        awh.Image vysledek = awh.Image.createEmpty(sirka, vyska, awh.Color.GRAY);
        int x = sirka - novaSirka;
        int y = vyska - novaVyska;
        vysledek.pasteFrom(vstup, x / 2, y / 2);
         
        vysledek.saveToFile(vystupniSoubor);
    }
}