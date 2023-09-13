package algo_202309;

import java.io.*;
import java.util.*;

public class BJ_1802_종이접기 {
    public static char[] input;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T= Integer.parseInt(br.readLine());
        for(int t=  0; t < T; t++){
            input = br.readLine().toCharArray();
            int length =input.length-1;
            if(find(0,length)){
                sb.append("YES").append("\n");
            }else{
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }

    public static boolean find(int left, int right){
        if(left >= right){
            return true;
        }

        int mid = (left+right)/2;
        for(int i = left; i < mid; i++){
            if(input[i] == input[right-i]){
                return false;
            }
        }

        return find(left,mid-1) && find(mid+1,right);
    }
}
