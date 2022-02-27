package day0226;

import java.io.*;
import java.util.*;

public class BJ_7562_나이트의이동 {
	
	static int[] dx = {-2,-1,1,2,2,1,-1,-2};
	static int[] dy = {1,2,2,1,-1,-2,-2,-1};

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t = 0; t < T; t++) {
			int I = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int rx = Integer.parseInt(st.nextToken());
			int ry = Integer.parseInt(st.nextToken());
//			int[][] map = new int[I][I];
			
			System.out.println(bfs(I,x,y,rx,ry));
			
		}
	}
	
	public static int bfs(int I, int x, int y, int rx, int ry) {
		int count = 0;
		if(x == rx && y == ry) {
			return 0;
		}
		boolean[][] visited = new boolean[I][I];
		visited[x][y] = true;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x,y});
		while(!queue.isEmpty()) {
			int size = queue.size();
			count++;
			for(int i = 0; i < size; i++) {//같은 레벨만큼 반복
				int[] now = queue.poll();
				
				for(int j = 0; j < 8; j++) {
					int nx = now[0] +dx[j];
					int ny = now[1] +dy[j];

					if(nx<0 || nx >= I || ny < 0 || ny>=I || visited[nx][ny]) continue;
					
					
					if(nx == rx && ny == ry) {
						return count;
					}
					visited[nx][ny] = true;
					queue.offer(new int[] {nx,ny});
				}
			}
		}
		
		
		
		
		return count;
	}

}
