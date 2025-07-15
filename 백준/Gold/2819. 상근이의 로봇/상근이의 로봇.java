

import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static int[] dx = {0, 0, 1, -1};
	public static int[] dy = {1, -1, 0, 0};
	public static Map<Character, Integer> dir = Map.of('S', 0, 'J', 1, 'I', 2, 'Z', 3);
	public static int[] xInfo, yInfo;
	public static long[] xSum;
	public static long[] ySum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		xInfo = new int[N+1];
		yInfo = new int[N+1];
		xSum = new long[N + 1];
		ySum = new long[N + 1];


		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())+1000000;
			int y = Integer.parseInt(st.nextToken())+1000000;
			xInfo[i] = x;
			yInfo[i] = y;
		}
		Arrays.sort(xInfo);
		Arrays.sort(yInfo);
		for (int i = 1; i <= N; i++) {
			xSum[i] += xSum[i - 1] + xInfo[i];
			ySum[i] += ySum[i - 1] + yInfo[i];
		}

		char[] input = br.readLine().toCharArray();
		long x = 1000000;
		long y =1000000;
		StringBuilder sb = new StringBuilder();
		for (char c : input) {
			int d = dir.get(c);
			x += dx[d];
			y += dy[d];
			long result = 0;
			long find1 = find(x, xInfo, xSum);
			long find2 = find(y, yInfo, ySum);
			// System.out.println("find1 = "+find1 + ", find2 = "+find2);

			result += find1+find2;
			sb.append(result).append("\n");
		}

		System.out.println(sb);
	}

	// 1, 3, 5,  x = 6 -> 9, x = 4 -> 4+1
	// 1 1 4 4 9 9
	// 1, 4, 9
	// -> sum[N] - sum[idx] - (x* (N-idx)) + (4*idx) - sum[idx];
	public static long find(long x, int[] info, long[] infoSum) {
		int start = 1;
		int end = N;

		while (start < end) {
			int mid = (start + end) / 2;

			if (info[mid] >= x) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		start--;
		// int pos = start - 1; // info[pos] < x 를 만족하는 가장 큰 인덱스
		// long left = Math.abs(1L * x * pos - infoSum[pos]);
		// long right = Math.abs(infoSum[N] - infoSum[pos] - 1L * x * (N - pos));
		// return left + right;
		return Math.abs(infoSum[N] - infoSum[start] - (x * (N - start))) + Math.abs(x * start - infoSum[start]);

	}
}
