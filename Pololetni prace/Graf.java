import java.util.ArrayList;
import java.util.List;

public class Graf {

	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
        int cislo, vyskaSloupce = 0, nejvetsi = 0;
        
        //Nacte cisla a najde nejvetsi
        List<Integer> list = new ArrayList<Integer>();
        while(sc.hasNextInt()) {
            cislo = sc.nextInt();
            if(nejvetsi < cislo)
                nejvetsi = cislo;
            
            list.add(cislo);
        }
        
        vypisGraf(list, nejvetsi, vyskaSloupce);
	}
	
	public static void vypisGraf(List<Integer> list, int nejvetsi, int vyskaSloupce) {
		int sirkaGrafu = 15 + list.size() * 24 + 10;
		System.out.println("<?xml version=\"1.0\"?>");
		System.out.printf(
				"<svg xmlns=\"http://www.w3.org/2000/svg\"\n" + 
				"    width=\"" + sirkaGrafu + "\" height=\"125\"\n" + 
				"    viewBox=\"0 0 " + sirkaGrafu +" 125\">\n");
		System.out.printf(
				"    <style>\n" + 
				"    rect {\n" + 
				"        fill: orange;\n" + 
				"        stroke: black;\n" + 
				"        stroke-width: 2;\n" + 
				"    }\n" + 
				"    </style>\n");
		
		//Vytiskne sloupce
        for(int i = 0; i < list.size(); i++) {
            if(nejvetsi < 100)
            	vyskaSloupce = list.get(i);
            else
            	vyskaSloupce = 100 * list.get(i) / nejvetsi;

            vytiskniSloupec(i, vyskaSloupce);
            
        }
        
        System.out.print("<line x1=\"7\" y1=\"10\" x2=\"7\" y2=\"125\" style=\"stroke: black;stroke-width: 2\" />");
        System.out.print("<line x1=\"0\" y1=\"118\" x2=\"" + sirkaGrafu + "\" y2=\"118\" style=\"stroke: black;stroke-width: 2\" />");
        
        System.out.print("</svg>");
	}
	
	public static void vytiskniSloupec(int cisloSloupce, int vyskaSloupce) {
		int x = 15 + 25 * cisloSloupce;
		int y = 15 + 100 - vyskaSloupce;
		System.out.printf("    <rect x=\"%d\" y=\"%d\" width=\"20\" height=\"%d\"/>\n", x, y, vyskaSloupce);
	}

}
