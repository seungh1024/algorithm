package SWExpertAcademy;

import java.io.*;
import java.util.*;


public class SWEA_1861_정사각형방 {
	static int[][] map;
	static int count;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		//start test_case
		for(int test_case = 1 ; test_case<=T; test_case ++) {
			int N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];

			//start input
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}

			}//end input
			
			//start dfs
			int point = map[0][0];//첫 번째 방의 값을 넣어줌
			int maxCount = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					count = 0;
					dfs(i,j,N);
					if(count>maxCount) {//더 많이 방문했다면 값을 바꿔줌
						maxCount = count;
						point = map[i][j];
					}else if(count == maxCount) {//같은 경우 방 번호가 작은 값으로
						point = point<map[i][j]?point:map[i][j];
					}
//					System.out.println("------------");
				}
			}

			System.out.println("#"+test_case+" "+point+" "+maxCount);
		}//end test case
	}
	
	//1큰수로만 진행하므로 왔던길 돌아올 수는 없음.
	public static void dfs(int x, int y,int N) {
		count ++; //방에 입장했으니 카운트 시켜 줌
		for(int i = 0; i < 4; i++) {
			int nx = x +dx[i];
			int ny = y +dy[i];
			//index 초과하지 않는 경우 + 직전 방의 값에서 1 더한 값이 이동하려는 곳의 값이면 이동
			if(nx>=0 && ny >= 0 && nx < N && ny <N && map[nx][ny]==map[x][y]+1) {
				dfs(nx,ny,N);
			}
		}
	}
	
	

}

