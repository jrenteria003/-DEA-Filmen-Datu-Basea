package filmdb;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

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
				//System.out.println(f.getIzena());
				for(int i = 0; i < akt.length; i++) {
					p = null;
					if(!mapaAktoreak.containsKey(akt[i])) {
						p = new Aktorea(akt[i]);
						mapaAktoreak.put(p.getIzena(), p);
					} else {
						p = mapaAktoreak.get(akt[i]);
					}
					f.gehituAktorea(p);
					p.gehituFilma(f);
				}
				mapaFilmak.put(f.getIzena(), f);
			}
			entrada.close();
		}
		catch(IOException e) {e.printStackTrace();}
	}
	
	public void gehituAktorea(Aktorea akt) {
		this.mapaAktoreak.put(akt.getIzena(), akt);
	}
	
	public void gehituFilma(Filma film) {
		this.mapaFilmak.put(film.getIzena(), film);
	}
	
	public Aktorea[] AktoreHashMapToArray(HashMap<String, Aktorea> mapa) {
		Object[] lag = mapa.keySet().toArray();
		Aktorea[] emaitza = new Aktorea[lag.length];
		for(int i = 0; i < lag.length; i++) {
			emaitza[i] = mapa.get(lag[i]);
		}
		return emaitza;
	}
	
	public Filma[] filmHashMapToArray(HashMap<String, Filma> mapa) {
		Object[] lag = mapa.keySet().toArray();
		Filma[] emaitza = new Filma[lag.length];
		for(int i = 0; i < lag.length; i++) {
			emaitza[i] = mapa.get(lag[i]);
		}
		return emaitza;
	}
	
	public ListaFilmak getListaFilmak() {
		//System.out.println("START GETLISTAFILMAK()");
		ListaFilmak emaitza = new ListaFilmak();
		Filma[] lag = this.filmHashMapToArray(mapaFilmak);
		for(int i = 0; i < lag.length; i++) emaitza.gehitu(lag[i]);
		//System.out.println("END GETLISTAFILMAK()");
		return emaitza;
	}
	
	public ListaAktoreak getListaAktoreak() {
		//System.out.println("START GETLISTAKTOREAK()");
		ListaAktoreak emaitza = new ListaAktoreak();
		Aktorea[] lag = this.AktoreHashMapToArray(this.mapaAktoreak);
		for(int i = 0; i < lag.length; i++) emaitza.gehitu(lag[i]);
		//System.out.println("END GETLISTAKTOREAK()");
		return emaitza;
	}

	public void konprobatu() {
		System.out.println(mapaAktoreak.size());
		System.out.println(mapaFilmak.size());
	}
	
	public Aktorea bilatuAktorea(String giltza) {
		if(this.mapaAktoreak.get(giltza) == null) {
			return null;
		}
		return this.mapaAktoreak.get(giltza);
	}	
	
	public Aktorea[] ordenatuAktoreMapa() {
		Aktorea[] aktoreberriak = this.AktoreHashMapToArray(mapaAktoreak);
		quickSort(aktoreberriak);
		
		return aktoreberriak;
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

	public void idatziFitxategia(Aktorea[] aktoreak) {
		Path file = Paths.get("/home/jonr/Desktop/idatzi.txt");
		try {
			Files.deleteIfExists(file);
			Files.createFile(file);
		} catch (IOException e) {
			System.err.println("ERROREA fitxategia sortzen");
		}
		for(int i = 0; i < aktoreak.length; i++) {
			byte[] data = (aktoreak[i].getIzena()+"\n").getBytes();
			try {
				Files.write(file, data, StandardOpenOption.APPEND);
			} catch (IOException e) {
				System.err.println("ERROREA fitxategian idazterakoan");
			}
		}
	}
	
	public ListaAktoreak getFilmarenAktoreak(String filmaStr) {
		Filma film = this.mapaFilmak.get(filmaStr);
		return film.getAktoreak();
	}
	
	public ListaFilmak getAktorearenFilmak(String aktoreaStr) {
		Aktorea aktore = this.mapaAktoreak.get(aktoreaStr);
		return aktore.getAgertutakoFilmak();
	}
}
