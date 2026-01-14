

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static List<Data>[] list;
	public static boolean[] visited;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			list[A].add(new Data(B, V));
			list[B].add(new Data(A, V));
		}

		visited = new boolean[N + 1];
		visited[1] = true;
		int result = find(1,Integer.MAX_VALUE);
		System.out.println(result);
	}

	public static int find(int idx, int value) {
		visited[idx] = true;
		// System.out.println("idx = "+idx);
		int min = value;
		int sum = 0;
		for (Data next : list[idx]) {
			if(visited[next.to]) continue;
			// System.out.println("next = "+next);
			sum += find(next.to, next.cost);
			// System.out.println("idx = "+idx + ", sum = "+sum);
		}

		// System.out.println("sum = "+sum + ", value = "+value);
		if(sum == 0)
			sum = Integer.MAX_VALUE;
		return Math.min(sum,value);
	}

	public static class Data{
		int to;
		int cost;

		@Override
		public String toString() {
			return "Data{" +
				"to=" + to +
				", cost=" + cost +
				'}';
		}

		public Data(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
}
