package algo_202309;

import java.io.*;
import java.util.*;

public class BJ_1813_논리학교수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] data = new int[51];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int input = Integer.parseInt(st.nextToken());
            data[input]++;
        }

        for(int i = 50; i >= 0; i--){
            if(i == data[i]){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}
