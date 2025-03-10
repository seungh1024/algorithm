import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t= 0 ;t < T; t++){
			N = Integer.parseInt(br.readLine());
			data = new int[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++){
				data[i] = Integer.parseInt(st.nextToken());
			}

			int result = find();
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	public static int find() {
		int[] makeTeam = new int[N+1];

		for (int i = 1; i <= N; i++) {
			if(makeTeam[i] == -1) continue;
			int next = i;
			// System.out.println("i = "+i +", next = "+next);
			while (true) {
				// System.out.println("next 1 = "+next + ", team info = "+Arrays.toString(makeTeam));

				makeTeam[next] = i;
				next = data[next];
				if (makeTeam[next] == i) { // 성공
					while (makeTeam[next] != -1) {
						makeTeam[next] = -1;
						next = data[next];
					}
					break;
				} else if(makeTeam[next] != 0){
					// System.out.println("-- fail --");
					next = data[i];
					while (makeTeam[next] == i) {
						makeTeam[next] = 0;
						next = data[next];
					}

					break;
				}

				// System.out.println("next 2 = "+next);
			}
		}

		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (makeTeam[i] == -1) {
				cnt++;
			}
		}

		return N-cnt;
	}
}