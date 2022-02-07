package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algo10870 {
	static int[] check;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		check = new int[N+1];
		
		System.out.println(fibo(N));

	}
	
	public static int fibo(int num) {
		if(check[num] >0) {
			return check[num];
		}
		if(num == 0) {
			return 0;
		}
		else if(num == 1) {
			return 1;
		}
		else {
			check[num] = fibo(num-1)+fibo(num-2);
			return check[num];
//			return fibo(num-1)+fibo(num-2);
		}
		
	}

}
