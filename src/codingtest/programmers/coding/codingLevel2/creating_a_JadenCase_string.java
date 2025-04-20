package codingtest.programmers.coding.codingLevel2;

/**
 * TITLE : JadenCase 문자열 만들기
 * LEVEL : 2
 */
public class creating_a_JadenCase_string {

    public static String solution(String s) {
        StringBuilder answer = new StringBuilder();
        boolean isStart = true;

        s = s.toLowerCase();

        for (char c: s.toCharArray()) {
            if (isStart && Character.isLetterOrDigit(c)) {
                answer.append(Character.toUpperCase(c));
                isStart = false;
            } else {
                answer.append(c);
                isStart = (c == ' ');
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        solution("3people unFollowed me");
        solution("for the last week");
    }
}
