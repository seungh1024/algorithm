package algo_202401;

import java.io.*;
import java.util.*;

public class BJ_17352_여러분의다리가되어드리겠습니다 {
	public static int N;
	public static int[] parent;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		initParent();
		for (int i = 2; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			unionParent(a,b);
		}

		StringBuilder sb = new StringBuilder();
		getParent(1);
		int num = getParent(1);
		sb.append(num);
		for (int i = 2; i <= N; i++) {
			getParent(i);
			if(num != getParent(i)){
				sb.append(" ").append(getParent(i));
				break;
			}
		}
		System.out.println(sb);

	}

	public static void initParent(){
		parent = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}

	public static int getParent(int index){
		if(index == parent[index]){
			return index;
		}
		return parent[index] = getParent(parent[index]);
	}

	public static void unionParent(int a, int b){
		int pa = getParent(a);
		int pb = getParent(b);

		if(pa <= pb){
			parent[pb] = pa;
		}else{
			parent[pa] = pb;
		}
	}
}
