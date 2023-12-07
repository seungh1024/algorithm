package algo_202312;

import java.io.*;
import java.util.*;

public class BJ_2098_외판원순회 {
    public static int N;
    public static int[][] data;
    public static int[][] dp;
    public static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[N][1<<N];


        result = dfs(0, 1);
//        result = dp[0][0];
        System.out.println(result);
//        printData();
    }

    public static int dfs(int x, int bit) {
//        System.out.println("x: "+ x +", bit: "+ bit);
        if (bit == (1 << N) -1) {

            if (data[x][0] > 0) {
                return data[x][0];
            }

            return 17000000;
        }

        if(dp[x][bit] > 0 && dp[x][bit] != Integer.MAX_VALUE) return dp[x][bit];
        dp[x][bit] = 17000000;

        for (int y = 0; y < N; y++) {
            if(x==y || data[x][y] == 0) continue; // 제자리걸음 or 못가면 continue
            if((bit & (1<<y)) >0) continue; //이미 방문했으면 안감
//            System.out.println("x: "+ x + ", y: "+ y);
            int next = dfs(y,bit | (1<<y));
            if (dp[x][bit] == 0) {
                dp[x][bit] = data[x][y] + next;
            } else {
                dp[x][bit] = Math.min(dp[x][bit], data[x][y] + next);
            }
        }

        return dp[x][bit];
    }

    public static void printData() {
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
    }
}
