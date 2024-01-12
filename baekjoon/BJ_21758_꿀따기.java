package algo_202401;

import java.io.*;
import java.util.*;

public class BJ_21758_꿀따기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] data = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		long sum = 0;
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
			sum += data[i];
		}
		long honey = (sum - data[0]-data[1])*2; // 제일 앞 두개 제외한 꿀의 합

		long max = honey;
		for(int i = 2; i < N; i++){
			honey = honey - (data[i]*2) + data[i-1];
			max = Math.max(honey,max);
			// System.out.println("i: "+ i + ", honey: "+honey);
		}

		honey = (sum - data[N-1] - data[N-2])*2; // 반대로 탐색할 떄 꿀의 합
		max = Math.max(max,honey);
		for(int i = N-3; i >= 0; i--){
			honey = honey - (data[i]*2) + data[i+1];
			max = Math.max(honey,max);
		}

		honey = sum-data[0]-data[N-1] + data[1]; // 양쪽 끝에 벌이 있고 통이 움직이는 경우
		max = Math.max(honey,max);
		for(int i = 2; i < N-1; i++){
			honey = honey +data[i] - data[i-1];
			max = Math.max(honey,max);
		}
		System.out.println(max);
	}
}
