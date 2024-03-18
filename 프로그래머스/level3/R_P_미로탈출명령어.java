package algo_202403;

import java.util.*;

public class R_P_미로탈출명령어 {
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1,-1,0,0};
	public static String[] ds = {"r","l","d","u"};
	public static boolean[][][] visited;

	public String solution(int n, int m, int x, int y, int r, int c, int k) {
		String answer = "impossible";

		Queue<Data> pq = new PriorityQueue<>();
		pq.offer(new Data(x,y,0,""));
		visited = new boolean[n+1][m+1][k+1];
		visited[x][y][0] = true;

		String result = "z";
		while(!pq.isEmpty()){
			int size = pq.size();
			// System.out.println("========");
			for(int s = 0; s < size; s++){
				Data now = pq.poll();
				// System.out.println(now + ", k = "+k);

				if(now.x == r && now.y == c && now.k == k){
					return now.value;
				}

				for(int d = 0; d < 4; d++){
					int nx = now.x + dx[d];
					int ny = now.y + dy[d];
					if(nx > 0 && nx <= n && ny > 0 && ny <= m && now.k+1 <=k && !visited[nx][ny][now.k+1]){
						visited[nx][ny][now.k+1] = true;
						pq.offer(new Data(nx,ny,now.k+1,now.value+ds[d]));
					}
				}
			}
			// k--;
		}

		return answer;
	}

	public static class Data implements Comparable<Data>{
		int x;
		int y;
		int k;
		String value;

		public Data(int x, int y, int k, String value){
			this.x = x;
			this.y = y;
			this.k = k;
			this.value = value;
		}

		@Override
		public int compareTo(Data data){
			return this.value.compareTo(data.value);
		}

		@Override
		public String toString(){
			return "x = "+ x + ", y = "+ y + ", value = "+value;
		}
	}
}
