package algo_202403;

import java.util.*;
import java.io.*;

public class BJ_1182_부분수열의합 {
	public static int N, S;
	public static int[] data;
	public static int result;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		data = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		result = 0;
		find(0,0);
		// find(1,data[0]);
		// System.out.println(result);
		if (S == 0) {
			result --;
		}
		System.out.println(result);
	}

	public static void find(int index, int sum) {
		// System.out.println("index = "+index + ", sum = "+sum);
		if (index == N) {
			if (sum == S) {
				result++;
			}
			return;
		}

		find(index + 1, sum + data[index]);
		find(index+1,sum);
	}
}
