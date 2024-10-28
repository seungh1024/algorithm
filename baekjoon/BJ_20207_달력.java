package algo_202410;

import java.io.*;
import java.util.*;

public class BJ_20207_달력 {
	public static int N;
	public static int[] data;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[368];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			data[start]++;
			data[end+1]--;
		}

		for (int i = 1; i < 367; i++) {
			data[i] = data[i]+data[i-1];
		}

		// System.out.println(Arrays.toString(data));

		int result = 0;
		int count = 0;
		for (int i = 1; i < 368; i++) {
			if (data[i] > 0) {
				count++;
				data[i] = Math.max(data[i], data[i - 1]);
			} else {
				// System.out.println("count = "+count +", max = "+data[i-1]);
				result += count*data[i-1];
				count = 0;
			}
		}

		System.out.println(result);
	}
}
