package day0225;

import java.io.*;
import java.util.*;

public class SWEA_7465_창용마을무리의개수 {
	
	static boolean[] visited;
	static int[] check;
	static int[] parents;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			visited = new boolean[N+1];
	
			check = new int[N+1];

				
			
			makeSet(N+1);
			int result = 0;
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int first = Integer.parseInt(st.nextToken());
				int second = Integer.parseInt(st.nextToken());
				
//				
				union(first,second);
			}
			
//			System.out.println(Arrays.toString(parents));
			
			
			for(int i = 1; i <= N; i++) {
				findSet(i);
				visited[parents[i]] =true;
			}
			for(int i = 1; i <= N; i++) {
				if(visited[i]) result++;
			}

			System.out.println("#" + t+" "+result);
			
		}
	}
	
	public static void makeSet(int N) {
		parents = new int[N];
		//자신의 부모노드를 자신의 값으로 세팅
		for(int i = 0; i <N; i++) {
			parents[i] = i;
		}
	}
	
	//a의 집합 찾기 : a의 대표자 찾기
	public static int findSet(int a) {
		if(a==parents[a]) {//내가 부모랑 같다는 것은 내가 루트라는 것
			return a;
		}
		
		return parents[a] = findSet(parents[a]); //path compression
		//현재 a의 부모를 재귀함수를 이용해서 루트 노드를 기리키도록 세팅함
		//부모 노드의 인덱스를 저장하는 것임
		//해당 인덱스를 찾아가면서 그 인덱스의 값이 또 다음 인덱스가 되는 것
	}
	
	//a,b 두 집합 합치기
	public static boolean union(int a, int b) {//합쳐졌다면 true, 합쳐지지 못했다면 false를 리턴 KRUSKAL 알고리즘에 사용하려고
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) {//루트가 같으면 같은 집합에 속함 -> 합칠 필요가 없음
			return false;
		}
		
		parents[bRoot] = aRoot; //a밑에 b를 붙이는 경우임 bRoot의 부모를 aRoot로 갱신하는 것
		return true;
	}
	
	

}



//2
//6 5
//1 2
//2 5
//5 1
//3 4
//4 6