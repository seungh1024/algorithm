package algo_202308;

import java.io.*;
import java.util.*;

public class BJ_14889_스타트와링크 {
    public static int N;
    public static int[][] data;
    public static boolean[] choose;
    public static int result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int [N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        choose = new boolean[N];
        result = Integer.MAX_VALUE;
        find(0,0);
        System.out.println(result);
    }
    public static void find(int index, int count){
        if(count == N/2){
            int startTeam = 0;
            int linkTeam = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(i!=j && choose[i] == choose[j]){
                        if(choose[i]){
                            startTeam+= data[i][j];
                        }else{
                            linkTeam+= data[i][j];
                        }
                    }
                }
            }
//            System.out.println(Arrays.toString(choose));
//            System.out.println("startTema: "+startTeam + ", linkTeam: "+linkTeam);
            result = Math.min(result,Math.abs(startTeam - linkTeam));
            return;
        }
//        if(index == N){
//            return;
//        }
        for(int i = index; i < N; i++){
            choose[i] = true;
            find(i+1,count+1);
            choose[i] = false;
        }
//        find(index+1,count);
    }
}
