package algo_202403;

import java.io.*;
import java.util.*;

public class BJ_2417_정수제곱근 {
	public static long N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Long.parseLong(br.readLine());
		long answer = find();
		System.out.println(answer);
	}
	public static long find() {
		long start = 0;
		long end = (long)Math.sqrt(N)+1;

		while(start < end){
			long mid = (start+end)/2;

			if(Math.pow(mid,2)>=N){
				end = mid;
			}else{
				start = mid +1;
			}
		}
		return start;
	}
}
