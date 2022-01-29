package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class algo2588 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num1 = Integer.parseInt(br.readLine());
		String num2 = br.readLine();
		char[] nums = num2.toCharArray();
		int length = nums.length-1;
		for(int i = length; i >= 0 ; i--) {
			System.out.println(num1*(nums[i]-'0'));
		}
		System.out.println(num1*(Integer.parseInt(num2)));
		
	}
}
