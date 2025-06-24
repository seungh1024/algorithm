
import java.io.*;
import java.util.*;

public class Main {
	public static int[][][] data;
	public static boolean[] visited;
	public static int[] indexes;
	public static int cnt = 0;
	public static int[] dx = {0, 0, 1, -1, 0, 0};
	public static int[] dy = {1, -1, 0, 0, 0, 0};
	public static int[] dz = {0, 0, 0, 0, -1, 1};
	public static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		data = new int[5][5][5]; // h, x, y
		for (int k = 0; k < 5; k++) {
			for (int i = 0; i < 5; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 5; j++) {
					data[k][i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}

		visited = new boolean[5];
		indexes = new int[5];
		per(5, 0);

		if(result == Integer.MAX_VALUE){
			result = -1;
		}
		System.out.println(result);
	}

	public static void per(int n, int idx){
		if (idx == 5) {
			int[][][] copy = getCopy();
			for (int a = 0; a < 4; a++) {
				for (int b = 0; b < 4; b++) {
					for (int c = 0; c < 4; c++) {
						for (int d = 0; d < 4; d++) {
							for (int e = 0; e < 4; e++) {
								if (copy[0][0][0] == 1 && copy[4][4][4] == 1) {
									int cnt = find(copy);
									if (cnt != Integer.MAX_VALUE) {
										// printData(copy);
										// System.out.println("cnt = "+cnt);

									}
									result = Math.min(result, cnt);
								}
								spin(4,copy);
							}
							spin(3,copy);
						}
						spin(2,copy);
					}
					spin(1,copy);
				}
				spin(0,copy);
			}
			return;
		}

		for (int i = 0; i < 5; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			indexes[idx] = i;
			per(n,idx+1);
			visited[i] = false;
		}

	}

	private static void printData(int[][][] copy) {
		System.out.println("========== print data ===========");
		for (int k = 0; k < 5; k++) {
			for (int i = 0; i < 5; i++) {
				System.out.println(Arrays.toString(copy[k][i]));
			}
		}
	}

	private static int find(int[][][] copy) {
		boolean[][][] visited = new boolean[5][5][5];
		visited[0][0][0] = true;
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0, 0, 0});

		int cnt = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			if (visited[4][4][4]) {
				return cnt;
			}
			cnt++;
			for (int s = 0; s < size; s++) {

				int[] now = q.poll();

				for (int d = 0; d < 6; d++) {
					int nz = now[0] + dz[d];
					int nx = now[1] + dx[d];
					int ny = now[2] + dy[d];

					if (isRange(nz,nx,ny) && !visited[nz][nx][ny] && copy[nz][nx][ny] == 1) {
						visited[nz][nx][ny] = true;
						q.offer(new int[] {nz, nx, ny});
					}
				}
			}
		}



		return Integer.MAX_VALUE;
	}

	private static boolean isRange(int nz, int nx, int ny) {
		if (nz >= 0 && nz < 5 && nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
			return true;
		}
		return false;
	}

	// x,y -> y,(4-x)
	private static void spin(int k, int[][][] copy) {
		int[][] layer = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				layer[i][j] = copy[k][i][j];
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				copy[k][j][4-i] = layer[i][j];
			}
		}
	}



	private static int[][][] getCopy() {
		int[][][] copy = new int[5][5][5];
		for (int k = 0; k < 5; k++) {
			int z = indexes[k];
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					copy[k][i][j] = data[z][i][j];
				}
			}
		}

		return copy;
	}
}
