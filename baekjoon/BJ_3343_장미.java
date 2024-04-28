package algo_202404;

import java.io.*;
import java.util.*;

public class BJ_3343_장미 {
	public static long N,A,B,C,D;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		D = Long.parseLong(st.nextToken());

		if(A*D < B*C){ // B가 더 작은 경우 switch
			long temp = A;
			A = C;
			C = temp;
			temp = B;
			B = D;
			D = temp;
		}

		long result = Long.MAX_VALUE;
		for (int i = 0; i < A; i++) {
			long value = (long)Math.ceil((double)(N-i*C)/A);

			boolean flag = false;
			if (value < 0) {
				value = 0;
				flag = true;
			}

			result = Math.min(result, i*D + value*B);
			if(flag) break;
		}
		System.out.println(result);
	}


}
// 199 100 99 99 89
