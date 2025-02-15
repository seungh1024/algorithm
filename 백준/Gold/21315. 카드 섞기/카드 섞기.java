import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[] data;
	public static int[] copy;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(st.nextToken());
			data[i] = input;
		}

		for (int i = 1; i < 10 && Math.pow(2, i) < N; i++) {
			copy = new int[N];
			for (int j = 1; j <= N; j++) {
				copy[j-1] = j;
			}
			// System.out.println("first====");
			find(N - 1, i);

			int[] arr = new int[N];
			for (int j = 0; j < N; j++) {
				arr[j] = copy[j];
			}
			for (int j = 1; j < 10 && Math.pow(2, j) < N; j++) {
				// System.out.println("second ====");
				find(N - 1, j);
				if (Arrays.equals(copy, data)) {
					System.out.println(i + " " + j);
					return;
				}

				for (int k = 0; k < N; k++) {
					copy[k] = arr[k];
				}
			}

		}
	}

	public static void find(int to, int k) {
		// System.out.println("to = "+to +", k = "+k);
		// System.out.println(Arrays.toString(copy));
		if (k == -1) {
			return;
		}
		int[] arr = new int[N];
		int pow = (int)Math.pow(2, k);
		// System.out.println("pow = "+pow);
		int idx = 0;
		for (int i = to-pow+1; i <= to; i++) {
			arr[idx++] = copy[i];
		}
		for (int i = 0; i <= to - pow; i++) {
			arr[idx++] = copy[i];
		}
		for (int i = idx; i < N; i++) {
			arr[i] = copy[i];
		}
		for (int i = 0; i < N; i++) {
			copy[i] = arr[i];
		}

		find(pow - 1, k - 1);
	}


}