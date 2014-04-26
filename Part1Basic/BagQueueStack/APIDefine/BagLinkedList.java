/*
 * The bag implements with the LinkedList
 */
import java.util.Iterator;
public class BagLinkedList<Item> implements Iterable<Item> {
	private class Node {
		Item item;
		Node next;
	}
	private Node first;
	private int N;
	public boolean isEmpty(){
		return N == 0;
	}
	public void add(Item item) {
		Node node = new Node();
		node.item = item;
		node.next = first;
		first = node;
		N++;
	}
	public Iterator<Item> iterator() {
		return new ListTerator();
	}
	private class ListTerator implements Iterator<Item> {
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
			//not impelments anything
		}
	}

}