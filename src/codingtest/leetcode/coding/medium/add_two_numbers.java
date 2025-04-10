package codingtest.leetcode.coding.medium;

public class add_two_numbers {

  public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode(0);
        //임시
        ListNode tmpAnswer = answer;
        //자리 올림 처리 변수
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10; //자리 올림
            tmpAnswer.next = new ListNode(sum % 10); //한 자리 숫자만 저장
            tmpAnswer = tmpAnswer.next;
        }

        while (answer.next != null) {
            System.out.println(answer.next.val);
            answer.next = answer.next.next;
        }


        return answer.next;
    }

    public static void main(String[] args) {
        addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3))), new ListNode(5, new ListNode(6, new ListNode(4))));
    }
}
