package algo_202312;

import java.io.*;
import java.util.*;

public class BJ_1041_주사위 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] data = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        long result = 0;
        if (N == 1) {
            Arrays.sort(data);
            int sum = 0;
            for (int i = 0; i < 5; i++) {
                sum += data[i];
            }
            result = sum;
        } else {
            int[] twoSide = new int[4];
            twoSide[0] = data[1]+data[2];
            twoSide[1] = data[1]+data[3];
            twoSide[2] = data[2]+data[4];
            twoSide[3] = data[3]+data[4];
            int two = twoSide[0]; //2면 최소값
            int three = Integer.MAX_VALUE; //3면 최소값
            for (int i = 0; i < 4; i++) {
                two = Math.min(two,twoSide[i]);
                two = Math.min(two,data[0]+data[i+1]);
                two = Math.min(two,data[5]+data[i+1]);
                three = Math.min(three,twoSide[i]+data[0]);
                three = Math.min(three,twoSide[i]+data[5]);
            }
            Arrays.sort(data);
            int one = data[0];
            result = getOneSide(N,one) +getTwoSide(N,two) + getThreeSide(three);

        }

        System.out.println(result);
    }

    public static long getOneSide(long n , long value) {
        long mul = (n-1)*(n-2)*4 + (n*n - (4*n-4));

        return mul*value;
    }

    public static long getTwoSide(long n, long value) {
        long mul = 4*(n-1) + 4*(n-2);
        return mul*value;
    }

    public static long getThreeSide(long value) {
        return 4L*value;
    }
}
