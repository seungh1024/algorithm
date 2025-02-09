import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[][] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N][N];

		int[][] origin = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
				origin[i][j] = data[i][j];
			}
		}

		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N; i++) {
				if(i == j || data[i][j] == 0) continue;
				for (int k = 0; k < N; k++) {
					if(j == k || i == k|| data[j][k] == 0) continue;
					if (data[i][j] + data[j][k] == data[i][k]) {
						data[i][k] -= (data[i][j] + data[j][k]);
					}
				}
			}
		}

		// for (int i = 0; i < N; i++) {
		// 	System.out.println(Arrays.toString(data[i]));
		// }

		int sum = 0;
		int[][] copy = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copy[i][j] = data[i][j];
				if (j >= i) {
					sum += copy[i][j];
				}
			}
		}

		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N; i++) {
				if(i == j || copy[i][j] == 0) continue;
				for (int k = 0; k < N; k++) {
					if(j == k || i == k || copy[j][k] == 0) continue;

					if (copy[i][k] == 0) {
						copy[i][k] = copy[i][j] + copy[j][k];
					} else {
						copy[i][k] = Math.min(copy[i][k], copy[i][j] + copy[j][k]);
					}
				}
			}
		}




		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (copy[i][j] != origin[i][j]) {
					System.out.println(-1);
					return;
				}
			}
		}

		System.out.println(sum);
	}

}