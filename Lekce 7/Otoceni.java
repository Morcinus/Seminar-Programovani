public class Otoceni {
    public static void main(String[] args) {
        awh.IntList cisla = awh.IntList.create();

        java.util.Scanner sc = new java.util.Scanner(System.in);
        while (sc.hasNextInt()) {
            cisla.add(sc.nextInt());
        }
        
        cisla.reverse();
        System.out.println(cisla);        
    }
}