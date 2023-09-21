package algo_202309;

import java.io.*;
import java.util.*;

public class BJ_17281_야구 {
    public static int N;
    public static int[] line;
    public static boolean[] visited;
    public static int[][] data;
    public static int result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        data = new int[N][9];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++){
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        line = new int[9];
//        line[3] = 0;
        visited = new boolean[9];
        visited[0] = true;
        result = 0;
        find(0);
//        line = new int[] {1,2,3,0,4,5,6,7,8};
//        makePoint();
        System.out.println(result);
    }

    public static void find(int index){
        if(index==9){
            result = Math.max(result,makePoint());
            return;
        }

        if(index == 3) {
            index++;
        }
        for(int i = 1; i < 9; i++){
            if(!visited[i]){
                visited[i] = true;
                line[index] = i;
                find(index+1 );
                visited[i] = false;
            }
        }
    }

    public static int makePoint(){
        int idx = 0;
        int outCount = 0;
        int point = 0;
        for(int i = 0; i < N; i++){
            boolean[] base = new boolean[3];
            outCount = 0;
            while(outCount < 3){
//                System.out.println(line[idx]);
                if(data[i][line[idx]] == 0){
                    outCount++;
                }else if(data[i][line[idx]] == 1){
                    if(base[2]){
                        point++;
                        base[2] = false;
                    }
                    for(int j = 1; j >= 0; j--){
                        base[j+1] = base[j];
                        base[j] = false;
                    }
                    base[0] = true;
                }else if(data[i][line[idx]] == 2){
                    for(int j = 2; j>= 1; j--){
                        if(base[j]){
                            point++;
                            base[j] = false;
                        }
                    }
                    base[2] = base[0];
                    base[0] = false;
                    base[1] = true;

                }else if(data[i][line[idx]] == 3){
                    for(int j = 2; j >= 0; j--){
                        if(base[j]){
                            point++;
                            base[j] = false;
                        }
                    }
                    base[2] = true;

                }else if(data[i][line[idx]] == 4){ // 홈런
//                    System.out.println("?");
                    for(int j = 0; j < 3; j++){
                        if(base[j]){
                            point++;
                            base[j] = false;
                        }
                    }
                    point++;
                }
                idx = (idx+1)%9;
            }
//            System.out.println("point: "+point);
        }
        return point;
    }
}

//50
//1 2 4 3 0 2 1 0 3
//1 2 1 2 0 0 0 0 1
//3 4 2 3 1 2 3 4 0
//0 1 2 3 4 2 1 0 0
//0 0 0 0 0 0 1 4 4
//0 4 0 4 0 4 0 4 0
//0 4 2 2 2 2 2 2 2
//1 1 1 1 1 1 1 1 0
//0 2 0 3 0 1 0 2 0
//1 2 4 3 0 2 1 0 3
//1 2 1 2 0 0 0 0 1
//3 4 2 3 1 2 3 4 0
//0 1 2 3 4 2 1 0 0
//0 0 0 0 0 0 1 4 4
//0 4 0 4 0 4 0 4 0
//0 4 2 2 2 2 2 2 2
//1 1 1 1 1 1 1 1 0
//0 2 0 3 0 1 0 2 0
//1 2 4 3 0 2 1 0 3
//1 2 1 2 0 0 0 0 1
//3 4 2 3 1 2 3 4 0
//0 1 2 3 4 2 1 0 0
//0 0 0 0 0 0 1 4 4
//0 4 0 4 0 4 0 4 0
//0 4 2 2 2 2 2 2 2
//1 1 1 1 1 1 1 1 0
//0 2 0 3 0 1 0 2 0
//1 2 4 3 0 2 1 0 3
//1 2 1 2 0 0 0 0 1
//3 4 2 3 1 2 3 4 0
//0 1 2 3 4 2 1 0 0
//0 0 0 0 0 0 1 4 4
//0 4 0 4 0 4 0 4 0
//0 4 2 2 2 2 2 2 2
//1 1 1 1 1 1 1 1 0
//0 2 0 3 0 1 0 2 0
//1 2 4 3 0 2 1 0 3
//1 2 1 2 0 0 0 0 1
//3 4 2 3 1 2 3 4 0
//0 1 2 3 4 2 1 0 0
//0 0 0 0 0 0 1 4 4
//0 4 0 4 0 4 0 4 0
//0 4 2 2 2 2 2 2 2
//1 1 1 1 1 1 1 1 0
//0 2 0 3 0 1 0 2 0
//3 4 2 3 1 2 3 4 0
//0 1 2 3 4 2 1 0 0
//0 0 0 0 0 0 1 4 4
//0 4 0 4 0 4 0 4 0
//0 4 2 2 2 2 2 2 2