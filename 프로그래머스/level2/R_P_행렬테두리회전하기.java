package algo_202403;

public class R_P_행렬테두리회전하기 {
	public static int[][] data;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {1,0,-1,0};

	public int[] solution(int rows, int columns, int[][] queries) {
		int queryLength = queries.length;
		int[] answer = new int[queryLength];
		data = new int[rows+1][columns+1];
		int num = 1;
		for(int i = 1; i <= rows; i++){
			for(int j = 1; j <= columns; j++){
				data[i][j] = num++;
			}
		}

		for(int i = 0; i < queryLength; i++){
			int x1 = queries[i][0];
			int y1 = queries[i][1];
			int x2 = queries[i][2];
			int y2 = queries[i][3];
			answer[i] = spinAndGetMin(x1,y1,x2,y2);
		}

		return answer;
	}

	public static int spinAndGetMin(int x1, int y1, int x2, int y2){
		int length = (x2-x1)*2 + (y2-y1)*2;
		int d = 0;
		int last = data[x1][y1];
		int next = 0;
		int x = x1;
		int y = y1;
		int min = last;
		for(int i = 0; i < length; i++){
			x+=dx[d];
			y+=dy[d];
			next = data[x][y];
			data[x][y] = last;
			last = next;
			min = Math.min(min,last);
			// System.out.println("x : "+x + ", y: "+ y);
			if((x==x1 && y == y2) || (x == x2 && y == y2) || (x == x2 && y == y1)){
				d++;
			}
		}

		return min;
	}
}
