

import java.io.*;
import java.util.*;

public class Main {
	public static int N, K;
	public static List<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int[] input = new int[N+1];
		for (int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(br.readLine(), 2);
		}

		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i <= N; i++) {
			for (int j = i+1; j <= N; j++) {
				int temp = input[i]^input[j];
				int cnt = 0;
				for (int k = 0; k < K; k++) {
					if ((temp & 1<<k) > 0) {
						cnt ++;
					}
					if(cnt >= 2) break;
				}
				if (cnt == 1) {
					list[i].add(j);
					list[j].add(i);
				}
			}
		}

		// for (int i = 1; i <= N; i++) {
		// 	System.out.println("i = "+i +", " + list[i]);
		// }

		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		find(A,B);
	}

	public static void find(int A, int B) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(A);
		int[] distance = new int[N + 1];
		Arrays.fill(distance,Integer.MAX_VALUE);
		distance[A] = 1;

		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				int now = q.poll();

				// System.out.println("now = "+now);
				if (now == B) {
					q = new ArrayDeque<>();
					break;
				}

				for (int next : list[now]) {
					// System.out.println("next = "+next + ", distance[next] = "+distance[next] +", distance[now] = "+distance[now]);
					if (distance[next] > distance[now]+1) {
						distance[next] = distance[now]+1;
						q.offer(next);
					}
				}
			}

		}

		if (distance[B] == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}

		q.offer(B);
		Stack<Integer> stack = new Stack<>();
		while (!q.isEmpty()) {
			int now = q.poll();
			stack.push(now);

			for (int next : list[now]) {
				if (distance[next] == distance[now] - 1) {
					q.offer(next);
					break;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		System.out.println(sb);
	}


}

// 1 -> 3,5
// 2 -> 4
// 3 -> 1,4
// 4 -> 2,3
// 5 -> 1
//
// 1,3,4,2
// 1,5,4,2