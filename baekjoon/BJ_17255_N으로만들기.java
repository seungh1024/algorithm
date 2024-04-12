package algo_202403;

import java.util.*;
import java.io.*;

public class BJ_17255_N으로만들기 {
	public static int N;
	public static Set<String> set;
	public static char[] data;
	public static int result;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		data = br.readLine().toCharArray();
		set = new HashSet<>();
		result = 0;
		N = data.length;
		for (int i = 0; i < N; i++) {
			find(i,i,1,""+data[i],""+data[i],i);
		}
		// find(0,0,"","",0);
		System.out.println(result);
		// System.out.println(set);
	}

	public static void find(int left, int right, int count, String s,String key,int last) {
		// System.out.println("key = "+key +", left = "+left +", right = "+right);
		if (count == N) {
			if (!set.contains(key)) {
				result++;
			}
			set.add(key);
			return;
		}
		if(left < 0 || right >= N) return;

		if (left-1 >= 0 && last != left-1) {
			find(left-1,right,count+1,data[left-1]+s,key+data[left-1]+s,left);
		}
		if (right + 1 < N && last != right+1) {
			find(left,right+1,count+1,s+data[right+1],key+s+data[right+1],right);
		}
	}
}
