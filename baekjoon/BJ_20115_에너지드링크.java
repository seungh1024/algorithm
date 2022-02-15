package algo.study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_20115_에너지드링크 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long max = 0;
		long sum = 0;
//		int[] data = new int[N];
		long input;
		for(int i = 0; i < N; i++) {
			input =Long.parseLong(st.nextToken());
//			data[i] = input;
			max = max>input? max : input;
			sum += input;
		}
		double result = ((1.0*sum-max)/2 + max);
//		if(result%1 == 0) {
//			System.out.println(result);
//		}else {			
//			System.out.println(result);
//		}
		System.out.println(result);
		
//		long a =0l;
//		for(int i = 0; i < 100000; i++) {
//			a+= 500000000;
//		}
//		System.out.println(a);
	}

}
