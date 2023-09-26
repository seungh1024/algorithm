package algo_202309;

import java.io.*;
import java.util.*;

public class BJ_4378_트ㅏㅊ {
    public static char[][] data = {
            {'`','1','2','3','4','5','6','7','8','9','0','-','='}, // 13개
            {'Q','W','E','R','T','Y','U','I','O','P','[',']','\\'}, //13개
            {'A','S','D','F','G','H','J','K','L',';','\''}, // 11개
            {'Z','X','C','V','B','N','M',',','.','/'} //10개
    };
    public static Map<Character,int[]> map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        mapInit();
        while(true){
            String inputString = br.readLine();
            if(inputString == null) break;
            char[] input =inputString.toCharArray();

            for(char c : input){
                if(map.get(c) != null){
                    int[] now = map.get(c);
                    sb.append(data[now[0]][now[1]]);
                }else{
                    sb.append(c);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
    public static void mapInit(){
        map = new HashMap<>();
        int x = 0;
        for(int i = 0; i <4; i++){
            int y = -1;
            for(char c : data[i]){
                map.put(c,new int[]{x,y});
                y++;
            }
            x++;
        }
    }
}
