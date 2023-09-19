package algo_202309;

import java.io.*;
import java.util.*;

public class BJ_21313_문어 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int size = N-1;
        for(int i = 1; i <= size; i++){
            if(i%2 == 1){
                sb.append("1 ");
            }else{
                sb.append("2 ");
            }
        }
        if(N%2==0){
            sb.append(2);
        }else{
            sb.append(3);
        }
        System.out.println(sb);
    }
}
