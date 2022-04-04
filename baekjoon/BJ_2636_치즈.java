package day0330;

import java.util.*;
import java.io.*;

public class BJ_2636_치즈 {
	
	public static int[][] list;
	public static int n,m;
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1,-1,0,0};
	
	public static boolean[][] dfsCheck;
	public static ArrayList<point> dfsDelete;
	public static int dfsCount;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new int[n][m];
		
		
		int data = 0;
		for(int i = 0 ; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				data = Integer.parseInt(st.nextToken());
				list[i][j] = data;
			}
//			System.out.println(Arrays.toString(list[i]));
		}
		
		int time = 0;
		int result = 0;
//		while(true) {
//			int metingCount = meltingCheese();
//			result = metingCount>0?metingCount:result;
//			
//			if(metingCount == 0) {
//				break;
//			}
//			time++;
//		}
//		System.out.println(time);
//		System.out.println(result);
		
//		int test = meltingCheese();
//		System.out.println(test);
//		for(int i = 0; i < n; i++) {
//			System.out.println(Arrays.toString(list[i]));
//		}
		
		while(true) {
			dfsCheck = new boolean[n][m];
			dfsDelete = new ArrayList<>();
			dfsCount = 0;
			
			dfs(0,0);
			
			
			int size = dfsDelete.size();
			for(int i = 0; i < size; i++) {
				list[dfsDelete.get(i).x][dfsDelete.get(i).y]= 0; 
			}
			
			if(dfsCount == 0) {
				break;
			}
			result = dfsCount;
			time++;
		}
		System.out.println(time);
		System.out.println(result);
	}
	
	public static void dfs(int a, int b) {
		if(list[a][b] == 1) {
			dfsCount++;
			dfsDelete.add(new point(a,b));
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int nx = a + dx[i];
			int ny = b + dy[i];
			
			if(nx >=0 && nx < n && ny >=0 && ny< m && !dfsCheck[nx][ny]) {
				dfsCheck[nx][ny] = true;
				dfs(nx,ny);
			}
		}
	}
	
	public static class point {
		int x;
		int y;
		
		public point() {};
		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "point [x=" + x + ", y=" + y + "]";
		}
		
		
	}
	
	public static int meltingCheese() {
		int result = 0;
		boolean check = false; //녹아 없어질 것인지 확인할 변수
		ArrayList<point> delete = new ArrayList<>();//녹아 없어지는 좌표
		Queue<point> queue = new LinkedList<>();
		queue.offer(new point(0,0));//시작 좌표 -> 테두리는 항상 비어 있음
		
		boolean[][] visited = new boolean[n][m];
		visited[0][0] = true;
		while(!queue.isEmpty()) {
			point now = queue.poll();
//			System.out.println(now);
			for(int i = 0; i <4; i++) {
				int nx = now.x+dx[i];
				int ny = now.y+dy[i];
				
				if(nx>=0 && nx < n && ny >=0 && ny<m && !visited[nx][ny]) {
					visited[nx][ny] = true;
					if(list[nx][ny] == 1) {//1인 경우 삭제 리스트에 넣어줌
						delete.add(new point(nx,ny));
					}else {//0인 경우 다음 좌표로 넣어줌
						queue.offer(new point(nx,ny));
					}
				}
					
				
			}
		}
		
		
		int size = delete.size();
		int count = 0;
		
		for(int i = 0; i <size; i++) {
			list[delete.get(i).x][delete.get(i).y] = 0; 
			count++;
		}
		
		return count;
	}
}
