import java.io.*;
import java.util.*;

public class BJ_11062_카드게임 {
    public static int T,N;
    public static int[] data;
    public static int[][][] dp; //근우 입장에서의 데이터만 저장

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            N = Integer.parseInt(br.readLine());
            dp = new int[2][N][N];
            data = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                data[i] = Integer.parseInt(st.nextToken());
            }

            System.out.println(find(0,N-1,0));
        }
    }

    public static int find(int start, int end, int flag){
        // 이렇게 재귀로 안쪽에서부터 바깥으로 최적값을 찾아가니 최대, 최소 구하는게 가능함
        if(start == end) {
            if (flag == 0) {
                return dp[flag][start][end] = data[start];
            } else {
                return dp[flag][start][end] = 0;
            }
        }

        if(dp[flag][start][end] != 0){ //이미 찾은 값이면 더이상 재귀호출하지 않도록
            return dp[flag][start][end];
        }

        if(flag == 0){ //근우 차례
            // 왼쪽거 뽑았으면 왼쪽 인덱스 증가시켜 호출, 오른쪽거 뽑았으면 오른쪽 인덱스 -1 하고 호출
            //이 중 큰 값을 저장하면 근우턴에 최적 값이 나옴
            dp[flag][start][end] = Math.max(
                    find(start+1,end,1) + data[start],
                    find(start,end-1, 1) +data[end]
            );
        }else{//명우 차례엔 명우가 최선을 다하니 dp에는 minimum 값을 저장해야 함
            //data값을 더하지 않는 이유는 내 차례가 아니기 때문
            //최소값을 설정하는 이유는 여기서 더 높은 값을 명우가 먹을 것이기 때문
            dp[flag][start][end] = Math.min(
                    find(start+1,end,0) ,
                    find(start,end-1,0)
            );
        }

        return dp[flag][start][end];

    }
}
