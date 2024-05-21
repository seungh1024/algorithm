package algo_202405;

import java.io.*;
import java.util.*;

public class BJ_15918_랭퍼든수열쟁이야 {
	public static int n,x,y,N;
	public static int[] lang;
	public static int[] data;
	public static boolean[] visited;
	public static int result;
	public static int target;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		N = 2*n;
		lang = new int[N];
		data = new int[n+1];
		visited = new boolean[n+1];
		result = 0;

		target = y-x-1;
		find(0,1);
		System.out.println(result);
	}

	public static void find(int index, int count){
		if (count == n) {
			lang = new int[N];
			lang[x-1] = target;
			lang[y-1] = target;
			int length = 0;
			int left = 0;
			for (int i = 0; i < n-1; i++) {
				int num = data[i];
				for (; left < N; left++) {
					if(lang[left] == 0){
						int right = left+num+1;
						if (right < N && lang[right] == 0) {
							length++;
							lang[left] = num;
							lang[right] = num;
						} else {
							return;
						}
						break;
					}

				}
			}
			if (length == n-1 && lang[x-1] == lang[y-1]) {
				// System.out.println(Arrays.toString(data));
				// System.out.println(Arrays.toString(lang));
				result++;
			}
			return;
		}

		for (int i = 1; i <= n; i++) {
			if(!visited[i] && i != target){
				visited[i] = true;
				data[index] = i;
				find(index+1,count+1);
				visited[i] =false;
			}
		}
	}
}
