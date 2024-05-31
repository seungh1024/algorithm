package vsfe_20240531;

import java.io.*;
import java.util.*;

public class BJ_11085_군사이동 {
	public static int p,w;
	public static List<Data>[] list;
	public static int start,end;


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		p = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		list = new ArrayList[p];
		for (int i = 0; i < p; i++) {
			list[i] = new ArrayList<>();
		}

		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		for (int i = 0; i < w; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[from].add(new Data(to,cost));
			list[to].add(new Data(from,cost));
		}

		find();
	}

	public static void find() {
		Queue<Data> pq = new PriorityQueue<>();
		pq.offer(new Data(start,Integer.MAX_VALUE));
		int[] distance = new int[p];
		distance[start] = -1;

		while (!pq.isEmpty()) {
			Data now = pq.poll();

			if(distance[now.to] >= now.cost) continue;
			distance[now.to] = now.cost;

			for (Data next : list[now.to]) {
				// System.out.println(next);
				int min = Math.min(next.cost, now.cost);
				// System.out.println(min);
				pq.offer(new Data(next.to,min));
			}
		}

		System.out.println(distance[end]);
	}

	public static class Data implements Comparable<Data>{
		int to;
		int cost;

		public Data(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Data data) {
			return data.cost - this.cost;
		}

		public String toString(){
			return "to = "+to + ", cost = "+cost;
		}
	}
}
