public class DenVRoce {
    public static void main(String[] args) {
    int rok = Integer.parseInt(args [0]); 
    int mesic = Integer.parseInt(args [1]); 
    int den = Integer.parseInt(args [2]);
    
    int vystupniDen = den;
    mesic--;
    
    
    for(int i = 0; i < mesic; i++)
      vystupniDen += pocetDnuMesice(mesic, rok);
      
    System.out.println(vystupniDen);    
    }
    
    public static boolean jePrestupny(int rok) {
      if(rok % 4 == 0){                         
          if(rok % 100 == 0){        
            if(rok % 400 == 0) {
              return true;        
            }
            return false;         
          }
        return true;    
      }
      return false;           
    }
    
    public static int pocetDnuMesice(int mesic, int rok){ //NE NEBUDU POUZIVAT JEDNODUCHY ARRAY!
    if (mesic <= 7) {
      if(mesic == 2){
        if(jePrestupny(rok))
          return 29;
        else return 28;         
      }               
    
      if(mesic % 2 == 0) {
        return 30;
      } else {
        return 31;
      }   
    } else {
      if(mesic % 2 == 0) {
        return 31;
      } else {
        return 30;
      }
    }

    
    }
}