package day0226;

import java.io.*;
import java.util.*;

public class BJ_2667_단지번호붙이기 {
	
	static PriorityQueue<Integer> pQueue = new PriorityQueue<>(); //단지의 집 수를 기록할 pQueue
	static char[][] map;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N= Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == '1') {
//					System.out.println(i+","+j);
					pQueue.offer(bfs(i,j));
				}
			}
		}
		System.out.println(pQueue.size());
		while(!pQueue.isEmpty()) {
			System.out.println(pQueue.poll());
		}
	}
	
	public static int bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		
		queue.offer(new int[] {x,y});
		map[x][y] = '0';
		int count = 1;
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = now[0]+dx[i];
				int ny = now[1]+dy[i];
				if(nx<0 || nx>=N || ny < 0 || ny >=N || map[nx][ny] == '0') continue;
				
				queue.offer(new int[] {nx,ny});
				map[nx][ny] = '0';
				count++;
			}
		}
		
		return count;
		
	}
}
