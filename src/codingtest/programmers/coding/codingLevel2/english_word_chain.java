package codingtest.programmers.coding.codingLevel2;

import java.util.HashSet;
import java.util.Set;

/**
 * TITLE : 영어 끝말잇기
 * LEVEL : 2
 */
public class english_word_chain {

    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        // 오류난 인덱스
        int idx = -1;

        // 중복 단어 checking
        Set<String> distinct = new HashSet<>();
        distinct.add(words[0]);

        // 끝단어 checking
        char end = words[0].charAt(words[0].length() - 1);
        for (int i = 1; i < words.length; i++) {
            // 앞단어
            char nextStart = words[i].charAt(0);
            // 뒷단어
            char nextEnd = words[i].charAt(words[i].length() - 1);

            if (end != nextStart) {
                idx = i + 1; // index 가 0부터 시작하므로 1 더하기
                break;
            } else {
                end = nextEnd;
            }

            // 중복 단어 비교
            if (!distinct.add(words[i])) {
                idx = i + 1; // index 가 0부터 시작하므로 1 더하기
                break;
            }
        }

        if (idx == -1) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            if (idx % n == 0) {
                answer[0] = n;
                answer[1] = idx / n;
            } else {
                answer[0] = idx % n;
                answer[1] = idx / n + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
        solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"});
        solution(6, new String[]{"hello", "one", "even", "never", "now", "world", "draw"});
    }
}
