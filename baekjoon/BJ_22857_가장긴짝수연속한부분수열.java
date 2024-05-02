package algo_202404;

import java.io.*;
import java.util.*;

public class BJ_22857_가장긴짝수연속한부분수열 {
	public static int N,K;
	public static int[] data;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		data = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = 0;
		int max = 0;
		int count = 0;
		// int range = K;
		while (true) {

			// System.out.println("right = " +right +", left = "+left + ", K = "+K);
			if (data[right] % 2 == 0) {
				count++;
			}
			else if(data[right] %2 != 0) {
				if (K > 0) {
					K--;
					// count++;
				} else {
					// System.out.println("right = "+right +", left = "+left);
					max = Math.max(max,count);
					while (left <= right) {
						if (data[left] % 2 != 0) {
							K++;
							left++;
							break;
						} else if (data[left] % 2 == 0) {
							count--;
						}
						left++;
					}
					continue;
				}
			}

			right++;
			if (right >= N) {
				// System.out.println("?");
				max = Math.max(max,count);
				break;
			}
		}

		System.out.println(max);
	}
}
