package filmdb;

//import java.util.ArrayList;
import java.util.HashMap;

public class ListaFilmak {
	private  HashMap<String,Filma> mapaFilmak;
	
	public ListaFilmak{
		this.mapaFilmak=new HashMap<String,Filma>();
	}

	public void sortuListaFilmak() { //no se que es esto
		this.filmak = null;
	}

	public HashMap<String,Filma> getFilmak() {
		return this.mapaFilmak;
	}

	public void gehituFilma(Filma f) {
		if (!(this.mapaFilmak.containsKey(f.getIzena()))){
			this.mapaFilmak.put(f.getIzena(),f);
		}
		else {
			throw new Exception("badago aktorea jadanik"); //ez dakit hau ondo dagoen
		}
		//this.filmak.add(f);
	}

	public void kenduFilma(Filma f) {
		if (this.mapaFilmak.containsKey(f.getIzena())){
			this.mapaFilmak.remove(f.getIzena());
		}
		else {
			throw new Exception("ez dago aktore hau"); //ez dakit hau ondo dagoen
		}
	}

}
