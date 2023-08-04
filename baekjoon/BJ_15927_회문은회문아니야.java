package algo_202308;

import java.io.*;
import java.util.*;

public class BJ_15927_회문은회문아니야 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        int length = input.length;
        int lastIdx = length-1;
        int size = length/2;

        int result = 0;
        char first = input[0];
        int sameCnt = 0;
        for(int i = 0; i < size; i++){
            if(input[i] == input[lastIdx]){
                lastIdx--;
                if(input[i] == first){
                    sameCnt++;
                }
            }else{
                break;
            }
        }

//        System.out.println("lastIdx: "+lastIdx);
//        if(lastIdx == length-1){
//            result = length;
//        }else if(lastIdx != length-1){
//            result = length-1;
//        }
        if(length%2==0) lastIdx++;
        if(lastIdx == size){ //회문인 경우
            result = length-1;
        }else{
            result = length;
        }
        if(sameCnt == size && first == input[lastIdx]){
            result = -1;
        }
        System.out.println(result);

    }
}
