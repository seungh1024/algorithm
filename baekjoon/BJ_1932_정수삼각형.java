import java.io.*;
import java.util.*;

public class BJ_1932_정수삼각형 {
    public static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] before = new int[1];
        before[0] = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 2; i <= N; i++){
            int[] now = new int[i];
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < i; j++){
                now[j] = Integer.parseInt(st.nextToken());
            }
            for(int j = 0; j < i; j++){
                if(j-1 < 0){
                    now[j] = now[j] + before[j];
                }else if(j+1 >= i){
                    now[j] = now[j] + before[j-1];
                }else{
                    now[j] = Math.max(now[j] +before[j-1], now[j]+before[j]);
                }
            }

            before = now;
        }

        Arrays.sort(before);
        System.out.println(before[N-1]);

    }
}
