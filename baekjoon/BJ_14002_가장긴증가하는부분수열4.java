package algo_202308;

import java.io.*;
import java.util.*;

public class BJ_14002_가장긴증가하는부분수열4 {
    public static int[] initData;
    public static int[] data;
    public static int[] dp;
    public static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        initData = new int[N+1];
        data = new int[N+1];
        dp = new int[N+1];
        int index = 2;
        StringTokenizer st = new StringTokenizer(br.readLine());
        data[1] = Integer.parseInt(st.nextToken());
        initData[1] = data[1];
        dp[1] = 1;
        for(int i = 2; i <= N; i++){
            int input = Integer.parseInt(st.nextToken());
            initData[i] = input;
            if(input > data[index-1]){
                data[index] = input;
                dp[i] = index;
                index++;
            }else{
                find(index,input,i);
            }
        }
//        System.out.println(Arrays.toString(dp));
//        System.out.println(Arrays.toString(data));

        StringBuilder sb  = new StringBuilder();
        sb.append(--index).append("\n");
        Stack<Integer> stack = new Stack<>();
        for(int i = N; i >= 1; i--){
            if(dp[i] == index){
                stack.push(i);
                index--;
            }
        }
        while(!stack.isEmpty()){
            sb.append(initData[stack.pop()]).append(" ");
        }
        System.out.println(sb);
    }
    public static void find(int index, int input, int i){
        int start = 1;
        int end = index;
        while(start <= end){
            int mid = (start+end)/2;
            if(data[mid] >= input){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        data[start] = input;
        dp[i] = start;
    }

}
