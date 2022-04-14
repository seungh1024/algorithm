package day0413;

import java.io.*;
import java.util.*;

public class BJ_17143_낚시왕 {

	static int R, C, M;
	static Shark[][] map;
	static Shark[][] newMap;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new Shark[R + 1][C + 1];
		int r,c,s,d,z;
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());

			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			map[r][c] = new Shark(s, d, z);

		}
		
		int result = 0;
		for (int i = 1; i <= C; i++) {
			for (int j = 1; j <= R; j++) {
				if (map[j][i] != null) {// 상어 있으면 잡아조짐
					result += map[j][i].z;
					map[j][i] = null;
					break;
				}
			}
			find();// 탐색
//			System.out.println("find");
		}
		System.out.println(result);

	}

	public static void find() {
		newMap = new Shark[R + 1][C + 1];
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (map[i][j] != null) {// 상어가 있다면
					move(map[i][j], i, j);
				}
			}
		}

		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				map[i][j] = newMap[i][j];
			}
		}
//		System.out.println("??????????????");
//		System.out.println(map[2][0]);
//		for(int i = 1; i <= R; i++) {
//			for(int j = 1; j <= C; j++) {
//				System.out.print(map[i][j] +",");
//			}
//			System.out.println();
//		}
//		System.out.println("????/????????");
	}

	public static void move(Shark shark, int x, int y) {
		int s = shark.s;
		int d = shark.d;
		int z = shark.z;

		switch (d) {
		case 1: // 위
			if (x > s) { // 튕겨서 반대로 가지 않는 경우
				x -= s;
			} else {
				s -= (x - 1);
				if ((s / (R - 1)) % 2 == 1) {// 홀수인 경우 -> 방향전환 X
					x = R - (s % (R - 1));
				} else {// 짝수 -> 방향전환
					d = 2;
					x = s % (R - 1)+1;
				}
			}
			break;
		case 2: // 아래
			if ((R - x) >= s) {
				x += s;
			} else {
				s -= (R - x);
				if ((s / (R - 1)) % 2 == 1) {
					x = s % (R - 1)+1;
				} else {
					d = 1;
					x = R - (s % (R - 1));
				}
			}
			break;
		case 3:// 오른쪽
			if ((C - y) >= s) {
				y += s;
			} else {
				s -= (C - y);
				if ((s / (C - 1)) % 2 == 1) {
					y = s % (C - 1)+1;
				} else {
					d = 4;
					y = C - (s % (C - 1));
				}
			}
			break;
		case 4:// 왼쪽
			if (y > s) {
				y -= s;
			} else {
				s -= (y - 1);
				if(z == 3) {
				}
				if ((s / (C - 1)) % 2 == 1) {
					y = C - (s % (C - 1));
				} else {
					d = 3;
					y = s % (C - 1)+1;
				}
			}
			break;
		}

		
		if (newMap[x][y] != null && z > newMap[x][y].z) {// 비었거나 클 때만 넣음
			newMap[x][y] = new Shark(shark.s, d, z);
		}else if(newMap[x][y] == null) {
			newMap[x][y] = new Shark(shark.s,d,z);
		}


	}

	public static class Shark {
		int s; // 속력
		int d; // 방향
		int z; // 크기

		public Shark() {
		};

		public Shark(int s, int d, int z) {
			super();
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public String toString() {
			return "Shark [s=" + s + ", d=" + d + ", z=" + z + "]";
		}
		
	}
}
