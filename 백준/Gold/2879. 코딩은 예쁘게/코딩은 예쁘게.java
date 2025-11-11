

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] data = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		int[] tab = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			tab[i] = Integer.parseInt(st.nextToken());
		}

		int result = 0;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			int temp = tab[i]-data[i];
			if (sum == 0) {
				result += Math.abs(temp);
				sum += temp;
			} else if (sum > 0) {
				if (temp >= 0) {
					if (temp >= sum) {
						result += (temp - sum);
					} else {

					}
					sum = temp;
				} else {
					result += Math.abs(temp);
					sum = temp;
				}
			} else if (sum < 0) {
				if (temp >= 0) {
					result += temp;
					sum = temp;
				} else {
					if (temp >= sum) {
						sum = temp;
					} else {
						result += Math.abs(temp - sum);
						sum = temp;
					}
				}
			}
			// System.out.println("result = "+result + ", sum = "+sum + ", temp = "+temp);
		}

		System.out.println(result);
	}
}
