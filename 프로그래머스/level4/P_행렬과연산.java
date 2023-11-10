package algo_202311;

import java.io.*;
import java.util.*;

public class P_행렬과연산 {
    public static int R,C;
    public static Deque<Integer>[] dq; //왼쪽이 first 오른쪽이 last
    public static Deque<Integer> left; // 위가 first
    public static Deque<Integer> right; // 아래가 first
    public static int start, end; // shift 했을 때 포인터

    public static void main(String[] args) {
        P_행렬과연산 test = new P_행렬과연산();
        int[][] rc = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        String[] operations = {"ShiftRow","Rotate", "ShiftRow","Rotate"};
        int[][] result = test.solution(rc,operations);
        if(isSame(result)){
            System.out.println("success");
        }else{
            System.out.println("fail");
        }
    }

    public static boolean isSame(int[][] result){
        int[][] data = {{1,6,7,8},{5,9,10,4},{2,3,12,11}};

        int r = result.length;
        int c = result[0].length;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(result[i][j] != data[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    public int[][] solution(int[][] rc, String[] operations) {
        R = rc.length;
        C = rc[0].length;
        start = 0;
        end = R-1;

        dq = new ArrayDeque[R];
        for(int i = 0; i < R; i++){
            dq[i] = new ArrayDeque<>();
        }
        int dqSize = C-1;
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();

        for(int i = 0; i < R; i++){
            for(int j = 1; j < dqSize; j++){
                dq[i].addLast(rc[i][j]);
            }
            left.addLast(rc[i][0]);
            right.addFirst(rc[i][C-1]);
        }


        for(String s : operations){
            if(s.equals("ShiftRow")){
                shiftRow();
            }else if(s.equals("Rotate")){
                rotate();
            }
        }

        return makeRC();
        // return rc;
    }

    public static void shiftRow(){
        left.addFirst(left.pollLast());
        right.addLast(right.pollFirst());

        start = end;
        end = (end+R-1)%R;

    }

    public static void rotate(){
        dq[start].addFirst(left.pollFirst());
        right.addLast(dq[start].pollLast()); // 위에서 오른쪽을 오른쪽에다 넣음
        dq[end].addLast(right.pollFirst()); // 오른쪽 아래거 맨 밑에다 넣음
        left.addLast(dq[end].pollFirst());
    }

    public static int[][] makeRC(){
        int[][] rc = new int[R][C];
        int dqSize = C-1;
        for(int i = 0; i < R; i++){
            int index = (start+i)%R;
            for(int j = 1; j < dqSize; j++){
                rc[i][j] = dq[index].pollFirst();
            }
            rc[i][0] = left.pollFirst();
            rc[i][dqSize] = right.pollLast();
            // System.out.println(Arrays.toString(rc[i]));
        }

        return rc;
    }
}