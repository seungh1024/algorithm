import java.io.*;
import java.util.*;

public class Main {
	public static int[] data;
	public static int N;
	public static int[] shom;
	public static int maxSize;
	public static int[] check;
	public static int[] result;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		maxSize = N*2;
		shom = new int[maxSize];
		check = new int[17];
		result = new int[maxSize];
		Arrays.fill(result,17);

		Arrays.sort(data);
		find(0);

		boolean flag = false;
		for (int i = 0; i < maxSize; i++) {
			if (result[i] != 17) {
				flag = true;
				break;
			}
		}
		if (flag) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < maxSize; i++) {
				sb.append(result[i]).append(" ");
			}
			System.out.println(sb);
		}else{
			System.out.println(-1);
		}

	}

	public static void find(int index) {
		if (index >= maxSize) {
			// System.out.println(Arrays.toString(shom));
			boolean flag = false;
			for (int i = 0; i < maxSize; i++) {
				if (shom[i] < result[i]) {
					flag = true;
					break;
				} else if (shom[i] > result[i]) {
					break;
				}
			}
			if (flag) {
				for (int i = 0; i < maxSize; i++) {
					result[i] = shom[i];
				}
			}

			return;
		}

		for (int i = 0; i < N; i++) {
			if (check[data[i]] == 0) {
				shom[index] = data[i];
				// shom[index+data[i]+1] = data[i];
				check[data[i]] ++;
				find(index+1);
				check[data[i]] --;
			} else if (check[data[i]] == 1) {
				shom[index] = data[i];
				// System.out.println(Arrays.toString(shom));
				int left = 0;
				int right = index;
				for (int j = 0; j < index; j++) {
					if (shom[j] == data[i]) {
						left = j;
						break;
					}
				}
				// System.out.println("index = " +index + ", right = "+right + ", left = "+left);
				if(right-left-1 != data[i]){
					continue;
				}
				// System.out.println("success");

				check[data[i]] ++;
				find(index+1);
				check[data[i]]--;
			}
		}
	}
}