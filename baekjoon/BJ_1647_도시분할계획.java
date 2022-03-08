package day0308;

import java.io.*;
import java.util.*;

public class BJ_1647_도시분할계획 {
	
	static ArrayList<Point>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());// number of house
		int M = Integer.parseInt(st.nextToken());// number of road

		list = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		int A,B,C;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			list[A].add(new Point(B,C));
			list[B].add(new Point(A,C));
		}
		
//		for(int i = 1; i <= N; i++) {
//			System.out.println(list[i]);
//		}
		
		prim(N);

	}
	
	public static void prim(int N) {
		int[] cost = new int[N+1];
		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[1] = 0;
		boolean[] visited = new boolean[N+1];
		
		PriorityQueue<Point> pQueue = new PriorityQueue<>();
		pQueue.offer(new Point(1,0));
		
		int result = 0;
		int cnt = 0;
		int max = 0;
		
		while(!pQueue.isEmpty()) {
			Point now = pQueue.poll();
			
			if(visited[now.to])continue;
			visited[now.to]= true; 
			result += now.money;
			max = Math.max(max, now.money);
			cnt++;
			if(cnt == N) {
				break;
			}
			
			for(Point p: list[now.to]) {
				if(!visited[p.to] && cost[p.to]> p.money) {
					cost[p.to]= p.money;
					pQueue.offer(new Point(p.to,p.money));
				}
			}
		}
//		System.out.println(Arrays.toString(cost));
		System.out.println(result-max);
	}
	
	public static class Point implements Comparable<Point>{
		int to;
		int money;
		
		public Point(int to, int money) {
			this.to = to;
			this.money = money;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "to: "+to+" money: "+money;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.money-o.money;
		}
	}

}
