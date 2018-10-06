public class KvadratickaRovnice {
    public static void main (String args[]) {
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);
        double D, x1, x2;

        D = b*b - 4*a*c;
        
        if (D >= 0) {
            x1 = (-1*b + Math.sqrt(D)) / 2*a;
            x2 = (-1*b - Math.sqrt(D)) / 2*a;

            System.out.printf("x1 = %f\n", x1);
            System.out.printf("x2 = %f\n", x2);
        } else {
            System.out.println("Rovnice nema realne koreny!");
        }
    }
}