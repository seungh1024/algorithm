package day0401;

import java.io.*;
import java.util.*;

public class BJ_4485_녹색옷입은애가젤다지 {
	
	public static int[][] list;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {1,0,-1,0};
	public static int[][] money;
	public static int result;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int pNum = 0;
		while(true) {	
			pNum++; //문제 번호
			int N = Integer.parseInt(br.readLine());
			
			if(N == 0) return; //0입력 받으면 종료
			
			list = new int[N][N];
			
			//////////////////start input///////////////////////////
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					list[i][j] = Integer.parseInt(st.nextToken());
				}
//				System.out.println(Arrays.toString(list[i]));
			}//////////////////end input/////////////////////////
			
			
			///bfs///
//			System.out.println("Problem "+pNum+": "+bfs(N));
			///end bfs///
			
			///dfs///
			money = new int[N][N];
			for(int i = 0; i < N; i++) {
				Arrays.fill(money[i],Integer.MAX_VALUE);
			}
			money[0][0]= list[0][0];
			result = Integer.MAX_VALUE;
			dfs(0,0,N,list[0][0]);
//			System.out.println("Problem "+pNum+": "+money[N-1][N-1]);
			System.out.println("Problem "+pNum+": "+result);
//			System.out.println(money[N-1][N-1]);
			///end dfs///
		}//end while
	}
	
	public static void dfs(int x, int y, int N, int sum) {
//		if(money[x][y] > money[N-1][N-1]) {
//			return;
//		}
//		if(x == N-1 && y == N-1) {//끝에 도착했을 때
////			System.out.println(result);
//			result = Math.min(result,sum);
//			return;
//		}
		
		for(int i = 0; i < 4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i]; //다음 좌표값
			
			if(nx>=0 && nx<N && ny>=0 && ny < N  && sum+list[nx][ny] < result) {
//				System.out.println(nx);
				if(sum + list[nx][ny] < money[nx][ny]) {
					money[nx][ny] = sum + list[nx][ny];
					dfs(nx,ny,N, sum + list[nx][ny]);
				}
			}
			
//			if(nx>=0 && nx<N && ny>=0 && ny < N && money[x][y]+list[nx][ny] < money[nx][ny] && money[x][y]+list[nx][ny] < money[N-1][N-1]) {
//				money[nx][ny] = money[x][y] + list[nx][ny];
//				dfs(nx,ny,N);
//			}
			
		}
		
	}
	
	public static int bfs(int N) {
		money = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		visited[0][0] = true;
		

		money[0][0] = list[0][0];
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0,0));
		
		while(!queue.isEmpty()) {
			Point now = queue.poll();
//			System.out.println(now);
			for(int i = 0; i < 4; i++) {
				int nx = now.x+dx[i];
				int ny = now.y+dy[i]; //다음 좌표값
				
				if(nx>=0 && nx<N && ny>=0 && ny < N) {
					int nextMoney =money[now.x][now.y] + list[nx][ny];
					if(money[nx][ny] != 0) {						
						if(nextMoney < money[nx][ny]) {
							money[nx][ny] = nextMoney;
							queue.offer(new Point(nx,ny));
							
					}
						
					}else if(!visited[nx][ny]) {
						visited[nx][ny] = true;
						money[nx][ny] = nextMoney;
						queue.offer(new Point(nx,ny));
					}
				}
				
			}
		}
		return money[N-1][N-1];
//		for(int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(money[i]));
//		}
		
	}
	
	public static class Point{
		int x;
		int y;
		
		public Point() {};
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
		
		
	}
}
