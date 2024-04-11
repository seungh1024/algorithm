package algo_202403;

import java.util.*;
import java.io.*;

public class BJ_1166_선물 {
	public static long N,L,W,H;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		L = Long.parseLong(st.nextToken());
		W = Long.parseLong(st.nextToken());
		H = Long.parseLong(st.nextToken());

		double result = find();
		System.out.println(result);
	}

	public static double find() {
		double start = 0;
		double end = 1_000_000_000;

		double max = 0;
		int count = 0;
		while (count++ < 100000) {
			double mid = (start+end)/2;

			long sum = (long)(L/mid) * (long)(W/mid) * (long)(H/mid);
			// System.out.println("mid = "+mid + ", sum = "+sum);

			if (sum < N) {
				end = mid;
			} else {
				start = mid;
			}
		}

		return start;
	}
}
