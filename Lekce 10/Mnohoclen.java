import java.util.ArrayList;
import java.util.List;

public class Mnohoclen{

    private List<Integer> cisla; 
    
    public Mnohoclen(int... cisla) {
        this.cisla = new ArrayList<Integer>();

        for(int i = 0; i < cisla.length; i++) {
            this.cisla.add(cisla[i]);
        }
    }

    public Mnohoclen prictiMnohoclen(Mnohoclen mnohoclen) {
        //Secte cisla mnohoclenu
        for(int i = 0; i < mnohoclen.cisla.size(); i++) { 
            cisla.set(i, cisla.get(i) + mnohoclen.cisla.get(i)); 
        }

        pridejKoncoveCleny(mnohoclen);        
        return this;
    }

    public Mnohoclen odectiMnohoclen(Mnohoclen mnohoclen) {
        //Odecte cisla mnohoclenu
        for(int i = 0; i < mnohoclen.cisla.size(); i++) { 
            cisla.set(i, cisla.get(i) - mnohoclen.cisla.get(i)); 
        }

        pridejKoncoveCleny(mnohoclen);        
        return this;
    }

    public Mnohoclen vynasobMnohoclen(Mnohoclen mnohoclen) {
        //Vynasobi cisla mnohoclenu
        for(int i = 0; i < mnohoclen.cisla.size(); i++) { 
            cisla.set(i, cisla.get(i) * mnohoclen.cisla.get(i)); 
        }

        pridejKoncoveCleny(mnohoclen);       
        return this;
    }

    private void pridejKoncoveCleny(Mnohoclen mnohoclen) {
        for(int i = cisla.size() - 1; i < mnohoclen.cisla.size() - 1; i++) { //Testnout - 1
            cisla.add(mnohoclen.cisla.get(i));
        }
    } 

    @Override
    public String toString() {
        String output = "" + cisla.get(0);

        for(int i = 1; i < cisla.size(); i++) {

            if(cisla.get(i) > 0) {
                output = output + " + " + cisla.get(i) + "x";
            } else if (cisla.get(i) < 0) {
                output = output + " - " + Math.abs(cisla.get(i)) + "x";
            }

            if(i >= 2 && cisla.get(i) != 0) {
                output = output + "^" + i;
            }
        }

        return output;
    }
}