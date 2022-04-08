package day0408;

import java.io.*;
import java.util.*;

public class BJ_1325_효율적인해킹 {
	
	static ArrayList<Integer>[] map;
	static int N,M;
	static int[] numCnt;
	static boolean[] visited;
	static int numSum;
	static int result;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			map[i] = new ArrayList<>();
		}
		
		
		int a,b;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			map[a].add(b);
		}
		
		//////////// dfs////////////////
//		StringBuilder sb = new StringBuilder();
//		result = 0;
//		for(int i = 1; i <= N; i++) {
//			if(map[i].size() > 0) {
////				System.out.println(i);
//				numSum = 0;
//				visited = new boolean[N+1];
//				dfs(i);	
//				if(result<numSum) {
//					result = numSum;
//					sb.setLength(0);
//					sb.append(i+" ");
//				}else if(result == numSum) {
//					sb.append(i+ " ");
//				}
//			}
//		}
//		System.out.println(sb);
		///////////// dfs////////////////////
		
		
		//////////// bfs ///////////////
		numCnt = new int[N+1];
		for(int i = 1; i <= N; i++) {
			if(map[i].size()>0) {
				bfs(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int maxNum = 0;
		for(int i = 1; i <= N; i++) {
			if(numCnt[i] > maxNum) {
				maxNum = numCnt[i];
				sb.setLength(0);
				sb.append(i+" ");
			}else if(numCnt[i] == maxNum) {
				sb.append(i+ " ");
			}
		}
		System.out.println(sb);
		//////////// bfs ///////////////
		
		
	}
	
	public static void dfs(int now) {
		for(int a : map[now]) {
			if(!visited[a]) {
				System.out.println(a);
				visited[a] = true;
				numSum++;
				dfs(a);
			}
		}
	}
	
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			for(int num : map[now]) {
				if(!visited[num]) {
					visited[num] = true;
					queue.offer(num);
					numCnt[num]++;
				}
			}
		}
	}
}
