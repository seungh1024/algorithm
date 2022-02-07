package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algo10872 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(factorial(N));
	}
	
	public static int factorial(int num) {
		if(num <= 1) {
			return 1;
		}
		
		return num*factorial(num-1);
	}

}
