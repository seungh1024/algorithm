import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static char[] data;
	public static String result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new char[N];
		// StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = br.readLine().charAt(0);
			// data[i] = st.nextToken().charAt(0);

		}
		// System.out.println(Arrays.toString(data));

		int left = 0;
		int right = N-1;
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		while (left <= right) {
			if (data[left] < data[right]) {
				sb.append(data[left]);
				left++;
			} else if (data[left] > data[right]) {
				sb.append(data[right]);
				right--;
			} else {

				int l = left+1;
				int r = right - 1;

				boolean flag = false;
				while (l <= r) {
					if (data[l] < data[r]) {
						sb.append(data[left]);
						left++;
						flag = true;
						break;
					} else if (data[l] > data[r]) {
						sb.append(data[right]);
						right--;
						flag = true;
						break;
					} else {
						l++;
						r--;
					}
				}
				if (!flag) {
					sb.append(data[left]);
					left++;
				}
			}
			cnt++;
			if (cnt % 80 == 0) {
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}

	public static char find(int idx, int limit, int move) {
		char now = data[idx];
		while (idx != limit && data[idx] == now) {
			idx += move;
		}

		return data[idx];
	}


}