package day0222;

import java.io.*;
import java.util.*;

public class SWEA_3289_서로소집합 {
	
	static int[] parent;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case<=T; test_case++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			parent = new int[n+1];
			makeSet(n+1);
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken()); //연산자 확인 변수 0은 합집합, 1은 같은집합 확인
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				int aRoot = findParent(a);
				int bRoot = findParent(b);
				if(u == 0) {
					if(aRoot != bRoot) {						
						union(aRoot,bRoot);
					}
				}else {
					if(aRoot != bRoot) {
						sb.append(0);
					}else {
						sb.append(1);
					}
				}
//				System.out.println(Arrays.toString(parent));
			}
			System.out.print("#"+ test_case+" "+sb);
		}
		
	}
	
	public static void makeSet(int N) {
		for(int i = 0; i <N; i++) {
			parent[i] = i;
		}
	}
	
	public static int findParent(int a) {
		if(parent[a] == a) {
			return a;
		}
		return parent[a] = findParent(parent[a]);
	}
	
	
	public static void union(int aRoot, int bRoot) {
		parent[bRoot] = aRoot;
	}
}
