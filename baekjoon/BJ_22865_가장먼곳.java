package day0304;

import java.io.*;
import java.util.*;

public class BJ_22865_가장먼곳 {
	
	static int N;
	static ArrayList<Point>[] list; 

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken()); //A,B,C가 사는위치
		list = new ArrayList[N+1];
		for(int i = 1; i <=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		int M = Integer.parseInt(br.readLine());//도로의 개수
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[from].add(new Point(to,weight));
			list[to].add(new Point(from,weight));//양방향 처리
		}
//		for(int i = 1; i<=N; i++) {
//			System.out.println(list[i]);
//		}
		
		int[] distanceA = dijkstra(A);
		int[] distanceB = dijkstra(B);
		int[] distanceC = dijkstra(C);
		
		int result = 0;
		int index = N+1;
		for(int i = 1; i <=N; i++) {
			int min = Math.min(Math.min(distanceA[i], distanceB[i]), distanceC[i]);
			
			if(min >result) {
				result = min;
				index = i;
				
			}else if(min == result) {
				index = Math.min(index, i);
			}
		}

		System.out.println(index);
	}
	
	public static int[] dijkstra(int start) {
		int[] distance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		boolean[] visited = new boolean[N+1];
		
		PriorityQueue<Point> pQueue = new PriorityQueue<>();
		pQueue.offer(new Point(start,0));
		
		while(!pQueue.isEmpty()) {
			Point now = pQueue.poll();
			
			if(visited[now.to])continue;
			visited[now.to]= true;
			
			for(Point p : list[now.to]) {
				if(!visited[p.to] && distance[p.to]> distance[now.to]+p.weight) {
					distance[p.to]= distance[now.to]+p.weight;
					pQueue.offer(new Point(p.to,distance[p.to]));
				}
			}
		}
		
		return distance;
	}
	
	public static class Point implements Comparable<Point>{
		int to;
		int weight;
		
		public Point(int to, int weight) {
			this.to=to;
			this.weight=weight;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "to: "+to+" weight: "+weight;
		}
		
		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.weight-o.weight;
		}
	}

}
