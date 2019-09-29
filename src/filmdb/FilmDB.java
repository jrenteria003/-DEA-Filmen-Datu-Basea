package filmdb;

public class FilmDB {
	private ListaFilmak filmak;
	private static filmDB gureDB;

	private FilmDB sortufilmDB() {
		this.filmak = new ListaFilmak();
	}

	public int main() {
		datuakKargatu();
		return 0;

	public static Filmdb getFilmDB() {
		return gureDB;
	}

	public void datuakKargatu(String fitxategia) {
		// String a = linea.split("\\s+-->");
		try{
			Scanner entrada = new Scanner(new FileReader(nomF));
			String linea;
			Filma f = null;
			while (entrada.hasNext()) {
				linea = entrada.nextLine();
				String iz = linea.split("\\s+--->");
				f = new Filma(iz, di);
				//f.gehituAktorea(p);
			}
			entrada.close();
		}
		catch(IOException e) {e.printStackTrace();}
	}
}
