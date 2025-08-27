

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] data = new int[N];
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}

		PriorityQueue<Data> pq = new PriorityQueue<>(Comparator.comparingInt(o -> -o.cost));

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if(data[i] == 1 || data[j] == 1) continue;
				if(data[i]*data[j] < 0) continue;
				if(data[i]>=0 && data[j]>=0 && (data[i]*data[j] <=1)) continue;
				pq.offer(new Data(i, j, data[i] * data[j]));
			}
		}


		int result = 0;
		boolean[] visited = new boolean[N];
		while (!pq.isEmpty()) {
			Data now = pq.poll();
			if (!visited[now.a] && !visited[now.b]) {
			// System.out.println(now);
				visited[now.a] = true;
				visited[now.b] = true;
				result += now.cost;
			}
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				result += data[i];
			}
		}
		System.out.println(result);
	}

	public static class Data{
		int a;
		int b;
		int cost;

		public Data(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

		public String toString() {
			return "a = " + a + ", b = " + b + ", cost = " + cost;
		}
	}
}
