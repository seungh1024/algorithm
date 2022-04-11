package day0409;

import java.io.*;
import java.util.*;

public class BJ_1912_연속합 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] data = new int[N];
		for(int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		int result = data[0];
		for(int i = 0; i < N-1; i++) {
			if(data[i+1]>data[i]+data[i+1]) {
				result = Math.max(data[i+1], result);
			}else {
				data[i+1] = data[i]+data[i+1];
				result = Math.max(data[i+1], result);
			}
		}
		
		System.out.println(result);
	}
}
