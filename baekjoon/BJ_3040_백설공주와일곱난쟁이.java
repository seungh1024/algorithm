package day0214;

import java.io.*;
import java.util.*;

public class BJ_3040_백설공주와일곱난쟁이 {
	static boolean[] check = new boolean[9];//알맞은 난쟁이 체크할 배열
	static int[] small = new int[9]; //난쟁이 넣을 배열
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 9; i++) {
			small[i] = Integer.parseInt(br.readLine());
		}
//		System.out.println(Arrays.toString(small));
		com(0,0,0,false);

	}
	
	public static void com(int cnt,int index, int sum, boolean end) {
		if(cnt == 7) {
			if(sum == 100) {
				for(int i = 0; i <9; i++) {
					if(check[i]) {
						System.out.println(small[i]);
					}
				}
				end = true;
			}
			return;
		}
		
		if(index>=9) {
			return;
		}
		
		check[index] = true;
		com(cnt+1,index+1,sum+small[index],end);
		if(end) {
			return;
		}
		check[index] = false;
		com(cnt,index+1,sum,end);
		if(end) {
			return;
		}
	}

}
