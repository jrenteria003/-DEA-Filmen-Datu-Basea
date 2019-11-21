package filmdb;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


//HACER SINGLETON

public class GraphHash {
	private static GraphHash gureGrafoa;
	private HashMap<String, ArrayList<String>> g;
	
	public GraphHash(){
		this.g = new HashMap<String,ArrayList<String>>();
	}
	
	public static GraphHash getGraphHash(){
		if (gureGrafoa == null){
			gureGrafoa = new GraphHash();
		}
		return gureGrafoa;
	}
	
	public void gehituAdabetaErla(String adabegi, ArrayList<String> erlazioak){
		if (!this.g.containsKey(adabegi)){
			this.g.put(adabegi, erlazioak);
		}
	}
	
	public void gehituAdabegia(String adabegi){
		if (!this.g.containsKey(adabegi)){
			ArrayList<String> erlazioak= new ArrayList<String>();
			this.g.put(adabegi, erlazioak);
		}
	}
	
	public void gehituErlazioak(String adabegi, String erlazioa){
		if(this.g.containsKey(adabegi) && !this.g.get(adabegi).contains(erlazioa)){
			ArrayList<String> erlazioak=new ArrayList<String> (this.g.get(adabegi));
			erlazioak.add(erlazioa);
			this.g.put(adabegi, erlazioak);
			//this.g.replace(adabegi, g.get(adabegi).add(erlazioa)); HAU TXARTO DAGO
		}
	}

	
	public void grafoaSortu(AktoreenZerrenda lAktoreak){
		// Post: aktoreen zerrendatik grafoa sortzen du
		// Adabegiak aktoreen izenak eta pelikulen izenburuak dira
		//meter como adabegi a todos los (string) actores primero y luego meter como erlazio a cada uno sus peliculas.
		//Posteriormente(lo mismo pero con pelis) meter como adabegi a todos las (string) peliculas y a cada una como erlazio sus actores.
		
	}
		
	public void print(){
		int i = 1;
		for (String s: g.keySet()){
			System.out.print("Element: " + i++ + " " + s + " --> ");
			for (String k: g.get(s)){
				System.out.print(k + " ### ");
			}
			System.out.println();
		}
	}
	
	public boolean konektatuta(String a1, String a2){
		//TODO	
		//basicamente dijkstra if aurkitura return true;
	}

	public void datuakKargatu(String nomF) { 
		
		//NO REDEFINIR QUE LOS DATOS NO SE METEN AL GRAFO DESDE EL TXT SINO QUE SE METEN DESDE LA LISTA DE ACTRIZOS Y DE LA DE PELICULAS DIRECTAMENTE
		//redefinir: por cada nuevo string de actor se mete como adabegi(el metodo comprueba si ya esta) 
		//y como erlazio a la ultima pelicula(el ultimo string antes de --->) y por cada nueva pelicula meterla como adabegi y 
		//a todos los actores (strings que vengan despues de --->) meterle la pelicula como erlazio
		
		
		
		//String moduan jasotzen da irakurri beharreko
		//fitxategiaren helbidea
		try{
			Scanner entrada = new Scanner(new FileReader(nomF));
			String linea;
			Filma f = null;
			//UnorderedDoubleLinkedList<Aktorea> aktors = null;
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
}


