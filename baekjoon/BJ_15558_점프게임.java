package algo_202405;

import java.io.*;
import java.util.*;

public class BJ_15558_점프게임 {
	public static int N,K;
	public static char[] leftInput;
	public static char[] rightInput;
	public static char[][] data;
	public static boolean[][] check;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());


		leftInput = br.readLine().toCharArray();
		rightInput = br.readLine().toCharArray();

		data = new char[2][N];
		data[0] = leftInput;
		data[1] = rightInput;

		check = new boolean[2][N];
		find();
		// check[0][0] = true;
		// check[0][0] = true;

		// boolean result = find(0, 0,0);
		// if (result) {
		// 	System.out.println(1);
		// } else {
		// 	System.out.println(0);
		// }

		// System.out.println(Arrays.toString(check[0]));
		// System.out.println(Arrays.toString(check[1]));

	}
	public static void find() {
		Queue<Data> pq = new PriorityQueue<>();
		pq.offer(new Data(0, 0, 0));

		int result = 0;
		int totalTime = 0;
		while (!pq.isEmpty()) {
			int size = pq.size();

			for (int s = 0; s < size; s++) {
				Data now = pq.poll();

				if(now.index < totalTime) continue;
				if (now.index + K >= N || now.index + 1 >= N) {
					result = 1;
					break;
				}
				if(check[now.inputIndex][now.index]) continue;
				check[now.inputIndex][now.index] = true;
				// System.out.println(now);

				if (now.index + K < N && data[(now.inputIndex+1)%2][now.index + K] == '1') {
					pq.offer(new Data(now.index+K,(now.inputIndex+1)%2, now.time+1));
				}
				if (now.index + 1 < N && data[now.inputIndex][now.index + 1] == '1') {
					pq.offer(new Data(now.index+1,now.inputIndex,now.time+1));
				}
				if (now.index - 1 >= 0 && data[now.inputIndex][now.index - 1] == '1') {
					pq.offer(new Data(now.index-1, now.inputIndex, now.time+1));
				}
			}
			totalTime++;
		}

		System.out.println(result);
	}

	// public static boolean find(int index, int inputIndex, int time) {
	// 	if(index < time) return false;
	//
	// 	if (index + K >= N || index + 1 >= N) {
	// 		return true;
	// 	}
	//
	// 	if (check[inputIndex][index] >= time) {
	// 		return false;
	// 	}
	//
	// 	check[inputIndex][index] = time;
	//
	// 	if (index + K < N && data[(inputIndex+1)%2][index + K] == '1') {
	// 		if (find(index + K, (inputIndex + 1) % 2, time + 1)) {
	// 			return true;
	// 		}
	// 	}
	// 	if (index + 1 < N && data[inputIndex][index + 1] == '1') {
	// 		if (find(index + 1, inputIndex,time+1)) {
	// 			return true;
	// 		}
	// 	}
	// 	if (index - 1 >= 0 && data[inputIndex][index - 1] == '1') {
	// 		if (find(index - 1, inputIndex, time+1)) {
	// 			return true;
	// 		}
	// 	}
	//
	// 	return false;
	// }

	public static class Data implements Comparable<Data>{
		int index;
		int inputIndex;
		int time;

		public Data(int index, int inputIndex, int time) {
			this.index = index;
			this.inputIndex = inputIndex;
			this.time = time;
		}

		@Override
		public int compareTo(Data d){
			return this.time - d.time;
		}

		@Override
		public String toString() {
			return "index = "+index + ", inputIndex = "+inputIndex +", time = "+time;
		}
	}
}
