package day0313;

import java.io.*;
import java.util.*;

public class BJ_14621_나만안되는연애 {
	
	static char[] mw;
	static ArrayList<Point>[] school;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());//학교 수
		int M = Integer.parseInt(st.nextToken());// 연결하는 도로의 개수
		
		mw = new char[N+1];
		st = new StringTokenizer(br.readLine());
		int index = 1;
		while(true){//null이 아닐때만 
			if(!st.hasMoreTokens()) break;
			mw[index] = st.nextToken().charAt(0);
			index++;
		}
		//학교 종류 입력 완료
		
//		System.out.println(Arrays.toString(mw));
		
		school = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			school[i] = new ArrayList<>();
		}
		//학교 크기 초기화 완료
		
		//연결된 데이터 입력 시작
		int start = 0;
		int from,to,weight;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			start = from;
			
			if(mw[from] != mw[to]) {				
				school[from].add(new Point(to,weight));
				school[to].add(new Point(from,weight));
			}
		
		}
		
//		for(int i = 1; i <=N; i++) {
//			System.out.println(school[i]);
//		}
		
		prim(N,start);

	}
	
	public static void prim(int N, int start) {
		int[] distance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		boolean[] visited = new boolean[N+1];
		
		PriorityQueue<Point> pQueue = new PriorityQueue<>();
		pQueue.offer(new Point(start,0));
		
		int result = 0;
		int count = 0;
		
		while(!pQueue.isEmpty()) {
			Point now = pQueue.poll();
			
			if(visited[now.to]) continue;
			visited[now.to]= true; 
			result+= now.weight;
			count ++;
			
			for(Point p: school[now.to]) {
				//방문하지 않았고, 거리가 더 가깝고 (다른 성별의 학교이거나 첫 시작점인 학교) 일 때
				if(!visited[p.to] && distance[p.to]> p.weight ) {
					distance[p.to]= p.weight;
					pQueue.offer(new Point(p.to,p.weight));
				}
			}
		}
//		System.out.println(Arrays.toString(distance));
//		System.out.println(Arrays.toString(visited));
		if(count != N) {
			System.out.println(-1);
			return;
		}
		System.out.println(result);
	}
	
	public static class Point implements Comparable<Point>{
		int to;
		int weight;
		
		public Point(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "to : "+to+" weight: "+weight;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
	}

}
