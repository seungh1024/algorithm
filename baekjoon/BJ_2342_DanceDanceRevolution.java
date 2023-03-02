import java.io.*;
import java.util.*;

public class BJ_2342_DanceDanceRevolution {
    public static int N;
    public static int[][][] dp;
    public static ArrayList<Integer> data;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = 1;
        int input;
        data = new ArrayList<>();
        data.add(0);
        while(true){
            input = Integer.parseInt(st.nextToken());
            if(input == 0){
                break;
            }
            N++;
            data.add(input);
        }
        dp = new int[N][5][5];
//        System.out.println(N);

        System.out.println(find(0,0,0));
    }
    public static int find(int index, int left, int right){
        //끝까지 갔으면 0리턴해서 power값만 남도록. 즉 이전지점에서 현재 지점으로 이동한 힘만 남도록
        // N으로 하지않는 이유는 N-2 -> N-1까지 이동하는게 마지막 이동이기 떄문
        // N-1에서 더 이동하지 않기 때문에 멈춰야함
        if(index == N-1){
            return 0;
        }
        if(dp[index][left][right] != 0){ //이미 구했으면 바로 리턴
            return dp[index][left][right];
        }

        // index+1부터하면 1부터 시작함. data 인덱스를 1부터 넣어줬기 때문에 처음부터 시작하는 것임
        // 이동하는 발의 경우 data[index+1]을 넣어줌으로써 해당 위치로 이동시킴
        // 재귀호출을 통해 모르는 값을 계속 재귀적으로 호출하여 가장 마지막부터 찾아오는 top-down 방식.
        // bottom-up으로 하지 않으니 전체 배열을 계산해줄 필요가 없다.
        int leftValue = find(index+1, data.get(index+1),right) + power(left,data.get(index+1));
        int rightValue = find(index+1, left, data.get(index+1)) + power(right,data.get(index+1));

        dp[index][left][right] = Math.min(leftValue,rightValue);

        return dp[index][left][right];
    }

    public static int power(int from, int to){
        if(from == 0){ //처음자리면 2 리턴
            return 2;
        }
        if(from == to){ //같은 위치면 1 리턴
            return 1;
        }
        if(Math.abs(from-to) == 2){ // 반대 방향인 경우 2만큼 차이남 (1,3), (2,4)
            return 4;
        }
        return 3;
    }
}
