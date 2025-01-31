import java.io.*;
import java.util.*;

public class Main {
	public static int N;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] data = new int[N+1];


		int[] sum1 = new int[N+1]; // 짝수 누적합
		int[] sum2 = new int[N+1]; // 홀수 누적합
		for (int i = 1; i <= N; i++) {
			sum1[i] += sum1[i - 1];
			sum2[i] += sum2[i - 1];
			data[i] = Integer.parseInt(st.nextToken());
			if (i % 2 == 1) { // 1부터 시작하니 얘가 ㅈ먼저 받는 것임
				sum1[i] +=  data[i];
			} else {
				sum2[i] +=  data[i];
			}
		}

		int result = Math.max(sum1[N], sum2[N]);
		// System.out.println(result);

		for (int i = 1; i <= N; i += 2) {
			result = Math.max(result , sum1[i-1] + sum2[N] - sum2[i]);
		}

		for (int i = 2; i <= N; i += 2) {
			result = Math.max(result, sum1[i - 1] +data[i] - data[N] + sum2[N] - sum2[i]);
		}

		System.out.println(result);


	}
}