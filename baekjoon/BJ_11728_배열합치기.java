package algo_202403;

import java.io.*;
import java.util.*;

public class BJ_11728_배열합치기 {
	public static int N, M;
	public static int[] A, B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N];
		B = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		int size = N+M;
		int[] result = new int[size];

		int ai = 0;
		int bi = 0;
		for (int i = 0; i < size; i++) {
			if (ai == N) {
				result[i] = B[bi++];
			} else if (bi == M) {
				result[i] = A[ai++];
			} else if (A[ai] >= B[bi]) {
				result[i] = B[bi++];
			} else if (A[ai] < B[bi]) {
				result[i] = A[ai++];
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb);
	}
}
