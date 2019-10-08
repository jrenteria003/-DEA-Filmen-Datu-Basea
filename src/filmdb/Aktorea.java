package filmdb;

public class Aktorea {
	private String izena;
	private ListaFilmak agertutakoFilmak;
	
	public Aktorea(String pIzena) {
		this.izena=pIzena;
		agertutakoFilmak = new ListaFilmak();
	}

	public String getIzena() {
		return this.izena;
	}
	
	public ListaFilmak getAgertutakoFilmak() {
		return this.agertutakoFilmak;
	}
	
	public void gehituFilma(Filma f) {
		if(!this.agertutakoFilmak.badago(f)) 
			this.agertutakoFilmak.gehitu(f);
	}
	
	public void kenduFilma(Filma f) {
		if(this.agertutakoFilmak.badago(f))
			this.agertutakoFilmak.kendu(f);
	}

	public int compareTo(Aktorea lag) {
		return this.izena.compareTo(lag.getIzena());
	}

	public void print() {
		System.out.println(this.izena+" agertu den filmak:");
		this.agertutakoFilmak.print();
	}

}
