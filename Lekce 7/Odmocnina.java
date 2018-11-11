public class Odmocnina {
    public static void main(String[] args) {
        int cislo = Integer.parseInt(args[0]);
        double presnost = Double.parseDouble(args[1]);
        double predchoziX = cislo, x = 1;     

        while(!closeEnough(predchoziX, presnost, x)) {
            predchoziX = x;            
            x = (((double)cislo / predchoziX) + predchoziX) / 2;
            System.out.println(x);
        }

        System.out.printf("Odmocnina je: %f\n", x);
    }

    public static boolean closeEnough(double predchoziX, double presnost, double x) {
        if (Math.abs(predchoziX - x) < presnost)
            return true;
        else
            return false;               
    }
}