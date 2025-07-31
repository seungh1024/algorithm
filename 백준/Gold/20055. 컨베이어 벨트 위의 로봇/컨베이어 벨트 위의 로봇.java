

import java.io.*;
import java.util.*;

public class Main {
	public static int N, K;
	public static int[] belt;
	public static boolean[] robot;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		belt = new int[2 * N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2 * N; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}
		robot = new boolean[N];

		int result = 0;
		do {
			result++;
			spin();
			robotMove();
			addRobot();
			// System.out.println("round = "+result);
			// System.out.println("belt = " + Arrays.toString(belt));
			// System.out.println("robot = " + Arrays.toString(robot));
		} while (isEnd());
		System.out.println(result);
	}
	public static boolean isEnd() {
		int cnt = 0;
		for (int i = 0; i < 2 * N; i++) {
			if (belt[i] == 0) {
				cnt++;
			}
		}
		if (cnt >= K) {
			return false;
		}
		return true;
	}

	public static void addRobot() {
		if (belt[0] > 0) {
			belt[0]--;
			robot[0] = true;
		}
	}
	public static void robotMove() {
		for (int i = N-2; i >=0; i--) {
			if(!robot[i] || robot[i+1] || belt[i+1] <= 0) continue;
			robot[i] = false;
			robot[i+1] = true;
			belt[i+1]--;
			// System.out.println("i = "+i);
		}
		// System.out.println("after robot move = "+Arrays.toString(robot));
	}

	public static void spin() {
		int[] copy = new int[2 * N];
		int temp = belt[2 * N - 1];
		for (int i = 1; i < 2*N; i++) {
			copy[i] = belt[i - 1];
		}
		copy[0] = temp;
		for (int i = 0; i < 2 * N; i++) {
			belt[i] = copy[i];
		}

		for (int i = N - 2; i >= 0; i--) {
			robot[i + 1] = robot[i];
		}
		robot[0] = false;
		robot[N-1] = false;
	}
}
