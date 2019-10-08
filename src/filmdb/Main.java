package filmdb;

public class Main {
	public static void main(String[] args) {
		FilmDB nireFilmDB;
		nireFilmDB = FilmDB.getFilmDB();
		nireFilmDB.datuakKargatu(args[0]);
		nireFilmDB.konprobatu();
		Stopwatch timer = new Stopwatch();
		//nireFilmDB.ordenatuAktoreMapa();
		System.out.println(timer.elapsedTime());
		ListaFilmak filmak = nireFilmDB.getListaFilmak();
		ListaAktoreak aktoreak = nireFilmDB.getListaAktoreak();
		Filma filma = filmak.get(3);
		Aktorea akt = aktoreak.get(3);
		System.out.println("3 Indizean dagoen aktorea:");
		akt.print();
		System.out.println("3 Indizean dagoen filma");
		filma.print();
	}

}