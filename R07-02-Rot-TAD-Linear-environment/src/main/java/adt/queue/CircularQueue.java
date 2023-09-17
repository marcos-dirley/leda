package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
        if (isFull()) throw new QueueOverflowException(); 

        tail = (tail + 1) % array.length;
        array[tail] = element;
        this.elements++;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
        if (isEmpty()) throw new QueueUnderflowException();

        this.elements--;
        int length = this.array.length;
        head = (head + 1) % length;

        return array[head];
	}

	@Override
	public T head() {
        if (isEmpty()) return null;
        return this.array[this.head + 1];
	}

	@Override
	public boolean isEmpty() {
        return (this.elements == 0);
	}

	@Override
	public boolean isFull() {
        return (this.elements == this.array.length);
	}

}
