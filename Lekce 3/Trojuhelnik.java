public class Trojuhelnik {
    public static void main (String[] args){  

        for(int i = 1; i <= 5; i++){     //i = 1, protoze by se nahore vykreslil jeden prazdny radek kvuli println
            for(int j = 0; j < i; j++){
                System.out.printf("X");
            }
            System.out.println("");
        }
    }
}