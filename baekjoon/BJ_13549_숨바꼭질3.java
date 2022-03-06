package day0303;

import java.io.*;
import java.util.*;

public class BJ_13549_숨바꼭질3 {
	static int result;
	static boolean[] check;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //수빈이가 있는 위치
		int K = Integer.parseInt(st.nextToken()); //동생이 있는 위치
		//수빈이가 동생 잡아야 함
		
		check = new boolean[100001];
		
		result = 0;
		
		bfs(N,K);

	}
	
	public static void bfs(int N, int K) {
		if(N==K) {
			System.out.println(0);
			return;
		}
		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.offer(new Point(N,0));
		check[N] = true;
		int[] dx = {2,1,-1};
		int nx,time;
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			for(int i = 0; i < 3; i++) {
				if(i==0) {
					nx = now.x*2;
					time = now.time;
				}else {					
					nx = now.x+dx[i];
					time = now.time+1;
				}
				if(nx == K) {
					System.out.println(time);
					return;
				}
				if(nx<0 || nx >100000 || check[nx]) continue;
				check[nx] = true;
				queue.offer(new Point(nx,time));
				
			}
		}

	}
	
	public static class Point implements Comparable<Point>{
		int x;
		int time;
		public Point(int x, int time) {
			this.x = x;
			this.time = time;
		}
		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.time-o.time == 0 ? this.x-o.x:this.time-o.time;
		}
	}
}
