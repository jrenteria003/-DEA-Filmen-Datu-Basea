package filmdb;

import java.util.Iterator;

public class OrderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements OrderedListADT<T> {
	
	public void add(T elem){
		// KOSTUA = O(n)
		Node<T> unekoa = this.first;
		if(unekoa == null) {
			Node<T> berria = new Node<T>(elem);
			this.first = berria;
			this.count++;
			return;
		}
		boolean sartuDa = false;
		while(unekoa != this.first || !sartuDa) {
			if(!sartuDa) sartuDa = true;
			if(unekoa.data.toString().compareTo(elem.toString()) >= 0) {
				sartuDa = false;
				Node<T> berria = new Node<T>(elem);
				berria.next = unekoa.next;
				berria.prev = unekoa;
				this.count++;
				return;
			}
			unekoa = unekoa.next;
		}
	}

	public void merge(DoubleLinkedList<T> zerrenda){
		// KODEA OSATU ETA KOSTUA KALKULATU
		Iterator<T> itr = this.iterator();
		while(itr.hasNext()) {
			T unekoa = itr.next();
			this.add(unekoa);
		}
	}

	public void visualizarNodos() {
		Iterator<T> itr = this.iterator();
		while(itr.hasNext()) {
			T unekoa = itr.next();
			System.out.println(unekoa.toString());
		}
	}
}
