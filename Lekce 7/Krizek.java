public class Krizek {
    public static void main(String[] args) {
        int p = Integer.parseInt(args[0]);
        int k = p;


        for(int i = 0; i < p * k - 1; i++) {
            if(i == (p * k - 1) / 2 - 1){
                tiskni("X", p * k + 2);
                System.out.println("");
                tiskni("X", p * k + 2);
                i++;
            } else {                
                tiskni(" ", (p * k) / 2);
                tiskni("X", p);
            }

            System.out.println("");
        }

    }

    public static void tiskni(String znak, int pocet) {
        for(int i = 0; i < pocet; i++) {
            System.out.print(znak);
        }
    }
}

/* 


        for(int i = 0; i < p * 3 - 1; i++) {
            if(i == (p * 3 - 1) / 2 - 1){
                tiskni("X", p * 3 + 2);
                System.out.println("");
                tiskni("X", p * 3 + 2);
                i++;
            } else {                
                tiskni(" ", p + 1);
                tiskni("X", p);
            }

            System.out.println("");
        }

*/