import java.io.*;
import java.util.*;

public class Main {
	public static int V, E;
	public static int[][] data;


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		data = new int[V+1][V+1];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			data[from][to] = cost;
		}

		for (int k = 1; k <= V; k++) {
			for (int i = 1; i <= V; i++) {
				if(data[i][k] == 0 || i == k) continue;
				for (int j = 1; j <= V; j++) {
					if(data[k][j] == 0 || j == k) continue;
					if (data[i][j] == 0) {
						data[i][j] = data[i][k] + data[k][j];
					} else {
						data[i][j] = Math.min(data[i][j],data[i][k] + data[k][j]);
					}
				}
			}
		}

		// for (int i = 0; i <= V; i++) {
		// 	System.out.println(Arrays.toString(data[i]));
		// }

		int result = Integer.MAX_VALUE;
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				if (data[i][j] != 0 && data[j][i] != 0) {
					result = Math.min(result, data[i][j] + data[j][i]);
				}
			}
		}

		if(result == Integer.MAX_VALUE){
			result = -1;
		}
		System.out.println(result);
	}

}