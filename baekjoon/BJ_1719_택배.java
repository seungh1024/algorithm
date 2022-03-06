package day0304;

import java.io.*;
import java.util.*;

//다익스트라로 풀기
//시작점은 from을 0으로 주고 다음 점으로 연결 시 부모의 지점 값을 주기
//단 from값이 0이 아니라면 해당 from값을 다음 집하장의 from 값에 주기
//그렇게 map에 기록해 나가기 -> 최소값일 때 마다 계속 기록해 나가면 됨
public class BJ_1719_택배 {
	
	static ArrayList<Point>[] list;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		list = new ArrayList[n+1];
		
		for(int i = 1; i <=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		
		int from,to,weight;
		for(int i = 0; i <m; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			list[from].add(new Point(0,to,weight));
			list[to].add(new Point(0,from,weight));
		}
		
//		for(int i = 1; i <=n; i++) {
//			System.out.println(list[i]);
//		}
		////////////end input////////////////
		dijkstra(n);
	}
	
	public static void dijkstra(int n) {
//		int[][] result = new int[n+1][n+1];//결과값 경로표
		
		for(int i = 1; i <= n; i++) {
			int[] distance = new int[n+1];
			int[] result = new int[n+1];
			Arrays.fill(distance, Integer.MAX_VALUE);
//			boolean[] visited = new boolean[n+1];
			PriorityQueue<Point> queue = new PriorityQueue<>();
			queue.offer(new Point(0,i,0));
			
			while(!queue.isEmpty()) {
				Point now = queue.poll();
//				visited[now.to] = true;
				int size = list[now.to].size();
				for(int j = 0; j < size; j++) {
					Point p = list[now.to].get(j);
					if(distance[p.to]>distance[now.to]+p.weight) {
						distance[p.to]= distance[now.to]+p.weight;
						if(now.from == 0) {
							queue.offer(new Point(p.to,p.to,distance[p.to]));
							result[p.to]= p.to; 
						}else {
							queue.offer(new Point(now.from,p.to,distance[p.to]));
							result[p.to]= now.from; 
						}
					}
				}
				
			}
			for(int j = 1; j <=n; j++) {
				if(i == j) {
					System.out.print("- ");
				}else {					
					System.out.print(result[j]+" ");
				}
			}
			System.out.println();
		}

		
	}
	
	public static class Point implements Comparable<Point>{
		int from;
		int to;
		int weight;
		
		public Point(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "from: "+from + " to: "+to +" weight: "+weight;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.weight-o.weight;
		}
		
		
	}

}
