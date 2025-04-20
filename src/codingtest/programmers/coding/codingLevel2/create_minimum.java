package codingtest.programmers.coding.codingLevel2;

import java.util.Arrays;
import java.util.Collections;

/**
 * TITLE : 최솟값 만들기
 * LEVEL : 2
 */
public class create_minimum {

    public static int solution(int []A, int []B) {
        int answer = 0;
        // 오름차순
        Arrays.sort(A);
        Integer[] BWrapper = Arrays.stream(B).boxed().toArray(Integer[]::new);

        // 내림차순
        Arrays.sort(BWrapper, Collections.reverseOrder());

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * BWrapper[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        solution(new int[]{1, 4, 2}, new int[]{5, 4, 4});
        solution(new int[]{1, 2}, new int[]{3, 4});
    }
}
