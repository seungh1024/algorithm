package day0407;

import java.io.*;
import java.util.*;

public class SWEA_1249_보급로 {
	
	static int[][] map;
	static int[][] time;
	static int N;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N= Integer.parseInt(br.readLine());
			map = new int[N][N];
			time = new int[N][N];
			
			StringTokenizer st;
			for(int i = 0; i < N; i++) {
				String s = br.readLine();
				for(int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j) -'0';
					time[i][j] = Integer.MAX_VALUE;
				}
//				System.out.println(Arrays.toString(map[i]));
			}
			time[0][0] = 0;
			////////////// end input ////////////
			
			bfs();
			System.out.println("#"+t+ " " + time[N-1][N-1]);
		}
	}
	
	public static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0,0});
		
		int x,y,nx,ny;
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			x = now[0];
			y = now[1];
//			System.out.println(x+","+y);
			
			for(int i = 0; i <4; i++) {
				nx = x+dx[i];
				ny = y +dy[i];
				if(nx>=0 && nx < N && ny >= 0 && ny < N && time[nx][ny] > time[x][y] + map[nx][ny]) {
//					System.out.println(nx+"?"+ny);
//					System.out.println("adsfads");
					time[nx][ny] = time[x][y] + map[nx][ny];
					queue.offer(new int[] {nx,ny});
				}
			}
		}
	}
}

//#1 2
//#2 2
//#3 8
//#4 57
//#5 151
//#6 257
//#7 18
//#8 160
//#9 414
//#10 395

