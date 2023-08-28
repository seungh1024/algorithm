package algo_202308;

import java.io.*;
import java.util.*;

public class BJ_2096_내려가기 {
    public static int N;
    public static int[][] maxDp;
    public static int[][] minDp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        maxDp = new int[N+1][3];
        minDp = new int[N+1][3];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            minDp[i][0] = a;
            minDp[i][1] = b;
            minDp[i][2] = c;
            maxDp[i][0] = a;
            maxDp[i][1] = b;
            maxDp[i][2] = c;
        }

        find();
        int max = 0;
        int min = N*10;
        for(int i = 0; i < 3; i++){
            max = Math.max(max,maxDp[N-1][i]);
            min = Math.min(min,minDp[N-1][i]);
        }
        System.out.println(max + " "+ min);

//        for(int i = 0; i < N; i++){
//            System.out.println(Arrays.toString(maxDp[i]));
//        }
//        for(int i = 0; i < N; i++){
//            System.out.println(Arrays.toString(minDp[i]));
//        }
    }
    public static void find(){
        for(int i = 1; i < N; i++){
            int maxNum1 = Math.max(maxDp[i-1][0],maxDp[i-1][1]);
            int maxNum2 = Math.max(maxDp[i-1][1],maxDp[i-1][2]);
            int minNum1 = Math.min(minDp[i-1][0],minDp[i-1][1]);
            int minNum2 = Math.min(minDp[i-1][1],minDp[i-1][2]);
            maxDp[i][0] += maxNum1;
            maxDp[i][1] += Math.max(maxNum1,maxNum2);
            maxDp[i][2] += maxNum2;
            minDp[i][0] += minNum1;
            minDp[i][1] += Math.min(minNum1,minNum2);
            minDp[i][2] += minNum2;
        }
    }
}
