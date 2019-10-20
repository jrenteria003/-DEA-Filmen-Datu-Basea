package filmdb;

public class OrderedDoubleLinkedList<T> implements OrderedListADT<T> {
	public void add(T elem) {
		//TODO
	}

	public void merge(OrderedLinkedList<T> z) {
		//TODO
	}

	public void setDescr(String nom) {
		//TODO
	}

	public String getDescr() {
		return deskr;
	}

	public T removeFirst() {
		Node berria = new Node();
		berria.next = first.getNextSibling();
		berria.prev = first.getPreviousSibling();
	}

	public T removeLast() {
		//TODO
	}

	public T remove(T elem) {
		//TODO
	}

	public T first() {
		return this.first.getNodeValue();
	}

	public T last() {
		//TODO
	}

	public boolean contains(T elem) {
		//TODO
	}

	public T find(T elem) {
		//TODO
	}

	public boolean isEmpty() {
		return this.first == null;
	}

	public int size() {
		return this.count;
	}

	public Iterator<T> iterator() {
		//TODO
	}
}
