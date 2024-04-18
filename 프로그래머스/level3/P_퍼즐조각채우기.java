package algo_202403;

import java.util.*;

public class P_퍼즐조각채우기 {
	public static int N;
	public static Queue<Board>[] boardList; // 빈칸 크기별 board 상태 저장
	public static int boardSize;
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1,-1,0,0};
	public static int blockIndex = 0;
	public static boolean[] boardCheck;

	public int solution(int[][] game_board, int[][] table) {
		int answer = 0;
		N = game_board.length;
		boardSize = N*N+1;
		boardList = new Queue[boardSize];
		for(int i = 0; i < boardSize; i++){
			boardList[i] = new ArrayDeque<>();
		}
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				if(game_board[i][j] == 0){
					findGame(i,j,game_board);
				}

			}
		}

		boardCheck = new boolean[blockIndex];

		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				if(table[i][j] == 1){
					answer += findTable(i,j,table);
				}
			}
		}


		return answer;
	}

	public static int findTable(int x, int y, int[][] table){
		int count = 1;
		table[x][y] = 0;
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{x,y});
		List<int[]> list = new ArrayList<>();
		list.add(new int[]{x,y});

		while(!q.isEmpty()){
			int[] now = q.poll();

			for(int d = 0; d < 4; d++){
				int nx = now[0]+dx[d];
				int ny = now[1]+dy[d];

				if(nx>=0 && nx < N && ny >=0 && ny < N && table[nx][ny] == 1){
					table[nx][ny] = 0;
					int[] next = {nx,ny};
					q.offer(next);
					list.add(next);
					count++;
				}
			}
		}

		List<int[]> spinList = new ArrayList<>();
		for(int[] l : list){
			spinList.add(new int[]{l[0],l[1]});
		}
		for(int i = 0; i < 4; i++){
			List<int[]> newList = new ArrayList<>();
			int minX = N;
			int minY = N;
			for(int[] s : spinList){
				int[] next = {s[1],N-1-s[0]};
				newList.add(next);
				minX = Math.min(minX,next[0]);
				minY = Math.min(minY,next[1]);
				s[0] = next[0];
				s[1] = next[1];

			}

			// 좌표를 좌상단으로 몰아줌
			for(int [] n : newList){
				n[0] -= minX;
				n[1] -= minY;
				// System.out.println(Arrays.toString(n));
			}
			// System.out.println("=======");


			int size = boardList[count].size();
			// System.out.println("size = "+size + ", count = "+count);
			for(int s = 0; s < size; s++){
				Board now = boardList[count].poll();

				if(boardCheck[now.index]) continue;
				List<int[]> nowList = now.list;

				int sameCount = 0;
				for(int[] a : newList){
					for(int[] b : nowList){
						if(a[0] == b[0] && a[1] == b[1]){
							sameCount++;
						}
					}
				}

				if(sameCount == count){
					boardCheck[now.index] = true;
					// System.out.println("count = "+count);
					return count;
				}
				boardList[count].offer(now);
			}

		}


		return 0;
	}

	public static void findGame(int x, int y, int[][] board){
		int count = 1;
		board[x][y] = 1;
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{x,y});
		List<int[]> list = new ArrayList<>();
		list.add(new int[]{x,y});

		int minX = x;
		int minY = y;
		while(!q.isEmpty()){
			int[] now = q.poll();

			for(int d = 0; d < 4; d++){
				int nx = now[0]+dx[d];
				int ny = now[1]+dy[d];

				if(nx>=0 && nx < N && ny >=0 && ny < N && board[nx][ny] == 0){
					board[nx][ny] = 1;
					int[] next = {nx,ny};
					q.offer(next);
					list.add(next);
					count++;
					minX = Math.min(minX,nx);
					minY = Math.min(minY,ny);
				}
			}
		}

		for(int[] l : list){
			l[0]-=minX;
			l[1]-=minY;
		}
		boardList[count].offer(new Board(blockIndex++,list));

	}

	// 빈칸 정보
	public static class Board{
		int index;
		List<int[]> list;

		public Board(int index, List<int[]> list){
			this.index = index;
			this.list = list;
		}
	}
}
