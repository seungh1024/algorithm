package day0217;

import java.io.*;
import java.util.*;

public class SWEA_1247_최적경로 {
	
	public static class Customer{
		int x;
		int y;
		
		public Customer(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		
	}
	
	static Customer[] customer;
	
	static boolean[] check;
	static int[] index;
	
	static int result;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <=T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			
			customer = new Customer[N+2]; //고객 위치 저장
			check = new boolean[N+2]; //방문체크
			index = new int[N+2];//방문할 곳의 인덱스 저장
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			index[0] = 0;
			index[N+1] = N+1;
			
			
			customer[0] = new Customer(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			customer[N+1] = new Customer(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
//			System.out.println(customer[0].x+","+customer[N+1].x);
			
			for(int i = 1; i < N+1; i++) {
				customer[i] = new Customer(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
//				System.out.println(customer[i].x+","+customer[i].y);
			}
			
			result = 2000;
			permutation(1,N);
			System.out.println("#"+test_case+" " +result);
		}
		
	}
	
	public static void permutation(int idx, int N) {
//		System.out.println(idx);
		if(idx == N+1) {
			int sum = 0;
			for(int i = 0; i < N+1; i++) {
				sum += Math.abs(customer[index[i]].x-customer[index[i+1]].x)+Math.abs(customer[index[i]].y-customer[index[i+1]].y);
//				System.out.println(customer[index[i]]);
			}
			
			result = result<sum?result:sum;
			
			return;
		}
		
		for(int i = 1; i < N+1; i++) {
			if(!check[i]) {//선택되지 않았다면
				check[i] = true;
				index[idx] = i;
				permutation(idx+1,N);
				check[i] = false;
			}
		}
	}
	

}

//#1 200
//#2 304
//#3 265
//#4 307
//#5 306
//#6 366
//#7 256
//#8 399
//#9 343
//#10 391

