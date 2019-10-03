package filmdb;

import java.util.ArrayList;
//import java.util.HashMap;

public class ListaFilmak {
	//private HashMap<String,Filma> mapaFilmak;
	private ArrayList<Filma> filmak;

	public ListaFilmak() {
		this.filmak = new ArrayList<Filma>();
		//this.mapaFilmak=new HashMap<String,Filma>();
	}

	//public HashMap<String,Filma> getFilmak() {
	//	return this.mapaFilmak;
	//}

	public void gehituFilma(Filma f) {
		if(!this.filmak.contains(f)) this.filmak.add(f);
	}

	public void kenduFilma(Filma f) {
		if(!this.filmak.contains(f)) this.filmak.remove(f);
	}
	
	public boolean badago(Filma f) {
		return this.filmak.contains(f);
	}

}
