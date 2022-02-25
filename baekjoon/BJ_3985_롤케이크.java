package day0225;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class BJ_3985_롤케이크 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int[] rollcake = new int[L+1];
		int[] max = new int[2];//상상 케잌 최대
		int real = 0; //진짜 케잌 최대값
		int person = 0; //진짜 케잌을 가진 사람 인덱스
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int sum = 0;
			for(int p = P; p <= K; p++) {
				if(rollcake[p] == 0) {					
					rollcake[p] = i;
					sum ++;
				}
			}
			if(sum>real) {
				real = sum;
				person = i;
			}
			
			if(max[1]<K-P+1) {
				max[0] = i;
				max[1] = K-P+1;
			}
		}
		
		System.out.println(max[0]);
		System.out.println(person);
	}

}
