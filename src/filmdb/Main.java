package filmdb;

public class Main {
	public static void main(String[] args) {
		FilmDB nireFilmDB;
		nireFilmDB = FilmDB.getFilmDB();
		nireFilmDB.datuakKargatu(args[0]);
		Stopwatch timer = new Stopwatch();
		nireFilmDB.ordenatuAktoreMapa();
		System.out.println(timer.elapsedTime());
		//		ListaFilmak filmak = nireFilmDB.getListaFilmak();
		//		ListaAktoreak aktoreak = nireFilmDB.getListaAktoreak();
		//		Filma filma = filmak.get(3);
		//		Aktorea akt = aktoreak.get(3);
		//		System.out.println("3 Indizean dagoen aktorea:");
		//		akt.print();
		//		System.out.println("3 Indizean dagoen filma");
		//		filma.print();
		//		filma = filmak.get(666);
		//		ListaAktoreak aktoreak2 = filma.getAktoreak();
		//		aktoreak2.print();
		//		System.out.println();
		//		Filma[] filmarray = {filma, filmak.get(1936)};
		//		Aktorea aktoreberria = new Aktorea("Durruti, Buenaventura", filmarray);
		//		aktoreberria.print();
		//		Aktorea aktoreberria2 = nireFilmDB.bilatuAktorea("Durruti, Buenaventura");
		//		aktoreberria2.print();
		Aktorea aktorea3 = nireFilmDB.bilatuAktorea("Tarantino, Quentin");
		//aktorea3.print();
		Aktorea aktorea4 = nireFilmDB.bilatuAktorea("Phoenix, Joaquin");
		Filma jokerfilma = new Filma("Joker", 666);
		jokerfilma.gehituAktorea(aktorea4);
		aktorea4.print();
		Aktorea aktorea5 = new Aktorea("Tarantino, Quentin");
		nireFilmDB.gehituAktorea(aktorea5);
		aktorea5.print();
		nireFilmDB.bilatuAktorea("Tarantino, Quentin").print();
		nireFilmDB.getAktorearenFilmak("Wynn, Natalie").print();
	}
}
