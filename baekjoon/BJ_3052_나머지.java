package day0225;

import java.io.*;
import java.util.*;

public class BJ_3052_나머지 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] array = new int[42];
		
		for(int i = 0; i < 10; i++) {
			int a = Integer.parseInt(br.readLine())%42;
			array[a] ++;
		}
		
		int result = 0;
		for(int i = 0; i <42; i++) {
			if(array[i] !=0) {
				result++;
			}
		}
		System.out.println(result);
		
	}

}
