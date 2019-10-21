package filmdb;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<T> implements ListADT<T> {

	// Atributuak
	protected Node<T> first; // lehenengoaren erreferentzia
	protected String deskr;  // deskribapena
	protected int count;

	public DoubleLinkedList() {
		first = null;
		deskr = "";
		count = 0;
	}

	public void setDeskr(String ize) {
		deskr = ize;
	}

	public String getDeskr() {
		return deskr;
	}

	public T removeFirst() {
		// listako lehen elementua kendu da
		// Aurrebaldintza: zerrenda ez da hutsa
		// KOSTUA = O(1)
		Node<T> lag = this.first;
		this.first = lag.next;
		this.first.prev = lag.prev;
		this.count--;
		return lag.data;
	}

	public T removeLast() {
		// listako azken elementua kendu da
		// Aurrebaldintza: zerrenda ez da hutsa
		// KOSTUA = O(1)
		Node<T> lag = this.first.prev;
		this.first.prev = lag.prev;
		this.first.prev.next = this.first;
		this.count--;
		return lag.data;
	}


	public T remove(T elem) {
		// Aurrebaldintza: zerrenda ez da hutsa
		// Balio hori listan baldin badago, bere lehen 
		// 	agerpena ezabatuko dut. Kendutako 
		// 	objektuaren erreferentzia 
		//  bueltatuko du (null ez baldin badago)
		// KOSTUA = O(n)
		Node<T> unekoa = this.first;
		T emaitza = null;
		boolean sartuDa = false;
		while(unekoa != this.first && !sartuDa) {
			if(!sartuDa) sartuDa = true;
			if(unekoa.data.equals(elem)) {
				emaitza = unekoa.data;
				Node<T> atzekoa = unekoa.prev;
				Node<T> hurrengoa = unekoa.next;
				atzekoa.next = hurrengoa;
				hurrengoa.prev = atzekoa;
				sartuDa = false;
				this.count--;
			}
			unekoa = unekoa.next;
		}
		return emaitza;
	}

	public T first() {
		// listako lehen elementua ematen du
		if (isEmpty())
			return null;
		else return first.data;
	}

	public T last() {
		// listako azken elementua ematen du
		if (isEmpty())
			return null;
		else return first.prev.data;
	}

	public boolean contains(T elem) {
		// Egiazkoa bueltatuko du aurkituz gero, eta false bestela
		// KOSTUA = O(n)
		if (isEmpty()) return false;
		Node<T> unekoa = this.first;
		boolean sartuDa = false;
		while(unekoa != this.first && !sartuDa) {
			if(!sartuDa) sartuDa = true;
			if(unekoa.data.equals(elem)) {
				sartuDa = false;
				return true;
			}
			unekoa = unekoa.next;
		}
		return false;
	}

	public T find(T elem) {
		// Elementua bueltatuko du aurkituz gero, eta null bestela
		if (isEmpty()){
			Node<T> unekoa = this.first;
			boolean sartuDa = false;
			while(unekoa != this.first && !sartuDa) {
				if(!sartuDa) sartuDa = true;
				if(unekoa.data.equals(elem)) {
					sartuDa = false;
					return unekoa.data;
				}
				unekoa = unekoa.next;
			}
		}
		return null;
	}

	public boolean isEmpty() 
	{ return first == null;};

	public int size() 
	{ return count;};

	/** Return an iterator to the stack that iterates through the items . */ 
	public Iterator<T> iterator() { return new ListIterator(); } 

	// an iterator, doesn't implement remove() since it's optional 
	private class ListIterator implements Iterator<T> { 

		// KODEA OSATU 
	} // private class


	public void adabegiakInprimatu() {
		System.out.println(this.toString());
	}


	@Override
	public String toString() {
		String result = new String();
		Iterator<T> it = iterator();
		while (it.hasNext()) {
			T elem = it.next();
			result = result + "[" + elem.toString() + "] \n";
		}	
		return "SimpleLinkedList " + result + "]";
	}

}
