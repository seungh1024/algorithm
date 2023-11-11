package algo_202311.kakaointern2021;

import java.util.*;
import java.io.*;

public class P_숫자문자열과영단어 {
    public static void main(String[] args) {
        P_숫자문자열과영단어 test = new P_숫자문자열과영단어();
        int result = test.solution("one4seveneight");
        if (result == 1478) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }
    }


    public static Map<String , Integer> map;
    public int solution(String s) {
        initNumbers();
        char[] data = s.toCharArray();

        int result = makeNumber(data);
        return result;
    }

    public static int makeNumber(char[] data){
        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for(char c : data){
            int num = c-'0';
            if(num >= 0 && num <= 9){
                result.append(num);
            }else{
                sb.append(c);
            }

            if(map.get(sb.toString()) != null){
                result.append(map.get(sb.toString()));
                sb = new StringBuilder();
            }
        }


        return Integer.parseInt(result.toString());
    }

    public static void initNumbers(){
        map = new HashMap<>();
        map.put("zero",0);
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        map.put("four",4);
        map.put("five",5);
        map.put("six",6);
        map.put("seven",7);
        map.put("eight",8);
        map.put("nine",9);
    }

}
