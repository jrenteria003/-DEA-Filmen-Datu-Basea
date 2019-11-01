package filmdb;

import java.util.Iterator;

public class OrderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements OrderedListADT<T> {

	public void add(T elem) {
		// KOSTUA = O(n)
		Node<T> berria = new Node<T>(elem);
		if(this.first == null) {
			this.first = berria;
			this.first.next = this.first;
			this.first.prev = this.first;
			this.count++;
		} else {
			Node<T> unekoa = this.first;
			boolean amaitu = false;
			while(!amaitu) {
				if(unekoa.data.toString().compareTo(berria.data.toString()) > 0) {
					if(unekoa == this.first) {
						berria.next = this.first;
						berria.prev = this.first.prev;
						this.first.prev.next = berria;
						this.first.prev = berria;
						this.first = berria;
						amaitu = true;
					} else {
						berria.prev = unekoa.prev;
						berria.next = unekoa;
						unekoa.prev.next = berria;
						unekoa.prev = berria;
						amaitu = true;
					}
					this.count++;
					return;
				} else {
					if(this.first.prev.data.toString().compareTo(berria.data.toString()) <= 0) {
						berria.prev = unekoa.prev;
						berria.next = unekoa;
						unekoa.prev.next = berria;
						unekoa.prev = berria;
						this.count++;
						amaitu = true;
					}
					unekoa = unekoa.next;
				}
			}
		}
	}

	public void merge(DoubleLinkedList<T> zerrenda){
		// KODEA OSATU ETA KOSTUA KALKULATU
		Iterator<T> itr = zerrenda.iterator();
		while(itr.hasNext()) {
			T unekoa = itr.next();
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
