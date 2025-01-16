package algo_202501;

import java.io.*;
import java.util.*;

public class BJ_21315_카드섞기 {
	public static int N;
	public static int[] data;
	public static int[] start;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		data = new int[N];
		start = new int[N];
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
			start[i] = i + 1;
		}

		for (int i = 1; Math.pow(2, i) < N; i++) {
			for (int j = 1; Math.pow(2, j) < N; j++) {
				int[] clone = getCopy();
				find(i,clone);
				find(j,clone);
				if (check(clone)) {
					System.out.println(i + " " + j);
					return;
				}
			}
		}

	}

	public static boolean check(int[] arr) {
		for (int i = 0; i < N; i++) {
			if (data[i] != arr[i]) {
				return false;
			}
		}

		return true;
	}

	public static void find(int k, int[] arr) {
		int range = N;

		for (int i = k; i >= 0 ; i--) {
			int pow = (int)Math.pow(2, i);
			int count = range - pow;
			swap(range, count, arr);
			// System.out.println(Arrays.toString(arr));
			range = pow;
			// System.out.println("range=  "+range + ", pow = "+pow +", count = "+count);
		}
	}

	public static void swap(int range, int count, int[] arr) {
		// System.out.println("rnage = "+range);
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();

		for (int i = 0; i < count; i++) {
			left.add(arr[i]);
		}

		for (int i = count; i < range; i++) {
			right.add(arr[i]);
		}

		int idx = 0;
		for (int r : right) {
			arr[idx++] = r;
		}

		for (int l : left) {
			arr[idx++] = l;
		}
	}

	private static int[] getCopy() {
		int[] copy = new int[N];
		for (int i = 0; i < N; i++) {
			copy[i] = start[i];
		}
		return copy;
	}
}
