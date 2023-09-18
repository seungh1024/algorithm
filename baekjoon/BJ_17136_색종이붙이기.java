package algo_202309;

import java.io.*;
import java.util.*;

public class BJ_17136_색종이붙이기 {
    public static int[][] data;
    public static boolean[][] visited;
    public static int[] dx = {1,0};
    public static int[] dy = {0,-1};
    public static int result;
    public static int[] count = {0,5,5,5,5,5};
    public static int totalCount;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        data = new int[10][10];
        totalCount = 0;
        for(int i = 0; i < 10; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 10; j++){
                data[i][j] = Integer.parseInt(st.nextToken());
                if(data[i][j] == 1) totalCount++;
            }
        }

        result = Integer.MAX_VALUE;
        visited = new boolean[10][10];
        find(0,0,totalCount, 0);
        System.out.println(result==Integer.MAX_VALUE?-1:result);
    }

    /**
     *
     * @param x
     * @param y
     * @param total = total 1 count
     * @param cnt = paper count
     */
    public static void find(int x, int y, int total, int cnt){
        if(total == 0 || x>=10){
            result = Math.min(result,cnt);
            return;
        }
        if(result<=cnt) return;

        if(data[x][y] == 1 && !visited[x][y]){
            for(int i = 5; i > 0; i--){
                if(isValid(x,y,i) && count[i]>0){
                    visitedChange(x,y,i,true);
                    count[i]--;
                    if(y+i >=10){
                        find(x+1,0,total-(i*i),cnt+1);
                    }else{
                        find(x,y+i,total-(i*i), cnt+1);
                    }
                    count[i]++;
                    visitedChange(x,y,i,false);
                }
            }
        }else{
            if(y+1 >=10){
                find(x+1,0,total,cnt);
            }else{
                find(x,y+1,total, cnt);
            }
        }

    }

    public static boolean isValid(int x, int y, int size){
        if(x + size > 10 || y + size > 10) return false;
        for(int i = x; i < x+size; i++){
            for(int j = y; j < y+size; j++){
                if(visited[i][j] || data[i][j] == 0) return false;
            }
        }

        return true;
    }

    public static void visitedChange(int x, int y, int size,boolean value){
        for(int i = x; i < x+size; i++){
            for(int j = y; j < y+size; j++){
                visited[i][j] = value;
            }
        }
    }
}
