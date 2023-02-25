import java.io.*;
import java.util.*;

public class BJ_17485_진우의달여행 {
    public static int N,M;
    public static int[][] data;
    public static int[][][] result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new int[N][M];
        int input;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                input = Integer.parseInt(st.nextToken());
                data[i][j] = input;
            }
        }

        result = new int[N][M][3];
        for(int i = 0; i < M; i++){
            Arrays.fill(result[0][i],data[0][i]);
        }
        for(int i = 1; i < N; i++){
            for(int j = 0; j < M; j++){
                Arrays.fill(result[i][j],Integer.MAX_VALUE);
            }
        }


        find();

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < M; i++){
            for(int j = 0; j < 3; j++){
                if(result[N-1][i][j] != 0){
                    ans = Math.min(ans, result[N-1][i][j]);
                }
            }
        }
        System.out.println(ans);

    }
    public static boolean valid(int x, int y){
        if(x>=0 && x < N && y >=0 && y < M){
            return true;
        }
        return false;
    }
    public static void find(){
        int nx,ny;
        for(int i = 0; i < N-1; i++){
            for(int j = 0; j < M; j++) {
                nx = i + 1;

                if(valid(i+1,j-1)){ //왼쪽 진행
                    result[i+1][j-1][0] = Math.min(result[i][j][1],result[i][j][2])+data[i+1][j-1];
                }
                if(valid(i+1,j)){ //아래쪽 진행
                    result[i+1][j][1] = Math.min(result[i][j][0],result[i][j][2])+data[i+1][j];
                }
                if(valid(i+1,j+1)){ // 오른쪽 진행
                    result[i+1][j+1][2] = Math.min(result[i][j][0],result[i][j][1])+data[i+1][j+1];
                }
            }
        }
    }



}
