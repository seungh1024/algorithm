package algo_202404;

import java.io.*;
import java.util.*;

public class BJ_1025_제곱수찾기 {
	public static int N,M;
	public static char[][] data;
	public static List<int[]> list;
	public static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new char[N][M];

		result = -1;
		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				data[i][j] = input[j];
				int num = input[j]-'0';
				double sqrt = Math.sqrt(num);
				int value = (int)sqrt;
				if (value * value == num) {
					result = Math.max(result,num);
				}
			}
		}

		int range = Math.max(N,M);
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(i == 0 && j == 0) continue;
				list.add(new int[]{i,j});
				list.add(new int[]{-i,j});
				list.add(new int[]{-i,-j});
				list.add(new int[]{i,-j});
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				find(i,j);
			}
		}

		System.out.println(result);
	}

	public static void find(int x, int y) {

		for (int[] l : list) {
			// System.out.println(Arrays.toString(l));
			List<Character> numbers = new ArrayList<>();
			numbers.add(data[x][y]);
			int nx = x;
			int ny = y;
			while(true){
				nx = nx + l[0];
				ny = ny + l[1];
				if (nx >= 0 && nx < N &&  ny >= 0 && ny < M) {
					numbers.add(data[nx][ny]);
				} else {
					break;
				}
			}
			StringBuilder sb = new StringBuilder();
			int length = numbers.size();
			for (int i = 0; i < length; i++) {
				sb.append(numbers.get(i));
				int num = Integer.parseInt(sb.toString());
				double sqrt = Math.sqrt(num);
				int value = (int)sqrt;
				if (value * value == num) {
					result = Math.max(result,num);
				}
			}

			sb = new StringBuilder();
			for (int i = length - 1; i >= 0; i--) {
				sb.append(numbers.get(i));
				int num = Integer.parseInt(sb.toString());
				double sqrt = Math.sqrt(num);
				int value = (int)sqrt;
				if (value * value == num) {
					result = Math.max(result,num);
				}
			}
		}
	}

}
