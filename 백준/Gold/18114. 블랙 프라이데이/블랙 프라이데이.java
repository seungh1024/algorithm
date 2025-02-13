import java.io.*;
import java.util.*;

public class Main {
	public static int N, C;
	public static int[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		data = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(data);

		boolean result = false;
		for (int i = 0; i < N && !result; i++) {
			if (data[i] == C) {
				result = true;
				break;
			}
			for (int j = i + 1; j < N; j++) {
				if (data[i] + data[j] < C) {
					if (j + 1 < N) {
						result |= binarySearch(j+1,C - (data[i] + data[j]));
					}
				} else if (data[i] + data[j] == C) {
					result = true;
					break;
				}
			}
		}

		if (result) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}

	}

	public static boolean binarySearch(int start, int target) {
		int end = N-1;

		while (start < end) {
			int mid = (start + end) / 2;
			int value = data[mid];

			if (value >= target) {
				end = mid;
			} else {
				start = mid+1;
			}
		}

		if (data[start] == target) {
			return true;
		}

		return false;
	}
}