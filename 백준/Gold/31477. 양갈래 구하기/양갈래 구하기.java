

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static List<Data>[] list;


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

		int result = find(1,Integer.MAX_VALUE);
		System.out.println(result);
	}

	public static int find(int idx, int parent) {
		int sum = 0;

		for (Data next : list[idx]) {
			if(next.to == parent) continue;
			sum += Math.min(next.cost, find(next.to, idx));
		}

		if (sum == 0) {
			sum = Integer.MAX_VALUE;
		}
		return sum;
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
