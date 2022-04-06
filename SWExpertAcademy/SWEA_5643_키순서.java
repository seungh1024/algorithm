package day0406;

import java.io.*;
import java.util.*;

public class SWEA_5643_키순서 {

	static int[] result;
	static int N,M;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			ArrayList<Integer>[] upList = new ArrayList[N+1];
			ArrayList<Integer>[] downList = new ArrayList[N+1];
			for(int i = 1; i <= N; i++) {
				upList[i] = new ArrayList<>();
				downList[i] = new ArrayList<>();
			}
			
			StringTokenizer st;
			int small,big;
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				small = Integer.parseInt(st.nextToken());
				big = Integer.parseInt(st.nextToken());
				upList[small].add(big);
				downList[big].add(small);
			}
			
			result = new int[N+1];
			
			for(int i = 1; i <= N; i++) {
				if(upList[i].size()>0) {
					bfs(i,upList);
				}
				if(downList[i].size()>0) {
					bfs(i,downList);
				}
			}
			int count = 0;
			for(int i = 1; i <= N; i++) {
				if(result[i] == N-1) {
					count++;
				}
			}
			
			System.out.println("#"+t+" "+count);
//			System.out.println(Arrays.toString(result));
		}
	}
	
	public static void bfs(int start, ArrayList<Integer>[] list) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		boolean[] visited = new boolean[N+1];
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			for(int l : list[now]) {
//				if(start == 5) {
//					System.out.println(l);
//				}
				if(!visited[l]) {	
					visited[l] = true;
					queue.add(l);
					result[l]++;
				}
			}
		}
	}
}

//1
//6
//6
//1 5
//3 4
//5 4
//4 2
//4 6
//5 2
