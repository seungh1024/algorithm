package day0401;

import java.io.*;
import java.util.*;

public class BJ_2579_계단오르기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] array = new int[N+1][2];
		
		int input = 0;
		for(int i = 0; i < N; i++) {
			input = Integer.parseInt(br.readLine());
			if(i-1>=0) {
				array[i][1] = Math.max(input + array[i-1][0],array[i][1]);
			}else {
				array[i][0] = input;
				array[i][1] = input;
			}
			
			if(i-2>= 0) {
				array[i][0] = Math.max(input + Math.max(array[i-2][0],array[i-2][1]),array[i][0]);
			}else if(i != 0){
				array[i][0] = input;
				array[i][1] = input + array[i-1][0];
			}
		}
		
//		System.out.println(array[N-1][0]);
//		System.out.println(array[N-1][1]);
		System.out.println(Math.max(array[N-1][0], array[N-1][1]));

		
//		for(int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(array[i]));
//		}
	}
}
