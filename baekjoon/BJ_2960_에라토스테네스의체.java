package algo_202404;

import java.io.*;
import java.util.*;

public class BJ_2960_에라토스테네스의체 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[N+1];


		for (int i = 2; i <= N; i++) {
			if (visited[i]) {
				continue;
			}
			for(int j = i; j <= N; j+=i){
				if(!visited[j]){
					visited[j] = true;
					K--;
				}
				if (K == 0) {
					System.out.println(j);
					return;
				}
			}
		}
	}
}
