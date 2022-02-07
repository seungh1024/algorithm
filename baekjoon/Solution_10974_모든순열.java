package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_10974_모든순열 {
    public static boolean[] check;
	

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
//		numbers = new int[N];
		check = new boolean[N];
		
		StringBuilder sb = new StringBuilder();
		permutation(0,N,sb);
	}
	
	public static void permutation(int cnt,int N,StringBuilder sb) {
		if(cnt == N) {
			System.out.println(sb);
			return;
		}
		for(int i = 0; i < N; i++) {
			if(check[i] ==false) {
				check[i] = true;
				//결과물 이어붙이기
				sb.append(i+1 + " ").toString();
				permutation(cnt+1,N,sb);
				//이어 붙인거 출력 후 삭제(반납 과정)
				sb.delete(cnt*2, sb.length());
				check[i] = false;
			}
		}
	}

}
