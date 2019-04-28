import java.util.Calendar;

public class Kalendar {

	public static void main(String[] args) {
		Calendar kalendar = Calendar.getInstance();
		kalendar.set(Calendar.DAY_OF_MONTH, 1);

		// Zpracuje argumenty
		if (args.length == 1) {
			int mesic = Integer.parseInt(args[0]) - 1;
			kalendar.set(Calendar.MONTH, mesic);
		} else if (args.length == 2) {
			int mesic = Integer.parseInt(args[0]) - 1;
			kalendar.set(Calendar.MONTH, mesic);
			int rok = Integer.parseInt(args[1]);
			kalendar.set(Calendar.YEAR, rok);
		}

		vypisKalendare(kalendar);
	}

	public static void vypisKalendare(Calendar kal2) {
		Calendar kal1 = Calendar.getInstance();
		kal1.set(Calendar.DAY_OF_MONTH, 1);
		kal1.set(Calendar.YEAR, kal2.get(Calendar.YEAR));

		Calendar kal3 = Calendar.getInstance();
		kal3.set(Calendar.DAY_OF_MONTH, 1);
		kal3.set(Calendar.YEAR, kal2.get(Calendar.YEAR));

		// Osetreni prechodu roku u prosince a ledna
		if (kal2.get(Calendar.MONTH) == 0) {
			kal1.set(Calendar.MONTH, 11);
			kal1.set(Calendar.YEAR, kal2.get(Calendar.YEAR) - 1);
			kal3.set(Calendar.MONTH, kal2.get(Calendar.MONTH) + 1);
		} else if (kal2.get(Calendar.MONTH) == 11) {
			kal3.set(Calendar.MONTH, 0);
			kal3.set(Calendar.YEAR, kal2.get(Calendar.YEAR) + 1);
			kal1.set(Calendar.MONTH, kal2.get(Calendar.MONTH) - 1);
		} else {
			kal1.set(Calendar.MONTH, kal2.get(Calendar.MONTH) - 1);
			kal3.set(Calendar.MONTH, kal2.get(Calendar.MONTH) + 1);
		}

		String[] kalendar1 = vytvorStringKalendare(kal1);
		String[] kalendar2 = vytvorStringKalendare(kal2);
		String[] kalendar3 = vytvorStringKalendare(kal3);

		// Vypise kalendare ze stringu po radcich
		for (int i = 0; i < 11; i++) {
			System.out.printf("%s", kalendar1[i]);
			System.out.print("  ");
			System.out.printf("%s", kalendar2[i]);
			System.out.print("  ");
			System.out.printf("%s", kalendar3[i]);
			System.out.println("");
		}
	}

	public static String[] vytvorStringKalendare(Calendar kal) {
		String mesic = prevedMesic(kal.get(Calendar.MONTH));
		String rok = "" + kal.get(Calendar.YEAR);
		String mesicARok = mesic + " " + rok;

		String[] vystupniKal = new String[11];
		vystupniKal[0] = "+----------------------+";
		vystupniKal[1] = String.format("| %-21s|", mesicARok);
		vystupniKal[2] = "+----------------------+";
		vystupniKal[3] = "| Po Ut St Ct Pa So Ne |";

		String[] castSeDny = vytvorStringSeDny(kal);
		for (int i = 0; i < castSeDny.length; i++) {
			if (castSeDny[i] != null)
				vystupniKal[i + 4] = castSeDny[i];
			else
				vystupniKal[i + 4] = "|                      |";
		}

		vystupniKal[10] = "+----------------------+";
		return vystupniKal;
	}

	// Vrati string mesice podle jeho cisla
	public static String prevedMesic(int index) {
		String[] mesice = new String[] { "leden", "unor", "brezen", "duben", "kveten", "cerven", "cervenec", "srpen",
				"zari", "rijen", "listopad", "prosinec" };
		return mesice[index];
	}

	public static String[] vytvorStringSeDny(Calendar kal) {
		int pocetDnu = kal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int prvniDen = kal.get(Calendar.DAY_OF_WEEK);
		int pocetDnuNaRadku = 0;

		String[] vystupniString = new String[6];

		// Prevede prvni den tydne na pondeli
		prvniDen--;
		if (prvniDen == 0)
			prvniDen = 7;

		// Udela mezery pred prvnim vypisem dnu
		vystupniString[0] = "| ";
		for (int i = 1; i < prvniDen; i++) {
			vystupniString[0] += "   ";
			pocetDnuNaRadku++;
		}

		// Vypise cisla dnu
		int radek = 0;
		for (int i = 1; i <= pocetDnu; i++) {
			vystupniString[radek] += String.format("%2d ", i);
			pocetDnuNaRadku++;
			if (pocetDnuNaRadku >= 7) { // Skoci na dalsi radek
				vystupniString[radek] += "|";
				radek++;
				vystupniString[radek] = "| ";
				pocetDnuNaRadku = 0;
			}
		}

		// Doplni mezery a zakonci vypis
		for (int i = pocetDnuNaRadku; i < 7; i++) {
			vystupniString[radek] += "   ";
		}
		vystupniString[radek] += "|";
		return vystupniString;
	}
}
