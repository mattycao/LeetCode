/*
 * The simple way of union find
 */
public class UFQuickUnion {
	private int[] id;
	private int count;

	public UFQuickUnion(int N) {
		id = new int[N];
		for(int i = 0; i < N; i++) {
			id[i] = i;
		}
		count = N;
	}

	public int count() {
		return count;
	}
	public boolean connected(int i, int j) {
		return id[i] == id[j];
	}
	public int find(int i) {
		while(id[i] != i) {
			i = id[i];
		}
		return i;
	}
	public void union(int i, int j) {
		int iID = find(i);
		int jID = find(j);
		if(iID == jID) {
			return;
		} else {
			id[iID] = jID;
			count--;
		}
	}

}