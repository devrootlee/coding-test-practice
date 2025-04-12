package codingtest.programmers.coding.codingLevel1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * TITLE : 대충 만든 자판
 * LEVEL : 1
 */
public class a_roughly_made_keyboard {

    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        Map<Character,Integer> move = new HashMap<>();

        for(String key:keymap){

            for(int i=0;i<key.length();i++){

                char sign = key.charAt(i);

                int step=move.getOrDefault(sign,i+1);

                move.put(sign,Math.min(step,i+1));
            }
        }

        for(int i=0;i<targets.length;i++){
            for(int j=0;j<targets[i].length();j++){
                char t = targets[i].charAt(j);

                if(move.containsKey(t)){
                    answer[i]+=move.get(t);
                }else{
                    answer[i]=-1;
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(answer));

        return answer;
    }

    public static void main(String[] args) {
        solution(new String[]{"ABACD","BCEFD"}, new String[]{"ABCD","AABB"});
        solution(new String[]{"AA"}, new String[]{"B"});
        solution(new String[]{"AGZ","BSSS"}, new String[]{"ASA","BGZ"});
        solution(new String[]{"ABCDE"}, new String[]{"FGHIJ"});
        solution(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD","DG", "AABB"});
    }
}
