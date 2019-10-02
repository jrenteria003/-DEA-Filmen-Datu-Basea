package filmdb;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.Scanner;

import java.io.FileReader;

import java.util.HashMap;

public class FilmDB {
	private ListaFilmak filmak;
	private static FilmDB gureDB;
	private HashMap<String,Aktorea> mapa;

	private FilmDB() {
		this.filmak = new ListaFilmak();
	}

	public static void main(String[] arg) {
		datuakKargatu(arg[0]);
		//return 0;
	}

	public static FilmDB getFilmDB() {
		return gureDB;
	}

	public static void datuakKargatu(String nomF) {
		// String a = linea.split("\\s+-->");

		try{
			Scanner entrada = new Scanner(new FileReader(nomF));
			String linea;
			Filma f = null;
			ListaAktoreak aktors = null;
			Aktorea p = null;
			while (entrada.hasNext()) {
				linea = entrada.nextLine();
				String[] iz = linea.split("\\s+--->\\s+");
				f = new Filma(iz[0]);
				//aktors = new ListaAktoreak();
				//aktors.gehitu(p);
				String[] akt = iz[1].split("\\s+&&&\\s+");
				System.out.println(iz[0]);
				for(int i = 0; i < akt.length; i++) {
					p = null;
					p = new Aktorea(akt[i]);
					System.out.println(i);
					f.gehituAktorea(p);
				}
				f = null;
			}
			entrada.close();
		}
		catch(IOException e) {e.printStackTrace();}


		//InputStream fitx = (InputStream) this.getClass().getClassLoader().getResourceAsStream(fitxategia);

		//InputStreamReader in = new InputStreamReader(fitx);
	}
}
