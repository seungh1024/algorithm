package day0409;

import java.io.*;
import java.util.*;

public class BJ_15961_회전초밥 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //접시 수
		int d = Integer.parseInt(st.nextToken()); //초밥의 가짓수
		int k = Integer.parseInt(st.nextToken()); //연속해서 먹는 접시의 수
		int c = Integer.parseInt(st.nextToken()); //쿠폰 번호 
		
		int[] result = new int[N];
		int[] sushi = new int[N];
		int[] check = new int[d+1]; //총 스시 종류
		
		check[c] = 1;
		
		for(int i = 0; i <N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		int nowEat = 1; //현재 겹치지 않고 먹은 접시 수
		for(int i = 0; i < k; i++) {
			if(check[sushi[i]] == 0) {
				nowEat ++;
			}
			check[sushi[i]] ++;
		}
//		System.out.println(Arrays.toString(check));
		result[0] = nowEat;
		
		for(int i = 0; i < N-1; i++) {
			check[sushi[i%N]] --;
			if(check[sushi[i%N]] == 0) {				
				nowEat--;
			}
			if(check[sushi[(i+k)%N]] == 0) {
				nowEat++;
			}
			check[sushi[(i+k)%N]] ++;
			result[i+1] = nowEat;
		}
		
		int ans = 0;
		for(int i = 0; i < N; i++) {
			ans = Math.max(result[i], ans);
		}
//		System.out.println(Arrays.toString(result));
//		System.out.println(Arrays.toString(check));
		System.out.println(ans);
	}
}
