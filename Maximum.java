public class Maximum {
  public static void main (String args[]) {
    int maxCislo = 0;
    int cislo = 0;
        
    java.util.Scanner sc = new java.util.Scanner(System.in);
    while(sc.hasNextInt()) {
      cislo = sc.nextInt();
      if (cislo > maxCislo) {
        maxCislo = cislo;        
      }      
    }
    System.out.printf("Nejvyssi cislo je: %d", maxCislo); 
  }
}
