package day0304;

import java.io.*;
import java.util.*;

public class BJ_1277_발전소설치 {
	static int N;
	static int W;
	static double M;
	static double[] distance;
	static ArrayList<Point>[] list;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		M = Double.parseDouble(br.readLine());//제한 길이
//		System.out.println(Integer.MAX_VALUE);
		list = new ArrayList[N+1];
		for(int i = 0; i <=N;i++) {
			list[i] = new ArrayList<Point>();
		}
		
		
		int x,y;
		Point[] point = new Point[N+1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			point[i] = (new Point(x,y,0));
//			System.out.println(x+","+y);
//			System.out.println(point[i]);
		}
		for(int i = 1; i <=N; i++) {
			Point now = point[i];
			for(int j = i+1; j <= N; j++) {
				Point next = point[j];
//				System.out.println(j);
//				System.out.println(now+"////"+next);
				double xl = (double)Math.abs(now.from-next.from);
				double yl = (double)Math.abs(now.to-next.to);
				double length =Math.sqrt(xl*xl + yl*yl);
				if(length>M) continue;
				list[i].add(new Point(i,j,length));
				list[j].add(new Point(j,i,length));
			}
		}
		
		for(int i = 1; i <= W; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			list[x].add(new Point(x,y,0));
			list[y].add(new Point(y,x,0));
			
		}
		dijkstra();
		System.out.println((int)(distance[N]*1000));
		
	}
	
	public static void dijkstra() {
		distance = new double[N+1];
		Arrays.fill(distance, Double.MAX_VALUE);
		distance[1] = 0; //1부터 시작
		boolean[] visited = new boolean[N+1];
		
		PriorityQueue<Point> pQueue = new PriorityQueue<>();
		pQueue.offer(new Point(0,1,distance[1]));
		
		while(!pQueue.isEmpty()) {
			Point now = pQueue.poll();
			
			if(visited[now.to]) continue;
			visited[now.to]= true;

			ArrayList<Point> data = list[now.to];
			int size = data.size();
			for(int i = 0; i < size; i++){
				Point p = data.get(i);
				if(!visited[p.to]&& distance[p.to]> now.weight+p.weight) {
					distance[p.to]= now.weight+p.weight;
					pQueue.offer(new Point(now.to,p.to,distance[p.to]));
				}
			}
		}
//		System.out.println(Arrays.toString(visited));
	}
	
	public static class Point implements Comparable<Point>{
		int from;
		int to;
		double weight;
		public Point(int from, int to,double weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			if(this.weight-o.weight < 0) {
				return -1;
			}else if(this.weight -o.weight > 0) {
				return 1;
			}else {
				return 0;
			}
			
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "from: "+from+" to: "+to;
		}
	}
}
