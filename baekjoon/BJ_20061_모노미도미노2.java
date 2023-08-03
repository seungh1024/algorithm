package algo_202308;

import java.io.*;
import java.util.*;

public class BJ_20061_모노미도미노2 {
    public static int[][] green;
    public static int[][] blue;

    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static int[][] block;
    public static int result, totalCnt;
    public static void main(String[] args) throws IOException{
        init();
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int blockSize = 0;
            if(t == 1){
                blockSize = 1;
                block[0][0] = x;
                block[0][1] = y;
            }else if(t==2){
                blockSize = 2;
                block[0][0] = x;
                block[0][1] = y;
                block[1][0] = x;
                block[1][1] = y+1;
            }else if(t==3){
                blockSize = 2;
                block[0][0] = x;
                block[0][1] = y;
                block[1][0] = x+1;
                block[1][1] = y;
            }
            moveBlock(blockSize, green); // 초록색 이동
            blockChange();
            moveBlock(blockSize, blue); // 파란색 이동
//            printBlock();
            bingo(green);
            bingo(blue);
//            printBlock();
            specialDown(green);
            specialDown(blue);
//            printBlock();
        }
        countTotalBlock();
        System.out.println(result);
        System.out.println(totalCnt);
    }

    private static void countTotalBlock() {
        for(int i = 4; i < 10; i++){
            for(int j = 0; j < 4;j ++){
                if(green[i][j] == 1){
                    totalCnt++;
                }
                if(blue[i][j] == 1){
                    totalCnt++;
                }
            }
        }
    }

    private static void specialDown(int[][] board){
        int specialCount = 0;
        for(int i = 4; i < 6; i++){ // 4~5번 칸에 있는지 확인
            for(int j = 0; j < 4; j++){
                if(board[i][j] == 1){
                    specialCount++;
                    break;
                }
            }
        }
        for(int sc = 0; sc < specialCount; sc++){
            for(int i = 9; i >3; i--){
                for(int j = 0; j < 4; j++){
                    board[i][j] = board[i-1][j];
                }
            }
        }
    }
    private static void bingo(int[][] board){
        for(int i = 4; i < 10; i++){
            boolean breakCheck = false;
            for(int j = 0; j < 4; j++){
                if(board[i][j] == 0){
                    breakCheck = true;
                    break;
                }
            }
            if(!breakCheck){ // 한 줄이 전부 1이면 빙고
                result++;
                for(int j = 0; j < 4; j++){
                    board[i][j] = 0;
                }

                for(int x = i; x >0; x--){
                    for(int y = 0; y < 4; y++){
                        board[x][y] = board[x-1][y];
                    }
                }
            }
        }

    }


    private static void moveBlock(int blockSize, int[][] board){
        int length = 1;
        boolean outCheck = false;
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < blockSize; j++){
                int x =  block[j][0]+length;
                int y = block[j][1];
                if(!isBoardValid(x,y,board)){ //갈 수 없으면 탈출
                    outCheck = true;
                    break;
                }
            }
            if(outCheck){ // 이동 못하면 탈출
                break;
            }
            length++;// 이동 가능하면 +1
        }
        length--;

        for(int i = 0; i < blockSize; i++){
            int x = block[i][0]+length;
            int y = block[i][1];
            board[x][y] = 1;
        }
    }

    private static void printBlock(){
        System.out.println("======= green ===========");
        for(int i = 0; i < 10; i++){
            System.out.println(Arrays.toString(green[i]));
        }
        System.out.println("======= blue ===========");
        for(int i = 0; i < 10; i++){
            System.out.println(Arrays.toString(blue[i]));
        }
//        System.out.println("result: "+ result);
    }
    private static boolean isBoardValid(int x, int y, int[][] board){
        if(x == 10 || board[x][y] != 0){
            return false;
        }
        return true;
    }
    // block x,y 변환 x = y, y = 3-x;
    private static void blockChange(){
        for(int i = 0; i < 2; i++){
            int x = block[i][0];
            int y = block[i][1];
            block[i][0] = y;
            block[i][1] = 3-x;
        }
    }

    private static void init(){
        green = new int[10][4];
        blue = new int[10][4];
        block = new int[2][2];
        result = 0;
        totalCnt = 0;
    }
}
