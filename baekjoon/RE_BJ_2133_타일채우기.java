package algo_202311;

import java.io.*;
import java.util.*;

public class RE_BJ_2133_타일채우기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] data = new long[N+1];
        data[0] = 1;
        data[1] = 0;
        long last = data[0];
        for (int i = 2; i <= N; i += 2) {
            data[i] = data[i-2]*4 - last;
            last = data[i-2];
        }

        System.out.println(data[N]);
    }
}
