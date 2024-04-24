package algo_202404;

import java.io.*;
import java.util.*;

public class BJ_16987_계란으로계란치기 {
	public static int N;
	public static Egg[] eggs;
	public static int result;


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		eggs = new Egg[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int shield = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			eggs[i] = new Egg(i,shield, weight);
		}
		result = 0;
		find(0);
		System.out.println(result);

	}

	public static void find(int index){
		// System.out.println("index = "+index);
		// System.out.println(Arrays.toString(eggs));

		if(index >= N){
			int sum = 0;
			// System.out.println(Arrays.toString(eggs));
			for(int i = 0; i < N; i++){
				if(eggs[i].shield <= 0){
					sum++;
				}
			}
			result = Math.max(result,sum);
			return;
		}

		if(eggs[index].shield<= 0){
			// System.out.println("?");
			find(index+1);
			return;
		}

		boolean flag = true;
		for(int i = 0; i < N; i++){
			if(i == index || eggs[i].shield <= 0) continue;

			flag = false;
			eggs[index].shield -= eggs[i].weight;
			eggs[i].shield -= eggs[index].weight;
			// System.out.println("for = "+index + ", i = "+i);
			// System.out.println(Arrays.toString(eggs));
			find(index+1);
			eggs[index].shield += eggs[i].weight;
			eggs[i].shield += eggs[index].weight;
		}

		if(flag){
			find(index+1);
		}
	}


	public static class Egg implements Comparable<Egg>{
		int index;
		int shield;
		int weight;

		public Egg(int index,int shield, int weight) {
			this.index = index;
			this.shield = shield;
			this.weight = weight;
		}

		@Override
		public int compareTo(Egg e){
			if (e.shield == this.shield) {
				return this.weight - e.weight;
			}
			return e.shield - this.shield;
		}

		@Override
		public String toString() {
			return "index = "+ index + ", shield = "+shield + ", weight = "+weight;
		}
	}
}
