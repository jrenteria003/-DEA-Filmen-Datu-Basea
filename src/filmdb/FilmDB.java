package filmdb;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.Scanner;

import java.io.FileReader;

import java.util.HashMap;

public class FilmDB {
	private ListaFilmak filmak;
	private static FilmDB gureDB = null;
	private HashMap<String,Aktorea> mapaAktoreak;
	private HashMap<String,Filma> mapaFilmak;

	public FilmDB() {
		//this.filmak = new ListaFilmak();
		this.mapaAktoreak = new HashMap<String,Aktorea>();
		this.mapaFilmak = new HashMap<String,Filma>();
	}

	public static FilmDB getFilmDB() {
		if (gureDB == null) {
			gureDB = new FilmDB();
		}
		return gureDB;
	}

	public void datuakKargatu(String nomF) {
		try{
			Scanner entrada = new Scanner(new FileReader(nomF));
			String linea;
			Filma f = null;
			ListaAktoreak aktors = null;
			Aktorea p = null;
			while (entrada.hasNext()) {
				f = null;
				linea = entrada.nextLine();
				String[] iz = linea.split("\\s+--->\\s+");
				f = new Filma(iz[0]);
				String[] akt = iz[1].split("\\s+&&&\\s+");
				System.out.println(f.getIzena());
				for(int i = 0; i < akt.length; i++) {
					p = null;
					p = new Aktorea(akt[i]);
					System.out.println(p.getIzena());
					f.gehituAktorea(p);
					mapaAktoreak.put(p.getIzena(), p);
				}
				mapaFilmak.put(f.getIzena(), f);
			}
			entrada.close();
		}
		catch(IOException e) {e.printStackTrace();}
	}
}
