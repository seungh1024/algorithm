package day0225;

import java.io.*;
import java.util.*;

public class BJ_7576_토마토 {
	
	static ArrayList<int[]> oldTomato;
	static int babyTomato;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] tomato = new int[M][N];
		oldTomato = new ArrayList<>();//완숙 토마토 위치
		babyTomato = 0; //안익은 토마토 개수
		for(int i = 0; i < M; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int now = Integer.parseInt(st.nextToken());
				tomato[i][j] = now;
				if(now == 0) {
					babyTomato++;
				}else if (now == 1){
					oldTomato.add(new int[] {i,j});
				}
				
			}
//			System.out.println(Arrays.toString(tomato[i]));
		}
//		System.out.println(oldTomato.size());
//		System.out.println(babyTomato);
		
		///////end input///////////
		
		System.out.println(bfs(N,M,tomato));
		
	}
	
	public static int bfs(int N, int M, int[][] tomato) {
		Queue<int[]> queue = new LinkedList<>();
		for(int i = 0; i < oldTomato.size(); i++) {
			queue.offer(oldTomato.get(i)); //완숙 토마토 좌표를 큐에 넣어줌
		}
		int result = -1; //며칠이 걸리는지
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			int[] dx = {0,0,1,-1};
			int[] dy = {1,-1,0,0};
			
			for(int i = 0; i < size; i++) {//큐에 들어있는 완숙 토마토 개수만큼 반복 -> 주변 감염시킴
				int[] nowT = queue.poll();
				int x = nowT[0];
				int y = nowT[1];
//				tomato[x][y] = -1; //현재 완숙 토마토 위치를 방문처리
				for(int j = 0; j < 4; j ++) {//해당 토마토 주변 4구역 탐방
					int nx = x+dx[j];
					int ny = y+dy[j];
					if(nx<0 || nx>=M || ny <0 || ny >=N || tomato[nx][ny] != 0) continue; // 못가는 곳이면 되돌림
//					else if(tomato[nx][ny] == 0) {
						queue.offer(new int[] {nx,ny});
						tomato[nx][ny] = -1;//토마토 방문 처리
						babyTomato --;//안익은거 찾았으니 개수 감소

//					}
				}
			}
			result++;
		}
//		System.out.println(babyTomato);
		if(babyTomato ==0) {
			return result;
		}else {
			return -1;
		}
		
	}

}
