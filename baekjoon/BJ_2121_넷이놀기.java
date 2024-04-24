package algo_202404;

import java.io.*;
import java.util.*;

public class BJ_2121_넷이놀기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int[] dx = {A,0,A};
		int[] dy = {0,B,B};

		// Map<String, Point> map = new HashMap<>();
		Set<Point> set = new HashSet<>(N);

		int a = 0;
		int b = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			set.add(new Point(a,b));
		}

		int count = 0;

		for (Point p : set) {
			// System.out.println(p);
			boolean flag = true;
			for (int d = 0; d < 3; d++) {
				int nx = p.x+dx[d];
				int ny = p.y+dy[d];
				// System.out.println("nx = "+ nx + ", ny = "+ny);
				Point next = new Point(nx,ny);
				if (!set.contains(next)) {
					flag = false;
					break;
				}
			}
			if(flag){
				count++;
			}
		}

		System.out.println(count);
	}
	public static class Point{
		int x,y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			int temp = 1_000_007;
			temp = temp*31 + x;
			return temp*31 + y;
		}

		@Override
		public boolean equals(Object o) {
			Point p = (Point)o;
			return (this.x == p.x && this.y == p.y);
		}

		@Override
		public String toString() {
			return "x = "+ x + ", y = "+y;
		}
	}
}
