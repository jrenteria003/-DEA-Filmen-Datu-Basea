package filmdb;

public interface OrderedListADT<T> extends ListADT<T> {
	public void add(T elem);
	public void merge(OrderedLinkedList<T> z);
}
