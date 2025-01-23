import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static boolean[][] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		data = new boolean[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			data[from][to] = true;

		}

		for (int j = 1; j <= N; j++) {
			for (int i = 1; i <= N; i++) {
				if(!data[i][j]) continue;
				for (int k = 1; k <= N; k++) {
					if (data[j][k]) {
						data[i][k] = true;
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		int s = Integer.parseInt(br.readLine());
		for (int i = 0; i < s; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			if (data[from][to]) {
				sb.append(-1);
			} else if (data[to][from]) {
				sb.append(1);
			} else {
				sb.append(0);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}


}