package filmdb;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.FileReader;

import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class FilmDB {
	private static FilmDB gureDB = null;
	private HashMap<String,Aktorea> mapaAktoreak;
	private HashMap<String,Filma> mapaFilmak;

	public FilmDB() {
		this.mapaAktoreak = new HashMap<String,Aktorea>();
		this.mapaFilmak = new HashMap<String,Filma>();
	}

	public static FilmDB getFilmDB() {
		if (gureDB == null) {
			gureDB = new FilmDB();
		}
		return gureDB;
	}

	public void gehituAktorea(Aktorea akt) {
		//aktorea HashMapean ez badago
		//bertara gehitzen du
		if(!this.mapaAktoreak.containsKey(akt.getIzena())) {
			this.mapaAktoreak.put(akt.getIzena(), akt);
		}
	}

	public void gehituFilma(Filma film) {
		//filma HashMapean ez badago
		//bertara gehitzen du
		if(!this.mapaAktoreak.containsKey(film.getIzena())) {
			this.mapaFilmak.put(film.getIzena(), film);
		}
	}

	public void kenduAktorea(Aktorea akt) {
		//aktorea mapatik kentzeaz gain,
		//parte hartu dituen filmetatik
		//kentzen du
		UnorderedDoubleLinkedList films = akt.getAgertutakoFilmak();
		Iterator<Filma> itr = films.iterator();
		while(itr.hasNext()) {
			Filma unekoa = itr.next();
			unekoa.kenduAktorea(akt);
		}
		mapaAktoreak.remove(akt.getIzena());
	}

	public void kenduFilma(Filma film) {
		//filma mapatik kentzeaz gain,
		//filman parte hartu dituzten aktoreen
		//ListaFilmetatik kentzen du
		UnorderedDoubleLinkedList<Aktorea> aktork = film.getAktoreak();
		Iterator<Aktorea> itr = aktork.iterator();
		while(itr.hasNext()) {
			Aktorea unekoa = itr.next();
			unekoa.kenduFilma(film);
		}
		mapaFilmak.remove(film.getIzena());
	}

	public Aktorea[] AktoreHashMapToArray(HashMap<String, Aktorea> mapa) {
		//beste metodoak gauzatzeko erabilia
		Object[] lag = mapa.keySet().toArray();
		Aktorea[] emaitza = new Aktorea[lag.length];
		for(int i = 0; i < lag.length; i++) {
			emaitza[i] = mapa.get(lag[i]);
		}
		return emaitza;
	}

	public Filma[] filmHashMapToArray(HashMap<String, Filma> mapa) {
		//beste metodoak gauzatzeko erabilia
		Object[] lag = mapa.keySet().toArray();
		Filma[] emaitza = new Filma[lag.length];
		for(int i = 0; i < lag.length; i++) {
			emaitza[i] = mapa.get(lag[i]);
		}
		return emaitza;
	}

	public ListaFilmak getListaFilmak() {
		//HashMapeko filmak ListaFilmak bezala
		//itzultzen ditu
		ListaFilmak emaitza = new ListaFilmak();
		Filma[] lag = this.filmHashMapToArray(mapaFilmak);
		for(int i = 0; i < lag.length; i++) emaitza.gehitu(lag[i]);
		return emaitza;
	}

	public ListaAktoreak getListaAktoreak() {
		//HashMapeko aktoreak ListaAktoreak
		//bezala itzultzen du
		//Metodo hau HashMap handiekin
		//ez da eraginkorra
		ListaAktoreak emaitza = new ListaAktoreak();
		Aktorea[] lag = this.AktoreHashMapToArray(this.mapaAktoreak);
		for(int i = 0; i < lag.length; i++) emaitza.gehitu(lag[i]);
		return emaitza;
	}

	public Aktorea bilatuAktorea(String giltza) {
		//null itzultzen du aktorea ez badago
		System.out.println(this.mapaAktoreak.get(giltza));
		return this.mapaAktoreak.get(giltza);
	}	

	public Filma bilatuFilma(String giltza) {
		//null itzultzen du filma ez badago
		return this.mapaFilmak.get(giltza);
	}

	public UnorderedDoubleLinkedList<Aktorea> getFilmarenAktoreak(String filmaStr) {
		Filma film = null;
		try {
			film = this.mapaFilmak.get(filmaStr);
		} catch (Exception e) {
			System.out.println("ERROREA gertatu da filma bilatzean");
		}
		return film.getAktoreak();
	}

	public UnorderedDoubleLinkedList<Filma> getAktorearenFilmak(String aktoreaStr) {
		Aktorea aktore = null;
		try {
			aktore = this.mapaAktoreak.get(aktoreaStr);
		} catch (Exception e) {
			System.out.println("ERROREA gertatu da aktorea bilatzean");
		}
		return aktore.getAgertutakoFilmak();
	}

	public Aktorea[] ordenatuAktoreMapa() {
		//quickSort algortimoa erabiliz aktoreen
		//mapa ordenatzen ditu, oso eraginkorra
		Aktorea[] aktoreberriak = this.AktoreHashMapToArray(mapaAktoreak);
		quickSort(aktoreberriak);

		return aktoreberriak;
	}

	/* ------------------------------------------------------------
	   QuickSort algoritmoa, aktoreak ordenatzeko
	   -------------------------------------------------------------*/

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
		//quickSort() metodoan erabiltzen da
		Aktorea lag = taula[ezker];
		taula[ezker] = taula[eskuin];
		taula[eskuin] = lag;
		return taula;
	}

	/* ------------------------------------------------------------
	   Fitxategiak tratatzeko dagokien metodoak
	   -------------------------------------------------------------*/

	public void datuakKargatu(String nomF) {
		//String moduan jasotzen da irakurri beharreko
		//fitxategiaren helbidea
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

	public void idatziFitxategia(Aktorea[] aktoreak, String helbidea) {
		//Fitxategia existitzen bada ezabatu egiten du,
		//eta berria sortzen du
		Path file = Paths.get(helbidea);
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
}
