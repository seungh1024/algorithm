package algo_202403;

import java.util.*;
import java.io.*;

public class BJ_16922_로마숫자만들기 {
	public static int N;
	public static boolean[] check;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int size = N*50+1;

		Queue<Integer> q = new ArrayDeque<>();
		q.offer(0);

		int[] data = {1,5,10,50};
		int range = N;
		while (!q.isEmpty()) {
			int qs = q.size();
			check = new boolean[N*50+1];
			for(int s = 0; s < qs; s++){
				int now = q.poll();
				// System.out.println(now);
				for (int i = 0; i < 4; i++) {
					int next = now+data[i];
					if(next <size && !check[next]){
						check[next] = true;
						q.offer(next);
					}
				}
			}
			// System.out.println("___");
			range--;
			if (range == 0) {
				break;
			}

		}

		// System.out.println(q);
		System.out.println(q.size());
	}
}
