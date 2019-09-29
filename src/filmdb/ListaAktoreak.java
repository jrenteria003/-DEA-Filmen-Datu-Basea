package filmdb;

public class ListaAktoreak {
	private ArrayList<Aktorea> aktoreak;

	public void sortuListaAktoreak() {
		this.aktoreak=null;
	}

	public ListaAktoreak getAktoreak() {
		return this.aktoreak;
	}

	public void gehituAktorea(Aktorea p) {
		if(not(badagoAktorea(p))) this.aktoreak.add(p);
		//TODO errore mezua gehitu
	}

	public boolean badagoAktorea(Aktorea p) {
		if(this.aktoreak.contains(p)) return true;
		else false;
	}

}
