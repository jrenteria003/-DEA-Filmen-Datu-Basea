package filmdb;

public class Filma {
	private String izena;
	private ListaAktoreak aktoreak;
	private int dirua;
	
	public Filma(String pIzena, int pDirua) {
		this.izena = pIzena;
		this.dirua = pDirua;
		this.aktoreak = new ListaAktoreak();
	}
	
	public Filma(String pIzena) {
		this.izena = pIzena;
		this.dirua = 0;
		this.aktoreak = new ListaAktoreak();
	}

	public ListaAktoreak getAktoreak() {
		return this.aktoreak;
	}
	
	public String getIzena() {
		return this.izena;
	}

	public void gehituAktorea(Aktorea p) {
		this.aktoreak.gehitu(p);
	}

	public void kenduAktorea(Aktorea p) {
		this.aktoreak.kendu(p);
	}

	public void gehituDirua(int d) {
		this.dirua = this.dirua + d;
	}

}
