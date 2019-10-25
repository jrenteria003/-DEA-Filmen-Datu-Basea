package filmdb;

public class OrderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements OrderedListADT<T> {
	
	public void add(T elem){
		// KOSTUA = O(n)
		Node<T> unekoa = this.first;
		boolean sartuDa = false;
		while(unekoa != this.first && !sartuDa) {
			if(!sartuDa) sartuDa = true;
			if(unekoa.data.toString().compareTo(elem.toString()) >= 0) {
				sartuDa = false;
				Node<T> berria = new Node<T>(elem);
				berria.next = unekoa.next;
				berria.prev = unekoa;
				break;
			}
			unekoa = unekoa.next;
		}
	}

	public void merge(DoubleLinkedList<T> zerrenda){
		// KODEA OSATU ETA KOSTUA KALKULATU
		
	}

	public void visualizarNodos() {
		// TODO Auto-generated method stub
		
	}

}
