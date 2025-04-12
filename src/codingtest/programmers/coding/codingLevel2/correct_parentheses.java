package codingtest.programmers.coding.codingLevel2;

public class correct_parentheses {

    static boolean solution(String s) {
        boolean answer = true;

        int subAnswer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                subAnswer++;
            } else {
                subAnswer--;
            }

            if (subAnswer < 0) {
                break;
            }
        }

        if (subAnswer != 0) {
            answer = false;
        }

        return answer;
    }

    public static void main(String[] args) {
        solution("()()");
        solution("(())()");
        solution(")()(");
        solution("(()(");
    }
}
