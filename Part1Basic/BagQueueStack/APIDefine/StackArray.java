/*
 * Push down(LIFO) stack( implements in array with array resize)
 */
import java.util.Iterator;
public class StackArray<Item> implements Iterable<Item> {
	@SuppressWarnings("unchecked")
	private Item[] a = (Item[])new Object[1];
	private int N = 0;
	public boolean isEmpty() {
		return N == 0;
	}
	public int size() {
		return N;
	}
	private void resize(int max) {
		@SuppressWarnings("unchecked")
		Item[] temp = (Item[])new Object[max];
		for(int i = 0; i < N; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}
	public void push(Item item) {
		if(N == a.length) resize(N * 2);
		// use the corrent value then add one for it
		a[N++] = item;
	}
	public Item pop() {
		if(N == 0)
			return null;
		Item item = a[--N];
		a[N] = null; // for the loitering
		if(N > 0 && N == a.length/4) {
			resize(N/2);
		}

		return item;
	}
	public Iterator<Item> iterator() {
		return new StackIterator();
	}

	private class StackIterator implements Iterator<Item> {
		private int i = N;
		public boolean hasNext() {
			return i > 0;
		}
		public Item next() {
			return a[--i];
		} 
		public void remove() {
			// not implement here
		}
	}
}