

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[] data;
	public static int[] leftChild, rightChild;
	public static List<Integer> list;
	public static int left, right;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[2 * N];
		leftChild = new int[2 * N];
		rightChild = new int[2 * N];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			list.add(num);
		}


		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if (s.equals("-")) {
				data[N + i] = -1;
			} else if (s.equals("+")) {
				data[N + i] = 1;
			}
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			leftChild[N+i] = l;
			rightChild[N+i] = r;
		}

		Collections.sort(list);
		left = 0;
		right = list.size()-1;
		int result = 0;
			result = makeAllMax(2 * N - 1, 0); // 최종 더하기 계산이면 루트 기준 둘 다 최대
		if (data[2 * N - 1] == 1) {

		} else {
			// result = makeAllMax(2 * N - 1, false);
		}

		System.out.println(result);
	}

	public static int makeAllMax(int idx, int mCnt) {
		if (data[idx] == 0) {
			if (mCnt%2 == 1) {
				return list.get(left++);
			} else {
				return list.get(right--);
			}
		}
		int lc = leftChild[idx];
		int rc = rightChild[idx];



		int sum = 0;
		if (data[idx] == 1) {
			sum = makeAllMax(lc, mCnt) + makeAllMax(rc,  mCnt);
		} else if (data[idx] == -1) {
			sum = makeAllMax(lc, mCnt) - makeAllMax(rc, mCnt+1);
		}
		data[idx] = sum;
		return data[idx];
	}
}
// 5
// 10
// 20
// 30
// 40
// 50
// - 1 2
// + 8 5
// - 3 4
// - 6 7