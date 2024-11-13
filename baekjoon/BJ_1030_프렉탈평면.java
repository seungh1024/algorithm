package algo_202411;

import java.io.*;
import java.util.*;

public class BJ_1030_프렉탈평면 {
	public static int s,N,K,R1,R2,C1, C2;
	public static int[] dx = {0, 0, 0, 1, -1, 1, -1, 1, -1};
	public static int[] dy = {0, 1, -1, 0, 0, 1, 1, -1, -1};
	public static int[][] result;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		R1 = Integer.parseInt(st.nextToken());
		R2 = Integer.parseInt(st.nextToken());
		C1 = Integer.parseInt(st.nextToken());
		C2 = Integer.parseInt(st.nextToken());

		if (s == 0) {
			StringBuilder sb = new StringBuilder();
			for (int i = R1; i <= R2; i++) {
				for (int j = C1; j <= C2; j++) {
					sb.append(0);
				}
				sb.append("\n");
			}
			System.out.println(sb);
		} else {
			result = new int[R2-R1+1][C2-C1+1];
			long size = 1;
			for (long i = 0; i < s; i++) {
				size *= N;
			}
			find(0,0,0,size,0);

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < R2 - R1 + 1; i++) {
				for(int j = 0; j < C2 - C1 + 1; j++) {
					sb.append(result[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
		}

	}

	/**
	 *
	 * @param x 중심 좌표
	 * @param y 중심 좌표
	 * @param time 현재 지나간 시간
	 * @param size 현재 정사각형의 한 변 크기
	 */
	public static void find(long x, long y, int time, long size, int fill) {
		if(x > R2 || y > C2) return;
		if(y+size <= C1 || x + size <= R1) return;
		if (time == s) {
			// System.out.println("x = "+ x +", y = "+y + ", size = "+size);
			result[(int)(x-R1)][(int)(y-C1)] = fill;
			return;
		}

		long div = size / N;
		long left = (N-K)/2;
		long right = left+K-1;
		for (int i = 0; i < N; i++) {
			long nx = x+div*i;
			for (int j = 0; j < N; j++) {
				long ny = y+div*j;
				int nextFill = fill;
				if (nextFill == 0 && i >= left && i <= right && j >= left && j <= right) {
					nextFill = 1;
				}
				find(nx, ny, time+1,div, nextFill);
			}
		}

	}
}
