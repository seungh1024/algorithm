package algo_202409;

import java.io.*;
import java.util.*;

public class BJ_12931_두배더하기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] data = new int[N];
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		int result = 0;
		while (true) {

			int count = 0;
			int divideCount = 0;
			int numCount = 0;
			for (int i = 0; i < N; i++) {
				if (data[i] > 0 && data[i] % 2 == 0) {
					divideCount++;
				}
				if (data[i] > 0) {
					numCount++;
				}
			}
			// System.out.println(divideCount);
			// System.out.println(numCount);
			// System.out.println(Arrays.toString(data));
			if (divideCount == numCount && numCount != 0) {
				result++;
				for (int i = 0; i < N; i++) {
					data[i] /= 2;
				}
			}
			else{
				for (int i = 0; i < N; i++) {
					if(data[i] %2 == 1){
						result++;
						data[i]--;
					}
				}
			}

			for (int i = 0; i < N; i++) {
				if (data[i] == 0) {
					count++;
				}
			}
			if (count == N) {
				break;
			}
		}

		System.out.println(result);
	}
}
