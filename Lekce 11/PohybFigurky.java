
public class PohybFigurky {

	public static void main(String[] args) {
		boolean jsmeVCili = false;
		int cisloTahu = 0;
		int cilovePolicko = 21 - 1; // Odecita se 1 kvuli array
		int startovniPolicko = 0;

		// Vytvoreni desky
		int[] array = new int[21];
		for (int i = 0; i < array.length; i++) {
			array[i] = -1;
		}
		array[startovniPolicko] = 0;

		while (!jsmeVCili) {			
			projdiPolicka(array, cisloTahu);

			vypisArray(array);

			if (array[cilovePolicko] != -1) {
				System.out.printf("Na policko se dostanem po %d tazich\n", array[cilovePolicko]);
				break;
			} else {
				cisloTahu++;
			}
		}

	}

	public static void projdiPolicka(int[] array, int cisloTahu) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == cisloTahu) { // Je na policku figurky
				posunFigurku(array, cisloTahu, i);
			}
		}
	}

	public static void posunFigurku(int[] array, int cisloTahu, int pozice) {
		if (pozice - 3 > 0) {
			if (array[pozice - 3] == -1)
				array[pozice - 3] = cisloTahu + 1;
		}
		if (pozice + 3 < array.length) {
			if (array[pozice + 3] == -1)
				array[pozice + 3] = cisloTahu + 1;
		}
		if (pozice - 5 > 0) {
			if (array[pozice - 5] == -1)
				array[pozice - 5] = cisloTahu + 1;
		}
		if (pozice + 5 < array.length) {
			if (array[pozice + 5] == -1)
				array[pozice + 5] = cisloTahu + 1;
		}

	}
	
	public static void vypisArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] == -1)
				System.out.printf("- ");
			else	
			    System.out.printf("%d ", array[i]);
		}
		System.out.println("");
	}

}
