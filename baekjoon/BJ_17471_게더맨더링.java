package day0406;

import java.io.*;
import java.util.*;

public class BJ_17471_게더맨더링 {
	
	static int N;
	static boolean[][] map;
	static boolean[] visited;
	static int[] peoples;
	static int result = Integer.MAX_VALUE;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		peoples = new int[N];
		map = new boolean[N][N]; //1인덱스에 해당하는 지역구가 2인덱스에 해당하는 지역구에 연결되어 있으면 true
		visited = new boolean[N];
		
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine()); // 지역마다의 인구수
		for(int i = 0; i < N; i++) {
			peoples[i] = Integer.parseInt(st.nextToken());
		}

		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int cityCnt = Integer.parseInt(st.nextToken()); //인접한 도시의 수
			for(int j = 0; j < cityCnt; j++) {
				int city = Integer.parseInt(st.nextToken()); //인접한 도시의 번호
				map[i][city-1] = true; //i구역과 인접한 도시는 true로
			}
//			System.out.println(Arrays.toString(map[i]));
		}
		/////////////////////end input////////////////////////////
		
		for(int i = 1; i <= N/2; i++) {
			com(0,0,i);
		}
		if(result != Integer.MAX_VALUE) {
			System.out.println(result);
		}else {
			System.out.println(-1);
		}
		
	}
	
	
	public static void com(int index, int cnt, int end) {
		if(cnt == end) {
			
			if(find(true) && find(false)) { //둘 다 연결되어 있다면
				int sum = 0;
				int totalSum = 0;
				for(int i = 0; i < N; i++) {
					if(visited[i]) {
						sum+= peoples[i];
					}
					totalSum+=peoples[i];
				}
//				System.out.println(sum);
				result = Math.min(result, Math.abs(totalSum - sum - sum)); //전체에서 선택된구 뺀 값 ->비선택 구 합 -> 거기서 뺀 값이 차
//				System.out.println(result);
			}
			return;
		}
		
		if(index == N) return; //범위 벗어난거 버림
		visited[index] = true;
		com(index+1,cnt+1,end); //선택한 경우
		visited[index] = false;
		com(index+1,cnt,end); //선택하지 않은 경우
	}
	
	public static boolean find(boolean tf) {//tf 로 선택된걸 탐색할지 아닌걸 탐색할지
//		System.out.println(Arrays.toString(visited));
		Queue<Integer> queue = new LinkedList<>();
		boolean[] check = new boolean[N];
		
		int count = 1;
		for(int i = 0; i < N; i++) {
			if(visited[i] == tf) {
				queue.add(i);
				check[i] = true;
				break;
			}
		}
		
		while(!queue.isEmpty()) {
			int now = queue.poll();//해당 번호의 구
//			System.out.println(now);
			for(int i = 0; i < N; i++) {
				if(map[now][i] && !check[i] && visited[i] == tf) {//연결되어 있고 방문하지 않았다면
					check[i] = true;
					count++;
					queue.add(i); //연결된 다른 구
				}
			}
		}
//		System.out.println(Arrays.toString(visited));
//		System.out.println(Arrays.toString(check));
		
		for(int i = 0; i < N; i ++) {
			if(visited[i] == tf) {
				count--;
			}
		}
		
		if(count == 0) {
			return true;
		}else {
			return false;
		}
		
	}
}

//5
//4 2 3 4 1 
//2 2 4
//3 1 3 5
//2 4 2
//2 1 3
//1 2

//5
//4 2 3 4 1 
//2 2 4
//2 1 3 
//2 4 2
//2 1 3
//0