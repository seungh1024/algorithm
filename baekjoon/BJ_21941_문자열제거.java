package algo_202410;

import java.io.*;
import java.util.*;

public class BJ_21941_문자열제거 {
	public static String data;
	public static int M;
	public static List<Word> list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		data = br.readLine();
		M = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String word = st.nextToken();
			int point = Integer.parseInt(st.nextToken());
			Word w = new Word(word, point);
			list.add(w);
		}


		int size = data.length()+1;
		int[] dp = new int[size];

		for (int i = 1; i < size; i++) {
			for(Word w : list){
				int idx = data.indexOf(w.word,i-1);
				if (idx == i-1) {
					// System.out.println(w);
					dp[i + w.length - 1] = Math.max(dp[i + w.length - 1], dp[i-1] + w.point);
				}
				dp[i] = Math.max(dp[i], dp[i - 1] + 1);
			}

		}


		// System.out.println(Arrays.toString(dp));
		System.out.println(dp[size-1]);

	}

	public static class Word{
		String word;
		int point;
		int length;

		public Word(String word, int point) {
			this.word = word;
			this.point = point;
			this.length = word.length();
		}

		public String toString(){
			return "word = " + word + ", point = " + point;
		}
	}
}
