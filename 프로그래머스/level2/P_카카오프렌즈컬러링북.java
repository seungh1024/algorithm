package algo_202402;

import java.util.*;

public class P_카카오프렌즈컬러링북 {
	public static void main(String[] args) {
		P_카카오프렌즈컬러링북 test = new P_카카오프렌즈컬러링북();
		int m = 6;
		int n = 4;
		int[][] picture = {{1,1,1,0},{1,2,2,0},{1,0,0,1},{0,0,0,1},{0,0,0,3},{0,0,0,3}};
		int[] answer = test.solution(m, n, picture);
		int[] result = {4,5};
		if (Arrays.equals(answer, result)) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	private static int[] dx = {0,0,1,-1};
	private static int[] dy = {1,-1,0,0};

	public int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;

		int[] answer = new int[2];

		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(picture[i][j] != 0){
					int count = find(i,j,picture,m,n);
					if(count != 0){
						maxSizeOfOneArea = Math.max(maxSizeOfOneArea,count);
						numberOfArea++;
					}

				}
			}
		}

		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

	public static int find(int x, int y, int[][] picture, int m, int n){
		int count = 1;
		int target = picture[x][y];

		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{x,y});
		picture[x][y] = 0;

		while(!q.isEmpty()){
			int[] now = q.poll();

			for(int d = 0; d < 4; d++){
				int nx = now[0]+dx[d];
				int ny = now[1]+dy[d];
				if(nx>=0 && nx < m && ny >=0 && ny < n && picture[nx][ny] == target){
					picture[nx][ny] = 0;
					count++;
					q.offer(new int[]{nx,ny});
				}
			}
		}

		// for(int i = 0; i < m; i++){
		//     System.out.println(Arrays.toString(picture[i]));
		// }
		// System.out.println("=======");

		return count;
	}
}
