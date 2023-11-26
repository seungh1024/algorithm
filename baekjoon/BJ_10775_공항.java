package algo_202311;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_10775_공항 {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine()); // 게이트 수
        int P = Integer.parseInt(br.readLine()); // 비행기 수

        int[] gate = new int[G+1];
        initGate(gate,G);

        int count = 0;
        for(int i = 0; i < P; i++){
            int input = Integer.parseInt(br.readLine());
            if(isValid(gate,input)){
                count++;
                unionParent(gate,input);
            }else{
                break;
            }
//            System.out.println(Arrays.toString(gate));
        }
        System.out.println(count);
    }

    public static void initGate(int[] gate, int G){
        for(int i = 1; i <= G; i++){
            gate[i] = i;
        }
    }

    public static int getParent(int[] gate, int index){
        if(index == gate[index]) return index;

        return gate[index] = getParent(gate,gate[index]);
    }

    public static void unionParent(int[] gate, int input){
        int inputParent = getParent(gate,input);
        int changeParent = getParent(gate,inputParent-1);

        gate[input] = changeParent;
        gate[inputParent] = changeParent;

    }

    public static boolean isValid(int[] gate, int index){
        if(getParent(gate,index) == 0) return false;

        return true;
    }
}
