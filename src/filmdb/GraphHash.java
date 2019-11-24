package filmdb;

import java.util.*;


public class GraphHash {
	private static GraphHash gureGrafoa;
	private HashMap<String, ArrayList<String>> g;
	
	public GraphHash(){
		this.g = new HashMap<String,ArrayList<String>>();
	}
	
	public static GraphHash getGraphHash(){
		if (gureGrafoa == null){
			gureGrafoa = new GraphHash();
		}
		return gureGrafoa;
	}
	
	public void gehituAdabetaErla(String adabegi, ArrayList<String> erlazioak){
		if (!this.g.containsKey(adabegi)){
			this.g.put(adabegi, erlazioak);
		}
	}
	
	public void gehituAdabegia(String adabegi){
		if (!this.g.containsKey(adabegi)){
			ArrayList<String> erlazioak= new ArrayList<String>();
			this.g.put(adabegi, erlazioak);
		}
	}
	
	public void gehituErlazioa(String adabegi, String erlazioa){
		if(this.g.containsKey(adabegi) && !this.g.get(adabegi).contains(erlazioa)){
			ArrayList<String> erlazioak=new ArrayList<String> (this.g.get(adabegi));
			erlazioak.add(erlazioa);
			this.g.put(adabegi, erlazioak);
			//this.g.replace(adabegi, g.get(adabegi).add(erlazioa)); HAU TXARTO DAGO
		}
	}

	
	public void grafoaSortu(HashMap<String,Aktorea> lAktoreak){
		// Post: aktoreen zerrendatik grafoa sortzen du
		// Adabegiak aktoreen izenak eta pelikulen izenburuak dira
		
		for (HashMap.Entry<String, Aktorea> entry : lAktoreak.entrySet()) {
		    String key = entry.getKey();
		    Aktorea value = entry.getValue();
		    ListaFilmak filmakArray=new ListaFilmak ();
		    filmakArray=value.getAgertutakoFilmak();
		    this.gehituAdabegia(key);
		    //this.gehituAdabetaErla(key, this.arrayFilmIzenak(filmakArray));
		    Iterator<Filma> iteradorea= filmakArray.getIterator();
		    while(iteradorea.hasNext()){
		    	String filmIzena=iteradorea.next().getIzena();
		    	this.gehituErlazioa(key, filmIzena);
		    	this.gehituAdabegia(filmIzena);
		    	this.gehituErlazioa(filmIzena, key);
		    }
		}
	}
	
	public ArrayList<String> arrayFilmIzenak(ListaFilmak filmak){
		ArrayList<String> arrayIzenak=new ArrayList<String>();
		Iterator<Filma> iteradorea= filmak.getIterator();
		while (iteradorea.hasNext()){
			String filmIzena=iteradorea.next().getIzena();
			arrayIzenak.add(filmIzena);
		}
		return arrayIzenak;
	}
	
	public void print(){
		int i = 1;
		for (String s: g.keySet()){
			System.out.print("Element: " + i++ + " " + s + " --> ");
			for (String k: g.get(s)){
				System.out.print(k + " ### ");
			}
			System.out.println();
		}
	}
	
	public Iterator<String> erlazioIterator(String key){
		  Iterator<String> nireIteradorea= this.g.get(key).iterator();
		  return nireIteradorea;
	  }
	
	public boolean konektatuta(String a1, String a2){
		boolean aurkituta=false;
		String aux=a1;
		ArrayList<String> aztertuak= new ArrayList<String>();
		ArrayList<String> aztGabeak= new ArrayList<String>();
		Iterator<String> erlazioak=this.erlazioIterator(aux);
		String hurrengoa;
		
		
		aztGabeak= this.g.get(aux);			//erlazioak sartu, aztertuak ez daudelako
		aztertuak.add(aux);					//unekoa sartu aztertua dagoelako
		
		while (aurkituta==false && !aztGabeak.isEmpty()){
			if (a2==aux) aurkituta=true;
			else{
				if (aztertuak.contains(aux)){ //mirar si tendria que ser aux o su primera relaciónç
					
					aux=aztGabeak.get(0);
					aztGabeak.remove(aux);
					aztertuak.add(aux);
					
					erlazioak=this.erlazioIterator(aux);
					int i=0;
					while (erlazioak.hasNext()){
						hurrengoa=erlazioak.next();
						if (!aztGabeak.contains(hurrengoa) && !aztertuak.contains(hurrengoa)){
							aztGabeak.add(i,hurrengoa);
							i++;
						}		
					}	
				}
				else{					
					aztertuak.add(aux);
					aztGabeak.remove(aux);
					
					erlazioak=this.erlazioIterator(aux);
					int i=0;
					while (erlazioak.hasNext()){
						hurrengoa=erlazioak.next();
						if (!aztGabeak.contains(hurrengoa) && !aztertuak.contains(hurrengoa)){
							aztGabeak.add(i,hurrengoa);	
							i++;
						}		
					}
				}	
			}
		
		}
		return aurkituta;
	}

}


