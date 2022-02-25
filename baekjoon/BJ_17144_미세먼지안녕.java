package day0225;

import java.io.*;
import java.util.*;

// 1. 각 먼지 위치 저장해서 각 먼지 위치별로 델타 사용해서 확산시킴
// 2. 공기청정기 기준으로 위, 아래 나눠서 순환 구조 하나씩 만들어서 돌림(-1 하나씩 찾아서 각 공기청정기로 구분)
// 3. T만큼 반복후 전체 배열의 값을 더해줌(-1 제외)
public class BJ_17144_미세먼지안녕 {

	static int[][] map;
	static int[] dx = { 0, -1, 0, 1 , 0, 1, 0, -1};
	static int[] dy = { 1, 0, -1, 0 , 1, 0, -1, 0};
	static Queue<SmallDust> smallDust = new LinkedList<>();// 확산되기 시작하면 먼지의 좌표와 가중치를 넣어줄 큐

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		int[] air = new int[2];// 공기청정기 x좌표만 저장. y는 항상 0이니까
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int point = Integer.parseInt(st.nextToken());
				map[i][j] = point;
				
				if (point > 0) {
					smallDust.add(new SmallDust(i,j,0));
				}
			}
//			System.out.println(Arrays.toString(air[i]));
		}


		int airIndex = 0;
		for (int i = 0; i < R; i++) {
			if (map[i][0] == -1) {
				air[airIndex] = i;
				airIndex++;
			}
		}

		////// end input///////////////

		/////start Test///////////
		for (int i = 0; i < T; i++) {// T초 만큼 반복

			spread(R, C,air[0],air[1]);
			clean(air[0],R,C,0);
			clean(air[1],R,C,4);

		}
		//////end Test//////////////

		//////// start output///////////
		int result = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				int now = map[i][j];
				if (now > 0) {
					result += now;
				}
			}
		}
		System.out.println(result);
		//////// end output/////////
	}

	public static class SmallDust {
		int x;
		int y;
		int weight;

		public SmallDust(int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}
	}

	// 먼지 확산
	public static void spread(int R, int C, int place1, int place2) {
		int size = smallDust.size();
		for (int s = 0; s < size; s++) {// 먼지 위치 수 만큼 반복
			SmallDust now = smallDust.poll();
			int x = now.x;
			int y = now.y;

			int nowDust = map[x][y]; // 확산 전 위치의 먼지 양
			if(nowDust <= 0) {
				continue;
			}

			for (int i = 0; i < 4; i++) {// 4방향으로 확산
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == -1 )
					continue; // 칸이 없거나 공기청정기가 있는 경우 확산 X

				// 확산 시작
				int nextDust = nowDust / 5;
				smallDust.offer(new SmallDust(nx, ny, nextDust));
				map[x][y] -= nextDust;// 확산된 만큼 빼줌
				
			}

		}
		boolean[][] visited = new boolean [R][C];
		int length = smallDust.size();
		while (length>0) {
			length--;
			SmallDust nowDust = smallDust.poll();
			int sx = nowDust.x;
			int sy = nowDust.y;
			int weight = nowDust.weight;
			map[sx][sy] += weight;
			if(sx ==0 || sx == place1 || sx== place2|| sx == R-1 || sy ==0 || sy == C-1 ) continue;
			
			if(!visited[sx][sy]) {				
				smallDust.offer(nowDust);
				visited[sx][sy] = true;
			}
		}
	}

	// 공기청정기로 확산 start = 시작 좌표 값
	public static void clean(int start, int R, int C,int index) {
		int x = start;
		int y = 1;

		int last = map[x][y];//초기 값 -> 현재 값으로 세팅
		map[x][y] = 0;
		int next = 0; //다음 값을 저장할 변수
		
		while (true) {
			
			int nx = x + dx[index];
			int ny = y + dy[index];

			
			if(nx<0|| nx>=R || ny<0 || ny >=C) {//범위를 벗어나면 index증가
				index++;
				continue;
			}

			if(map[nx][ny] == -1) {
				return;//공기청정기를 만나면 종료
			}
			
			next = map[nx][ny];
			map[nx][ny] = last;//다음 값을 이전 값으로 변경
			last = next;//변경 후 기존에 있던 값을 last에 저장
			x = nx;
			y = ny;
			if(map[x][y] > 0) {
				smallDust.offer(new SmallDust(x,y,0));
			}

		}
	}

}

//7 8 10
//0 0 0 0 0 0 0 9
//0 0 0 0 3 0 0 8
//-1 0 5 0 0 0 22 0
//-1 8 0 0 0 0 0 0
//0 0 0 0 0 10 43 0
//0 0 5 0 15 0 0 0
//0 0 40 0 0 0 20 0
