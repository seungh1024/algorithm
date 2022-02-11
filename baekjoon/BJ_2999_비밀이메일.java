package day0211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_2999_비밀이메일 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		int N = s.length();
		
		int R = 0;
		int C = 0;
		
		for(int i = 1; i <= N; i++) {
			C = i;
			if(N%C == 0) {//C가 N의 약수이면 ->약수여야 R이나옴
				R = N/C;//R은 나눈 몫이 됨
				if(R <= C) {//R은 C보다 작아야 하므로 작아질 때 반복문 탈출
					//C가 제일 작은수 부터 시작해서 커지기 때문에 C가 커지자마자 멈추면 됨
					break;
				}
			}
		}
		
		
		///배열 사용/////////////////
		char[] data = s.toCharArray();
		int index = 0;
		StringBuilder sb = new StringBuilder();
		while(true) {
			if(data[index] == '0') {
				index++;
				continue;
			}
			sb.append(data[index]);
			data[index] = '0';
			index += R;
			if(index>=N) {
				index = index%N+1;
//				System.out.println(index);
			}
			if(sb.length() == N) {
				break;
			}
		}
		System.out.println(sb);
		////////////////////////////////
		
//		System.out.println(N);
//		System.out.println(R+","+C);
		
//		int[][] data = new int[R][C];
//		for(int i = 0; i < R; i++) {
//			for(int j = 0; j < C; j++) {
//				data[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
		
		
		
	}

}
