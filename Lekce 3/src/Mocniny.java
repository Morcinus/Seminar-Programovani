public class Mocniny {
    public static void main (String[] args){        
        int x = Integer.parseInt(args [0]);

        for(int i = 0; i * i < x; i++){
            System.out.printf("%d ", i * i);
        }
    }
}