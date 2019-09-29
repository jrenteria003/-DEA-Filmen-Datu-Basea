package filmdb;

public class ListaFilmak {
	private ArrayList<Filma> filmak;

	public void sortuListaFilmak() {
		this.filmak = null;
	}

	public ListaFilmak getFilmak() {
		return this.filmak;
	}

	public void gehituFilma(Filma f) {
		this.filmak.add(f);
	}

	public void kenduFilma(Filma f) {
		this.filmak.remove(f);
	}

}
