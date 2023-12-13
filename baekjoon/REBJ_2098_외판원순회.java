package algo_202312.re;

import java.io.*;
import java.util.*;

public class REBJ_2098_외판원순회 {
    public static int N,size;
    public static int[][] data;
    public static int[][] dp;
    public static int max = 17000001;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        size = 1<<N;
        dp = new int[N][size];
        int result = find(0,1);
        System.out.println(result);
//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
    }

    public static int find(int index, int visit) {
        if (visit == (1 << N)-1) {
            if (data[index][0] > 0) {
                return data[index][0];
            }
            return max;
        }

        if(dp[index][visit] > 0) return dp[index][visit];

        if(dp[index][visit] == 0) dp[index][visit] = max;
        for (int i = 1; i < N; i++) {
            int next = 1<<i;
            if((visit & next) > 0) continue; //이미 방문한 곳은 안감
            if (data[index][i] != 0) {
                dp[index][visit] = Math.min(dp[index][visit] , data[index][i] + find(i,visit|next));
            }
        }

        return dp[index][visit];
    }
}
