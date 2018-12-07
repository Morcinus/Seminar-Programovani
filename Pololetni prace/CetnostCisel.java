import java.util.ArrayList;
import java.util.List;

public class CetnostCisel {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        List<Integer> cisla = new ArrayList<Integer>();
        List<Integer> cetnost = new ArrayList<Integer>();

        //Prvni vstup
        cisla.add(sc.nextInt());
        cetnost.add(1);

        //Nacte cisla a cetnosti
        while(sc.hasNextInt()) {
            int noveCislo = sc.nextInt();            
            if(!existujeCislo(noveCislo, cisla, cetnost)) {
                cisla.add(noveCislo);
                cetnost.add(1);
            } 
        }
        
        //Seradi podle cetnosti
        seradListy(cisla, cetnost);
        
        //Vypise cisla a cetnosti
        System.out.println("Cisla : Cetnost");
        for(int i = 0; i < cisla.size(); i++) {
            System.out.printf("%d : %d\n", cisla.get(i), cetnost.get(i));
        }
    }

    //Zjisti jestli uz mame dane cislo - Kdyz ano, zvysi cetnost
    public static boolean existujeCislo(int cislo, List<Integer> cisla, List<Integer> cetnost) {
        for(int i = 0; i < cisla.size(); i++) {
            if(cislo == cisla.get(i)){
                cetnost.set(i, cetnost.get(i) + 1);
                return true;
            }            
        }
        return false;
    }

    //Seradi oba listy podle cetnosti cisel
    public static void seradListy(List<Integer> cisla, List<Integer> cetnost) {
        for (int i = 0; i < cetnost.size() - 1; i++) {
            for (int j = 0; j < cetnost.size() - i - 1; j++) {
                if(cetnost.get(j) < cetnost.get(j + 1)){
                    int cislo = cetnost.get(j);
                    cetnost.set(j, cetnost.get(j + 1));
                    cetnost.set(j + 1, cislo);

                    cislo = cisla.get(j);
                    cisla.set(j, cisla.get(j + 1));
                    cisla.set(j + 1, cislo);
                }
            }
        }
    }
}

