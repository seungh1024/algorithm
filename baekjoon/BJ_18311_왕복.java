package algo_202403;

import java.io.*;
import java.util.*;

public class BJ_18311_왕복 {
	public static long[] data;
	public static long[] input;
	public static int N;
	public static long K;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Long.parseLong(st.nextToken());
		input = new long[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Long.parseLong(st.nextToken());
		}

		data = new long[N*2+1];
		data[0] = 0;
		for(int i = 1; i <= N; i++){
			data[i] = data[i-1] + input[i-1];
		}
		for(int i = N+1; i <= 2*N; i++){
			data[i] = data[i-1] + input[N-1-(i-N-1)];
		}
		// System.out.println(Arrays.toString(data));

		int result = find(2*N)+1;
		// System.out.println(result);
		if (result > N) {
			System.out.println(N+1-(result-N));
		} else {
			System.out.println(result);
		}
	}

	public static int find(int range){
		int start = 0;
		int end = range;

		while (start < end) {
			int mid = (start+end+1)/2;

			if (data[mid] > K) {
				end = mid - 1;
			} else {
				start = mid;
			}
		}

		return start;
	}
}
