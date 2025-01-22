import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static long[][] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new long[N+1][N+1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				long in = Long.parseLong(st.nextToken());
				data[i][j] = in;
			}
		}

		for (int i = 0; i <= N; i++) {
			for (int j = N; j > 0; j--) {
				data[i][j] -= data[i][j-1];
			}
		}

		for (int i = N; i > 0; i--) {
			for (int j = 0; j <= N; j++) {
				data[i][j] -= data[i-1][j];
			}
		}

		// for (int i = 0; i <= N; i++) {
		// 	System.out.println(Arrays.toString(data[i]));
		// }

		long[][] result = new long[N][N];
		int size = M/2;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (data[i][j] < 0) {
					long value = -data[i][j];
					data[i][j] += value;
					data[i+M][j] -= value;
					data[i][j+M] -= value;
					data[i + M][j + M] += value;
					result[i+size][j+size] += value;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}