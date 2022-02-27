package day0226;

import java.io.*;
import java.util.*;

public class BJ_18352_특정거리의도시찾기 {
	
	static ArrayList<Point>[] list;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());//도시의 개수
		int M = Integer.parseInt(st.nextToken());//도로의 개수
		int K = Integer.parseInt(st.nextToken());//거리 정보
		int X = Integer.parseInt(st.nextToken());//출발 도시의 번호
		
		list = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Point>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to= Integer.parseInt(st.nextToken());
			list[from].add(new Point(to));
		}
//		for(int i = 1; i <= N; i++) {
//			System.out.println(list[i]);
//		}
		//////////end input////////////
		
		StringBuilder sb = new StringBuilder();
//		System.out.println(Arrays.toString(result));
		bfs(X,K,N);
		
	}
	
	public static class Point implements Comparable<Point>{
		int to;
		public Point(int to) {
			super();
			this.to = to;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "to: " + to;
		}
		
		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	
	public static void bfs(int X, int K,int N) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(X);
		boolean[] visited = new boolean[N+1];
		visited[X] = true;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			if(size == 0) continue;
			for(int i = 0; i < size; i++) {
				int now = queue.poll();
				ArrayList<Point> pointList = list[now];
				
				for(Point p :pointList) {					
					if(visited[p.to])continue; 
					visited[p.to]= true; 
					queue.offer(p.to);
				}
				
//				System.out.println(p);
			}
			K--;
//			System.out.println("K: "+K);
			if(K == 0) {
				break;
			}
		}
		
		int length = queue.size();
		int[] result = new int[length];
		if(length == 0) {
			System.out.println(-1);
		}else {
			for(int i = 0; i < length; i++) {
				result[i] = queue.poll();
			}
		}
		Arrays.sort(result);
		for(int i = 0; i < length; i++) {
			System.out.println(result[i]);
		}
		
	}
	
	

}
