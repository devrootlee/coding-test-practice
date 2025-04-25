package codingtest.programmers.coding.codingLevel2;

import java.util.Stack;

/**
 * TITLE : 짝지어 제거하기
 * LEVEL : 2
 */

//예를 들어, 문자열 S = baabaa 라면
//b aa baa → bb aa → aa →
//의 순서로 문자열을 모두 제거할 수 있으므로 1을 반환합니다.
//성공적으로 수행할 수 있으면 1을, 아닐 경우 0을 리턴
public class remove_in_pairs {

    public static int solution(String s) {
        int answer = 0;

        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            // stack 에 들어있는 윗값과 같을경우
            if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        if (stack.isEmpty()) answer = 1;

        System.out.println(answer);

        return answer;
    }

    public static void main(String[] args) {
        solution("baabaa");
        solution("cdcd");
        solution("aa");
        solution("daabbd");
    }
}
