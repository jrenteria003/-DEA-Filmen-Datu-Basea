package filmdb;

import java.util.ArrayList;

public class ListaFilmak {
	private ArrayList<Filma> filmak;

	public void sortuListaFilmak() {
		this.filmak = null;
	}

	public ArrayList<Filma> getFilmak() {
		return this.filmak;
	}

	public void gehituFilma(Filma f) {
		this.filmak.add(f);
	}

	public void kenduFilma(Filma f) {
		this.filmak.remove(f);
	}

}
