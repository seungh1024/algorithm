package algo_202312;

import java.io.*;
import java.util.*;

public class BJ_2437_저울 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] data = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(data);
        int left = 0;
        int right = 0;
        int result = 0;
        for (int i = 0; i < N; i++) {
            int ld = left + data[i];
            int rd = right + data[i];
//            System.out.println("data[i]: "+data[i]+ ", ld : "+ld +", rd : "+rd + ", right: "+right);
            if (ld - 1 <= right) {
                right = rd;
            } else {
                result = right+1;
                break;
            }
            result = right+1;
        }
        System.out.println(result);
    }
}
