package algo_202308;

import java.io.*;
import java.util.*;

public class BJ_23253_자료구조는정말최고야 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean result = true;
        for(int i = 0; i < M; i++){
            int k = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int last = N+1;
            for(int j = 0; j <k; j++){
                int input = Integer.parseInt(st.nextToken());
                if(last < input){
                    result = false;
                    break;
                }
                last = input;
            }
            if(!result){
                break;
            }
        }
        if(result){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
