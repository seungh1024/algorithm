

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static char[] data;
	public static List<Integer>[] list;
	public static char[] check;
	public static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		char[] input = br.readLine().toCharArray();
		data = new char[N + 1];
		for (int i = 1; i <= N; i++) {
			data[i] = input[i-1];
		}
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}

		check = new char[N + 1];
		Arrays.fill(check, '0');
		arr = new int[N + 1];
		Arrays.fill(arr, -1);
		arr[0] = 0;
		find();

		int max = -1;
		int idx = 0;
		for (int i = 1; i <= N; i++) {
			if (arr[i] > max) {
				max = arr[i];
				idx = i;
			}
		}
		// System.out.println("idx = "+idx);
		// System.out.println(Arrays.toString(arr));

		// Stack<Integer> stack = new Stack<>();
		// while (idx != 0) {
		// 	stack.push(idx);
		// 	idx = arr[idx];
		//
		// }
		// StringBuilder sb = new StringBuilder();
		// while (!stack.isEmpty()) {
		// 	int now = stack.pop();
		// 	sb.append(data[now]);
		// }

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if(check[i] == '0') break;
			sb.append(check[i]);
		}
		System.out.println(sb);
	}

	public static void find() {
		Queue<Data> pq = new ArrayDeque<>();
		pq.offer(new Data(1, data[1], 0));
		boolean[] visited = new boolean[N + 1];
		int depth = 1;
		check[depth] = data[1];
		while (!pq.isEmpty()) {
			int size = pq.size();
			// System.out.println("depth = "+depth + "============");
			// System.out.println("size = "+size);
			for (int s = 0; s < size; s++) {

				Data now = pq.poll();

				if(visited[now.idx]) continue;
				visited[now.idx] = true;
				// System.out.println(now);
				if(check[depth] != data[now.idx]) continue;
				arr[now.idx] = now.last;

				for (int next : list[now.idx]) {
					// System.out.println("next = "+next +", data = "+data[next]);
					if (!visited[next] && check[depth+1] <= data[next]) {
						// System.out.println("success");
						check[depth+1] = data[next];
						pq.offer(new Data(next, data[next],now.idx));
					}
				}
			}
			depth++;
		}

		// System.out.println(Arrays.toString(check));
	}

	public static class Data{
		int idx;
		char c;
		int last;

		@Override
		public String toString() {
			return "Data{" +
				"idx=" + idx +
				", c=" + c +
				", last=" + last +
				'}';
		}

		public Data(int idx, char c, int last) {
			this.idx = idx;
			this.c = c;
			this.last = last;
		}
	}
}
