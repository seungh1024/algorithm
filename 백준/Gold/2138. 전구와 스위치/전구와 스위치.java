import java.io.*;
import java.util.*;

public class Main {
	public static int N;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		char[] input1 = br.readLine().toCharArray();
		char[] input2 = br.readLine().toCharArray();

		boolean[] start = new boolean[N];
		boolean[] end = new boolean[N];

		for (int i = 0; i < N; i++) {
			if (input1[i] == '1') {
				start[i] = true;
			}
			if (input2[i] == '1') {
				end[i] = true;
			}
		}

		boolean[] first = new boolean[N];
		for (int i = 0; i < N; i++) {
			first[i] = start[i];
		}

		first[0] = !first[0];
		first[1] = !first[1];
		// System.out.println(Arrays.toString(first));
		int count = 1;
		for (int i = 1; i < N; i++) {
			if(first[i-1] != end[i-1]) {
				count++;
				for (int j = i - 1; j <= i + 1 && j < N; j++) {
					first[j] = !first[j];
				}
				// System.out.println(Arrays.toString(first));
			}
		}

		// System.out.println(count);
		// System.out.println(Arrays.toString(first));
		// System.out.println(Arrays.toString(end));
		int result = -1;
		if (Arrays.equals(first, end)) {
			result = count;
		}

		count = 0;
		for (int i = 1; i < N; i++) {
			if (start[i - 1] != end[i - 1]) {
				count++;
				for (int j = i - 1; j <= i + 1 && j < N; j++) {
					start[j] = !start[j];
				}
			}
		}

		if (Arrays.equals(start, end)) {
			result = count;
		}

		System.out.println(result);

	}

}