package day0408;

import java.io.*;
import java.util.*;

public class SWEA_1767_프로세서연결하기 {
	
	static int N;
	static int maxCore;
	static int minLine;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static ArrayList<Point> core;
	static int[][] map;
	static int coreSize;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			core = new ArrayList<>();
			
			StringTokenizer st;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					int input = Integer.parseInt(st.nextToken());
					map[i][j] = input;
					if(input == 1 && i != 0 && i != N-1 && j !=0 && j != N-1) {
						core.add(new Point(i,j));//가장자리 아닌 코어들만 넣어줌
					}
				}
			}
			maxCore = 0;
			minLine = 0;
			coreSize = core.size();
			
			dfs(0,0);
			
			System.out.println("#"+t+" "+minLine);				
			
		}
		
	}
	static int tmp = 0;
	public static void dfs(int index,int sumCore) {
//		if(tmp++<20)
		if(index == coreSize) {
//			System.out.println(Arrays.toString(visited));
			int lines = countLine();

			if(maxCore < sumCore) { //코어 개수 많을 땐 무조건 넣어줌
				maxCore = sumCore;
				minLine = lines;
			}else if(maxCore == sumCore) {
				minLine = minLine < lines ? minLine : lines; //더 작은거 넣어줌
			}
//			System.out.println(minLine);
			return;
		}
		
		
		Point now = core.get(index); // 현재 살표볼 코어 위치
		for (int d = 0; d < 4; d++) {
			if (isAvailable(dx[d], dy[d], now)) {//라인 깔 수 있으면
				makeLine(dx[d], dy[d], now, 2);// 라인은 2번으로 깔아줌
				dfs(index + 1,sumCore+1);
				makeLine(dx[d], dy[d], now, 0);// 탈출하면 다시 0번으로 초기화 시켜줌
			}

		}
		dfs(index+1,sumCore);
		
		
	}
	
	public static boolean isAvailable(int nx, int ny, Point now) {
		int cx = now.x;
		int cy = now.y;
		while(true) {
			cx += nx;
			cy += ny;
			if(cx == -1 || cx == N || cy == -1 || cy == N ) return true; //끝까지 연결하면 끝남
			
			if(map[cx][cy] != 0) return false; //중간에 0 말고 코어나 라인 만나면 false리턴
		}
	}
	public static void makeLine(int nx,int ny, Point now, int value) {
		int cx = now.x;
		int cy = now.y;
		while(true) {
			cx += nx;
			cy += ny;
			if(cx == -1 || cx == N || cy == -1 || cy == N ) return; //끝까지 연결하면 끝남
			
			map[cx][cy] = value;
		}
	}
	public static int countLine() {
		int sum = 0;
		for(int i = 0; i < N; i++) {
			for(int j =0; j < N; j++) {
				if(map[i][j] == 2) {//라인이 깔려 있는 것만 더해줌
					sum++;
				}
			}
//			System.out.println(Arrays.toString(map[i]));
		}
//		System.out.println("/////////////////");
		return sum;
	}
	
	public static class Point{
		int x,y;

		Point(){};
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
//3
//7
//0 0 1 0 0 0 0
//0 0 1 0 0 0 0
//0 0 0 0 0 1 0
//0 0 0 0 0 0 0
//1 1 0 1 0 0 0
//0 1 0 0 0 0 0
//0 0 0 0 0 0 0
//9
//0 0 0 0 0 0 0 0 0
//0 0 1 0 0 0 0 0 1
//1 0 0 0 0 0 0 0 0
//0 0 0 1 0 0 0 0 0
//0 1 0 0 0 0 0 0 0
//0 0 0 0 0 0 1 0 0
//0 0 0 1 0 0 0 0 0
//0 0 0 0 0 0 0 1 0
//0 0 0 0 0 0 0 0 1
//11
//0 0 1 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0 1
//0 0 0 1 0 0 0 0 1 0 0
//0 1 0 1 1 0 0 0 1 0 0
//0 0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 1 0 0 0
//0 0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 1 0 0
//0 0 0 0 0 0 1 0 0 0 0
//0 0 0 0 0 0 0 0 0 0 0
