package day0215;

import java.io.*;

public class BJ_2839_설탕배달 {
	public static void main(String[] args)  throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int count = 0;
		while(N>=15) {
			N -= 5;
			count ++;
		}
		
		
		if(N%5==0) {
			count += N/5;
			N = N%5;
		}else if(N%3 == 0) {
			count += N/3;
			N = N%3;
		}else if(N>5) {
			while(N>=5) {
				N-=5;
				count++;
				if(N%3 == 0) {
					count += N/3;
					N = N%3;
				}
			}
		}
//		System.out.println(N);
		if(N != 0) {
			count = -1;
		}
		
		System.out.println(count);
	}
}
