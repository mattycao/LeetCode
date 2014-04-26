/*
 * This part is used for handling the basic operation of array
 */
public class ArrayHandle {
	// reverse the array
	public void reverseArray(int[] array) {
		for(int i = 0; i < array.length/2; i++) {
			int temp = array[i];
			array[i] = array[array.length - 1 - i];
			array[array.length - 1 - i] = temp;
		}
	}

	// produce the result of matrix multiple
	public int[][] multipleMatrix(int[][] a, int[][] b) {
		int N = a.length;
		int[][] c = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					c[i][j] += a[i][k] + b[k][j];
				}
			}
		}
		return c;
	}


}