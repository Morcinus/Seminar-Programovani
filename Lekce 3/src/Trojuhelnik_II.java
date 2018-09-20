public class Trojuhelnik_II {
    public static void main (String[] args){  

        for(int i = 1; i <= 5; i++){     //i = 1, protoze by se nahore vykreslil jeden prazdny radek kvuli println
            for(int j = 5; j > 0; j--){
                if(j <= i) {
                    System.out.printf("X");
                } else 
                    System.out.printf(" ");                                    
            }
            System.out.println("");
        }        
    }
} 