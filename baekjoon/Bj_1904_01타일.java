package algo_202304;

import java.io.*;
import java.util.*;

public class Bj_1904_01타일 {
    public static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        long first = 0;
        long second = 1;
        long result = 0;
        for(int i = 1; i <= N; i++){
            result = (first + second)%15746;
            first = second;
            second = result;
        }
        System.out.println(result);
    }
}
