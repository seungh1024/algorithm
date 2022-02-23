package day0222;

import java.io.*;
import java.util.*;

import day0222.SWEA_1251_하나로.Tunnel;

public class SWEA_1251_하나로 {
	
	static int[] parent;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <=T; test_case++) {//start test
			int N = Integer.parseInt(br.readLine()); //섬의 개수
			
//			Island[] island = new Island[N];
			int[] x = new int[N];
			int[] y = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i <N; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(x));
//			System.out.println(Arrays.toString(y));
			
//			for(int i = 0; i < N; i++) {
//				island[i] = new Island(x[i],y[i]);
//			}
			
			Double E = Double.parseDouble(br.readLine()); //환경 부담금
			
			int length = N*(N-1);
			
			int idx = 0;
			Tunnel[] tunnel = new Tunnel[length];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(i == j) {
						continue;
					}
					
					tunnel[idx] = new Tunnel(i,j,Math.abs(x[i]-x[j]),Math.abs(y[i]-y[j]),E);
					idx++;
				}
			}
//			System.out.println(Arrays.toString(tunnel));
			
			
			
			
//			Tunnel[] tunnel = new Tunnel[N*(N-1)]; // 모든 간선의 경우
//			int index = 0;
//			for(int i = 0; i < N; i++) {
//				Island from = island[i];
//				for(int j = 0; j < N; j++) {
//					if(i ==j) {
//						continue;
//					}
//					
//					Island to = island[j];
//					tunnel[index] = new Tunnel(Math.abs(from.x-to.x),Math.abs(from.y-to.y),i,j,E);//간선 추가
//					index++;
//				}
//			}
			
			Arrays.sort(tunnel); //낮은 것 부터 정렬
//			System.out.println(Arrays.toString(tunnel));
			
			makeSet(N*(N-1));//간선별 부모 배열 생성
			int count = 0;
			double result = 0.0;
			for(Tunnel t : tunnel) {
				if(union(t.from,t.to)) {
					result += t.cost;
					count++;
					if(count ==N-1) {
//						System.out.println("break");
						break;
					}
				}
				
			}
			
			System.out.printf("#%d %.0f \n",test_case,result);
//			System.out.println(Double.MAX_VALUE);
			
		}//end test
	}
	public static void makeSet(int N) {
		parent = new int[N];
		for(int i = 0; i < N; i++) {
			parent[i] = i;
		}
	}
	
	public static int findParent(int a) {
		if(parent[a] == a) {
			return a;
		}
		return parent[a] = findParent(parent[a]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = findParent(a);
		int bRoot = findParent(b);
		
		if(aRoot == bRoot) {
			return false;
		}
		parent[aRoot] = bRoot;
		return true;
	}
	
	public static class Tunnel implements Comparable<Tunnel>{
		int from;
		int to;
		double cost;
		
//		public Tunnel(int xLength, int yLength, int from ,int to,double E) {
//			this.from = from;
//			this.to = to;
//			cost = 1.0*((xLength*xLength)+(yLength*yLength))*E;
//		}
		public Tunnel(int from, int to, int x ,int y,double E) {
			this.from = from;
			this.to = to;
			cost = (E*x*x)+(E*y*y);
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "from: "+ from + " to : "+ to+" cost: "+cost;
		}

		@Override
		public int compareTo(Tunnel o) {
			// TODO Auto-generated method stub
			if(this.cost-o.cost >0) {
				return 1;
			}else if(this.cost -o.cost <0) {
				return -1;
			}
			return 0;
//			return (int)((int)this.cost-(int)o.cost);
		}
	}
	
	public static class Island {
		int x;
		int y;
		
		public Island(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}

}

//#1 10000
//#2 180000
//#3 1125000
//#4 1953913
//#5 27365366
//#6 337122
//#7 711268755613
//#8 280157
//#9 521568761
//#10 34
//#11 375890356686
//#12 68427157
//#13 21404
//#14 16620885
//#15 4776395492
//#16 54860981981
//#17 24236206202
//#18 132410
//#19 12876964085
//#20 7016649393
