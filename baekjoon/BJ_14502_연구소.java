package day0408;

import java.io.*;
import java.util.*;

public class BJ_14502_연구소 {
	
	static int[][] map; //연구소 맵
	static int N,M;
	static ArrayList<int[]> empty; //빈 공간 위치
	static ArrayList<int[]> virus; //바이러스 위치
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int emptyCnt; //빈 공간 개수
	static int result; //결과값
	static boolean[] comVisit;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		virus = new ArrayList<>();
		empty = new ArrayList<>();
		int input = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				input = Integer.parseInt(st.nextToken());
				map[i][j] = input;
				if(input == 2) {
					virus.add(new int[] {i,j});
				}else if(input == 0) {
					empty.add(new int[] {i,j});
					emptyCnt++;
				}
			}
//			System.out.println(Arrays.toString(map[i]));
		}
//		System.out.println(emptyCnt);
		
		result = 0;
		comVisit = new boolean[emptyCnt];
		com(0,0);
		System.out.println(result);
		
	}
	
	public static void com(int index, int cnt) {
		if(cnt == 3) {
			bfs();
			return;
		}
		if(index == emptyCnt) {
			return;
		}
		
		comVisit[index] = true;
		com(index+1,cnt+1);
		comVisit[index] = false;
		com(index+1,cnt);
		
	}
	
	public static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		int[][] newMap = new int[N][M];
		for(int i = 0; i < N; i++) { //복사
			for(int j = 0; j < M; j++) {
				newMap[i][j] = map[i][j];
			}
		}
		for(int i = 0; i < emptyCnt; i++) {
			if(comVisit[i]) {
				newMap[empty.get(i)[0]][empty.get(i)[1]] = 1;
			}
		}
		
		int virusSize = virus.size();
		for(int i = 0; i < virusSize; i++) {
			queue.offer(virus.get(i));
		}
		
		int count = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int i = 0; i < size; i++) {
				int[] now = queue.poll();
//				System.out.println(now[0]+","+now[1]);
				int nx,ny;
				for(int d = 0; d < 4; d++) {
					nx = now[0] + dx[d];
					ny = now[1] + dy[d];
//					System.out.println(nx+"//"+ny);
					//범위 안벗어나고 0이라서 이동할 수 있다면
					if(nx >= 0 && nx < N && ny >= 0 && ny < M && newMap[nx][ny] == 0) {
						newMap[nx][ny] = 2; //감염
						count++;
						queue.offer(new int[] {nx,ny});//감염됐으니 넣어줌
					}
				}
			}
		}
		
		result = Math.max(result, emptyCnt-count-3);//3개를 빼는건 벽을 세워야해서
//		for(int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(newMap[i]));
//		}
//		System.out.println(result);
	}
}
