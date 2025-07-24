package codingtest.programmers.coding.codingLevel2;

import java.util.Stack;

/**
 * TITLE : 괄호 회전하기
 * LEVEL : 2
 */
public class rotate_parentheses {

    public static int solution(String s) {
        int answer = 0;

        // 홀수이면 짝을 맞출수 없음
        if (s.length() % 2 == 1) {
            return answer;
        }

        for (int i = 0; i < s.length(); i++) {
            String rotated = s.substring(i) + s.substring(0, i);
            boolean validate = isValid(rotated);

            if (validate) {
                answer++;
            }
        }

        return answer;
    }

    public static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == ']' && top != '[') ||
                        (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty(); // 스택이 비어있으면 올바른 괄호
    }

    public static void main(String[] args) {
        solution("[](){}");
        solution("}]()[{");
        solution("[)(]]");
        solution("}}}");
    }
}
