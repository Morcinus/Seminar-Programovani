import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Zipovani {
	
	static String zipNazev;

	public static void main(String[] args) {
		
		zipNazev = args[0];
		
		loop:
		for(int i = 0; i < args.length; i++) {
			switch (args[i]) {
				case "-t":
					for(int j = 0; j < args.length; j++) {
						if(args[j].equals("-l")){
							VypisSoubory(true);
							break loop;
						}
					}
					VypisSoubory(false);
					break;
				case "-x":
					for(int j = 0; j < args.length; j++) {
						if(args[j].equals("-d")){
							// Rozbali do daneho adresare
							RozbalZip();
							break loop;
						} else if(args[j].equals("-D")) {
							// Rozbali do aktualniho adresare s podadresarem
							RozbalZip();
							break loop;
						}
					}
					// Rozbali do aktualniho adresare
					RozbalZip();
					break;
			}			
		}
	}
	
	static void VypisSoubory(boolean vypisData) throws IOException {
		if(vypisData){
			// Vypise s datem
			ZipFile soubor = new ZipFile(zipNazev);
			Enumeration<? extends ZipEntry> entries = soubor.entries();
			
			
		} else {
			// Vypise bez data
		}
	}
	
	static void RozbalZip() {
		
	}
}
