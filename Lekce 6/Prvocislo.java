public class Prvocislo {
  public static void main (String args[]) {
    int cislo = Integer.parseInt(args[0]);
    boolean prvocislo = true;

    for(int i = 2; i < cislo; i++) {
      if(cislo % i == 0) { //Nemame prvocislo
        System.out.println("Cislo neni prvocislo");  
        prvocislo = false;
        break;
      }
    }

    if(prvocislo) { //Mame prvocislo
      System.out.println("Cislo je prvocislo");
    }

  }
}
