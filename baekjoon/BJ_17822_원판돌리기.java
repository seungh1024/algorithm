package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_17822_원판돌리기 {
    public static int N,M,T;
    public static int[][] data;

    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        data = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                int input = Integer.parseInt(st.nextToken());
                data[i][j] = input;

            }
        }
        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            move(x,d,k);
        }

        int result = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(data[i][j] > 0) result+=data[i][j];
            }
        }
        System.out.println(result);

    }

    // d = 0 -> 시계방향, d = 1 -> 반시계 방향
    public static void move(int x, int d, int k){
        int mul = 1;
        while(x*mul<=N){
            rotate(x*mul-1,d,k); //0부터 시작하니 i-1해줌
            mul++;
        }
        int total = 0;
        int totalCnt = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(data[i][j]>0){
                    total+=data[i][j];
                    totalCnt++;
                }
            }
        }

        if(total>0){
            find(total, totalCnt);
        }
    }
    public static void find(int total, int totalCnt){
        boolean[][] visited = new boolean[N][M];
        int cnt = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j] && data[i][j]>0){
                    cnt += bfs(i,j,visited);
                }
            }
        }

        if(cnt > 0){
            for(int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (visited[i][j]) {
                        data[i][j] = 0;
                    }
                }
            }

        }else{
            double num = (double)total/(double)totalCnt;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(data[i][j] > 0){
                        if(data[i][j] > num){
                            data[i][j] -= 1;
                        }else if(data[i][j] < num){
                            data[i][j] += 1;
                        }
                    }
                }
            }
        }


    }
    public static int bfs(int x, int y, boolean[][]visited){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;
        int cnt = 0;
        while(!q.isEmpty()){
            int[] now = q.poll();
            int value = data[now[0]][now[1]];
            for(int d = 0; d < 4; d++){
                int nx = now[0] + dx[d];
                int ny = (now[1] + dy[d])%M;
                if(ny<0) ny = M-1;
                if(ny>=M) ny = 0;
                if(nx>= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && data[nx][ny] == value){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                    cnt++;
                }

            }
        }

        if(cnt>0){
            return cnt+1;
        }else{
            visited[x][y] = false;
            return 0;
        }
    }

    public static void rotate(int x, int d, int k){
        int idx = 0;
        if(d == 0){
            idx = k;
        }else{
            idx = M-k%M;
        }

        int[] copy = new int[M];
        for(int i = 0; i < M; i++) {
            copy[(i + idx) % M] = data[x][i];
        }
        for(int i = 0; i < M; i++){
            data[x][i] = copy[i];
        }
    }

    public static void printData(){
        for(int i = 0; i < N; i++){
            System.out.println(Arrays.toString(data[i]));
        }
    }
}

//6 5 10
//1 2 3 2 1
//4 5 4 2 3
//6 8 2 1 2
//7 6 2 8 8
//3 2 4 2 8
//5 8 2 1 1
//2 0 2
//2 1 4
//6 1 2