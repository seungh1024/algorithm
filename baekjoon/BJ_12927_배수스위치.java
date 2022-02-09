package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_12927_배수스위치 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		
		int result = 0;
		int length = input.length;
		for(int i = 0; i < length; i++) {
			if(input[i] == 'Y') {
				result++;
				for(int j = i; j < length; j+=i+1) {
					if(input[j] == 'N') {
						input[j] = 'Y';
					}else {
						input[j] = 'N';
					}
				}
			}
		}
//		System.out.println(result+ "//" +Arrays.toString(input));
		System.out.println(result);
	}

}
