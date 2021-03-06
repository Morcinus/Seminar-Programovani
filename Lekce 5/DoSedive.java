public class DoSedive {
    public static void main(String args[]){
        awh.Image obr = awh.Image.loadFromFile(args[0]);
        int sirka = obr.getWidth();
        int vyska = obr.getHeight();
        int sediva;
 
        for (int y = 0; y < vyska; y++) {
            for (int x = 0; x < sirka; x++) {
                awh.Color puvodni = obr.getPixel(x, y);

                //Prevedeni barvy na sedivou
                sediva = (int)(
                    (double)puvodni.getRed() * 0.299 + 
                    (double)puvodni.getGreen() * 0.587 + 
                    (double)puvodni.getBlue() * 0.114
                );  

                awh.Color nova = awh.Color.fromRgb(sediva, sediva, sediva);
                obr.setPixel(x, y, nova);
            }
        }
 
        obr.saveToFile(args[1]);
    }
}