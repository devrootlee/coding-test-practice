package codingtest.programmers.coding.codingLevel2;

import java.util.Arrays;

/**
 * TITLE : 이진 변환 반복하기
 * LEVEL : 2
 */
public class repeat_binary_conversion {
    public static int[] solution(String s) {
        int[] answer = new int[2];

        while (!s.equals("1")) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    answer[1] += 1;
                }
            }
            s = s.replace("0","");
            s = Integer.toBinaryString(s.length());

            answer[0] += 1;
        }

        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static void main(String[] args) {
        solution("110010101001");
        solution("01110");
        solution("1111111");
    }
}
