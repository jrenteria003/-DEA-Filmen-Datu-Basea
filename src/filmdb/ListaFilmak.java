package filmdb;

import java.util.ArrayList;

public class ListaFilmak {
  private ArrayList<Filma> filmak;
  public int length = 0;

  public ListaFilmak() {
	this.filmak = new ArrayList<Filma>();
  }

  public void gehitu(Filma f) {
	if(!this.filmak.contains(f)) this.filmak.add(f);
	this.length++;
  }

  public void kendu(Filma f) {
	if(!this.filmak.contains(f)) this.filmak.remove(f);
	this.length--;
  }

  public boolean badago(Filma f) {
	return this.filmak.contains(f);
  }

  public void print() {
	for(int i = 0; i < this.filmak.size(); i++) {
	  System.out.println(this.filmak.get(i).getIzena());
	}
  }

  public Filma get(int i) {
	//i indizean dagoen filma bueltatzen du
	return this.filmak.get(i);
  }

  public void print() {
	//ListaFilma honetan dauden
	//filma bakoitzaren izenak
	//printeatzen ditu
	for(int i = 0; i < this.filmak.size(); i++) {
	  System.out.println(this.filmak.get(i).getIzena());
	}
  }
}
