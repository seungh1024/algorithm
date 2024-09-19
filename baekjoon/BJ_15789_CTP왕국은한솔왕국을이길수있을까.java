package algo_202409;

import java.io.*;
import java.util.*;

public class BJ_15789_CTP왕국은한솔왕국을이길수있을까 {
	public static int N, M;
	public static List<Integer>[] list;
	public static int C,H, K;
	public static boolean[] visited;
	public static PriorityQueue<Integer> pq;
	public static int cCount;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
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

		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		pq = new PriorityQueue<>(Comparator.reverseOrder());
		visited = new boolean[N + 1];
		find(C);
		find(H);
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				find(i);
			}
		}

		for (int i = 0; i < K && !pq.isEmpty(); i++) {
			int count = pq.poll();
			cCount+=count;
		}
		System.out.println(cCount);

	}

	public static void find(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);
		visited[start] = true;

		int count = 0;
		while(!q.isEmpty()) {
			int now = q.poll();
			count++;

			for (int next : list[now]) {
				if(visited[next]) continue;
				visited[next] = true;
				q.offer(next);
			}
		}

		if (start == C) {
			cCount = count;
			// System.out.println("cCount = "+cCount);
		} else if(start != H) {
			pq.offer(count);
		}
	}

}
