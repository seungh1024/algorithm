package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_1063_킹 {
    public static char[] row = {'8','7','6','5','4','3','2','1'};
    public static char[] col = {'A','B','C','D','E','F','G','H'};
    public static int[] king = {0,0};
    public static int[] stone = {0,0};
    public static int N;
    public static int[] dx = {0,0,1,-1,-1,-1,1,1};
    public static int[] dy = {1,-1,0,0,1,-1,1,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] inputKing = st.nextToken().toCharArray();
        char[] inputStone = st.nextToken().toCharArray();
        changeInt(inputKing,king);
        changeInt(inputStone,stone);

        N = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++){
            String input = br.readLine();
            move(input);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(col[king[1]]).append(row[king[0]]).append("\n").append(col[stone[1]]).append(row[stone[0]]);
        System.out.println(sb);
    }
    public static void move(String input){
        int d = 0;
        if(input.equals("L")){
            d = 1;
        }else if(input.equals("B")){
            d = 2;
        }else if(input.equals("T")){
            d = 3;
        }else if(input.equals("RT")){
            d = 4;
        }else if(input.equals("LT")){
            d = 5;
        }else if(input.equals("RB")){
            d = 6;
        }else if(input.equals("LB")){
            d = 7;
        }

        int nx = king[0] + dx[d];
        int ny = king[1] + dy[d];
        if(nx >= 0 && nx < 8 && ny >= 0 && ny < 8){
            if(nx == stone[0] && ny == stone[1]){ // 돌과 겹치는 경우
                int sx = stone[0] + dx[d];
                int sy = stone[1] + dy[d];
                if(sx >= 0 && sx < 8 && sy >= 0 && sy < 8){
                    stone[0] = sx;
                    stone[1] = sy;
                }else{
                    return;
                }
            }
            king[0] = nx;
            king[1] = ny;
        }
    }

    public static void changeInt (char[] input, int[] data){
        for(int i = 0; i < 8; i++){
            if(col[i] == input[0]){
                data[1] = i;
                break;
            }
        }
        for(int i = 0; i < 8; i++){
            if(row[i] == input[1]){
                data[0] = i;
                break;
            }
        }
    }
}
