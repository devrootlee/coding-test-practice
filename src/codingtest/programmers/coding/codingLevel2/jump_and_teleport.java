package codingtest.programmers.coding.codingLevel2;
/**
 * TITLE : 점프와 순간이동
 * LEVEL : 2
 */

// 점프는 한 칸당 에너지 1 사용
// 순간이동은 현재까지 온 거리의 2배 이동, 에너지 사용 X
public class jump_and_teleport {

    public static int solution(int n) {
        int ans = 0;

        while (n != 0) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = n - 1;
                ans++;
            }
        }

        System.out.println(ans);

        return ans;
    }

    public static void main(String[] args) {
        solution(5);
        solution(6);
        solution(5000);
    }
}
