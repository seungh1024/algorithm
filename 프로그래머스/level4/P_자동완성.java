package algo_202311.kakaoblindrecruitment2018;

import java.util.*;

public class P_자동완성 {
    public static void main(String[] args) {
        P_자동완성 test = new P_자동완성();
        String[] words = {"aaaaa", "aaaa", "aaa", "aa"};
        int result = 14;
        int answer = test.solution(words);
        if(result == answer) System.out.println("success");
        else System.out.println("fail");
    }

    public int solution(String[] words) {
        int answer = 0;


        // 검색 값, 전체 값 저장
        Map<String,Word> map = new HashMap<>();
        Queue<Word> q = new ArrayDeque<>();
        Set<String> set = new HashSet<>();
        for(String input : words){
            // System.out.println("input: "+input);
            int length = input.length();
            int index = 0;
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < length; i++){
                sb.append(input.charAt(i));

                // 완성된 것은 넣고 끝냄
                if(sb.toString().equals(input)){
                    map.put(sb.toString(),new Word(input,input,i+1,length));
                    break;
                }

                // 겹치지 않으면 바로 등록
                if(!set.contains(sb.toString())){
                    map.put(sb.toString(), new Word(sb.toString(),input,i+1,length));
                    set.add(sb.toString());
                    break;
                }else if(map.containsKey(sb.toString())){ // 겹치는데 목록에 있으면 재확인 -> 미완성이면 q에 넣어서 완성본으로 만듦
                    Word output = map.get(sb.toString());
                    if(!output.s.equals(output.word)){
                        map.remove(sb.toString());
                        q.offer(output);
                    }
                    q.offer(new Word(sb.toString(),input,i+1,length));
                    break;
                }
            }


            // 중복되는 단어들 알파벳 추가하면서 중복 안되게 만들기
            while(!q.isEmpty()){
                Word now = q.poll();

                sb = new StringBuilder(now.s);
                index = now.index;
                for(int i = now.index; i < now.length; i++){
                    sb.append(now.word.charAt(index));
                    index++;
                    if(!set.contains(sb.toString())){
                        map.put(sb.toString(),new Word(sb.toString(), now.word,index,now.length));
                        set.add(sb.toString());
                        break;
                    }else if(map.containsKey(sb.toString())){
                        Word next = map.get(sb.toString());

                        if(!next.s.equals(next.word)){
                            map.remove(sb.toString());
                            q.offer(next);
                        }
                        if(index == now.length){
                            map.put(sb.toString(), new Word(sb.toString(), now.word, index, now.length));
                        }

                    }
                }
            }
        }

        for(Word word : map.values()){
            answer += word.index;
        }

        return answer;
    }

    public static class Word{
        String s;
        String word;
        int index;
        int length;

        public Word(String s, String word, int index, int length){
            this.s = s;
            this.word = word;
            this.index =index;
            this.length = length;
        }

        @Override
        public String toString(){
            return "index: "+index +", s: "+s + ", word: "+word;
        }
    }
}
