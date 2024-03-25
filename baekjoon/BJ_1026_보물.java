package algo_202403;

import java.io.*;
import java.util.*;

public class BJ_1026_보물 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] B = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st2.nextToken());
		}
		Arrays.sort(A);
		Arrays.sort(B);

		int result = 0;
		for (int i = 0; i < N; i++) {
			result += (A[i] * B[N-i-1]);
		}
		System.out.println(result);
	}
}
