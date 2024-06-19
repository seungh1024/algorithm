package algo_202406;

import java.io.*;
import java.util.*;

public class BJ_9934_완전이진트리 {
	public static int K;
	public static int[] data;
	public static int size;
	public static List<Integer>[] list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		size = 1;
		for (int i = 0; i < K; i++) {
			size*=2;
		}
		size--;
		data = new int[size];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < size; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		list = new ArrayList[K];
		for (int i = 0; i < K; i++) {
			list[i] = new ArrayList<>();
		}

		find(0,size/2, (size/2+1)/2);
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < K; i++) {
			for (int l : list[i]) {
				sb.append(l).append(" ");
			}
			sb.append("\n");

		}

		System.out.println(sb);
	}

	public static void find(int height, int index, int move) {
		if (height >= K || index >= size || index < 0) {
			return;
		}

		find(height+1, index-move, (move+1)/2); // 왼쪽
		find(height+1, index+move, (move+1)/2); // 오른쪽
		list[height].add(data[index]);
		// System.out.println("height = "+height +", index = "+index + ", data[index] = "+data[index]);
	}
}
