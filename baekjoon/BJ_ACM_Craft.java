package algo_202308;

import java.io.*;
import java.util.*;

public class BJ_ACM_Craft {
    public static int N,K;
    public static int W;
    public static int[] time;
    public static ArrayList<Integer>[] parent;
    public static int[] childCnt;
    public static int[] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t= 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            time = new int[N+1];
            dp = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++){
                time[i] = Integer.parseInt(st.nextToken());
            }
            parent = new ArrayList[N+1];
            for(int i = 1; i <= N; i++){
                parent[i] = new ArrayList<>();
            }
            childCnt = new int[N+1];
            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                parent[x].add(y);
                childCnt[y]++;
            }
            W = Integer.parseInt(br.readLine());
            findMinTime();
            sb.append(dp[W]).append("\n");
//            System.out.println(Arrays.toString(time));
//            System.out.println(Arrays.toString(dp));
//            System.out.println(Arrays.toString(childCnt));
//            System.out.println("==============");
        }
        System.out.println(sb);
    }
    public static void findMinTime(){
        Queue<Integer> q = new LinkedList<>();
        for(int i =1 ; i<= N; i++){
            if(childCnt[i] == 0){
                dp[i] = time[i];
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int now = q.poll();
//            if(now == W)break;
//            dp[now] = Math.max(dp[now],time[now]);
            for(int next :parent[now]){
                childCnt[next]--;
                if(childCnt[next] == 0) q.offer(next);
                dp[next] = Math.max(dp[next],time[next]+dp[now]);
//                if(time[next]+dp[now]>dp[next]){
//                    q.offer(next);
//                }
            }
        }
    }
}
