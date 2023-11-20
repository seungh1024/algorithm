package algo_202311.kakaointern2019;

import java.util.*;

public class P_불량사용자 {
    public static void main(String[] args) {
        P_불량사용자 test = new P_불량사용자();
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "abc1**"};
        int result = 2;
        int answer = test.solution(user_id,banned_id);
        if(result == answer) System.out.println("success");
        else System.out.println("fail");
    }
    public static boolean[] visited;
    public static int[] indexInfo;
    public static char[][] userId;
    public static char[][] banId;
    public static int[] nameLength;
    public static int[] banNameLength;
    public static int result;
    public static Set<String> set;

    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;

        int userLength = user_id.length;
        userId = new char[userLength][0];
        nameLength = new int[userLength];
        for(int i = 0; i < userLength; i++){
            userId[i] = user_id[i].toCharArray();
            nameLength[i] = userId[i].length;
        }

        int banLength = banned_id.length;
        banId = new char[banLength][0];
        banNameLength = new int[banLength];
        for(int i = 0; i < banLength; i++){
            banId[i] = banned_id[i].toCharArray();
            banNameLength[i] = banId[i].length;
        }

        set = new HashSet<>();

        result =0;
        visited= new boolean[userLength];
        indexInfo = new int[banLength];
        find(0,0,userLength,banLength);

        return result;
    }

    public static void find(int index, int count, int userLength, int banLength){
        if(count == banLength){
            for(int i = 0; i < banLength; i++){
                if(banNameLength[i]!= nameLength[indexInfo[i]]){
                    return;
                }
                if(!checkName(banId[i],userId[indexInfo[i]],banNameLength[i])){
                    return;
                }
            }
            int[] copy = new int[banLength];
            for(int i = 0; i < banLength; i++){
                copy[i] = indexInfo[i];
            }
            Arrays.sort(copy);

            StringBuilder sb = new StringBuilder();
            for(int i : copy){
                sb.append(i);
            }

            if(!set.contains(sb.toString())){
                set.add(sb.toString());
                result++;
            }

            return;
        }

        for(int i = 0; i < userLength; i++){
            if(!visited[i]){
                visited[i] = true;
                indexInfo[index] = i;
                find(index+1,count+1,userLength,banLength);
                visited[i] = false;
            }
        }
    }

    public static boolean checkName(char[] ban , char[] user, int length){
        for(int i = 0; i < length; i++){
            if(ban[i] != user[i] && ban[i] != '*'){
                return false;
            }
        }
        return true;
    }

}
