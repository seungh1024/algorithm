import java.io.*;
import java.util.*;

public class BJ_11659_구간합구하기4 {
    public static int N,M;
    public static int[] data;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new int[N+1];
        st = new StringTokenizer(br.readLine());
        int num;
        for(int i = 1 ; i <=N; i++){
            num = Integer.parseInt(st.nextToken());
            data[i] = data[i-1] + num;
        }
        int from, to;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            System.out.println(data[to] - data[from-1]);
        }

    }
}
