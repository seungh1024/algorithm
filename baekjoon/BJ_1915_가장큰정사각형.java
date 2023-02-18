import java.io.*;
import java.util.*;

public class BJ_1915_가장큰정사각형 {
    public static int N,M;
    public static int result;
    public static boolean[] check;
    public static int[][] data;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new int[N+1][M+1];
        char[] input;
        for(int i = 1; i <= N; i++){
            input = br.readLine().toCharArray();
            for(int j = 1; j <= M; j++){
                data[i][j] = input[j-1] - '0'
                        + data[i-1][j]
                        + data[i][j-1]
                        - data[i-1][j-1];
            }
        }

        check = new boolean[N*N+1];
        for(int i = 0; i <= N; i++){
            check[i*i] = true;
        }

        result = 0;
        int sum = 0;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                int size = Math.min(i,j);
                for(int s = 1; s <= size; s++){
                    sum = data[i][j] -data[i][j-s] -data[i-s][j] + data[i-s][j-s];
//                    System.out.println(sum);
                    if(!check[sum] || sum < s*s) break;
                    result = Math.max(result,sum);
                }
            }
        }
        System.out.println(result);
    }
}

