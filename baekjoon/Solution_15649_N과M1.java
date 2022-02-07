package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_15649_N과M1 {
	public static boolean[] check;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		check = new boolean[N];
		
		StringBuilder sb = new StringBuilder();
		permutation(0,N,M,sb,0);
	}
	
	public static void permutation(int cnt,int N,int M,StringBuilder sb,int length) {
		if(cnt == M) {
			System.out.println(sb);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(check[i] == false) {//선택되지 않은 수이면
				check[i] = true;
				sb.append(i+1+" ");
				length += 2;
				permutation(cnt+1,N,M,sb,length);
				sb.delete(cnt*2, length);
				length -=2;
				check[i] = false;
				
			}
		}
	}

}
