package algo_202410;

import java.io.*;
import java.util.*;

public class BJ_1493_박스채우기 {
	public static int N;
	public static int L,W, H;
	public static List<int[]> list;
	public static long result;
	public static boolean flag = false;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		N = Integer.parseInt(br.readLine());
		// map = new TreeMap<>(Comparator.reverseOrder());
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int length = 1<<A;
			int cnt = Integer.parseInt(st.nextToken());
			list.add(new int[] {length, cnt});
			// map.put(length, cnt);
		}

		list.sort(Comparator.comparing(arr -> -arr[0]));
		result = 0;
		find(L, W, H);
		if (flag) {
			result = -1;
		}

		System.out.println(result);
	}

	public static void find(int x, int y, int z) {
		if (x <= 0 || y <= 0 || z <= 0) {
			return;
		}

		boolean check = false;
		int length = 0;
		int cnt = 0;
		int min = Math.min(x, Math.min(y, z));
		for (int i = 0; i < N; i++) {
			int[] arr = list.get(i);
			length = arr[0];
			cnt = arr[1];

			if(cnt == 0 || min < length) continue;

			check = true;
			arr[1]--;
			result++;
			find(x - length, y, z);
			find(length, y - length, z);
			find(length, length, z - length);

			break;
		}

		if (!check) {
			flag = true;
		}

	}


}
