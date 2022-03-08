package day0308;

import java.io.*;
import java.util.*;

public class BJ_16398_행성연결 {
	
	static ArrayList<Point>[] list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		
		StringTokenizer st;
		int money;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < i+1; j++) {//같거나 이미 확인한 곳은 넘어감
				st.nextToken();
			}
			for(int j = i+1; j < N; j++) {
				money = Integer.parseInt(st.nextToken());
				if(money == 0) continue;
				list[i].add(new Point(j,money));
				list[j].add(new Point(i,money));
			}
		}
		
//		for(int i = 0; i < N; i++) {
//			System.out.println(list[i]);
//		}
		prim(N);
	}
	
	public static void prim(int N) {
		int[] cost = new int[N];
		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[0] = 0;
		boolean[] visited = new boolean[N];
		
		PriorityQueue<Point> pQueue = new PriorityQueue<>();
		pQueue.offer(new Point(0,0));
		
		double result = 0;
		int cnt = 0;
		while(!pQueue.isEmpty()) {
			Point now = pQueue.poll();
			
			if(visited[now.to]) continue;
			visited[now.to]= true; 
			result += (double)(now.money);
			cnt++;
			if(cnt ==N) {
				break;
			}
			
			for(Point p: list[now.to]) {
				if(!visited[p.to]&& cost[p.to]>p.money) {
					cost[p.to]= p.money;
					pQueue.offer(new Point(p.to,p.money));
				}
			}
		}
		
		System.out.printf("%.0f",result);
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
