package algo_202412;

import java.io.*;
import java.util.*;

public class BJ_21940_가운데에서만나기 {
	public static int N, M;
	public static int[][] data;
	public static int K;
	public static int[] city;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		data = new int[N+1][N+1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			if (data[from][to] == 0) {
				data[from][to] = cost;
			} else {
				data[from][to] = Math.min(data[from][to], cost);
			}
		}

		K = Integer.parseInt(br.readLine());
		city = new int[K];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			city[i] = Integer.parseInt(st.nextToken());
		}

		for (int j = 1; j <= N; j++) {
			for (int i = 1; i <= N; i++) {
				int go = data[i][j];
				if(go == 0) continue;
				for (int k = 1; k <= N; k++) {
					int back = data[j][k];
					if(back == 0) continue;
					if (data[i][k] == 0) {
						data[i][k] = go + back;
					} else {
						// System.out.println("i = "+i + ", k = "+k + " go= "+ go + ", back = "+back);
						data[i][k] = Math.min(data[i][k], go + back);
					}
				}
			}
		}

		int min = Integer.MAX_VALUE;
		Set<Integer> set = new TreeSet<>();
		for (int i = 1; i <= N; i++) {
			int max = 0;
			for (int j = 0; j < K; j++) {
				int c = city[j];
				if (i == c) {
					max = Math.max(max, data[i][c]);
				} else {
					max = Math.max(max, data[c][i] + data[i][c]);
				}
			}
			if (min > max) {
				set = new TreeSet<>();
				min = max;
				set.add(i);
			} else if (min == max) {
				set.add(i);
			}
		}

		// for (int i = 0; i <= N; i++) {
		// 	System.out.println(Arrays.toString(data[i]));
		// }

		// Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		set.stream().forEach(i -> sb.append(i).append(" "));
		System.out.println(sb);

	}

	public static class Data{
		int to;
		int cost;

		public Data(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
}
