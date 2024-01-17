package algo_202401;

import java.util.*;

public class P_파일명정렬 {
	public static void main(String[] args) {
		P_파일명정렬 test = new P_파일명정렬();
		String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		String[] result = {"img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"};
		String[] solution = test.solution(files);
		if(Arrays.equals(result,solution)){
			System.out.println("success");
		}else{
			System.out.println("fail");
		}
	}
	public String[] solution(String[] files) {

		Queue<Data> pq = new PriorityQueue<>();
		int myIndex = 0;
		for(String file : files){
			char[] array = file.toCharArray();
			StringBuilder sb = new StringBuilder();
			Data data = new Data();
			data.index = myIndex++;
			int index = 0;
			int length = file.length();
			for(; index < length; index++){
				if(array[index] >= '0' && array[index] <= '9'){
					data.head = sb.toString().toLowerCase();
					break;
				}
				sb.append(array[index]);
			}
			sb = new StringBuilder();
			int maxIndex = index+5;
			for(; index< maxIndex && index < length; index++){
				if(array[index] < '0' || array[index] > '9'){
					break;
				}
				sb.append(array[index]);
			}
			data.number = Integer.parseInt(sb.toString());

			data.origin = file;
			pq.offer(data);
		}


		int size = files.length;
		String[] answer = new String[size];
		for(int i = 0; i < size; i++){
			Data data = pq.poll();
			answer[i] = data.origin;
		}
		StringBuilder sb = new StringBuilder();

		return answer;
	}

	public static class Data implements Comparable<Data>{
		String origin,head;
		int number, index;

		public Data(){
			this.origin = "";
			this.head = "";
		}

		@Override
		public int compareTo(Data d){
			int compare = this.head.compareTo(d.head);
			if(compare == 0){
				if(this.number == d.number){
					return this.index - d.index;
				}
				return this.number-d.number;
			}

			return compare;
		}

		@Override
		public String toString(){
			return "head: "+head + ", number: "+number;
		}
	}
}
