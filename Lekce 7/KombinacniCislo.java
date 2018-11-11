public class KombinacniCislo {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        if(n >= k) { 
            double C = fak(n) / (fak(n - k) * fak(k));
            System.out.printf("Kombinacni cislo je: " + (long)C);
        } else 
            System.out.printf("k nemuze byt vetsi nez n");   

    }

    public static double fak(int cislo) { // Faktorial
        double vystup = 1;
        for(int i = 1; i <= cislo; i++) {
            vystup *= i;
        }
        return vystup;
    }
}