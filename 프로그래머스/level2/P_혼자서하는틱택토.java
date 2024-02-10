package algo_202402;

public class P_혼자서하는틱택토 {
	public static void main(String[] args) {
		P_혼자서하는틱택토 test = new P_혼자서하는틱택토();
		String[] board = {"OOO", "...", "XXX"};
		int answer = test.solution(board);
		int result = 0;
		if (answer == result) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}

	public static char[][] data;
	public static int N, M;

	public int solution(String[] board) {
		int answer = 1;

		N = board.length;
		M = board[0].length();
		data = new char[N][M];

		int oCount = 0;
		int xCount = 0;
		for (int i = 0; i < N; i++) {
			char[] input = board[i].toCharArray();
			for (int j = 0; j < M; j++) {
				data[i][j] = input[j];
				if (input[j] == 'O') {
					oCount++;
				} else if (input[j] == 'X') {
					xCount++;
				}
			}
		}

		if (xCount > oCount) {
			answer = 0;
		} else {
			if (Math.abs(xCount - oCount) > 1) {
				answer = 0;
			} else if (isValid("X") && oCount > xCount) {
				answer = 0;
			} else if (isValid("O") && oCount == xCount) {
				answer = 0;
			}
		}

		return answer;
	}

	public static boolean isValid(String ox) {
		String s = ox;
		for (int i = 0; i < 2; i++) {
			s += ox;
		}

		for (int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < M; j++) {
				sb.append(data[i][j]);
			}
			if (sb.toString().equals(s)) {
				return true;
			}
		}
		for (int j = 0; j < M; j++) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				sb.append(data[i][j]);
			}
			if (sb.toString().equals(s)) {
				return true;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(data[i][i]);
		}
		if (sb.toString().equals(s)) {
			return true;
		}
		sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(data[i][N - i - 1]);
		}
		if (sb.toString().equals(s)) {
			return true;
		}

		return false;
	}
}
