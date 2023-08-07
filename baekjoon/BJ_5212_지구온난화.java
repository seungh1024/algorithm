package algo_202308;

import java.io.*;
import java.util.*;

public class BJ_5212_지구온난화 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] data = new char[R][C];
        ArrayList<int[]> land = new ArrayList<>();
        for(int i = 0; i < R; i++){
            char[] input = br.readLine().toCharArray();
            for(int j = 0; j < C; j++){
                data[i][j] = input[j];
                if(input[j] == 'X'){
                    land.add(new int[] {i,j});
                }
            }
        }
        find(R,C,data,land);
    }

    public static void find(int R, int C, char[][] data, List<int[]> land){
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        ArrayList<int[]> sinkDown = new ArrayList<>();
        ArrayList<int[]> alive = new ArrayList<>();
        for(int[] now : land){
            int x = now[0];
            int y = now[1];
            int seaCnt = 0;
            for(int d = 0; d < 4; d++){
                int nx = x+dx[d];
                int ny = y+dy[d];
                if(nx >= 0 && nx < R && ny >= 0 && ny < C){
                    if(data[nx][ny] == '.'){
                        seaCnt++;
                    }
                }else{
                    seaCnt++;
                }
            }
            if(seaCnt >= 3){
                sinkDown.add(now);
            }else{
                alive.add(now);
            }
        }

        for(int[] sink : sinkDown){
            data[sink[0]][sink[1]] = '.';
        }

        int minX = R;
        int minY = C;
        int maxX = 0;
        int maxY = 0;
        for(int[] now : alive){
            minX = Math.min(minX,now[0]);
            minY = Math.min(minY,now[1]);
            maxX = Math.max(maxX,now[0]);
            maxY = Math.max(maxY,now[1]);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = minX; i <= maxX; i++){
            for(int j = minY; j <= maxY; j++){
                sb.append(data[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
