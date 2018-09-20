public class Ramecek {
    public static void main (String[] args){
        int y = 7, x = 24; //Rozmery vnejsich okraju ramecku

        for(int i = 0; i < y; i++) {    //Vykresleni radku
            for(int j = 0; j < x; j++){     //Vykresleni jednotlivych znaku

                if(i > 1 && i < y-2 && j > 1 && j < x-2) { //Pokud je kurzor na miste, kde ma byt prazdne pole
                    System.out.printf(" ");
                } else
                    System.out.printf("X");                
            }
            System.out.println("");
        }
    }
}