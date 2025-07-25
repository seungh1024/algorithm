

import java.io.*;
import java.util.*;

public class Main {
	public static int[] number = new int[10];
	public static int result = 0;
	public static int[] data;
	public static int[] score;
	public static boolean[] visited;
	public static int[] now;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 10; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}

		data = new int[200];
		score = new int[34];
		for (int i = 0; i < 21; i++) {
			data[i] = i+1;
			score[i] = i*2;
		}
		// 21이 도착
		data[21] = 21;
		for (int i = 22; i < 27; i++) {
			data[i] = i+1;
		}
		// data[5] = 22;
		data[50] = 22;
		data[27] = 20;
		// data[10] = 28;
		data[100] = 28;
		data[28] = 29;
		data[29] = 25;
		// data[15] = 30;
		data[150] = 30;
		data[30] = 31;
		data[31] = 32;
		data[32] = 25;

		int num = 13;
		for (int i = 22; i < 25; i++) {
			score[i] = num;
			num+=3;
		}
		num = 28;
		for (int i = 30; i < 33; i++) {
			score[i] = num;
			num--;
		}
		num = 22;
		for (int i = 28; i < 30; i++) {
			score[i] = num;
			num+=2;
		}
		num = 25;
		for (int i = 25; i <= 27; i++) {
			score[i] = num;
			num += 5;
		}

		visited = new boolean[34];
		now = new int[4];
		find(0, 0);
		System.out.println(result);
	}

	public static void find(int idx, int sum) {
		if (idx == 10) {
			result = Math.max(result, sum);
			return;
		}


		for (int i = 0; i < 4; i++) {
			int plus = number[idx];
			int nowIdx = now[i];
			int next = now[i];

			if (next <= 15 && next % 5 == 0) {
				next *= 10;
			}
			while (plus-- > 0) {
				next = data[next];
			}

			if(next != 21 && visited[next]) continue;
			// System.out.println("i = "+i + ", nowIdx = "+nowIdx+ ", next = "+next + ", plus = "+plus);
			now[i] = next;
			visited[nowIdx] = false;
			visited[next] = true;
			find(idx + 1, sum + score[next]);

			visited[next] = false;
			visited[nowIdx] = true;
			now[i] = nowIdx;
		}
	}
}
