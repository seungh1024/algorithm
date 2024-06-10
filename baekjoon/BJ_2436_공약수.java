package algo_202406;

import java.io.*;
import java.util.*;

public class BJ_2436_공약수 {
	public static int N, M;
	public static boolean[] visited;
	public static List<Integer> list;
	public static int min,l, r;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		M /= N;
		int total = M;

		list = new ArrayList<>();
		for (int i = 2; i <= M; i++) {
			int num = 1;
			while (M % i == 0) {
				num *= i;
				M/=i;
			}
			if (num != 1) {
				list.add(num);
			}
		}
		// System.out.println(list);

		int size = list.size();
		visited = new boolean[size];
		min = Integer.MAX_VALUE;
		l = 0;
		r = 0;
		find(0,size);
		// System.out.println("l = " + l +", r = "+r);
		List<Integer> result = new ArrayList<>(List.of(l * N, r * N));
		// System.out.println(result);
		result.sort(Comparator.naturalOrder());
		result.stream().forEach(i -> System.out.print(i + " "));
	}

	public static void find(int index, int size) {

		int left = 1;
		int right = 1;
		for (int i = 0; i < size; i++) {
			if (visited[i]) {
				left *= list.get(i);
			} else {
				right *= list.get(i);
			}
		}

		if (left + right < min) {
			min = left+right;
			l = left;
			r = right;
		}

		if(index >= size){
			return;
		}

		visited[index] = true;
		find(index+1,size);
		visited[index] = false;
		find(index+1,size);
	}
}
