package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_11559_PuyoPuyo {
    public static char[][] data;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        data = new char[12][6];
        for(int i = 0; i < 12; i++){
            char[] input = br.readLine().toCharArray();
            for(int j = 0; j < 6; j++){
                data[i][j] = input[j];
            }
        }

        int result = 0;
        while(true){
            int cnt = 0;
            visited = new boolean[12][6];
            for(int j = 0; j < 6; j++){
                for(int i = 11; i >= 0; i--){
                    if(data[i][j] != '.' && !visited[i][j]){
                        cnt += find(i,j);
//                        System.out.println(cnt);
//                        System.out.println(i+ " , "+j);
//                        printData();
//                        System.out.println("///////////");
                    }else{
                        continue;
                    }
                }
            }
            if(cnt > 0){
                down();
                result++;
//                printData();
            }else{
                break;
            }
//            printData();

        }
        System.out.println(result);
    }
    public static void printData(){
        for(int i = 0; i < 12; i++){
            System.out.println(Arrays.toString(data[i]));
        }
    }
    public static void down(){
        int start = 0;
        int end = 0;
        int idx = 0;

        for(int j = 0; j < 6; j++){
            for(int i = 11; i >= 0; i--){
                if(data[i][j] != '.'){
                    idx = i+1;
                    while(idx<12){
                        if(data[idx][j] != '.'){
//                            System.out.println(idx + ", "+i+" ,"+j +", "+data[idx][j]);
//                            System.out.println("zz");
                            break;
                        }
                        idx++;
                    }
                    data[idx-1][j] = data[i][j];
                    if(idx-1 != i){
                        data[i][j] = '.';
                    }
//                    printData();

                }
            }
        }
    }

    public static int find(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;
        int cnt = 1;
        char color = data[x][y];
        ArrayList<int[]> list = new ArrayList<>();
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int d = 0; d < 4; d++){
                int nx = now[0]+dx[d];
                int ny = now[1]+dy[d];
                if(nx >= 0 && nx < 12 && ny >= 0 && ny < 6 && !visited[nx][ny] && color == data[nx][ny]){
                    cnt++;
//                    data[nx][ny] = '.';
                    visited[nx][ny] = true;
                    int[] input = {nx,ny};
                    list.add(input);
                    q.offer(input);
                }
            }
        }
        if(cnt >= 4){
            data[x][y] = '.';
            for(int[] now : list){
                data[now[0]][now[1]] = '.';
            }
            return 1;
        }else{
            return 0;
        }
    }
}

//......
//......
//......
//......
//......
//......
//.Y....
//.Y....
//.Y....
//.YG...
//RRYGG.
//RRYGG.