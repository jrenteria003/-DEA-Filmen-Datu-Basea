package filmdb;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.Scanner;

//import com.sun.tools.javac.util.List;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
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
					if(!mapaAktoreak.containsKey(p.getIzena())) {
						mapaAktoreak.put(p.getIzena(), p);
						f.gehituAktorea(p);
					} else {
						Aktorea p2 = mapaAktoreak.get(akt[i]);
						f.gehituAktorea(p2);
					}
				}
				mapaFilmak.put(f.getIzena(), f);
			}
			entrada.close();
		}
		catch(IOException e) {e.printStackTrace();}
	}
	
	public void konprobatu() {
		System.out.println(mapaAktoreak.size());
		System.out.println(mapaFilmak.size());
	}
	
	public void ordenatuAktoreMapa() {
		Object[] aktorelag;
		aktorelag = this.mapaAktoreak.keySet().toArray();
		Aktorea[] aktoreberriak;
		aktoreberriak = new Aktorea[mapaAktoreak.size()];
		for(int i = 0; i < aktorelag.length; i++) {
			aktoreberriak[i] = this.mapaAktoreak.get(aktorelag[i]);
			//System.out.println(aktoreberriak[i].getIzena());
		}
		quickSort(aktoreberriak);
		
		for(int i = 0; i < aktoreberriak.length; i++) {
			System.out.println(aktoreberriak[i].getIzena());
		}
	}
	
	public void quickSort(Aktorea[] taula){
		quickSort(taula, 0, taula.length-1);
	}
		
	private void quickSort(Aktorea[ ] taulaBat, int hasiera, int bukaera){
		if ( bukaera - hasiera> 0 ) { // taulan elementu bat baino gehiago
			int indizeaZatiketa = zatiketa(taulaBat, hasiera, bukaera);
			quickSort(taulaBat, hasiera, indizeaZatiketa - 1);
			quickSort(taulaBat, indizeaZatiketa + 1, bukaera);
		}
	}

	private int zatiketa(Aktorea[] taula, int i, int f) {
		Aktorea lag = taula[i];
		int ezker = i;
		int eskuin = f;
		while ( ezker < eskuin ){
			while ( taula[ezker].compareTo(lag) <= 0 && ezker < eskuin)
				ezker++;
			while ( taula[eskuin].compareTo(lag) > 0 )
				eskuin--;
			if ( ezker < eskuin ) {
				taula = swap(taula, ezker, eskuin);
			}
		}
		taula[i] = taula[eskuin];
		taula[eskuin] = lag;
		return eskuin;
	}

	private Aktorea[] swap(Aktorea[] taula, int ezker, int eskuin) {
		Aktorea lag = taula[ezker];
		taula[ezker] = taula[eskuin];
		taula[eskuin] = lag;
		return taula;
	}
}
