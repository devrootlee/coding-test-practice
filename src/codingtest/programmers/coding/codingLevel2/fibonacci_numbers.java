package codingtest.programmers.coding.codingLevel2;
/**
 * TITLE : 파보나치 수
 * LEVEL : 2
 */
//F(2) = F(0) + F(1) = 0 + 1 = 1
//F(3) = F(1) + F(2) = 1 + 1 = 2
//F(4) = F(2) + F(3) = 1 + 2 = 3
//F(5) = F(3) + F(4) = 2 + 3 = 5
public class fibonacci_numbers {

    public static int solution(int n) {
        int answer = 0;
        int prev = 0;
        int curr = 1;
        int mod = 1234567;

        for (int i = 2; i <= n; i++) {
            int next = (prev + curr) % mod;
            prev = curr;
            curr = next;
        }

        answer = curr;
        System.out.println( answer);

        return answer;
    }

    public static void main(String[] args) {
        solution(3);
        solution(5);
    }
}
