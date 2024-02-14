package algo_202402;

import java.util.*;

public class P_교점에별만들기 {
	public static void main(String[] args) {
		P_교점에별만들기 test = new P_교점에별만들기();
		int[][] line = {{2,-1,4},{-2,-1,4},{0,-1,1},{5,-8,-12},{5,8,12}};
		String[] answer = test.solution(line);
		String[] result = {"....*....", ".........", ".........", "*.......*", ".........", ".........", ".........",
			".........", "*.......*"};
		int length = result.length;
		for (int i = 0; i < length; i++) {
			if (!answer[i].equals(result[i])) {
				System.out.println("fail");
				return;
			}
		}
		System.out.println("success");
	}
	// Ax + By + E = 0, Cx + Dy + F = 0
	// x.= (BF - ED)/(AD-BC)
	// y = (EC - AF)/(AD-BC)
	public String[] solution(int[][] line) {

		int length = line.length;
		List<long[]> list = new ArrayList<>();
		long minx = Long.MAX_VALUE;
		long miny = Long.MAX_VALUE;
		long maxx = Long.MIN_VALUE;
		long maxy = Long.MIN_VALUE;
		for(int i = 1; i < length; i++){
			long A = (long)line[i][0];
			long B = (long)line[i][1];
			long E = (long)line[i][2];

			for(int j = 0; j < i; j++){
				long C = (long)line[j][0];
				long D = (long)line[j][1];
				long F = (long)line[j][2];
				// A = 100_000L;
				// D = 100_000L;
				// B = 100_000L;
				// C = -100_000L;
				long ADBC = (A*D)-(B*C);
				// System.out.println(ADBC);
				// if(ADBC != 0)
				//     return new String[]{};
				if(ADBC != 0){
					long x = (B*F)-(E*D);
					long y = (E*C)-(A*F);
					if(x%ADBC == 0 && y%ADBC == 0){
						x = x/ADBC;
						y = y/ADBC;
						// int ix = (int)x;
						// int iy = (int)y;
						list.add(new long[]{x,y});
						minx = Math.min(minx,x);
						miny = Math.min(miny,y);
						maxx = Math.max(maxx,x);
						maxy = Math.max(maxy,y);
					}
				}
			}
		}


		// x에서 minx를 빼야하고
		// y에서 maxy를 빼야함 그리고 -1 곱해야 함
		// 그리고 x,y를 바꿔서 y,x로 별을 새겨야 함. 좌표 평면이랑 반대니까
		int xl = (int)(maxx-minx+1);
		int yl = (int)(maxy-miny+1);
		char[][] data = new char[yl][xl];

		for(int i = 0; i < yl; i++){
			Arrays.fill(data[i],'.');
		}

		System.out.println("minx: "+minx + ", maxx: "+maxx);
		System.out.println("miny: "+miny + ", maxy: "+maxy);

		for(long[] i : list){
			// System.out.println(Arrays.toString(i));
			// int x = i[0] - minx;
			// int y = (i[1] - maxy)*-1;
			long x = i[0];
			long y = i[1];
			x-=minx;
			y-=maxy;
			y *= (-1);
			// System.out.println("x: "+ x + ", y: "+y);
			data[(int)y][(int)x] = '*';
		}

		String[] answer = new String[yl];
		for(int i = 0; i < yl; i++){
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < xl; j++){
				sb.append(data[i][j]);
			}
			answer[i] = sb.toString();
			// System.out.println(sb);
		}



		return answer;
	}
}
