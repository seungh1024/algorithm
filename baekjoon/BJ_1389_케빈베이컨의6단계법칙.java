package algo_202406;

import java.io.*;
import java.util.*;

public class BJ_1389_케빈베이컨의6단계법칙 {
	public static int N, M;
	public static List<Integer>[] list;
	public static int result;

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

		int min = Integer.MAX_VALUE;
		result = 0;
		for (int i = 1; i <= N; i++) {
			int sum = find(i);
			if (min > sum) {
				min = sum;
				result = i;
			}
		}

		System.out.println(result);
	}

	public static int find(int start) {
		Queue<int[]> pq = new PriorityQueue<>((o1,o2)->
			o1[1] - o2[1]
		);
		int[] distance = new int[N+1];
		boolean[] visited = new boolean[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		pq.offer(new int[] {start, 0});
		distance[start] = 0;

		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			if(visited[now[0]]) continue;
			visited[now[0]] = true;
			// System.out.println(Arrays.toString(now));

			for(int next :list[now[0]]){
				if(!visited[next] && distance[next] > now[1] + 1){
					distance[next] = now[1]+1;
					pq.offer(new int[] {next, distance[next]});
				}
			}
		}

		int sum = 0;
		for (int i = 1; i <= N; i++) {
			sum += distance[i];
		}
		// System.out.println(Arrays.toString(distance));

		return sum;
	}
}
