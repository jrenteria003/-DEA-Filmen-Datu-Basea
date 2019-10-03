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
			this.agertutakoFilmak.gehituFilma(f);
	}
	
	public void kenduFilma(Filma f) {
		if(this.agertutakoFilmak.badago(f))
			this.agertutakoFilmak.kenduFilma(f);
	}

}
