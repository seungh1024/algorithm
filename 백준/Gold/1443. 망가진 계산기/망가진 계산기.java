

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static int result = -1;
	public static int D, P;
	public static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		D = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		arr = new int[D + 1];
		int v = 1;
		for (int i = 0; i <= D; i++) {
			arr[i] = v;
			v*=10;
		}
		// System.out.println(Arrays.toString(arr));

		find(0, 1,2);
		System.out.println(result);
	}

	public static void find(int idx, int value, int mul) {
		// System.out.println(getLength(value));
		if (getLength(value) > D) {
			return;
		}
		if (idx == P) {
			result = Math.max(result, value);
			return;
		}

		for (int i = mul; i <= 9; i++) {
			find(idx + 1, value * i, i);
		}
	}

	public static int getLength(int value) {
		if (arr[D] < value) {
			return D+1;
		}
		for (int i = D; i >= 0; i--) {
			if (value >= arr[i]) {
				// System.out.println("value  = "+value + ", i = "+i +", arr[i] = "+arr[i]);
				return i + 1;
			}
		}
		return D+1;
	}

}