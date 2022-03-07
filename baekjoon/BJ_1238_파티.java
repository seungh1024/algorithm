package day0307;

import java.io.*;
import java.util.*;

public class BJ_1238_파티 {
	
	static ArrayList<Point>[] list;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		
		for(int i = 1; i <=N; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[from].add(new Point(to,weight));//단방향
		}
//		for(int i = 1; i <=N; i++) {
//			System.out.println(list[i]);
//		}
		int result = 0;
		for(int i = 1; i<= N; i++) {
			if(list[i].size()>0) {//가는 길이 있는 경우만
				result = Math.max(result,dijkstra(i,N,X)+ dijkstra(X,N,i));
			}
		}
		
		System.out.println(result);
	}
	public static int dijkstra(int start, int N,int X) {
		int[] distance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;//시작점을 잡아줌
		boolean[] visited = new boolean[N+1];
		
		PriorityQueue<Point> pQueue = new PriorityQueue<>();
		pQueue.offer(new Point(start,0));
		
		while(!pQueue.isEmpty()) {
			Point now = pQueue.poll();
			
			if(visited[now.to]) continue;
			visited[now.to] = true;
			
			//정점에서 연결된 다른 정점 중 가까운 것을 찾아줌
			for(Point p: list[now.to]) {
				if(!visited[p.to] && distance[p.to] > distance[now.to] + p.time) {
					distance[p.to] = distance[now.to]+p.time;
					pQueue.offer(new Point(p.to,distance[p.to]));//연결 성공하면 해당 지점을 피큐에 넣어줌
				}
			}
		}
		//단방향으로 최소 거리를 다 구함
		
		return distance[X];
		
		
	}
	
	public static class Point implements Comparable<Point>{
		int to;
		int time;
		
		public Point(int to, int time) {
			this.to = to;
			this.time = time;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "to : " + to + " time: "+time;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.time-o.time;
		}
	}

}
