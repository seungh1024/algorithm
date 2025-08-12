

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Data[] data = new Data[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			data[i] = new Data(x, y);
		}

		boolean[] visited = new boolean[N];

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if(data[i].y == 0)continue;
			if(visited[i]) continue;
			visited[i] = true;
			cnt++;
			int h = data[i].y;
			for (int j = i + 1; j < N; j++) {
				if(data[j].y < h) break;
				if (data[j].y == h) {
					visited[j] = true;
				}
			}
		}
		System.out.println(cnt);
	}

	public static class Data{
		int x;
		int y;

		public Data(int x, int y){
			this.x = x;
			this.y = y;
		}

		public String toString(){
			return "x = " + x + ", y = " + y;
		}
	}
}
