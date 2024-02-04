package algo_202402;

import java.util.*;

public class P_리코쳇로봇 {
	public static void main(String[] args) {
		P_리코쳇로봇 test = new P_리코쳇로봇();
		String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
		int answer = test.solution(board);
		int result = 7;
		if (answer == result) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1,-1,0,0};
	public static boolean[][] visited;
	public static int N,M;
	public static char[][] data;

	public int solution(String[] board) {
		int answer = 0;
		int x = 0;
		int y = 0;
		int gx = 0;
		int gy = 0;
		N = board.length;
		M = board[0].length();
		visited= new boolean[N][M];
		data = new char[N][M];

		for(int i = 0; i < N; i++){
			char[] input = board[i].toCharArray();
			for(int j = 0; j < M; j++){
				data[i][j] = input[j];
				if(input[j] =='R'){
					x = i;
					y = j;
				}else if(input[j] == 'G'){
					gx = i;
					gy = j;
				}
			}
		}

		answer = find(x,y,gx,gy);

		return answer;
	}

	public static int find(int x, int y, int gx, int gy){
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{x,y});
		visited[x][y] = true;

		int count = 0;
		while(!q.isEmpty()){
			int size = q.size();
			count++;
			for(int s = 0; s < size; s++){
				int[] now = q.poll();
				// System.out.println("count: "+count + ", now: "+Arrays.toString(now));

				for(int d = 0; d < 4; d++){
					int nx = now[0];
					int ny = now[1];
					while(true){
						int mx = nx+dx[d];
						int my = ny+dy[d];
						if(mx <0 || mx >= N || my < 0 || my >= M || data[mx][my] =='D'){
							break;
						}
						nx = mx;
						ny = my;
					}
					if(!visited[nx][ny]){
						if(nx == gx && ny == gy){
							return count;
						}
						visited[nx][ny] = true;
						q.offer(new int[]{nx,ny});
					}
				}
			}

		}
		return -1;
	}
}
