package algo_202406;

import java.io.*;
import java.util.*;

public class BJ_20665_독서실거리두기 {
	public static int N,T,P;
	public static int[][] seat;

	// 9시 = 540
	// 21시 = 1260
	// 0~12시 -> 0 , 720
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		seat = new int[N+1][720];
		// for (int i = 0; i < 720; i++) {
		// 	seat[P][i] = -1;
		// }

		// int[] = {시작 시간, 끝나는 시간, 이용 시간}
		Queue<int[]> pq = new PriorityQueue<>((o1,o2)->{
			if (o1[0] == o2[0]) {
				return o1[2]-o2[2];
			}
			return o1[0]-o2[0];
		});

		int defaultTime = 540;

		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a == b)continue;

			int start = (a/100)*60 + (a%100) - defaultTime;
			int end = (b/100)*60 + (b%100) - defaultTime;

			pq.offer(new int[] {start, end, end - start});
		}

		int index = 1;
		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			// boolean flag = false;
			// if (seat[1][now[0]] == 0) { // 1번 자리 앉을 수 있는 경우
			// 	for (int i = now[0]; i < now[1]; i++) {
			// 		seat[1][i] = index;
			// 	}
			// 	flag = true;
			// } else if (seat[1][now[0]] != 0) {
			//
			// }
			int target = 0;

			int max = 0;
			int count = 0;
			for (int i = 1; i <= N; i++) {
				if(seat[i][now[0]] != 0) continue;

				int left = i-1;
				int right = i+1;

				while (left >= 1) {
					if (seat[left][now[0]] != 0) {
						break;
					}
					left--;
				}
				if (left == 0) {
					left = Integer.MAX_VALUE;
				} else {
					left = i-left;
				}

				while (right <= N) {
					if (seat[right][now[0]] != 0) {
						break;
					}
					right++;
				}
				if (right == N + 1) {
					right = Integer.MAX_VALUE;
				} else {
					right -= i;
				}

				int min = Math.min(left, right);
				if (min > max) {
					max = min;
					target = i;
					// flag = true;
				}
			}



			for (int i = now[0]; i < now[1]; i++) {
				seat[target][i] = index;
			}
			// if(!flag){ // 가장 먼 좌석 중 번호가 가장 작은 자리
			// 	int target = N;
			// 	for (int i = N; i > 0; i--) {
			// 		if (seat[i][now[0]] <= 0) {
			// 			target = i;
			// 			break;
			// 		}
			// 	}
			//
			// 	for (int i = now[0]; i < now[1]; i++) {
			// 		seat[target][i] = index;
			// 	}
			// }

			index++;
		}

		int result = 0;
		for (int i = 0; i < 720; i++) {
			if (seat[P][i] == 0) {
				result++;
			}
		}

		// StringBuilder sb = new StringBuilder();
		// for (int i = 1; i <= N; i++) {
		// 	for (int j = 600; j < 720; j++) {
		// 		sb.append(seat[i][j] ).append(" ");
		// 	}
		// 	sb.append("\n");
		// }
		// System.out.println(sb);
		System.out.println(result);
	}
}
