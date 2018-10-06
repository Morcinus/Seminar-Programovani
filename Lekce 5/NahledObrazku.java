public class NahledObrazku {
    public static void main(String args[]) {
        //Vstupni obrazek
        awh.Image obr = awh.Image.loadFromFile(args[0]);
        int sirka = obr.getWidth();
        int vyska = obr.getHeight();
        double ratio = (double)vyska / sirka;   

        //Vystupni obrazek        
        int maxVyska = 150;
        int maxSirka = 100;
        awh.Image novyObr = awh.Image.createEmpty(maxSirka, maxVyska, awh.Color.GRAY);
        double limitRatio = (double)maxVyska / maxSirka;
                
        //Zmenseni obrazku
        if(limitRatio < ratio) { // Obrazek je vyssi
            System.out.println("Obrazek je vyssi");

            //Zmensi vysku na 150 a prizpusobi sirku
            obr.rescale((int)(maxVyska / ratio), maxVyska);            
            novyObr.pasteFrom(obr, 0, 0);

        } else if (limitRatio > ratio) { // Obrazek je sirsi
            System.out.println("Obrazek je sirsi");

            //Zmensi sirku na 100 a prizpusobi vysku
            obr.rescale(maxSirka, (int)(maxSirka * ratio));            
            novyObr.pasteFrom(obr, 0, 0);

        } else { // Obrazek je stejny
            System.out.println("Obrazek je stejny");
        }
 
        novyObr.saveToFile(args[1]);    
    }
}