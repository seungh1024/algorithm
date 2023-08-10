package algo_202308;

import java.io.*;
import java.util.*;

public class BJ_20944_팰린드롬척화비 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append("a");
        }
        System.out.println(sb);
    }
}
