package filmdb;

public class Main {
	public static void main(String[] args) {
		FilmDB nireFilmDB;
		nireFilmDB = FilmDB.getFilmDB();
		nireFilmDB.datuakKargatu(args[0]);
		nireFilmDB.konprobatu();
		Stopwatch timer = new Stopwatch();
		nireFilmDB.ordenatuAktoreMapa();
		System.out.println(timer.elapsedTime());
	}

}