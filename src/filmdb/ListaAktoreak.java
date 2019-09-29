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
		this.aktoreak.add(p);
	}

}
