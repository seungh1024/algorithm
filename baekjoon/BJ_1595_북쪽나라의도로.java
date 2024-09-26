package algo_202409;

import java.io.*;
import java.util.*;

public class BJ_1595_북쪽나라의도로 {
	public static List<Road>[] roads;

	public static void main(String[] args) throws IOException{
		init();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String input = br.readLine();
			if(input == null || input.isEmpty()) break;
			StringTokenizer st = new StringTokenizer(input);
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());

			roads[from].add(new Road(to,length));
			roads[to].add(new Road(from, length));
		}

		Road start = find(1);
		Road result = find(start.to);
		System.out.println(result.length);

	}

	public static Road find(int start){
		Queue<Road> q = new ArrayDeque<>();
		q.offer(new Road(start, 0));
		boolean[] visited = new boolean[10001];
		visited[start] = true;

		Road result = new Road(start,0);
		while (!q.isEmpty()) {
			Road now = q.poll();
			if (now.length > result.length) {
				result = now;
			}

			for(Road next : roads[now.to]){
				if (!visited[next.to]) {
					visited[next.to] = true;
					q.offer(new Road(next.to,now.length+next.length));
				}
			}
		}

		return result;
	}

	public static void init(){
		roads = new ArrayList[10001];
		for (int i = 1; i <= 10000; i++) {
			roads[i] = new ArrayList<>();
		}
	}

	public static class Road{
		int to;
		int length;

		public Road(int to, int length) {
			this.to = to;
			this.length = length;
		}
	}
}
