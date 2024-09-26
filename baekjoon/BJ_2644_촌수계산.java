package algo_202409;

import java.io.*;
import java.util.*;

public class BJ_2644_촌수계산 {
	public static int N;
	public static int A, B;
	public static int M;
	public static List<Integer>[] list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());

		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		find();
	}

	public static void find() {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(A);
		boolean[] visited = new boolean[N+1];
		visited[A] = true;

		int result = 0;
		boolean flag = false;
		while (!q.isEmpty()) {
			int size = q.size();
			// System.out.println("result = "+result);
			for (int s = 0; s < size; s++) {
				int now = q.poll();
				// System.out.println(now);
				if (now == B) {
					flag =  true;
					break;
				}

				for (int next : list[now]) {
					if(!visited[next]){
						q.offer(next);
						visited[next] = true;
					}
				}
			}
			if(flag) break;

			result++;
		}

		if (flag) {
			System.out.println(result);
		} else {
			System.out.println(-1);
		}
	}
}
