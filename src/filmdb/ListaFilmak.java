package filmdb;

import java.util.ArrayList;
//import java.util.HashMap;

public class ListaFilmak {
	//private HashMap<String,Filma> mapaFilmak;
	private ArrayList<Filma> filmak;
	public int length = 0;

	public ListaFilmak() {
		this.filmak = new ArrayList<Filma>();
	}

	public void gehituFilma(Filma f) {
		if(!this.filmak.contains(f)) this.filmak.add(f);
		this.length++;
	}

	public void kenduFilma(Filma f) {
		if(!this.filmak.contains(f)) this.filmak.remove(f);
		this.length--;
	}
	
	public boolean badago(Filma f) {
		return this.filmak.contains(f);
	}
	
	public void print() {
		for(int i = 0; i < this.filmak.size(); i++) {
			System.out.println(this.filmak.get(i).getIzena());
		}
	}

}
