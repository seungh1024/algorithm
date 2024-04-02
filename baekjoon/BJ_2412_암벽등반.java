package algo_202403;

import java.io.*;
import java.util.*;

public class BJ_2412_암벽등반 {
	public static int n,T;
	public static Point[] point;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		point = new Point[n+1];
		point[0] = new Point(0,0);
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			point[i] = new Point(x,y);
		}
		Arrays.sort(point,(o1,o2)->{
			if (o1.y == o2.y) {
				return o1.x - o2.x;
			}
			return o1.y-o2.y;
		});
		// System.out.println(Arrays.toString(point));

		int result = find();
		System.out.println(result);
	}

	public static int find() {
		boolean[] visited=  new boolean[n+1];
		visited[0] = true;
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(0);

		int result = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				int now = q.poll();
				// System.out.println(now);
				if (point[now].y == T) {
					return result;
				}

				for (int i = now-1; i > 0; i--) {
					if(visited[i]) continue;
					Point next = point[i];
					if(next.y - point[now].y > 2) break;
					if (Math.abs(point[now].x - next.x) <= 2 && Math.abs(point[now].y - next.y) <= 2) {
						if (!visited[i]) {
							visited[i] = true;
							q.offer(i);
						}
					}
				}

				for (int i = now + 1; i <= n; i++) {
					if(visited[i]) continue;
					Point next = point[i];
					if(next.y - point[now].y > 2) break;
					if (Math.abs(point[now].x - next.x) <= 2 && Math.abs(point[now].y - next.y) <= 2) {
						if (!visited[i]) {
							visited[i] = true;
							q.offer(i);
						}
					}
				}

			}
			result++;
		}

		return -1;
	}

	public static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "[x = "+x + ", y = "+y + "]";
		}
	}

}
