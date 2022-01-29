package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algo10869 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		
		sum(a,b);
		sub(a,b);
		mul(a, b);
		div(a, b);
	}
	
	public static void sum(int a, int b) {
		System.out.println(a+b);
	}
	
	public static void sub(int a, int b) {
		System.out.println(a-b);
	}
	
	public static void mul(int a, int b) {
		System.out.println(a*b);
	} 
	
	public static void div(int a, int b) {
		System.out.println(a/b);
		System.out.println(a%b);
	}
	
	

}
