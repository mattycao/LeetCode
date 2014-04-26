/*
 * The stack implements the linkedlist
 */
import java.util.Iterator;
public class StackLinkedList<Item> implements Iterable<Item> {
	private class Node {
		Item item;
		Node next;
	}
	private Node first;
	private int N;

	public boolean isEmpty() {
		return N == 0;
	}
	public int size() {
		return N;
	}
	public void push(Item item) {
		Node newNode = new Node();
		newNode.item = item;
		newNode.next = first;
		first = newNode;
		N++;
	}
	public Item pop() {
		if(first == null)
			return null;
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	public Iterator<Item> iterator() {
		return new StackListIterator();
	}

	private class StackListIterator implements Iterator<Item> {
		Node node = first;
		public boolean hasNext() {
			return node != null;
		}
		public Item next() {
			Item item = node.item;
			node = node.next;
			return item;
		}
		public void remove() {
			// empty for this
		}
	}
}