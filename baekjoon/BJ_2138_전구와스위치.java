package algo_202401;

import java.io.*;
import java.util.*;

public class BJ_2138_전구와스위치 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] data1 = br.readLine().toCharArray();
		char[] data2 = br.readLine().toCharArray();

		int[] origin = new int[N];
		int[] changed = new int[N];

		for (int i = 0; i < N; i++) {
			origin[i] = data1[i]-'0';
			changed[i] = data2[i] -'0';
		}

		int result = -1;

		int[] on = new int[N];
		for (int i = 0; i < N; i++) {
			on[i] = origin[i];
		}

		// 0번 누른 경우
		on[0] = 1-on[0];
		on[1] = 1-on[1];
		int count = 1;
		for (int i = 1; i < N; i++) {
			if(on[i-1] != changed[i-1]){
				for (int j = i - 1; j <= i + 1; j++) {
					if (j >= 0 && j < N) {
						on[j] = 1-on[j];
					}
				}
				count++;
			}
		}
		if (Arrays.equals(on, changed)) {
			if (result == -1) {
				result = count;
			} else {
				result = Math.min(result,count);
			}
		}

		count = 0;
		for (int i = 1; i < N; i++) {
			if(origin[i-1] != changed[i-1]){
				for (int j = i - 1; j <= i + 1; j++) {
					if (j >= 0 && j < N) {
						origin[j] = 1-origin[j];
					}
				}
				count++;
			}
		}
		if (Arrays.equals(origin, changed)) {
			if (result == -1) {
				result = count;
			} else {
				result = Math.min(result,count);
			}
		}

		System.out.println(result);

	}
}
