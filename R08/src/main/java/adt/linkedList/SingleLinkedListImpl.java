package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
        return (this.head.isNIL());
	}

	@Override
	public int size() {
        if (isEmpty()) return 0;

        int size = 0;
        SingleLinkedListNode<T> aux = head;
        while (!(aux.isNIL())) {
            size++;
            aux = aux.getNext();
        }
        return size;
	}

	@Override
	public T search(T element) {
        if (head.isNIL()) return null;
        if (head.getData().equals(element)) return head.getData();

        SingleLinkedListNode<T> aux = head;
        while (!(aux.isNIL())) {
            if (aux.getData().equals(element)) return aux.getData(); 
            aux = aux.getNext();
        }

        return null;
	}

	@Override
	public void insert(T element) {
        if (head.isNIL()) {
            head.setData(element);
            head.setNext(new SingleLinkedListNode<T>());
        } else {
            SingleLinkedListNode<T> aux = head;
            while (!(aux.isNIL())) aux = aux.getNext();
            aux.setData(element);
            aux.setNext(new SingleLinkedListNode<T>());
        }
	}

	@Override
	public void remove(T element) {
        if (!isEmpty()) {
            SingleLinkedListNode<T> aux = head;
            while (!aux.getData().equals(element) && !aux.isNIL()) aux = aux.getNext();
            if (!aux.isNIL()) {
                aux.setNext(aux.getNext().getNext());
                aux.setData(aux.getNext().getData());
            }
        }
	}

	@Override
	public T[] toArray() {
        T[] array = (T[]) new Object[this.size()];

        int i = 0;
        SingleLinkedListNode<T> aux = head;
        while (!aux.isNIL()) {
            array[i++] = aux.getData();
            aux = aux.getNext();
        }

        return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
