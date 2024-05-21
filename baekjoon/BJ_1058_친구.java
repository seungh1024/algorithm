package algo_202405;

import java.io.*;
import java.util.*;

public class BJ_1058_친구 {
	public static List<Integer>[] list;
	public static int N;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if (input[j] == 'Y') {
					list[i].add(j);
					list[j].add(i);
				}
			}
		}

		find();
	}

	public static void find() {
		int result = 0;
		for (int i = 0; i < N; i++) {
			Queue<Integer> q = new ArrayDeque<>();
			boolean[] visited = new boolean[N];
			visited[i] = true;
			q.offer(i);

			int range = 2;
			int count = 0;
			while (!q.isEmpty() && range-- > 0) {
				int size = q.size();
				for (int s = 0; s < size; s++) {
					int now = q.poll();

					for (int next : list[now]) {
						if (!visited[next]) {
							q.offer(next);
							visited[next] = true;
							count++;
						}
					}
				}

			}
			result = Math.max(result,count);
		}
		System.out.println(result);
	}
}
