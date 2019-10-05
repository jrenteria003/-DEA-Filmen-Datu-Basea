package filmdb;

import java.util.ArrayList;

public class ListaAktoreak {
	private ArrayList<Aktorea> aktoreak;

	public ListaAktoreak() {
		this.aktoreak = new ArrayList<Aktorea>();
	}

	public ArrayList<Aktorea> getAktoreak() {
		return this.aktoreak;
	}

	public void gehituAktorea(Aktorea p) throws Exception {
		if(!(badagoAktorea(p))){ this.aktoreak.add(p);}
		//else {throw new Exception("badago aktorea jadanik");}
	}

	public boolean badagoAktorea(Aktorea p) {
		if(this.aktoreak.contains(p)) return true;
		else return false;
	}
	
	public void gehitu(Aktorea a) {
		this.aktoreak.add(a);
	}
	
	public void kendu(Aktorea a) {
		this.aktoreak.remove(a);
	}

}
