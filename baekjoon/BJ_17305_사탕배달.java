package algo_202411;

import java.io.*;
import java.util.*;

public class BJ_17305_사탕배달 {
	public static int N, W;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		long sum = 0;
		int totalWeight = 0;
		PriorityQueue<Candy> three = new PriorityQueue<>(Comparator.comparing((Candy candy)->candy.cost));
		PriorityQueue<Candy> five = new PriorityQueue<>(Comparator.comparing((Candy candy)-> -candy.cost));
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (w == 3) {
				three.add(new Candy(w, c));
				sum += c;
				totalWeight += w;
			} else {
				five.add(new Candy(w, c));
			}
		}


		long result = 0;

		while (!five.isEmpty()&&totalWeight < W) {
			Candy now = five.poll();
			if (totalWeight + now.weight <= W) {
				totalWeight += now.weight;
				sum += now.cost;
			} else {
				five.offer(now);
				break;
			}

		}

		if (totalWeight <= W) {
			result = sum;
		}
		while (!three.isEmpty()) {
			if(!three.isEmpty()){
				Candy candy = three.poll();
				// System.out.println(candy);
				sum -= candy.cost;
				totalWeight -= candy.weight;

			}

			if (totalWeight <= W) {
				result = Math.max(result, sum);
			}
			// System.out.println("result = "+result);
			// boolean flag = false;
			if(!five.isEmpty()){
				// flag = true;
				Candy candy = five.poll();
				// System.out.println(candy);
				if (totalWeight + candy.weight <= W) {
					sum += candy.cost;
					totalWeight += candy.weight;
					result = Math.max(result, sum);
					// three.offer(candy);
				} else {
					five.offer(candy);
				}
			}

			// if (!flag) {
			// 	break;
			// }
		}
		System.out.println(result);

	}

	public static class Candy{
		int weight;
		int cost;

		public Candy(int weight, int cost){
			this.weight = weight;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Candy{" +
				"weight=" + weight +
				", cost=" + cost +
				'}';
		}
	}
}
