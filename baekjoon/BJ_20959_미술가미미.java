package algo_202409;

import java.io.*;
import java.util.*;

public class BJ_20959_미술가미미 {
	public static int N;
	public static RGB[] rgb;
	public static RGB gom;
	public static boolean[] visited;
	public static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		rgb = new RGB[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			rgb[i] = new RGB(r, g, b);
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int gr =Integer.parseInt(st.nextToken());
		int gg =Integer.parseInt(st.nextToken());
		int gb =Integer.parseInt(st.nextToken());
		gom = new RGB(gr, gg, gb);

		visited = new boolean[N];
		find(0,0);
		System.out.println(result);
	}

	public static void find(int idx, int cnt) {
		if(cnt <= 7 && cnt >= 2){

			int r = 0;
			int g = 0;
			int b = 0;
			int k = 0;
			for (int i = 0; i < N; i++) {
				if (visited[i]) {
					r+=rgb[i].r;
					g+=rgb[i].g;
					b+=rgb[i].b;
					k++;
				}
			}

			r/=k;
			g/=k;
			b/=k;

			int sum = Math.abs(gom.r-r)+Math.abs(gom.g-g)+Math.abs(gom.b-b);
			result = Math.min(result, sum);

		}

		if(idx >= N || cnt >=7) return;
		visited[idx] = true;
		find(idx+1,cnt+1);
		visited[idx] = false;
		find(idx+1,cnt);

	}


	public static class RGB{
		int r,g, b;
		public RGB(int r, int g, int b) {
			this.r = r;
			this.g = g;
			this.b = b;
		}
	}
}
