

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static long K;
	public static int[] A;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Long.parseLong(st.nextToken());
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}


		// 양 끝단의 합 *(N/2) + 양 끝단의 합/2 *(N%2)
		long result = find();
		System.out.println(result);
	}

	public static long find() {
		long start = 1;
		long end = 2_000_000_000L;

		while (start < end) {
			long mid = (start+end)/2;

			long value = getValue(mid);
			// System.out.println("start = "+start +", end = "+end + ", mid = "+mid +  ", value = "+value);

			if (value >= K) {
				end = mid;
			}else{
				start = mid+1;
			}
		}

		return start;
	}

	private static long getValue(long v) {
		long sum = 0;
		for (int i = 1; i < N; i++) {
			long cnt = A[i]-A[i-1];
			if (cnt == 1|| v == 1) {
				sum += v;
			} else {
				long end = v-(cnt-1);
				if(end <=0){
					cnt = v;
					end = 1;
				}
				sum += ((v+end)*(cnt/2) + (v+end)/2*(cnt%2));
			}
			// System.out.println("sum = "+sum);
		}

		long cnt = v;
		long end = 1;
		if(cnt == 1){
			sum+=v;
		}else{
			sum += ((v + end) * (cnt / 2) + (v + end) / 2 * (cnt % 2));
		}

		return sum;

	}

}
