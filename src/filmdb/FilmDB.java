package filmdb;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.Scanner;

import org.omg.CORBA.portable.InputStream;

public class FilmDB {
	private ListaFilmak filmak;
	private static FilmDB gureDB;

	private FilmDB() {
		this.filmak = new ListaFilmak();
	}

	public int main() {
		datuakKargatu("aaaa");
		return 0;
	}

	public static FilmDB getFilmDB() {
		return gureDB;
	}

	public void datuakKargatu(String fitxategia) {
		// String a = linea.split("\\s+-->");
		//String irakurketa = Files.lines(path).For
		//try{
		//	Scanner entrada = new Scanner(new File(Lista2.txt), "UTF-8");
		//	String linea;
		//	Filma f = null;
		//	Aktorea p = null;
		//	while (entrada.hasNext()) {
		//		linea = entrada.nextLine();
		//		String iz = (String) linea.split("\\s+--->");
		//		f = new Filma(iz);
		//		//f.gehituAktorea(p);
		//	}
		//	entrada.close();
		//}
		//catch(IOException e) {e.printStackTrace();}
		InputStream fitx = (InputStream) this.getClass().getClassLoader().getResourceAsStream("Lista2.txt");

		InputStreamReader in = new InputStreamReader(fitx);
	}
}
