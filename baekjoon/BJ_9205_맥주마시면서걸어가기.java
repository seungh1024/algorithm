package day0413;

import java.io.*;
import java.util.*;

public class BJ_9205_맥주마시면서걸어가기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine()); //편의점 개수
			
			ArrayList<Point> list = new ArrayList<>();//연결되는 지점들
			StringTokenizer st = new StringTokenizer(br.readLine());
			int homex = Integer.parseInt(st.nextToken());
			int homey = Integer.parseInt(st.nextToken());
			list.add(new Point(homex,homey));
			
			Point[] store = new Point[n+1];
			for(int i = 0; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				store[i] = new Point(x,y);
			}
			
			if(bfs(homex,homey,n,store)) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
			
		}
	}
	
	public static boolean bfs(int x, int y, int n, Point[] store) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(x,y));
		
		boolean[] visited = new boolean[n+1];
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			int size = store.length;
			if(visited[size-1]) {
				return true;
			}
			for(int i = 0; i < size; i++) {
				if(Math.abs(now.x-store[i].x)+ Math.abs(now.y-store[i].y) <= 1000 && !visited[i]) {
					visited[i] = true;
					queue.offer(new Point(store[i].x,store[i].y));
				}
			}
		}
		
		return false;
	}
	
	public static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	
}
