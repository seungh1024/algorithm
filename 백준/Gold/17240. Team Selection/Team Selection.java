

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static Data[][] data;
	public static boolean[] visited;
	public static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new Data[5][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				data[j][i] = new Data(i, Integer.parseInt(st.nextToken()));
			}
		}
		for (int i = 0; i < 5; i++) {
			Arrays.sort(data[i], Comparator.comparingInt(o -> -o.v));
		}

		visited = new boolean[N];
		find(0, 0);
		System.out.println(result);

	}
	public static void find(int sum, int idx) {
		if (idx == 5) {
			result = Math.max(result, sum);
			return;
		}

		// N명 전부 볼 필요 없으니 5명만 본다.
		for (int i = 0; i < 5; i++) {
			Data now = data[idx][i];
			if (!visited[now.idx]) {
				visited[now.idx] = true;
				find(sum + now.v, idx + 1);
				visited[now.idx] = false;
			}
		}
	}
	public static class Data{
		int idx;
		int v;

		public Data(int idx, int v) {
			this.idx = idx;
			this.v = v;
		}
	}
}
