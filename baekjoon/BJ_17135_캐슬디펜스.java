package day0408;

import java.io.*;
import java.util.*;

public class BJ_17135_캐슬디펜스 {
	
	static int N,M,K; //행 길이 N, 열 길이 M, 사거리 K
	static int[][] map;
	static int[] dx = {0,-1,0};
	static int[] dy = {-1,0,1}; //좌,상,우 순서대로 탐색
	static boolean[] comVisit;
	static int result;
	static ArrayList<int[]> delete;//표적 맞춘 위치 기록
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M]; //행 크기를 1 늘려서 궁수가 위치할 수 있도록 함
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M ;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(map[i]));
		}
		////////////// end input ///////////////
		
		comVisit = new boolean[M];
		result = 0;
		com(0,0);
		System.out.println(result);
		
	}
	
	//궁수를 뽑음 0~M까지의 위치만 전달
	public static void com(int index, int cnt) {
		if(cnt == 3) {
			int[][] newMap = new int[N][M];
			copy(newMap);
			int sum = 0;
			for(int n = 0; n < N; n++) {	
				delete = new ArrayList<>();
				for(int i = 0; i < M; i++) {
					if(comVisit[i]) {//궁수가 있는 자리라면
						bfs(i,newMap);//해당 궁수가 활을 쏘러 출발
					}
				}
				sum += kill(delete,newMap); //활 쐈으면 해당 자리 0으로 초기화
				down(newMap); //한 줄 내리기
			}
			result = Math.max(result, sum);
		}
		
		if(index == M) {
			return;
		}
		
		comVisit[index] = true;
		com(index+1, cnt+1);
		comVisit[index] = false;
		com(index+1,cnt);
	}
	
	//궁수의 열 번호를 전달받아서 좌,상,우 순으로 탐색하며 제거
	public static void bfs(int point,int[][] newMap) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {N,point});
		boolean[][] visited = new boolean[N][M];
		
		
		int count = 0;
		while(count<K) {
			int size = queue.size();
			for(int s = 0; s < size; s++) {				
				int[] now = queue.poll();
				int nx,ny;
				for(int i = 0; i < 3; i++) {
					nx = now[0] + dx[i];
					ny = now[1] + dy[i];
					
					if(nx>=0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
						visited[nx][ny] = true;
						if(newMap[nx][ny] == 1) {
							delete.add(new int[] {nx,ny});
							return;
						}
						queue.offer(new int[] {nx,ny});
					}
				}
			}
			
			count++;
		}
	}
	
	public static int kill(ArrayList<int[]> delete,int[][] newMap) {
		int sum = 0;
		for(int[] now : delete) {
			if(newMap[now[0]][now[1]] == 1) {
				sum++;
				newMap[now[0]][now[1]] = 0;
			}
		}
		return sum;
	}
	
	public static void down(int[][] newMap) {
		for(int i = N-2; i >= 0; i--) {
			for(int j = 0; j < M; j++) {
				newMap[i+1][j] = newMap[i][j];
			}
		}
		for(int j = 0; j < M; j++) {
			newMap[0][j] = 0;
		}
//		for(int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//		System.out.println("////////");
	}
	
	public static void copy(int[][] newMap) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				newMap[i][j] = map[i][j];
			}
		}
	}
}
