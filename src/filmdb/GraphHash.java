package filmdb;
import java.util.*;

public class GraphHash {
	HashMap<String, ArrayList<String>> g;
	
	public GraphHash(){
		this.g = new HashMap<String,ArrayList<String>>();
	}
	
	public void grafoaSortu(AktoreenZerrenda lAktoreak){
		// Post: aktoreen zerrendatik grafoa sortzen du
		// Adabegiak aktoreen izenak eta pelikulen izenburuak dira
		//TODO
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
	}

}
