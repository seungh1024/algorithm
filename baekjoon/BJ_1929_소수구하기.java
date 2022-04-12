package day0412;

import java.io.*;
import java.util.*;

public class BJ_1929_소수구하기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		boolean[] sosu = new boolean[N+1];
		
		double size = Math.sqrt(N);
		
		for(int i = 2; i <= size; i++) {
			int now = i;
			for(int j = 2; i*j<=N; j++) {
				sosu[i*j] = true;
			}
		}
		if(M == 1) {
			M ++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = M; i <= N; i++) {
			if(!sosu[i]) {
//				System.out.println(i);
				sb.append(i+"\n");
			}
		}
		System.out.println(sb);
	}
}
