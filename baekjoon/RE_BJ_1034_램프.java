package algo_202311;

import java.io.*;
import java.util.*;

public class RE_BJ_1034_램프 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] data = new String[N];
        int[] zeroCount = new int[N];

        for(int i = 0; i < N; i++){
            data[i] = br.readLine();
            char[] charData = data[i].toCharArray();
            for(char c : charData){
                if(c-'0' == 0){
                    zeroCount[i]++;
                }
            }

        }
        int K = Integer.parseInt(br.readLine());
        makeResult(N,M,data,zeroCount,K);

    }

    public static void makeResult(int N, int M, String[] data, int[] zeroCount, int K){
        int result = 0;
        for(int i = 0; i < N; i++){
            if(zeroCount[i] > K || zeroCount[i] % 2 != K % 2) continue;
//            System.out.println("i: "+i);
            String s = data[i];
            int count = 1;
            for(int j = i + 1; j < N; j++){
                if(s.equals(data[j])){
                    count++;
                }
            }
            result = Math.max(result,count);
        }

        System.out.println(result);
    }
}
