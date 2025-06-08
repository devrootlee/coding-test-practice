package codingtest.programmers.coding.codingLevel2;

import java.util.HashSet;

/**
 * TITLE : 연속 부분 수열 합의 개수
 * LEVEL : 2
 */
public class number_of_sums_of_consecutive_subsequences {

    public static int solution(int[] elements) {
        int answer = 0;

        HashSet<Integer> answerSet = new HashSet<>();

        // 최초값들 넣기
        for (int i : elements) {
            answerSet.add(i);
        }

        // 부분 집합 넣기
        int n = elements.length;

        for (int len = 2; len <= n; len++) { // 부분 수열의 길이
            for (int start = 0; start < n; start++) { // 시작 위치
                int sum = 0;
                for (int k = 0; k < len; k++) {
                    sum += elements[(start + k) % n];
                }

                answerSet.add(sum);
            }
        }
        answer = answerSet.size();

        return answer;
    }

    public static void main(String[] args) {
        solution(new int[]{7,9,1,1,4});
    }
}
