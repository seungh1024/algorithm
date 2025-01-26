import java.io.*;
import java.util.*;

public class Main {
	public static int S, N, K, R1,R2,C1, C2;
	public static int[] dx = {0, 0, 0, 1, -1, 1, -1, 1, -1};
	public static int[] dy = {0, 1, -1, 0, 0, 1, 1, -1, -1};
	public static int[][] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		R1 = Integer.parseInt(st.nextToken());
		R2 = Integer.parseInt(st.nextToken());
		C1 = Integer.parseInt(st.nextToken());
		C2 = Integer.parseInt(st.nextToken());

		if (S == 0) {
			StringBuilder sb = new StringBuilder();
			for (int i = R1; i <= R2; i++) {
				for (int j = C1; j <= C2; j++) {
					sb.append(0);
				}
				sb.append("\n");
			}
			System.out.println(sb);
		} else {
			data = new int[R2 - R1 + 1][C2 - C1 + 1];
			long size = 1;
			for (long i = 0; i < S; i++) {
				size *= N;
			}
			run(0, 0, 0, size, 0);

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i <= R2 - R1; i++) {
				for (int j = 0; j <= C2 - C1; j++) {
					sb.append(data[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
		}


	}

	public static void run(long x, long y, int time, long size, int color) {
		if(x > R2 || y > C2) return;
		if(x+size <= R1 || y+size <= C1) return;
		if (time == S) {
			data[(int)(x-R1)][(int)(y-C1)] = color;
			return;
		}

		long div = size / N;
		long left = (N - K) / 2;
		long right = left + K - 1;
		for (int i = 0; i < N; i++) {
			long nx = x + div * i;
			for (int j = 0; j < N; j++) {
				long ny = y + div * j;
				int nextColor = color;
				if (nextColor == 0 && i >= left && i <= right && j >= left && j <= right) {
					nextColor = 1;
				}
				run(nx,ny,time+1,div,nextColor);
			}
		}

	}
}