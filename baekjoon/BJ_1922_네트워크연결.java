package day0301;

import java.io.*;
import java.util.*;

public class BJ_1922_네트워크연결 {
	
	static ArrayList<Net>[] list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		for(int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}//네트워크 리스트 초기화
		
		int from;
		int to;
		int weight;
		StringTokenizer st;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			list[from].add(new Net(to,weight));
			list[to].add(new Net(from,weight));
		}
		
//		for(int i = 0; i < N; i++) {
//			System.out.println(list[i]);
//		}
		
		prim(N+1);
	}
	
	public static void prim(int N) {//입력값 N보다 1큰 수가 들어올 것
		boolean[] visited = new boolean[N];
		int[] cost = new int[N];//비용을 저장할 배열
		Arrays.fill(cost, Integer.MAX_VALUE);//비교를 위해 모든 값을 최대로 채워 넣음
		cost[1] = 0;
		
		int result = 0;
		
		for(int i = 1; i < N; i++) {//모든 지점에서 반복 -> 각 지점에서 연결가능한 최소 값을 구하기 위함
			int index = 0;
			int min = Integer.MAX_VALUE; //비교를 위해 최대 값으로 채워 넣음
			
			for(int j = 1; j < N; j++) {//비용 저장하는 곳을 순회하며 최소 값을 가진 곳을 찾음
				if(!visited[j] && min>cost[j]) {//최소 값을 가진 컴퓨터 번호와 그 최소 값을 저장함
					min = cost[j];
					index = j;
				}
			}
			
			visited[index] = true;//방문 처리
			result += min;
//			System.out.println(index);
			ArrayList<Net> data = list[index];//선택된 컴퓨터와 연결된 다른 컴퓨터들의 정보
			int size = data.size();
			for(int j = 0; j < size; j++) {
				int com = data.get(j).to;
				int comCost = data.get(j).weight;
//				System.out.println("comCost: "+comCost+","+cost[com]);
				if(!visited[com] && cost[com]>comCost) {
					cost[com] = comCost;
				}
			}
//			System.out.println(Arrays.toString(cost));
			
		}
		System.out.println(result);
	}
	
	public static class Net implements Comparable<Net>{
		int to;
		int weight;
		
		public Net(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Net o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return " to: "+to+" weight: "+weight;
		}
	}

}
