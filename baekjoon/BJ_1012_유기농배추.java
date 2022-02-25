package day0223;

import java.io.*;
import java.util.*;

public class BJ_1012_유기농배추 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken()); //가로 길이
			int N = Integer.parseInt(st.nextToken()); //세로 길이
			int K = Integer.parseInt(st.nextToken()); //배추가 심어져 있는 위치의 개수
			
			int[][] baechu = new int[N][M];
			
			//start baechu input
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				baechu[x][y] = 1;
			}//end baechu input
			
			////start bfs//////
			int result = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(baechu[i][j] ==1) {
//						System.out.println(i+"//"+j);
//						bfs(i,j,M,N,baechu);
						dfs(i,j,M,N,baechu);
						result++;
					}
				}
//				System.out.println(Arrays.toString(baechu[i]));
			}
			
			System.out.println(result);
			//////end bfs///////
			
			
		}
	}
	
	public static void bfs(int x, int y,int M, int N, int[][] baechu) {
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		
		Queue<int[]> queue = new LinkedList<>();
		int[] data = {x,y};
		queue.offer(data);
		
		while(!queue.isEmpty()) {
			int[] bc = new int[2];
			bc = queue.poll();

			for(int i = 0; i < 4; i++) {
				int nx = bc[0]+dx[i];
				int ny = bc[1]+dy[i];
				
				
				if(nx>=0 && nx<N && ny >=0 && ny<M && baechu[nx][ny] ==1) {
					baechu[nx][ny] = 0;
					int[] next = {nx,ny};
					
					queue.offer(next);
				}
			}
		}
		
	}
	
	public static void dfs(int x, int y, int M, int N, int[][] baechu) {
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		
		for(int i = 0; i < 4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i]; //next point
			
			if(nx>=0 && nx<N && ny >=0 && ny<M && baechu[nx][ny] ==1) {
				baechu[nx][ny] = 0;
				dfs(nx,ny,M,N,baechu);
			}
			
		}
	}
	
}
