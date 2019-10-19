package filmdb;

public class Aktorea {
	private String izena;
	private ListaFilmak agertutakoFilmak;

	public Aktorea(String pIzena) {
		//Eraikitzailea
		this.izena = pIzena;
		agertutakoFilmak = new ListaFilmak();
	}

	public Aktorea(String pIzena, Filma[] pFilmak) {
		//Eraikitzailea
		this.izena = pIzena;
		agertutakoFilmak = new ListaFilmak();
		for(int i = 0; i < pFilmak.length; i++) {
			agertutakoFilmak.gehitu(pFilmak[i]);
			pFilmak[i].gehituAktorea(this);
		}
		FilmDB nireFilmDB = FilmDB.getFilmDB();
		nireFilmDB.gehituAktorea(this);
	}

	public String getIzena() {
		return this.izena;
	}

	public ListaFilmak getAgertutakoFilmak() {
		//Aktoreak parte hartu dituen filmen
		//lista itzultzen du
		return this.agertutakoFilmak;
	}

	public void gehituFilma(Filma f) {
		//Aktoreen ListaFilman f filma gehitzen
		//du, lehenago badagoen konprobatzen du
		if(!this.agertutakoFilmak.badago(f)) 
			this.agertutakoFilmak.gehitu(f);
	}

	public void kenduFilma(Filma f) {
		//filma badago ListaFilmatik kendu
		//bestela ezer
		if(this.agertutakoFilmak.badago(f))
			this.agertutakoFilmak.kendu(f);
	}

	public int compareTo(Aktorea lag) {
		//Bi aktoreen izenak konparatzen ditu
		return this.izena.compareTo(lag.getIzena());
	}

	public void print() {
		//Aktorearei buruzko informazioa printeatzen ditu
		System.out.println(this.izena+" agertu den filmak:");
		this.agertutakoFilmak.print();
	}

}
