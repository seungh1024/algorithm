package algo_202307;

import java.io.*;
import java.util.*;

public class BJ_16956_늑대와양 {
    public static int R,C;
    public static char[][] data;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        data = new char[R][C];
        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 0; i< R; i++){
            char[] input = br.readLine().toCharArray();
            for(int j = 0; j < C; j++){
                if(input[j] == '.'){
                    data[i][j] = 'D';
                }else{
                    data[i][j] = input[j];
                }

                if(input[j] == 'W'){
                    list.add(new int[]{i,j});
                }
            }
        }
        int result = 1;
        for(int[] p : list){
            for(int d = 0; d < 4; d++){
                int nx = p[0]+dx[d];
                int ny = p[1]+dy[d];
                if(nx>= 0 && nx < R && ny >= 0 && ny < C && data[nx][ny] == 'S'){
                    result = 0;
                    System.out.println(result);
                    return;
                }
            }
        }
        System.out.println(result);
        printData();
    }
    public static void printData(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                sb.append(data[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
