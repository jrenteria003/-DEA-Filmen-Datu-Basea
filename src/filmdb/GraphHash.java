package filmdb;

import java.util.*;


public class GraphHash {
	private static GraphHash gureGrafoa;
	private HashMap<String, ArrayList<String>> g;
	private HashMap<String, Double> pageRank = this.pageRank();
	
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
				if (aztertuak.contains(aux)){
					
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
	
	public ArrayList<String> erlazionatuta(String a1, String a2){
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
				if (aztertuak.contains(aux)){ //mirar si tendria que ser aux o su primera relaci�n�
					
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
		if (aurkituta==false){
			aztertuak=null;
		}
		return aztertuak;
	}

	
	public HashMap<String, Double> pageRank(){
		HashMap <String,Double> aux = new HashMap<String,Double>();
		HashMap <String,Double> emaitza = new HashMap<String,Double>();
		double errorea = 100.0;
		double d = 0.85;
		int n = this.g.size();
		double hasieraProb = 1/n;
		double lehenZatidura = (1-d)/n;
	
		
		for (Map.Entry<String,ArrayList<String>> entry: g.entrySet()) {
			aux.put(entry.getKey(),hasieraProb);
		}
		
		while(errorea > 0.0001) {
			for(Map.Entry<String,ArrayList<String>> entry: g.entrySet()){
				String unekoa = entry.getKey();
				double probUnekoa = aux.get(unekoa);
				ArrayList<String> erlazioak = entry.getValue();// unekoaren erlazioak 
				int erlazioLuzera = erlazioa.size();
				for (int h=0; h<erlazioak.size; h++) {
					String lag = erlazioak(h);
					if (!emaitza.containsKey(lag)) {
						emaitza.put(lag, probUnekoa/erlazioLuzera);
					} else {		
						double probBerria = emaitza.get(lag) + (probUnekoa/erlazioLuzera);
						emaitza.put(lag, probBerria);
					}
				}
				for (Map.Entry<String,Double> entry: emaitza.entrySet()) {
					String unekoaEmaitza = entry.getKey();
					double balioa = entry.getValue();
					double azkenProb = lehenZatidura + (d*balioa);
					emaitza.put(lag, azkenProb);								
				}
				for (Map.Entry<String,Double> entry: emaitza.entrySet()) {
					String unekoa = entry.getKeyy();
					unekoBalioa = unekoBalioa + Math.abs(emaitza.get(unekoa)- aux.get(unekoa));
				}
			}
			errorea = unekoBalioa;			
		}
		return emaitza;		
	}
	
	public ArrayList<Bikote> bilatzailea(String gakoHitz){
		HashMap<String,Double> aux = new HashMap<String, Double>();
		Iterator<String> it = this.pageRank.keySet().iterator();
		ArrayList<Bikote> emaitza = new ArrayList<Bikote>();
		while(itr.hasNext()) {
			String unekoa = it.next();
			if(unekoa.contains(gakoHitz)){
				aux.put(unekoa, this.pageRank.get(unekoa));
			}
		}
		aux = sortByValue(aux); 
		Iterator <String> it2 = lag.keySet().iterator();
		HashMap<String, Double> hash = new HashMap<String,Double>();
		if(it2.hasNext()) {
			String unekoa = it2.next();
			if(ListaAktoreak.getAktoreak().badago(unekoa)){ //Aktorea bada
				Iterator<Filma> itFilm = ListaAktoreak.getListaAktoreak().getAktorearenFilmak(unekoa).getIterator();
				while(itrFilm.hasNext()) {
					Filma film = itFilm.next();
					String izena = film.getIzena();
					hash.put(izena,pageRank.get(film));
				}
			}
			else { //Filma bada
				Filma film = new Filma (unekoa);
				Iterator<Aktorea> itAktore = ListaAktoreak.getNireListaAktoreak.getFilmarenAktoreak(unekoa).getIteradorea();
				while (itAktore.hasNext()) {
					Aktorea a = itAktore.next();
					String izena = a.getIzena();
					hash.put(izena, pageRank.get(a));
				}
			}
		}
		hash = this.sortByValue(hash);
		Iterator<String> itrEmaitza = hash.keySet().iterator();
		while(itrEmaitza.hasNext()) {
			String unekoBikotea = itrEmaitza.next();
			Bikote b = new Bikote(unekoBikotea, pageRank.get(unekoBik));
			emaitza.add(b);
		}
		return emaitza;
	}	
	
	public HashMap<String, Double> sortByValue(HashMap<String, Double> hashMap) {
		List<Map.Entry<String, Double> > lista = new LinkedList<Map.Entry<String,Double> >(hashMap.entrySet());
		Collections.sort(lista, new Comparator<Map.Entry<String, Double> >() {
			public int compare(Map.Entry<String, Double> balio2, Map.Entry<String, Double> balio1) {
				return (balio1.getValue()).compareTo(balio2.getValue());
			}
		} );
		HashMap<String, Double> bueltatu = new LinkedHashMap<String, Double>();
		for (Map.Entry<String, Double> aux : list) {
			bueltatu.put(aux.getKey(), aux.getValue());
		}
		return bueltatu;
	}


}


