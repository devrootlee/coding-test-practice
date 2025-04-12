package codingtest.programmers.coding.codingLevel1;

import java.util.HashMap;
import java.util.Map;

/**
 * TITLE : 가장 많이 받은 선물
 * LEVEL : 1
 */
public class most_received_gift {

    // 선물 지수: 준 선물 - 받은 선물
    public static int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Integer> friendIndexMap = new HashMap<>();

        // 친구 인덱스맵
        for (int i = 0; i < friends.length; i++) {
            friendIndexMap.put(friends[i],i);
        }

        // 선물 주고받은 횟수를 저장할 2차원 배열 만들기
        int[][] giftMatrix = new int[friends.length][friends.length]; // 선물 주고받은 횟수 저장
        int[] giftGiven = new int[friends.length]; // 각 친구가 준 선물 총합
        int[] giftReceived = new int[friends.length]; // 각 친구가 받은 선물 총합

        for (String gift : gifts) {
            String[] part = gift.split(" ");
            String giver = part[0];
            String receiver = part[1];

            int giverIdx = friendIndexMap.get(giver);
            int receiverIdx = friendIndexMap.get(receiver);

            giftMatrix[giverIdx][receiverIdx]++;
            giftGiven[giverIdx]++;
            giftReceived[receiverIdx]++;
        }

        // 선물 지수 구하기
        int[] giftScore = new int[friends.length];
        for (int i = 0; i < giftScore.length; i++) {
            giftScore[i] = giftGiven[i] - giftReceived[i];
        }

        // 다음 달 선물 예측
        int[] nextMonthGifts = new int[friends.length];

        for (int i =0; i < friends.length; i++) {
            for (int j = 0; j < friends.length; j++) {
                // 자기 자신 제외
                if (i == j) continue;

                // i가 j보다 선물을 더 많이 준 경우 → i가 j에게 선물 하나 받음
                if (giftMatrix[i][j] > giftMatrix[j][i]) {
                    nextMonthGifts[i]++;
                } else if (giftMatrix[i][j] == giftMatrix[j][i]) {
                    // 주고받은 수가 같을 때 → 선물 지수 비교
                    if (giftScore[i] > giftScore[j]) {
                        nextMonthGifts[i]++;
                    }
                }
            }
        }

        for (int i = 0; i < nextMonthGifts.length; i++) {
            answer = Math.max(answer, nextMonthGifts[i]);
        }
        System.out.println(answer);

        return answer;
    }

    public static void main(String[] args) {
        solution(new String[]{"muzi", "ryan", "frodo", "neo"}, new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"});
        solution(new String[]{"joy", "brad", "alessandro", "conan", "david"}, new String[]{"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"});
        solution(new String[]{"a", "b", "c"}, new String[]{"a b", "b a", "c a", "a c", "a c", "c a"});
    }
}
