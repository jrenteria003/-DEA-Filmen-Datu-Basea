package filmdb;

public class Main {
	public static void main(String[] args) {
		FilmDB nireFilmDB;
		nireFilmDB = FilmDB.getFilmDB();
		nireFilmDB.datuakKargatu("/home/jonr/gits/-DEA-Filmen-Datu-Basea/src/filmdb/lista2.txt");
		nireFilmDB.ordenatuAktoreMapa();
	}
}
