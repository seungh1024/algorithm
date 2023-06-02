package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_17779_게리맨더링2 {
    public static int x,y,d1,d2;
    public static int N;
    public static int[][] data;
    public static int[] sum;
    public static int[][] check;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static int result;
    public static int totalCnt;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N+1][N+1];
        totalCnt = 0;
        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                int input = Integer.parseInt(st.nextToken());
                data[i][j] = input;
                totalCnt+=input;
            }
        }

        result = Integer.MAX_VALUE;
        find();
        System.out.println(result);
    }

    public static void find(){
        for(int i = 1; i <=N; i++){
            for(int j = 1; j <= N; j++){
                x = i;
                y = j;
                makeLine();
            }
        }
    }

    public static void makeLine(){
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                d1 = i;
                d2 = j;
                if(x < x+d1+d2 && x+d1+d2<=N && y-d1>=1 && y-d1<y && y<y+d2 && y+d2<=N){
                    markFive();
                    sum = new int[6];
                    mark(1,x+d1-1,1,y,1);
                    mark(1,x+d2,y+1,N,2);
                    mark(x+d1,N,1,y-d1+d2-1,3);
                    mark(x+d2+1,N,y-d1+d2,N,4);
                    sum[5] = totalCnt-sum[1]-sum[2]-sum[3]-sum[4];
                    Arrays.sort(sum);
                    result = Math.min(Math.abs(sum[5]-sum[1]),result);
                }
            }
        }
    }


    public static void markFive(){
        check = new int[N+1][N+1];
        for(int i = 0; i<=d1;i++){
            check[x+i][y-i] = 5;
            check[x+d2+i][y+d2-i] = 5;
        }
        for(int i = 0; i <= d2; i++){
            check[x+i][y+i] = 5;
            check[x+d1+i][y-d1+i] = 5;
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x+d1,y-d1+1});
        q.offer(new int[]{x+d2,y+d2-1});
        check[x+d1][y-d1+1] = 5;
        check[x+d2][y+d2-1] = 5;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int d = 0; d < 4; d++){
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                if(nx>= 1 && nx <= N && ny >= 1 && ny <= N && check[nx][ny] != 5){
                    q.offer(new int[]{nx,ny});
                    check[nx][ny] = 5;
                }
            }
        }
    }

    public static void mark(int xl, int xr, int yl, int yr, int num){
        for(int i = xl; i <= xr; i++){
            for(int j = yl; j <= yr; j++){
                if(check[i][j] != 5){
                    sum[num] += data[i][j];
                }
            }
        }
    }

    public static void printCheck(){
        System.out.println("x: "+x+", y: "+y +", d1: "+d1+ ", d2: "+d2);
        for(int i = 0; i <= N; i++){
            System.out.println(Arrays.toString(check[i]));
        }
        System.out.println("//////////////");
    }
}
