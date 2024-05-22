package algo_202405;

import java.io.*;
import java.util.*;

public class BJ_8983_사냥꾼 {
	public static int M, N;
	public static long L;
	public static long[] sa;

	public static boolean[] visited;


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		L = Long.parseLong(st.nextToken());

		sa = new long[M];


		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			sa[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(sa);

		int result = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (find(x, y)) {
				result++;

			}
		}
		System.out.println(result);
	}

	public static boolean find(long x, long y) {
		int start = 0;
		int end = M-1;

		while (start < end) {
			int mid = (start+end)/2;

			long length = Math.abs(sa[mid]-x)+y;
			if (length > L) {
				if (sa[mid] < x) {
					start = mid+1;
				} else if(sa[mid] == x){
					// System.out.println("100 false");
					// System.out.println("x = "+x +", y = "+ y + ", sa[mid] = "+sa[mid]);
					return false;
				}else {
					end = mid-1;
				}
			} else {
				// System.out.println("x = "+x +", y = "+ y + ", sa[mid] = "+sa[mid]);
				return true;
			}
		}

		if (Math.abs(sa[start] - x) + y <= L) {
			return true;
		}
		return false;
	}

}
