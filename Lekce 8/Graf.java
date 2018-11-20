import java.util.ArrayList;
import java.util.List;

public class Graf {
    public static void main(String []args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int cislo, pocetKanalu, nejvetsi = 0;
        
        //Nacte cisla a najde nejvetsi
        List<Integer> list = new ArrayList<Integer>();
        while(sc.hasNextInt()) {
            cislo = sc.nextInt();
            if(nejvetsi < cislo)
                nejvetsi = cislo;
            
            list.add(cislo);
        }

        //Vypise graf
        for(int i = 0; i < list.size(); i++) {
            if(nejvetsi < 60)
                pocetKanalu = list.get(i);
            else
                pocetKanalu = 60 * list.get(i) / nejvetsi;

            for(int j = 0; j < pocetKanalu; j++) {
                System.out.print("#");
            }
            
            System.out.println("");
        }

    }
}