package filmdb;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {

	public UnorderedDoubleLinkedList() {
		super();
	}

	public void addToFront(T elem) {
		// hasieran gehitu
		// KOSTUA = O(1)
		Node<T> berria = new Node<T>(elem);
		Node<T> lehen = this.first;
		berria.next = this.first;
		berria.prev = this.first.prev;
		lehen.prev = berria;
		this.first = berria;
		
		this.count++;
	}

	public void addToRear(T elem) {
		// bukaeran gehitu
		// KOSTUA = O(1)
		if(this.first==null) {
			this.first = new Node<T>(elem);
			this.first.prev = this.first;
		} else {
			Node<T> berria = new Node<T>(elem);
			Node<T> azkena = this.first.prev;
			berria.next = this.first;
			berria.prev = azkena;
			azkena.next = berria;
			this.first.prev = berria;

		}
		this.count++;
	}

	public void addAfter(T elem, T target) {
		// KODEA OSATU ETA KOSTUA KALKULATU (AUKERAZKOA)
		// KOSTUA = O(n)
		Node<T> unekoa = this.first;
		boolean sartuDa = false;
		while(unekoa != this.first && !sartuDa) {
			if(!sartuDa) sartuDa = true;
			if(unekoa.data.equals(target)) {
				Node<T> berria = new Node<T>(elem);
				berria.next = unekoa.next.next;
				unekoa.next = berria;
				berria.prev = unekoa;
				sartuDa = false;
				break;
			}
			unekoa = unekoa.next;
		}
		this.count++;
	}
}
