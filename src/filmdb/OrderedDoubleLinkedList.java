package filmdb;

import java.util.Iterator;

public class OrderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements OrderedListADT<T> {
	
	public void add(T elem){
		// KOSTUA = O(n)
		Node<T> unekoa = this.first;
		Node<T> berria = new Node<T>(elem);
		if(unekoa == null) {
			this.first = berria;
			this.first.next = this.first;
			this.first.prev = this.first;
			this.count++;
			return;
		}
		boolean sartuDa = false;
		if(this.first.next == null || this.first.prev == null) {
			if(this.first.data.toString().compareTo(berria.data.toString()) <= 0) {
				this.first.next = berria;
				berria.prev = this.first;
				berria.next = this.first;
				this.first.prev = berria;
				this.count++;
				return;
			}
			if(this.first.data.toString().compareTo(berria.data.toString()) > 0) {
				Node<T> lag = this.first;
				this.first.prev = berria;
				this.first.next = berria;
				berria.next = this.first;
				berria.prev = this.first;
				this.first = berria;
				this.count++;
				return;
			}
		} else {
			while(unekoa != this.first || !sartuDa) {
				if(!sartuDa) sartuDa = true;
				if(this.first.data.toString().compareTo(berria.data.toString()) > 0) {
					berria.prev = this.first.prev;
					this.first.prev = berria;
					berria.next = this.first;
					this.first = berria;
					this.count++;
					return;
				}
				if(unekoa.data.toString().compareTo(berria.data.toString()) <= 0) {
					//Node<T> berria = new Node<T>(elem);
					berria.prev = unekoa.prev;
					berria.next = unekoa;
					unekoa.prev.next = berria;
					unekoa.prev = berria;
					this.count++;
					return;
				}
				unekoa = unekoa.next;
			}
		}
	}

	public void merge(DoubleLinkedList<T> zerrenda){
		// KODEA OSATU ETA KOSTUA KALKULATU
		Iterator<T> itr = zerrenda.iterator();
		while(itr.hasNext()) {
			T unekoa = itr.next();
			//System.out.println("merge, unekoa: " + unekoa + "; kop: " + this.size());
			this.add(unekoa);
		}
	}

	public void visualizarNodos() {
		Iterator<T> itr = this.iterator();
		while(itr.hasNext()) {
			T unekoa = itr.next();
			System.out.println(unekoa);
		}
	}
}
