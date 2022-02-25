package day0223;

import java.io.*;
import java.util.*;

public class BJ_10026_적록색약 {
	
	static int R = 0;
	static int G = 0;
	static int B = 0;
	
	static char[][] input;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		

		char[][] map1 = new char[N][N];
		char[][] map2 = new char[N][N];
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			map1[i] = s.toCharArray();
			map2[i] = s.toCharArray();
//			System.out.println(Arrays.toString(map[i]));
		}
		
		//////end input///////
		
		
		
		int normal = 0;
		int abnormal = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				char rgb1 = map1[i][j];
				char rgb2 = map2[i][j];
				if(rgb1 != 'X') {
					if(rgb1 == 'R') {
						bfs(map1,i,j,rgb1,rgb1,N);
					}else if(rgb1 == 'G') {
						bfs(map1,i,j,rgb1,rgb1,N);
					}else if(rgb1 == 'B') {
						bfs(map1,i,j,rgb1,rgb1,N);
					}
					normal++;
				}
				
				if(rgb2 !='X') {
					if(rgb2 == 'R' || rgb2 == 'G') {
						bfs(map2,i,j,'R','G',N);
					}else if(rgb2 == 'B') {
						bfs(map2,i,j,rgb2,rgb2,N);
					}
					abnormal++;
				}
			}
		}
		
		System.out.println(normal+ " " + abnormal);
	}
	
	//map 의 x,y 좌표, rgb색 중 하나, N의 값
	public static void bfs(char[][] map, int x, int y, char rgb1, char rgb2 , int N) {
		Queue<int[]> queue = new LinkedList<>();
		int[] data = new int[] {x,y};
		queue.offer(data);
		map[x][y] = 'X';//방문 체크
		
		int[] dx = new int[]{0,0,1,-1};
		int[] dy = new int[]{1,-1,0,0};
//		System.out.println(x+"??"+y);
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = now[0] +dx[i];
				int ny = now[1] +dy[i];
				
				if(nx >=0 && nx <N && ny >=0 && ny <N && (map[nx][ny] ==rgb1 || map[nx][ny] == rgb2 )) {
					map[nx][ny] = 'X';//방문처리
					queue.offer(new int[] {nx,ny});
				}
			}
		}
	}
	
	
}
