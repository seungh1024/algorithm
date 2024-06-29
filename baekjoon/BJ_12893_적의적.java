package algo_202406;

import java.io.*;
import java.util.*;

public class BJ_12893_적의적 {
	public static int N,M;
	public static List<Integer>[] list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}

		Queue<Integer> q = new ArrayDeque<>();
		int[] visited = new int[N+1];

		int result = 1;
		for (int i = 1; i <= N; i++) {
			if(visited[i] != 0) continue;
			visited[i] = 1;

			q.offer(i);
			while (!q.isEmpty()) {
				int size = q.size();
				for (int s = 0; s < size; s++) {
					int now = q.poll();

					for (int l : list[now]) {
						if(visited[l] == visited[now]){
							System.out.println(0);
							return;
						}else{
							if(visited[l] == 0) {
								visited[l] = -visited[now];
								q.offer(l);
							}

						}

					}
				}

			}
		}


		System.out.println(result);
	}

}
