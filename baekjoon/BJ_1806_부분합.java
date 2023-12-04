package algo_202312;

import java.io.*;
import java.util.*;

public class BJ_1806_부분합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] data = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        for (int i = 0; i < N; i++) {
            sum += data[i];
            if (sum >= S) {
                while (sum >= S) {
                    minLength = Math.min(minLength,i-left+1);
                    sum -= data[left];
                    left++;
                }
            }
        }
//        System.out.println("sum: "+sum + ", left: "+left);
        if(minLength == Integer.MAX_VALUE) minLength = 0;
        System.out.println(minLength);
    }
}
