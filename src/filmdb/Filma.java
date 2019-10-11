package filmdb;

public class Filma {
  private String izena;
  private ListaAktoreak aktoreak;
  private int dirua;

  public Filma(String pIzena, int pDirua) {
	//Eraikitzailea
	this.izena = pIzena;
	this.dirua = pDirua;
	this.aktoreak = new ListaAktoreak();
  }

  public Filma(String pIzena) {
	//Eraikitzailea
	this.izena = pIzena;
	this.dirua = 0;
	this.aktoreak = new ListaAktoreak();
  }

  public ListaAktoreak getAktoreak() {
	return this.aktoreak;
  }

  public String getIzena() {
	return this.izena;
  }

  public void gehituAktorea(Aktorea p) {
	//Aktorea listan ez badago
	//listara gehitzen du
	this.aktoreak.gehitu(p);
	p.gehituFilma(this);
  }

  public void kenduAktorea(Aktorea p) {
	//Aktorea listan ez badago
	//listatik kentzen du
	this.aktoreak.kendu(p);
	p.kenduFilma(this);
  }

  public void gehituDirua(int d) {
	this.dirua = this.dirua + d;
  }

  public void kenduDirua(int d) {
	this.dirua = this.dirua - d;
  }

  public void setDirua(int d) {
	this.dirua = d;
  }

  public void print() {
	//Filmari buruzko informazioa bistaratu
	System.out.println(this.izena+" filmak "+this.dirua+" dirua lortu du");
	System.out.println("eta hurrengo aktoreak agertu dira filman:");
	this.aktoreak.print();
  }
}
