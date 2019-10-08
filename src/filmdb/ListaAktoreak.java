package filmdb;

import java.util.ArrayList;

public class ListaAktoreak {
	private ArrayList<Aktorea> aktoreak;
	public int length = 0;

	public ListaAktoreak() {
		this.aktoreak = new ArrayList<Aktorea>();
	}

	public ArrayList<Aktorea> getAktoreak() {
		return this.aktoreak;
	}

	public boolean badagoAktorea(Aktorea p) {
		if(this.aktoreak.contains(p)) return true;
		else return false;
	}
	
	public void gehitu(Aktorea a) {
		if(!(badagoAktorea(a))) {
			this.aktoreak.add(a);
			this.length++;
		}
	}
	
	public void kendu(Aktorea a) {
		this.aktoreak.remove(a);
		this.length--;
	}

	public Aktorea get(int i) {
		//i indizean dagoen aktorea bueltatzen du
		return this.aktoreak.get(i);
	}

	public void print() {
		for(int i = 0; i < this.aktoreak.size(); i++) {
			System.out.println(this.aktoreak.get(i).getIzena());
		}
	}

}
