package day0404;

import java.io.*;
import java.util.*;

public class SWEA_1263_사람네트워크2_dijkstra {
	
	public static ArrayList<Point>[] list;
	public static int result;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			list = new ArrayList[N];
			for(int i = 0; i < N; i++) {
				list[i] = new ArrayList<>();
			}
			
			//연결된 값 입력
			int input = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					input = Integer.parseInt(st.nextToken());
					if(input != 0) {
						list[i].add(new Point(j,input));
//						list[j].add(new Point(i,input));
					}
				}
//				System.out.println(list[i]);
			}//end input
			
			
			result = Integer.MAX_VALUE;
			for(int i = 0; i < N; i++) {
				dijkstra(N,i);
			}
			
			System.out.println("#"+t+" "+result);
			
		}//end test
	}
	public static int dijkstra(int N, int start) {
		int[] distance = new int[N];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0; //시작점
		boolean[] visited = new boolean[N];
		PriorityQueue<Point> pQueue = new PriorityQueue<>();
		pQueue.offer(new Point(start,0));
		
		int count = 0;
		int total = 0;
		while(!pQueue.isEmpty()) {
			Point now = pQueue.poll();
			
			
			visited[now.to] = true;
			count ++;
			total += distance[now.to];
			if(count == N) {
				break;
			}
			
			for(Point p : list[now.to]) {
				if(!visited[p.to] && distance[p.to] > distance[now.to] + p.weight) {
					distance[p.to] = distance[now.to] + p.weight;
					pQueue.offer(new Point(p.to, distance[p.to]));
				}
			}
		}
//		System.out.println(Arrays.toString(distance));
		result = Math.min(result, total);
		
		return 0;
	}
	
	public static class Point implements Comparable<Point>{
		int to;
		int weight;
		
		public Point() {}
		public Point(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
		@Override
		public String toString() {
			return "Point [to=" + to + ", weight=" + weight + "]";
		}
		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.weight-o.weight;
		}
		
	}
}

//#1 2
//#2 3
//#3 25
//#4 37
//#5 16
//#6 11
//#7 21
//#8 20
//#9 715
//#10 1449