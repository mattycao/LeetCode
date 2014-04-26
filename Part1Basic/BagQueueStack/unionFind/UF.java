/*
 * The simple way of union find
 */
public class UF {
	private int[] id;
	private int count;

	public UF(int N) {
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
		return id[i];
	}
	public void union(int i, int j) {
		int iID = find(i);
		int jID = find(j);
		if(iID == jID) {
			return;
		} else {
			for(int t = 0; t < id.length; t++) {
				if(id[t] == iID) {
					id[t] = jID;
				}
			}
			count--;
		}
	}

}