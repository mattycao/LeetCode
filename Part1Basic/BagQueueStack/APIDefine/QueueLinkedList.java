/*
 * The queue implement with the linkedList
 */
import java.util.Iterator;
public class QueueLinkedList<Item> implements Iterable<Item> {
	private class Node{
		private Node next;
		private Item item;
	}
	private Node first;
	private Node last;
	private int N;
	public boolean isEmpty() {
		return N == 0;
	}
	public int size() {
		return N;
	}
	public void enqueue(Item item) {
		Node node = new Node();
		node.item = item;
		if(last == null) {
			first = node;
		}else {
			last.next = node;
		}
		last = node;
		N++;
	}
	public Item dequeue() {
		if(first == null)
			return null;
		Item item = first.item;
		first = first.next;
		N--;
		if(N == 0)
			last = null;
		return item;
	}

	public Iterator<Item> iterator() {
		return new QueueIterator();
	}
	private class QueueIterator implements Iterator<Item> {
		private Node node = first;
		public boolean hasNext() {
			return node != null;
		}
		public Item next() {
			Item item = node.item;
			node = node.next;
			return item;
		}
		public void remove() {
			// not implements
		}
	}
}
