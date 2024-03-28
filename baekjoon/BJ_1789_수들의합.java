package algo_202403;

import java.io.*;
import java.util.*;

public class BJ_1789_수들의합 {
	public static long S;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = Long.parseLong(br.readLine());

		long answer = find();
		if(makeSum(answer) > S){
			answer--;
		}
		System.out.println(answer);
	}

	public static long find(){
		long start = 1;
		long end = S;

		while(start<end){
			long mid = (start+end)/2;

			if(makeSum(mid) >= S){
				end = mid;
			}else{
				start = mid+1;
			}
		}
		return start;
	}

	public static long makeSum(long num){
		long result = 0;
		result = (num+1)* (num/2);
		if(num % 2 > 0){
			result+= (num/2)+1;
		}
		return result;
	}
}
