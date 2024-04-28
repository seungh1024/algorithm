package algo_202404;

import java.io.*;
import java.util.*;

public class BJ_1747_소수팰린드롬 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if(N == 1){
			System.out.println(2);
			return;
		}
		else if (N <= 3) {
			System.out.println(N);
			return;
		}
		while(true){
			if(check(N)){
				int sqrt = (int)Math.sqrt(N)+1;
				boolean flag = true;
				for (int i = 2; i <= sqrt; i++) {
					if(N%i == 0){
						flag = false;
						break;
					}
				}
				if(flag){
					System.out.println(N);
					return;
				}
			}
			N++;
		}
	}

	public static boolean check(int num){
		char[] data = (num+"").toCharArray();

		int left = 0;
		int right = data.length-1;
		while(left < right){
			if(data[left++] != data[right--]){
				return false;
			}
		}
		return true;
	}
}
