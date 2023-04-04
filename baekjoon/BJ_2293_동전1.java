package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_2293_동전1 {
    public static int N,K;
    public static int[] data;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        data = new int[N];
        for(int i = 0; i < N; i++){
            data[i] = Integer.parseInt(br.readLine());
        }
        find();
    }

    public static void find(){
        int[] cnt = new int[K+1];
        cnt[0] = 1;
        for(int i = 0; i < N; i++){
            for(int j = data[i]; j <= K; j++){
                cnt[j] += cnt[j-data[i]];
            }
        }
//        System.out.println(Arrays.toString(cnt));
        System.out.println(cnt[K]);
    }
}
