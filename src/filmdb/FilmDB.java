package filmdb;

import java.io.IOException;
import java.util.Scanner;

public class FilmDB {
	private ListaFilmak filmak;
	private static FilmDB gureDB;

	private FilmDB() {
		this.filmak = new ListaFilmak();
	}

	public int main() {
		datuakKargatu("aaaa");
		return 0;
	}

	public static FilmDB getFilmDB() {
		return gureDB;
	}

	public void datuakKargatu(String fitxategia) {
		// String a = linea.split("\\s+-->");
		try{
			Scanner entrada = new Scanner(new FileReader(nomF));
			String linea;
			Filma f = null;
			Aktorea p = null;
			while (entrada.hasNext()) {
				linea = entrada.nextLine();
				String iz = (String) linea.split("\\s+--->");
				f = new Filma(iz);
				//f.gehituAktorea(p);
			}
			entrada.close();
		}
		catch(IOException e) {e.printStackTrace();}
	}
}
