package algo_202403;

import java.io.*;
import java.util.*;

public class BJ_20366_같이눈사람만들래 {
	public static int N;
	public static int[] input;
	public static List<Data> list;
	public static int result;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				Data data = new Data(input[i]+input[j],i,j);
				list.add(data);
			}
		}
		Collections.sort(list);

		result = Integer.MAX_VALUE;
		int size = list.size();
		for (int i = 0; i < size; i++) {
			find(i+1,size);
		}
		System.out.println(result);


	}

	public static int find(int start, int end) {
		Data now = list.get(start-1);

		// System.out.println("start = "+start  + ",end = "+end);
		while (start < end) {
			int mid = (start+end)/2;

			Data target = list.get(mid);
			if (target.num >= now.num ) {
				end = mid;
				if(now.isValid(target)){
					result = Math.min(result,target.num - now.num);
					// System.out.println("target = " + target);
					// System.out.println("now = " + now);
					// System.out.println(result);
				}
			} else {
				start = mid+1;
				if(now.isValid(target)){
					result = Math.min(result,target.num - now.num);
					// System.out.println("target = " + target);
					// System.out.println("now = " + now);
					// System.out.println(result);
				}
			}
		}

		return start;
	}

	public static class Data implements Comparable<Data> {
		int num;
		int left;
		int right;

		public Data(int num, int left, int right) {
			this.num = num;
			this.left = left;
			this.right = right;
		}

		@Override
		public int compareTo(Data data) {
			return this.num - data.num;
		}


		public boolean isValid(Data data){
			if (this.left != data.left && this.left != data.right && this.right != data.left
				&& this.right != data.right) {
				return true;
			}
			return false;
		}

		@Override
		public String toString() {
			return "num = "+num + ", left = "+left + ",right = "+right;
		}
	}

}
