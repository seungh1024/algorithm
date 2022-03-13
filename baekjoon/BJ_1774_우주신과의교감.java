package day0310;

import java.io.*;
import java.util.*;

public class BJ_1774_우주신과의교감 {
	
	static ArrayList<Point>[] list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//신들의 좌표 입력 시작//
		Point[] god = new Point[N+1];
		int x,y;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			god[i] = new Point(x,y);
		}
		//신들 위치 전부 입력 끝//
		
		list = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		//간선 정보 리스트 초기화//
		
		//신들끼리의 거리 정보 초기화 시작//
		Point now,next;
		double weight;
		double xl,yl;
		for(int i = 1; i <= N; i++) {
			now = god[i];
			for(int j = i+1; j <= N; j++) {
				next = god[j];
				xl = (double)(Math.abs(now.from - next.from));
				yl = (double)(Math.abs(now.to - next.to));
				weight = Math.sqrt(xl*xl+yl*yl);
				list[i].add(new Point(i,j,weight));
				list[j].add(new Point(j,i,weight));
			}
		}
		//신들끼리의 거리 정보 초기화 끝//
		
		//연결된 신들의 정보//
		int from,to;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			list[from].add(new Point(from,to,0));
			list[to].add(new Point(to,from,0)); //연결되어 있으니 거리를 0으로 해서 넣어줌
		}
		//신들 정보 입력 끝//
		
//		for(int i = 1; i <=N; i++) {
//			System.out.println(list[i]);
//		}
		
		
		
		prim(N);
	}
	
	public static void prim(int N) {
		double[] distance = new double[N+1];
		Arrays.fill(distance, Double.MAX_VALUE);
		distance[1] = 0.0;
		boolean[] visited = new boolean[N+1];
		
		PriorityQueue<Point> pQueue = new PriorityQueue<>();
		pQueue.offer(new Point(0,1,0.0));
		
		double result = 0.0;
		
		while(!pQueue.isEmpty()) {
			Point now = pQueue.poll();
			
			if(visited[now.to])continue;
			visited[now.to]= true; 
			result += now.weight;
			
			for(Point p: list[now.to]) {
				if(!visited[p.to]&& distance[p.to]> p.weight) {
					distance[p.to]= p.weight;
					pQueue.offer(new Point(0,p.to,p.weight));
				}
			}
		}
		
		System.out.printf("%.2f",result);
	}
	
	public static class Point implements Comparable<Point>{
		int from;
		int to;
		double weight;
		
		public Point(int x,int y) {
			this.from = x;
			this.to = y;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "to: "+to+" weight: "+weight;
		}
		
		public Point(int from, int to, double weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			if(this.weight-o.weight>0) {
				return 1;
			}else if(this.weight-o.weight<0) {
				return -1;
			}
			return 0;
		}
	}

}
