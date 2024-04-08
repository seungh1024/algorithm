package algo_202403;

import java.util.*;

public class P_자물쇠와열쇠 {
	public static int N,M;
	public static List<int[]> list; // key를 저장
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1,-1,0,0};
	public static int[][] data;
	public static boolean[][] check;
	public static int size;
	public static int hole;

	public boolean solution(int[][] key, int[][] lock) {
		boolean answer = false;
		list = new ArrayList<>();
		N = lock.length;
		M = key.length;
		size = N+M+M;
		data = new int[size][size];
		check = new boolean[size][size];
		hole = 0;
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				data[i+M][j+M] = lock[i][j];
				if(lock[i][j] == 0){
					check[i+M][j+M] = true;
					hole++;
				}
			}
		}
		for(int i = 0; i < M; i++){
			for(int j = 0; j < M; j++){
				if(key[i][j] == 1){
					list.add(new int[]{i,j});
				}
			}
		}

		for(int i = 0; i < 4; i++){
			if(i != 0){
				for(int[] l : list){
					int x = l[1];
					int y = M-l[0]-1;
					l[0] = x;
					l[1] = y;
				}
				// for(int[] l : list){
				//     System.out.println(Arrays.toString(l));
				// }
				// System.out.println("======");
			}
			answer = find();
			// System.out.println(answer);
			if(answer) break;
		}

		return answer;
	}

	public static boolean find(){
		Queue<List> q = new ArrayDeque<>();

		boolean[][] visited = new boolean[size][size];
		// visited[list.get(0)[0]][list.get(0)[1]] = true;
		List<int[]> input = new ArrayList<>();
		for(int[] l : list){
			input.add(new int[]{l[0],l[1]});
		}
		q.offer(input);


		while(!q.isEmpty()){
			List<int[]> now = q.poll();

			if(visited[now.get(0)[0]][now.get(0)[1]]) continue;
			visited[now.get(0)[0]][now.get(0)[1]] = true;

			int count = hole;
			for(int[] n : now){
				int x = n[0];
				int y = n[1];
				if(data[x][y] == 1) break;
				if(check[x][y]){
					count--;
				}
			}
			// System.out.println(count);
			if(count == 0){
				return true;
			}

			for(int d = 0; d < 4; d++){
				List<int[]> next = new ArrayList<>();
				boolean flag = false;
				for(int[] n : now){
					int nx = n[0]+dx[d];
					int ny = n[1]+dy[d];
					if(nx >= 0 && nx < size && ny >= 0 && ny < size){
						next.add(new int[]{nx,ny});
					}else{
						flag = true;
						break;
					}
				}
				if(flag) continue;
				q.offer(next);
			}
		}


		return false;
	}
}
