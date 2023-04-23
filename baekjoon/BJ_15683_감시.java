package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_15683_감시 {
    public static int N,M,size,result;
    public static int[][] data;
    public static ArrayList<int[]> fiveCCTV; // 5 CCTV 좌표 얘는 안돌려도 되니 먼저 적용시킴
    public static ArrayList<CCTV> cctvs; //1~4 CCTV 좌표
    public static int[] dx = {0,-1,0,1};
    public static int[] dy = {1,0,-1,0}; // 동 북 서 남
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new int[N][M];
        fiveCCTV = new ArrayList<>();
        cctvs = new ArrayList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                int input = Integer.parseInt(st.nextToken());
                if(input == 5){
                    fiveCCTV.add(new int[]{i,j});
                }
                if(input > 0 && input <5){
                    cctvs.add(new CCTV(i,j,input));
                }
                data[i][j] = input;
            }
        }

        int nx,ny;
        for(int[] point : fiveCCTV){
            for(int d = 0; d < 4; d++){
                nx = point[0] + dx[d];
                ny = point[1] +dy[d];
                while(nx >= 0 && nx< N && ny >= 0&& ny < M && data[nx][ny] !=6){
                    if(data[nx][ny] == 0){
                        data[nx][ny] = 9;
                    }
                    nx +=dx[d];
                    ny += dy[d];
                }
            }
        }
        size = cctvs.size();
        result = Integer.MAX_VALUE;
//        printMap(data);
        dfs(0,data);
        System.out.println(result);
    }

    public static void dfs(int idx, int[][] map){
        if(idx == size){
            result = Math.min(result,countMap(map));
            return;
        }

        CCTV cctv = cctvs.get(idx);
        if(cctv.num != 2){
            for(int i = 0; i < 4; i++){
                dfs(idx+1, search(cctv,map,i));
            }
        }else{
            for(int i = 0; i < 2; i++){
                dfs(idx+1,search(cctv,map,i));
            }
        }
    }

    public static int[][] search(CCTV cctv, int[][] map, int direction){
        int[][] copy = copyMap(map);

        go(cctv,copy,direction);
        if(cctv.num == 2){
//            go(cctv,copy,direction);
            go(cctv,copy,(direction+2)%4);
        }
        if(cctv.num == 3){
//            go(cctv,copy,direction);
            go(cctv,copy,(direction+1)%4);
        }
        if(cctv.num == 4){
//            System.out.println(4);
//            go(cctv,copy,direction);
            go(cctv,copy,(direction+1)%4);
            go(cctv,copy,(direction+2)%4);

        }
//        printMap(copy);
//        System.out.println("//////");
        return copy;
    }

    public static void go(CCTV cctv, int[][] map , int direction){
        int nx, ny;
        nx = cctv.x + dx[direction];
        ny = cctv.y +dy[direction];
        while(nx >= 0 && nx < N && ny >= 0 && ny < M && data[nx][ny] != 6){
            if(map[nx][ny] == 0){
                map[nx][ny] = 9;
            }
            nx += dx[direction];
            ny += dy[direction];
        }
    }


    public static int[][] copyMap(int[][] map){
        int[][] copy = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                copy[i][j] = map[i][j];
            }
        }
        return copy;
    }

    public static int countMap(int[][] map){
        int cnt = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static class CCTV{
        int x,y,num;
        public CCTV(int x, int y , int num){
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    public static void printMap(int[][] map){
        for(int i = 0; i < N; i++){
            System.out.println(Arrays.toString(map[i]));
        }
    }
}
