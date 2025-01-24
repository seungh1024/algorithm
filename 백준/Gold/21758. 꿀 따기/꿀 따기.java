import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[] data;
	public static int[] sum;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N+1];
		sum = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
			sum[i] = data[i] + sum[i-1];
		}

		// System.out.println(Arrays.toString(sum));
		int result = 0;
		int temp = sum[N] - sum[1];
		for (int i = 2; i < N; i++) {
			int value = temp - data[i] + sum[N] - sum[i];
			result = Math.max(result,value);
		}

		temp = sum[N-1] - sum[0];
		for (int i = N - 1; i > 0; i--) {
			int value = temp - data[i] + sum[i-1] - sum[0];
			// System.out.println("i = "+i +", value = "+value);
			result = Math.max(result, value);
		}

		for (int i = 1; i < N; i++) {
			int value = sum[i] - sum[1] + sum[N-1] - sum[i-1];
			result = Math.max(result,value);
		}

		System.out.println(result);
	}
}