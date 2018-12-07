public class Seq {

	public static void main(String[] args) {
		nactiVstup(args);
	}

	public static void vypisPosloupnost(int prvniCislo, int druheCislo, int skok, String vypln) {
		if (skok > 0)
			for (int i = prvniCislo; i <= druheCislo; i = i + skok) {
				if (i + skok > druheCislo) // Nevypise posledni vypln
					vypln = "";
				System.out.printf("%d%s", i, vypln);
			}
		else
			for (int i = prvniCislo; i >= druheCislo; i = i + skok) {
				if (i + skok < druheCislo) // Nevypise posledni vypln
					vypln = "";
				System.out.printf("%d%s", i, vypln);
			}
	}

	public static void nactiVstup(String[] args) {
		if (!args[0].equals("-s")) {
			if (args.length == 1)
				vypisPosloupnost(1, Integer.parseInt(args[0]), 1, " ");
			else if (args.length == 2)
				vypisPosloupnost(Integer.parseInt(args[0]), Integer.parseInt(args[1]), 1, " ");
			else if (args.length == 3)
				vypisPosloupnost(Integer.parseInt(args[0]), Integer.parseInt(args[2]), Integer.parseInt(args[1]), " ");
		} else {
			if (args.length == 3)
				vypisPosloupnost(1, Integer.parseInt(args[2]), 1, args[1]);
			else if (args.length == 4)
				vypisPosloupnost(Integer.parseInt(args[2]), Integer.parseInt(args[3]), 1, args[1]);
			else if (args.length == 5)
				vypisPosloupnost(Integer.parseInt(args[2]), Integer.parseInt(args[4]), Integer.parseInt(args[3]), args[1]);

		}
	}
}
