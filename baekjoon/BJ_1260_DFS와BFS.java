package day0223;

import java.io.*;
import java.util.*;

public class BJ_1260_DFS와BFS {
	
	static boolean[] visited;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken()); //start point
		
		Point[] point = new Point[N+1];
		
		//start input
		for(int i = 0; i <M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			if(point[from] !=null) {
				point[from].list.add(to);
			}else {
				point[from] = new Point(to);
			}
			
			if(point[to] != null) {
				point[to].list.add(from);
			}else {
				point[to] = new Point(from);
			}
		}
		
//		for(int i = 0; i <= N; i++) {
//			if(point[i] != null)
//				System.out.println(point[i]);
//		}
		//end input
		
		visited = new boolean[N+1];
		dfs(V,point);
		System.out.println();
		visited = new boolean[N+1];
		bfs(V,point);
		
	}
	
	public static void dfs(int start,Point[] point) {
		visited[start] = true;
		System.out.print(start+" ");
		
		if(point[start] != null) {			
			Collections.sort(point[start].list);
			for(int a : point[start].list) {
				if(!visited[a]) {
					dfs(a,point);
				}
			}
		}
	}
	
	public static void bfs(int start, Point[] point) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start] = true;
		System.out.print(start+" ");
		
		while(!queue.isEmpty()) {
			int next = queue.poll();
			if(point[start] != null) {				
				Collections.sort(point[next].list);
				for(int a : point[next].list) {
					if(!visited[a]) {
						visited[a] = true;
						queue.offer(a);
						System.out.print(a+" ");
					}
				}
			}
		}
	}
	
	
	public static class Point{
		ArrayList<Integer> list;
		
		public Point(int to) {
			super();
			list = new ArrayList<>();
			list.add(to);
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "list: "+list.toString();
		}
	}

}
