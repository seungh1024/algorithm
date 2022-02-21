package day0221;

import java.io.*;
import java.util.*;

public class BJ_2798_블랙잭 {
	
	static int result = 0;
	static boolean[] check;

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//start input
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] data = new int[N];
		check = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}//end input
//		System.out.println(Arrays.toString(data));
		
		blackJack(data,M,0,0);
		System.out.println(result);
	}
	
	public static void blackJack(int[] data,int M, int cnt,int index) {
		if(cnt == data.length) {

			return;
		}
		
		if(index == 3) {
//			System.out.println('c');
			int sum = 0;
			for(int i = 0; i < data.length;i++) {
				if(check[i]) {
					sum+=data[i];
				}
			}
			if(sum>0 && sum <= M) {				
				result = result>sum?result:sum;
			}
			
			return;
		}
		
		check[cnt] = true;
		blackJack(data,M,cnt+1,index+1);
		check[cnt] = false;
		
		blackJack(data,M,cnt+1,index);
		
	}

}
