package algo_202403;

import java.io.*;
import java.util.*;

public class BJ_20444_색종이와가위 {
	public static long n,k;
	public static long result;

	public static void main(String[] args) throws  IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Long.parseLong(st.nextToken());
		k = Long.parseLong(st.nextToken());

		result = 0;
		long num = find();
		if ((num + 1) * (n - num + 1) == k) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	public static long find() {
		long start = 0;
		long end = n/2;

		while (start < end) {
			long mid = (start+end)/2;
			long sum = (mid+1)*(n-mid+1);

			if (sum >= k) {
				end = mid;
			} else if (sum < k) {
				start = mid + 1;
			}
		}

		return start;
	}


}
