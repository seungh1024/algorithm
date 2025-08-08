

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] visited = new boolean[1000001];
		int[] data = new int[N];
		int[] indexes = new int[1000001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int idx = Integer.parseInt(st.nextToken());
			visited[idx] = true;
			data[i] = idx;
			indexes[idx] = i;
		}

		int[] count = new int[N];
		for (int i = 0; i < N; i++) {
			int v = data[i];
			for (int j = v * 2; j <= 1000000; j += v) {
				if(!visited[j]) continue;
				int idx = indexes[j];
				int v2 = data[idx];
				if (v2 % v == 0) {
					count[i]++;
					count[idx]--;
				}
			}
		}
		// System.out.println(Arrays.toString(count));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(count[i]).append(" ");
		}
		System.out.println(sb);
	}
}
