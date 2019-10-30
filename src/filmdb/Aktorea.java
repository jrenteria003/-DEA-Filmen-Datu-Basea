package filmdb;

import java.util.Iterator;

public class Aktorea {
	private String izena;
	private UnorderedDoubleLinkedList<Filma> agertutakoFilmak;

	public Aktorea(String pIzena) {
		//Eraikitzailea
		this.izena = pIzena;
		agertutakoFilmak = new UnorderedDoubleLinkedList<Filma>();
	}

	public Aktorea(String pIzena, Filma[] pFilmak) {
		//Eraikitzailea
		this.izena = pIzena;
		agertutakoFilmak = new UnorderedDoubleLinkedList<Filma>();
		for(int i = 0; i < pFilmak.length; i++) {
			agertutakoFilmak.addToRear(pFilmak[i]);
			pFilmak[i].gehituAktorea(this);
		}
		FilmDB nireFilmDB = FilmDB.getFilmDB();
		nireFilmDB.gehituAktorea(this);
	}

	public String getIzena() {
		return this.izena;
	}

	public UnorderedDoubleLinkedList<Filma> getAgertutakoFilmak() {
		//Aktoreak parte hartu dituen filmen
		//lista itzultzen du
		return this.agertutakoFilmak;
	}

	public void gehituFilma(Filma f) {
		//Aktoreen ListaFilman f filma gehitzen
		//du, lehenago badagoen konprobatzen du
		if(!this.agertutakoFilmak.contains(f)) 
			this.agertutakoFilmak.addToRear(f);
	}

	public void kenduFilma(Filma f) {
		//filma badago ListaFilmatik kendu
		//bestela ezer
		if(this.agertutakoFilmak.contains(f))
			this.agertutakoFilmak.remove(f);
	}

	public int compareTo(Aktorea lag) {
		//Bi aktoreen izenak konparatzen ditu
		return this.izena.compareTo(lag.getIzena());
	}

	public void print() {
		//Aktorearei buruzko informazioa printeatzen ditu
		System.out.println(this.izena+" agertu den filmak:");
		Iterator<Filma> itr = this.agertutakoFilmak.iterator();
		while(itr.hasNext()) {
			Filma unekoa = itr.next();
			System.out.println(unekoa.getIzena());
		}
	}
}
