package algo_202403;

import java.util.*;
import java.io.*;

public class BJ_NQueen {
	// public static boolean[][] data;
	public static boolean[] colCheck;
	public static int N;
	public static int result;
	public static boolean[] check1,check2;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		colCheck = new boolean[N];
		check1 = new boolean[2*N];
		check2 = new boolean[2*N];
		// stack.push(new int[] {0, 0});
		result = 0;
		find(0);
		System.out.println(result);
	}

	public static void find(int row){
		if(row == N){
			result ++;
			return;
		}

		for (int i = 0; i < N; i++) {
			int a = row+i;
			int b = row-i+N-1;
			// int b = Math.abs(row-i);
			if (!colCheck[i] && !check1[a] && ! check2[b]) {
				colCheck[i] = true;
				check1[a] = true;
				check2[b] = true;

				find(row+1);

				colCheck[i] =false;
				check1[a] = false;
				check2[b] = false;
			}
		}
	}
}
