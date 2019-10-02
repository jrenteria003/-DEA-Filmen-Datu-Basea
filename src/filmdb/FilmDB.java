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
	private HashMap<String, Filma> mapaFilmak;

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
				String[] akt = iz[1].split("\\s+&&&\\s+");
				System.out.println(iz[0]);
				for(int i = 0; i < akt.length; i++) {
					p = null;
					p = new Aktorea(akt[i]);
					System.out.println(p.getIzena());
					f.gehituAktorea(p);
				}
				f = null;
			}
			entrada.close();
		}
		catch(IOException e) {e.printStackTrace();}
	}
}
