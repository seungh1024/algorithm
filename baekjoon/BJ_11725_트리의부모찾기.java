package algoStudy;

import java.io.*;
import java.util.*;

public class BJ_11725_트리의부모찾기 {
	
	static int[] parent;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];
		parent[1] = 1;
		
		Point[] point = new Point[N+1];
		for(int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			if(point[from] != null) {
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
		
//		bfs(point);
		dfs(point,1);
//		System.out.println(Arrays.toString(parent));
		for(int i = 2; i <=N;i++) {
			System.out.println(parent[i]);
		}
		
		
	}
	public static void dfs(Point[] point,int start) {

		int size = point[start].list.size();
		for(int i = 0; i < size; i++) {
			int next = point[start].list.get(i);
			if(parent[next] ==0) {					
				parent[next] = start;
				dfs(point,next);
			}
		}
	}
	
	public static void bfs(Point[] point) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			int size = point[now].list.size();
			for(int i = 0; i < size; i++) {
				int next = point[now].list.get(i);
				if(parent[next] ==0) {					
					queue.offer(next);
					parent[next] = now;
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
	}
	
}
