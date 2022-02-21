package day0218;

import java.io.*;
import java.util.*;

public class BJ_10971_외판원순회2 {
	
	static int[][] data;
	static boolean check[]; //같은 열인지 체크
	static int result = 100000001;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		data = new int[N][N];
		check = new boolean[N];
		
		for(int i = 0; i < N; i++) {//start input
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(data[i]));
		}//end input
		
		for(int i = 0; i < N; i++) {			
			travel(0,i,N,i,0);
//			System.out.println("///////////");
		}
		System.out.println(result);
	}
	
	public static void travel(int cnt, int idx, int N, int start, int sum) {
		if(sum>=result) {
			return;
		}
		if(cnt == N-1) {

			if(data[idx][start]==0) {
				return;
			}
			sum+=data[idx][start];
			result = result<sum?result:sum;
			
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!check[i] && idx != i && i != start) {
				if(data[idx][i] == 0) {
					continue;
				}
				check[i] = true;
				travel(cnt+1,i,N,start, sum + data[idx][i]);
				check[i] = false;
			}
		}
	}
	
	
}
