package algo_202311;

import java.io.*;
import java.util.*;

public class RE_BJ_3020_개똥벌레 {
    public static int[] bottom;
    public static int[] top;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int halfN = N / 2;
        bottom = new int[H + 1];
        top = new int[H + 2];

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                int input = Integer.parseInt(br.readLine());
                bottom[input]++;
            } else {
                int input = Integer.parseInt(br.readLine());
                top[H-input+1]++;
            }
        }

        find(N, H);
    }

    public static void find(int N, int H){
        for(int i = 1; i <= H; i++){
            bottom[i] += bottom[i-1];
            top[H-i] += top[H-i+1];
        }

        int[] count = new int[N+1];
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= H; i++){
            int sum = bottom[H] - bottom[i-1] + top[1] - top[i+1];
            if(sum <= min){
                min = sum;
                count[min] ++;
            }
//            System.out.println("min: "+min);
//            System.out.println(Arrays.toString(count));
        }

        System.out.println(min + " " + count[min]);

    }

}
