

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static char[] data;
	public static int[] indexes;
	public static boolean[] visited;
	public static int[] arr;
	public static int maxValue = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = br.readLine().toCharArray();
		int idx = 0;
		indexes = new int[N / 2];
		for (int i = 1; i < N; i += 2) {
			indexes[idx++] = i;
		}

		arr = new int[N / 2];
		visited = new boolean[N];
		find(0);
		System.out.println(maxValue);
	}

	public static void find(int idx) {
		if (idx == N / 2) {
			Deque<Data> dq = new ArrayDeque<>();
			for (int i = 0; i < N; i++) {
				dq.offer(new Data(data[i] - '0', i));
			}

			for (int i = 0; i < N / 2; i++) {
				int size = dq.size();
				for (int s = 0; s < size; s++) {
					Data now = dq.poll();
					if (now.idx == arr[i]) {
						Data last = dq.pollLast();
						Data next = dq.poll();
						int result = 0;
						if (data[now.idx] == '+') {
							result = last.num + next.num;
						} else if (data[now.idx] == '-') {
							result = last.num - next.num;
						} else {
							result = last.num * next.num;
						}

						dq.offerFirst(new Data(result, next.idx));
					} else {
						dq.offer(now);
					}
				}
			}
			// System.out.println(dq);

			maxValue = Math.max(maxValue, dq.poll().num);
			return;
		}
		for (int i = 0; i < N / 2; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			arr[idx] = indexes[i];
			find(idx + 1);
			visited[i] = false;
		}
	}

	public static class Data{
		int num;
		int idx;

		@Override
		public String toString() {
			return "Data{" +
				"num=" + num +
				", idx=" + idx +
				'}';
		}

		public Data(int num, int idx) {
			this.num = num;
			this.idx = idx;
		}
	}
}
