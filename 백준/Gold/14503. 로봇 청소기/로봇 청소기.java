

import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static int[][] data;
	public static int[] dx = {-1, 0, 1, 0}; // 북, 동, 남 ,서
	public static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new int[N][M];
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int result = find(r, c, d);
		System.out.println(result);
	}

	public static int find(int r, int c, int dd) {
		Queue<Bot> q = new ArrayDeque<>();
		q.offer(new Bot(r, c, dd));

		int result = 0;
		while (!q.isEmpty()) {
			Bot now = q.poll();

			// 1. 현재 칸 청소
			if (data[now.x][now.y] == 0) {
				data[now.x][now.y] = -1;
				result++;
			}
			// System.out.println(now);
			// printData();

			// 2. 4칸 확인
			int cnt = 0;
			for (int d = 0; d < 4; d++) {
				int nx = now.x+dx[d];
				int ny = now.y + dy[d];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && data[nx][ny] == 0) {
					cnt++;
				}
			}
			if (cnt == 0) { // 청소되지 않은 빈 칸이 없는 경우
				int nx = now.x-dx[now.d];
				int ny = now.y-dy[now.d];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && data[nx][ny] != 1) { // 후진
					q.offer(new Bot(nx, ny, now.d));
				} else { // 멈춤
					break;
				}
			} else { // 청소되지 않은 빈 칸이 있는 경우
				now.d = (now.d + 3) % 4; // 90도 회전
				int nx = now.x + dx[now.d];
				int ny = now.y + dy[now.d];
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && data[nx][ny] == 0){ // 청소되지 않으면 전진
					q.offer(new Bot(nx,ny,now.d));
				}else{ // 아니면 방향 유지한채로 복귀
					q.offer(now);
				}
			}
		}

		return result;
	}

	public static void printData() {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(data[i]));
		}
	}

	public static class Bot{
		int x;
		int y;
		int d;

		public Bot(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Bot{" +
				"x=" + x +
				", y=" + y +
				", d=" + d +
				'}';
		}
	}
}
