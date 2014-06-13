public class Insertion {
	public static void sort(Comparable[] a) {
		int length = a.length;
		for(int i= 0; i < length; i++) {
			int min = i;
			for( int j = i + 1; j < length; j++) {
				if(less(a[j], a[min]))
					min = j;
			}
			exchange(a, i, min);
		}
	}

	private static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}

	private static void exchange(Comparable[] a, int i, int min) {
		Comparable temp = a[min];
		a[min] = a[i];
		a[i] = temp;
	}

	private static void show(Comparable[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("");
	}

	public static boolean isSorted(Comparable[] a) {
		for(int i = 1; i < a.length; i++) {
			if(less(a[i], a[i - 1]))
				return false;
		}
		return true;
	}
}