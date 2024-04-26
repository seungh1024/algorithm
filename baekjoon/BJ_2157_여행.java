package algo_202404;

import java.io.*;
import java.util.*;

public class BJ_2157_여행 {
	public static int N,M,K;
	public static List<Point>[] list;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		list = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int score = Integer.parseInt(st.nextToken());
			if (from < to) {
				list[from].add(new Point(to, score,M));
			}
		}

		int result = find();
		System.out.println(result);
	}

	public static int find() {
		Queue<Point> pq = new ArrayDeque<>();
		pq.offer(new Point(1, 0,M-1));
		int[][] distance = new int[N+1][M+1];

		int max = 0;
		int count = 1;
		while (!pq.isEmpty() && count < M) {
			int size = pq.size();
			for (int s = 0; s < size; s++) {
				Point now = pq.poll();
				// System.out.println(now + ", now.m = "+now.m);
				// if(distance[now.to][now.m] > now.score) continue;
				// if(visited[now.to][now.m]) continue;
				// visited[now.to][now.m] = true;
				// max = Math.max(max, now.score);

				for (Point next : list[now.to]) {
					if (distance[next.to][count+1] < distance[now.to][count] + next.score) {
						distance[next.to][count+1] = distance[now.to][count] + next.score;
						pq.offer(new Point(next.to, distance[next.to][count+1],now.m-1));
					}
				}
			}
			count++;
		}

		// int max = 0;
		// for (int i = 0; i <= N; i++) {
		// 	for (int j = 0; j <= M; j++) {
		// 		max = Math.max(max,distance[i][j]);
		// 	}
		// 	// System.out.println(Arrays.toString(distance[i]));
		// }
		for (int i = 0; i <= M; i++) {
			max = Math.max(max,distance[N][i]);
		}

		return max;
	}

	public static class Point implements Comparable<Point>{
		int to;
		int score;
		int m;

		public Point(int to, int score, int m) {
			this.to = to;
			this.score = score;
			this.m = m;
		}

		@Override
		public int compareTo(Point point) {
			return point.score - this.score;
		}

		@Override
		public String toString() {
			return "to = "+to + ", score = "+score;
		}
	}

}
