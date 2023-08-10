package algo_202308;


import java.io.*;
import java.util.*;

public class BJ_2565_전깃줄 {
    public static Line[] lines;
    public static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        lines = new Line[N];
        StringTokenizer st;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Line line = new Line(a,b);
            lines[i] = line;
        }

        Arrays.sort(lines);
//        System.out.println(Arrays.toString(lines));
        find();

    }
    public static void find(){
        int[] dp = new int[N];
        int result = 0;
        for(int i = 0; i < N; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(lines[j].b <lines[i].b){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            result = Math.max(result,dp[i]);
        }
        System.out.println(N-result);
    }

    public static class Line implements Comparable<Line>{
        int a,b;
        public Line(int a, int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Line line){
            return  this.a - line.a;
        }

        public String toString(){
            return "a: "+a+", b: "+ b;
        }
    }
}
