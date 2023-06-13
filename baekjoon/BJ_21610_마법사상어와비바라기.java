package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_21610_마법사상어와비바라기 {
    public static int N,M;
    public static int[][] data;
    public static Queue<int[]> cloud;
    public static int cloudSize;
    public static boolean[][] cloudCheck;
    public static int[] dx = {0, 0,-1,-1,-1,0,1,1,1}; // 1부터 8까지
    public static int[] dy = {0, -1,-1,0,1,1,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cloud = new LinkedList<>();
        initCloud();
        for(int i =0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            move(d,s);
            copyBug();
//            printData();
            setCloud();
//            System.out.println("?");
        }
        int result = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                result += data[i][j];
            }
        }
        System.out.println(result);
    }
    public static void setCloud(){
        cloudSize = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(data[i][j] >= 2 && !cloudCheck[i][j]){
                    cloud.offer(new int[]{i,j});
                    data[i][j] -= 2;
                    cloudSize++;
                }
            }
        }
    }
    public static void copyBug(){
        cloudCheck = new boolean[N][N];
        for(int cs = 0; cs < cloudSize; cs++){
            int[] now = cloud.poll();
            int x = now[0];
            int y = now[1];
            int cnt = 0;
            for(int d = 2; d <= 8; d+=2){
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx >= 0 && nx < N && ny >= 0 && ny < N && data[nx][ny] > 0){
                    cnt++;
//                    System.out.println("?");
                }
            }
            data[x][y] += cnt;
            cloudCheck[x][y] = true;
        }
    }
    public static void move(int d, int s){
        for(int cs = 0; cs < cloudSize; cs++){
            int[] now = cloud.poll();
            int x = now[0];
            int y = now[1];
            now[0] = (x + (N+ dx[d]*s%N))%N;
            now[1] = (y+ (N + dy[d]*s%N))%N;
//            System.out.println("x : "+now[0] + ", y: "+now[1]);
            data[now[0]][now[1]]++;
            cloud.offer(now);
        }
//        System.out.println("///////////////////////");
    }

    public static void printData(){
        for(int i = 0; i < N; i++){
            System.out.println(Arrays.toString(data[i]));
        }
    }

    public static void initCloud(){
        cloud.offer(new int[]{N-1,0});
        cloud.offer(new int[]{N-1,1});
        cloud.offer(new int[]{N-2,0});
        cloud.offer(new int[]{N-2,1});
        cloudSize = 4;
    }
}
