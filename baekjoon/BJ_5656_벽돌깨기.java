package day0409;

import java.io.*;
import java.util.*;

public class BJ_5656_벽돌깨기 {
	
	static int[][] map;
	static int[] check; //중복 순열 체크 -> 리스트로 해야하지 않나?
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int N; //구슬 개수
	static int W; //열 개수
	static int H; //행 개수
	static int result;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			map = new int[H][W];
			for(int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
//				System.out.println(Arrays.toString(map[i]));
			}
			
			check = new int[N]; //구슬 개수만큼 초기화
			result = Integer.MAX_VALUE; //결과값 => 최소값으로 계속 갱신
			per(0);
			System.out.println("#"+t+" "+result);
			
		}
	}
	
	public static void per(int index) {
		if(index == N) {
//			System.out.println(Arrays.toString(check));
			int[][] newMap = new int[H][W];
			copy(newMap);
			for(int i = 0; i < N; i++) {
				int now = check[i];
				for(int j = 0; j < H; j++) {// 수직 탐색 -> 벽돌 있는지 확인
					if(newMap[j][now]>0) {
						boom(j,now,newMap);
						down(newMap);
						break;
					}
				}
			}
			int count = counting(newMap);
//			System.out.println(count);
			result = Math.min(result, count);
			
//			for(int i = 0; i < H; i++) {
//				System.out.println(Arrays.toString(newMap[i]));
//			}
//			System.out.println("/////////////");
			
			return;
		}
		
		for(int i = 0; i < W; i++) {
			check[index] = i;
			per(index+1);
		}
		return;
	}
	
	public static int counting(int[][] newMap) {
		int sum = 0;
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if(newMap[i][j] != 0) {
					sum++;
				}
			}
		}
		return sum;
	}
	
	public static class Point{
		int x,y;

		public Point() {};
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void boom(int x, int y, int[][] newMap) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(x,y));//시작점
		while(!queue.isEmpty()){
			Point now = queue.poll();
			int length = newMap[now.x][now.y]-1;
			newMap[now.x][now.y]= 0; 
//			System.out.println(length);
			for(int d=0; d < 4; d++) {//4방 탐색
				int nx = now.x;
				int ny = now.y;
				for(int i = 0; i < length; i ++) {
					nx+= dx[d];
					ny += dy[d];
					if(nx >= 0 && nx < H && ny >= 0 && ny < W ) {
//						System.out.println(nx+","+ny);
						if(newMap[nx][ny]>=1) {
							queue.offer(new Point(nx,ny));
						}							
//						newMap[nx][ny] = 0;
						
					}
				}
			}
		}
		
//		for(int i = 0; i < H; i++) {
//			System.out.println(Arrays.toString(newMap[i]));
//		}
//		System.out.println("////////////");
	}
	
	public static void down(int[][] newMap) {
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < W; i++) {
			for(int j = 0; j < H; j++) {
				if(newMap[j][i]>0) {
					stack.push(newMap[j][i]);
					newMap[j][i] = 0;
				}
			}
			int size = stack.size();
			int index = H-1;
			for(int j = 0; j < size; j++) {
				newMap[index][i] = stack.pop();
				index--;
			}
		}
	}
	
	public static void copy(int[][] newMap) {
		for(int i = 0; i < H; i++) {
			for(int j = 0; j <W; j++) {
				newMap[i][j] = map[i][j];
			}
		}
	}
}


//5
//3 10 10
//0 0 0 0 0 0 0 0 0 0
//1 0 1 0 1 0 0 0 0 0
//1 0 3 0 1 1 0 0 0 1
//1 1 1 0 1 2 0 0 0 9
//1 1 4 0 1 1 0 0 1 1
//1 1 4 1 1 1 2 1 1 1
//1 1 5 1 1 1 1 2 1 1
//1 1 6 1 1 1 1 1 2 1
//1 1 1 1 1 1 1 1 1 5
//1 1 7 1 1 1 1 1 1 1