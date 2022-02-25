package day0223;

import java.io.*;
import java.util.*;

public class BJ_4963_섬의개수 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			if(w == 0 && h == 0) {
				break;
			}
			int[][] map = new int[h][w];
			
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
//				System.out.println(Arrays.toString(map[i]));
			}
			/////end input
			
			//start bfs
			int result = 0;
			for(int i = 0; i <h; i++) {
				for(int j = 0; j <w; j++) {
					if(map[i][j] == 1) {//갈 수 있는 땅이면
//						bfs(map,i,j,h,w);
						dfs(map,i,j,h,w);
						result ++;
					}
				}
			}
			System.out.println(result);
			
			
		}
	}
	
	public static void bfs(int[][] map, int x, int y,int h, int w) {
		Queue<int[]> queue = new LinkedList<>();
		int[] data = {x,y};
		queue.offer(data);
		int[] dx = {0,0,1,-1,1,1,-1,-1};
		int[] dy = {1,-1,0,0,1,-1,1,-1};
		map[x][y] = 0;
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for(int i = 0; i < 8; i++) {
				int nx = now[0]+dx[i];
				int ny = now[1]+dy[i];
				
				if(nx>=0 && nx <h && ny>=0 && ny < w && map[nx][ny] ==1) {
					map[nx][ny] = 0;//방문 체크
					int[] next = {nx,ny};
					queue.offer(next);
				}
			}
		}
	}
	
	public static void dfs(int[][] map,int x, int y, int h, int w) {
		int[] dx = {0,0,1,-1,1,1,-1,-1};
		int[] dy = {1,-1,0,0,1,-1,1,-1};
		
		for(int i = 0; i < 8; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx>=0 && nx <h && ny>=0 && ny < w && map[nx][ny] ==1) {
				map[nx][ny] = 0;//방문 체크
				dfs(map,nx,ny,h,w);
			}
		}
	}
}
