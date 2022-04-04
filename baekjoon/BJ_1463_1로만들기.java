package day0331;

import java.io.*;
import java.util.*;

public class BJ_1463_1로만들기 {
	
	public static int result = Integer.MAX_VALUE;
	public static int[] D;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		D = new int[N+1];
		
		Arrays.fill(D, Integer.MAX_VALUE);
		D[0] = 0;
		D[1] = 0;
		
//		for(int i = 2; i <=N; i++) {
//			if(i%3==0) {
//				D[i] = Math.min(D[i], D[i/3]+1);
//			}
//			if(i%2 == 0) {
//				D[i] = Math.min(D[i], D[i/2]+1);
//			}
//			D[i] = Math.min(D[i], D[i-1]+1);
//		}
		
//		System.out.println(D[N]);
//		System.out.println(dfs(N));
		
		System.out.println(dfs(N,0));
//		System.out.println(result);
//		System.out.println(Arrays.toString(D));
	}
	
	public static int dfs(int N, int sum) {
//		if(N == 1) {
//			return 1;
//		}
		
		
		if(N%3 == 0 ) {
			if(D[N/3] == Integer.MAX_VALUE) {
				D[N] = Math.min(D[N],dfs(N/3,sum+1)+1);
			}else {
				D[N] = Math.min(D[N],D[N/3] + 1);
			}
			
		}
		else if(N%2 == 0) {
			if(D[N/2] == Integer.MAX_VALUE) {
				D[N] = Math.min(D[N],dfs(N/2,sum+1)+1);
			}else {
				D[N] = Math.min(D[N],D[N/2] + 1);
			}
		}
		if(N-1 >1 ) {
			if(D[N-1] == Integer.MAX_VALUE) {
				D[N] = Math.min(D[N-1],dfs(N-1,sum+1)+1);
			}else {
				D[N] = Math.min(D[N],D[N-1] + 1);
			}
		}
		
		
		return D[N];
	}
}
