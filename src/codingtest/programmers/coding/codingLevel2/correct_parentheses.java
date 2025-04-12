package codingtest.programmers.coding.codingLevel2;

public class correct_parentheses {

    static boolean solution(String s) {
        boolean answer = true;

        int sLength = s.length();
        while (true) {
            s = s.replaceAll("\\(\\)","");
            int compareLength = s.length();

            //replace 한 길이가 더 작으면
            if (sLength > compareLength) {
                sLength = s.length();
            } else { //길이가 같으면
                break;
            }
        }

        if (s.length() > 0) {
            answer = false;
        }

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        solution("()()");
        solution("(())()");
        solution(")()(");
        solution("(()(");
    }
}
