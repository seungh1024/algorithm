package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_12100_2048 {
    public static int N,result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] data = new int[N][N];
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(N == 1){
            System.out.println(data[0][0]);
            return;
        }

        result = 2;
        find(0,data);
        System.out.println(result);
    }
    public static void printMap(int[][] map){
        for(int i = 0; i < N; i++){
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println("////////////////");
    }
    public static void find(int time, int[][] map){
        if(time == 5){
            findMax(map);
//            printMap(map);
            return;
        }

        for(int i = 0; i < 4; i++){
            int[][] newMap = copyMap(map);
            moveMap(newMap,i);
//            System.out.println(i + ", "+result + ", time: "+time);
//            printMap(newMap);
            find(time+1,newMap);
        }
    }
    public static int[][] copyMap(int[][] map){
        int[][] copy = new int[N][N];
        for(int i = 0; i < N ;i++){
            for(int j = 0;j < N;j ++){
                copy[i][j] = map[i][j];
            }
        }
        return copy;
    }
    public static void findMax(int[][] map){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                result = Math.max(result,map[i][j]);
            }
        }
    }

    public static void moveMap(int[][] map, int num){
        boolean[][] sumCheck = new boolean[N][N];
        if(num == 0 ){ // 위로 이동하는 경우
            for(int i = 1; i < N; i++){ //위에서 아래로 탐색
                for(int j = 0; j < N; j++){
                    if(map[i][j] != 0){ // 블록이 있는 경우
                        int k = i-1;
                        int value = map[i][j];
//                        System.out.println(value);
//                        map[i][j] = 0;
                        while(true){
                            if(k < 0){
//                                map[k+1][j] = value;
                                break;
                            }
                            if(map[k][j] != 0){ //앞에 블록이 있는 경우
                                if(map[k][j] == map[k+1][j] && !sumCheck[k][j]){ //앞에거랑 현재랑 같다면 합쳐줌
                                    map[k][j] += map[k+1][j];
                                    map[k+1][j] = 0;
                                    sumCheck[k][j] = true;
                                }else{
//                                    map[k+1][j] = value;
                                }
                                break;
                            }
                            map[k][j] += map[k+1][j];
                            map[k+1][j] = 0;
                            k--;
                        }
                    }
                }
            }
        }

        if(num == 1){ //아래로 이동하는 경우
            for(int i = N-2; i >= 0; i--){ //아래에서 위로 탐색
                for(int j = 0;j < N; j++){
                    if(map[i][j] != 0){
                        int k = i +1;
                        int value = map[i][j];
//                        map[i][j] = 0;
//                        System.out.println(value);
                        while(true){
                            if(k == N){
//                                map[k-1][j] = value;
                                break;
                            }
                            if(map[k][j] != 0){ //아래에 블록이 있다면
                                if(map[k][j] == map[k-1][j] &&!sumCheck[k][j]){
                                    map[k][j] += map[k-1][j];
                                    map[k-1][j] = 0;
                                    sumCheck[k][j] = true;
                                }else{
//                                    map[k-1][j] = value;

                                }
                                break;
                            }
                            map[k][j] += map[k-1][j];
                            map[k-1][j] = 0;
                            k++;
                        }
                    }
                }
            }
        }

        if(num == 2){ //왼쪽으로 미는 경우
            for(int j = 1; j < N; j++){ //왼쪽에서 오른쪽으로 탐색
                for(int i = 0; i < N; i++){
                    if(map[i][j] != 0){ //블록이 있다면
                        int k = j-1; //왼쪽으로 이동하며 재탐색
//                        int value = map[i][j];
//                        map[i][j] = 0;
                        while(true){
                            if(k < 0){
//                                map[i][k+1] = value;
                                break;
                            }
                            if(map[i][k] != 0 ){
//                                System.out.println(map[i][k] +" , "+map[i][k+1]);
                                if(map[i][k] == map[i][k+1] &&!sumCheck[i][k]){
                                    map[i][k] += map[i][k+1];
                                    map[i][k+1] = 0;
                                    sumCheck[i][k] = true;
                                }else{
//                                    map[i][k+1] = value;
                                }
                                break;
                            }
                            map[i][k] += map[i][k+1];
                            map[i][k+1] = 0;

                            k--;
                        }
                    }
                }
            }
        }

        if(num == 3){ //으른쪽으로 미는 경우
            for(int j = N-2; j >= 0; j --){
                for(int i = 0; i < N; i++){
                    if(map[i][j] != 0){
                        int k = j+1;
//                        int value = map[i][j];
//                        map[i][j] = 0;
                        while(true){
                            if(k == N){
//                                map[i][k-1] =value;
                                break;
                            }
                            if(map[i][k] != 0){
                                if(map[i][k] == map[i][k-1] &&!sumCheck[i][k]){
                                    map[i][k] += map[i][k-1];
                                    map[i][k-1] = 0;
                                    sumCheck[i][k] = true;
                                }else{
//                                    map[i][k-1] = value;
                                }
                                break;
                            }
                            map[i][k] += map[i][k-1];
                            map[i][k-1] = 0;
                            k++;
                        }
                    }
                }
            }

        }
    }


}
