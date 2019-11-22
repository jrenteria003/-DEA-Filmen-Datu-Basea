package filmdb;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


//HACER SINGLETON

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
	
	public void gehituErlazioak(String adabegi, String erlazioa){
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
		    this.gehituAdabegia(key);
		    //forEach pelikula in aktore gehituErlazioak(aktore,pelikula)
		    this.gehituErlazioak(key, );
		}
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
	
	public boolean konektatuta(String a1, String a2){
		//TODO	
		//basicamente dijkstra if aurkitura return true;
	}

}


