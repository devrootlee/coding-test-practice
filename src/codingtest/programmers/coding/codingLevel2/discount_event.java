package codingtest.programmers.coding.codingLevel2;

import java.util.*;

/**
 * TITLE : 할인 행사
 * LEVEL : 2
 */

public class discount_event {
    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        // want map 으로 변경
        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        // 정답 구하기
        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> discountMap = new HashMap<>();

            // 10걔씩 끊기
            for (int j = i; j < i + 10; j++) {
                String product = discount[j];
                discountMap.put(product, discountMap.getOrDefault(product, 0) + 1);
            }

            boolean canBuyAll = true;
            for (String key : wantMap.keySet()) {
                // 목록보다 wantMap 에 보다 값이 작으면 break 해서 다음 목록으로 옮기기
                if (discountMap.getOrDefault(key, 0) < wantMap.get(key)) {
                    canBuyAll = false;
                    break;
                }
            }

            if (canBuyAll) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3,2,2,2,1}, new String[] {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"});
        solution(new String[]{"apple"}, new int[]{10}, new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"});
    }
}
