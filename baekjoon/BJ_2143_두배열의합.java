package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_2143_두배열의합 {
    public static int T,N,M;
    public static int[] A;
    public static int [] B;
    public static long result;
    public static Map<Integer,Integer> ma;
    public static Map<Integer,Integer> mb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        B = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }
        result = 0;
        ma = new HashMap<>();
        mb = new HashMap<>();
        find();
        makeResult();
        System.out.println(result);
    }
    public static  void makeResult(){
        for(Object i : ma.keySet().toArray()){
            int num = (int) i;
            if(mb.get(T-num)!=null){
                result+=(long)ma.get(num) * (long)mb.get(T-num);
            }
        }
    }

    public static void find() {
        int[] dp = new int[N];
        int idx = 0;
        for(int i = 0; i < N; i++){
            for(int j = idx; j < N; j++){
                dp[j-i] = dp[j-i] + A[j];
                int num = 1;
                if(ma.get(dp[j-i]) != null) {
                    num += ma.get(dp[j - i]);
                }
                ma.put(dp[j-i],num);
            }
            idx++;
        }
//        System.out.println(ma.toString());

        dp = new int[M];
        idx = 0;
        for(int i = 0; i < M; i++){
            for(int j = idx; j < M; j++){
                dp[j-i] = dp[j-i] + B[j];
                int num = 1;
                if(mb.get(dp[j-i])!=null){
                    num += mb.get(dp[j-i]);
                }
                mb.put(dp[j-i],num);

            }
            idx++;
        }
//        System.out.println(mb.toString());
    }
}
