package algo_202312;

import java.io.*;
import java.util.*;

public class BJ_2533_사회망서비스 {
    public static int N,result;
    public static ArrayList<Integer>[] list;
    public static int[][] dp;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        visited = new boolean[N+1];
        dp = new int[N+1][2];
        dfs(1);
        System.out.println(Math.min(dp[1][0],dp[1][1]));
    }

    private static void dfs(int node) {

        visited[node] = true;
        dp[node][0] = 0;
        dp[node][1] = 1;

        for (int next : list[node]) {
            if(visited[next]) continue;

            dfs(next);
            dp[node][0] += dp[next][1];
            dp[node][1] += Math.min(dp[next][0], dp[next][1]);
        }
    }

}
//10
//1 6
//6 7
//1 3
//6 8
//8 5
//5 4
//4 9
//4 10
//9 2

//15
//1 2
//1 3
//3 4
//1 5
//5 6
//6 7
//7 8
//8 9
//9 10
//10 11
//11 12
//12 13
//13 14
//14 15

//16
//1 2
//1 3
//1 4
//1 5
//1 6
//2 7
//3 8
//4 9
//5 10
//8 11
//9 12
//9 13
//9 14
//9 15
//9 16