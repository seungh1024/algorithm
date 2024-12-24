package algo_202412;

import java.io.*;
import java.util.*;

public class BJ_9470_strahler순서 {
	public static int K,M, P;
	public static int[] count;
	public static int[] max;
	public static List<Data>[] list;
	public static int[] sCount;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			count = new int[M + 1];
			max = new int[M + 1];
			sCount = new int[M+1];
			list = new ArrayList[M + 1];
			for (int i = 1; i <= M; i++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 0; i < P; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list[from].add(new Data(to, 0));
				count[to]++;
			}
			int result = find();
			sb.append(K).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	public static int find() {
		Queue<Data> q = new ArrayDeque<>();
		for (int i = 1; i <= M; i++) {
			if (count[i] == 0) {
				q.offer(new Data(i, 1));
				max[i] = 1;
			}
		}

		int result = 0;
		while(!q.isEmpty()) {
			Data now = q.poll();
			result = Math.max(result, now.cost);

			for (Data next : list[now.to]) {
				if(count[next.to] == 0)continue;

				if (max[next.to] == now.cost) {
					sCount[next.to]++;
				} else if (max[next.to] < now.cost) {
					sCount[next.to] = 1;
					max[next.to] = now.cost;
				}
				count[next.to]--;
				if (count[next.to] == 0) {
					if (sCount[next.to] > 1) {
						max[next.to]++;
					}
					q.offer(new Data(next.to, max[next.to]));
				}
			}
		}

		return result;
	}

	public static class Data{
		int to;
		int cost;

		public Data(int to, int cost){
			this.to = to;
			this.cost = cost;
		}
	}
}
