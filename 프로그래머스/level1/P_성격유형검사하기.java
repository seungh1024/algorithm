package algo_202311;
import java.io.*;
import java.util.*;

public class P_성격유형검사하기 {
    public static void main(String[] args) {
        P_성격유형검사하기 test = new P_성격유형검사하기();
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5,3,2,7,5};
        // result = "TCMA";
        String answer = test.solution(survey, choices);
        System.out.println(answer);
    }

    public static Map<Character, Integer> count;
    public static int[] points = {0,3,2,1,0,1,2,3};
    public String solution(String[] survey, int[] choices) {
        countInit();

        int length = survey.length;
        for(int i = 0; i < length; i++){
            makePoint(survey[i],choices[i]);
        }
        return makeResult();
    }

    public static String makeResult(){
        char[] data = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 8; i+=2){
            char left = data[i];
            char right = data[i+1];
            int leftPoint = count.get(left);
            int rightPoint = count.get(right);

            if(leftPoint < rightPoint){
                sb.append(right);
            }else{
                sb.append(left);
            }
        }
        return String.valueOf(sb);
    }

    public static void makePoint(String data , int choice){
        int keyAt = 0;

        if(choice > 4){
            keyAt = 1;
        }

        char key = data.charAt(keyAt);
        int point = count.get(key);
        point += points[choice];
        count.put(key, point);
        // System.out.println("key: "+ key + ", point: "+ point);
    }

    public static void countInit(){
        count = new HashMap<>();
        count.put('R',0);
        count.put('T',0);
        count.put('C',0);
        count.put('F',0);
        count.put('J',0);
        count.put('M',0);
        count.put('A',0);
        count.put('N',0);
    }
}
