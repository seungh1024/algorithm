package day0331;

import java.io.*;
import java.util.*;

public class BJ_9655_돌게임 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		if(N<=3) {
			if(N == 2) {
				System.out.println("CY");
			}
			else {
				
				System.out.println("SK");
			}
			return;
		}
		
		int[] stone = new int[N+1];
		stone[1] =  stone[3] = -1;
		
		for(int i = 4; i <= N; i++) {
			if(stone[i-2] == -1 && stone[i-4] == -1) {
				stone[i] = -1;
			}
			if(i>=6 && stone[i-4] == -1 && stone[i-6] == -1) {
				stone[i] = -1;
			}
		}
		
//		System.out.println(stone[N]);
//		System.out.println(Arrays.toString(stone));
		if(stone[N] == -1) {
			System.out.println("SK");
		}else {
			System.out.println("CY");
		}
		
//		if(N>3) {
//			if(N%2 == 0) {
//				System.out.println("CY");
//			}else {
//				System.out.println("SK")
//			}
//		}else {
//			System.out.println("SK");
//		}
		
	}
}
