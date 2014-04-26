/*
 * The simple way of union find
 */
public class UFWeightedQuickUnionPathCompression {
	private int[] id;
	private int count;
	private int[] size;

	public UFWeightedQuickUnionPathCompression(int N) {
		id = new int[N];
		for(int i = 0; i < N; i++) {
			id[i] = i;
			size[i] = 1;
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
		int curr = i;
		while(id[i] != i) {
			i = id[i];
		}
		int des = i;
		while(id[curr] != curr) {
			curr = id[curr];
			id[curr] = i;
		}
		return i;
	}
	public void union(int i, int j) {
		int iID = find(i);
		int jID = find(j);
		if(iID == jID) {
			return;
		} else {
			if(size[iID] > size[jID]) {
				id[jID] = iID;
				size[iID] += size[jID];
			} else {
				id[iID] = jID;
				size[jID] += size[iID];
			}
			count--;
		}
	}

}