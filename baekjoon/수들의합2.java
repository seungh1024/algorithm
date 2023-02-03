import java.io.*;
import java.util.*;

public class 수들의합2 {
    public static int N,M;
    public static int[] data;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new int[N];

        st = new StringTokenizer(br.readLine());
        int result = 0;
        int sum = 0;
        int idx = 0;
        for(int i = 0; i <N; i++){
            data[i] = Integer.parseInt(st.nextToken());
            sum += data[i];

            while(sum > M && idx < i){
                sum -= data[idx];
                idx++;
            }
            if(sum == M){
                result++;
            }
        }
        System.out.println(result);

    }
}
