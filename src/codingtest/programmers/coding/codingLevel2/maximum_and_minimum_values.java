package codingtest.programmers.coding.codingLevel2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * TITLE : 최대값과 최솟값
 * LEVEL : 2
 */
public class maximum_and_minimum_values {

    public static String solution(String s) {
        String answer = "";

        String[] splitS = s.split(" ");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < splitS.length; i++) {
            list.add(Integer.parseInt(splitS[i]));
        }

        int max = Collections.max(list);
        int min = Collections.min(list);

        answer = min + " " + max;
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        solution("1 2 3 4");
        solution("-1 -2 -3 -4");
        solution("-1 -1");
    }
}
