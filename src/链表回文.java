import java.util.Scanner;
import java.util.Stack;

/**
 * Description
 * 判断一个单向链表是否为回文结构。自定义链表数据结构，要求时间复杂度为O(n)，额外空间复杂度为O(1)。
 *
 * Input
 * 输入第一行为用例个数， 每个测试用例输入的每一行的值用空格隔开，第一个值为节点个数，后面为每一个节点值
 *
 * Output
 * 是回文则输出true，不是则输出false，一行表示一个链表的结果。
 *
 */
public class 链表回文 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfCases = Integer.parseInt(sc.nextLine());
        while(numOfCases > 0) {
            String[] temp = sc.nextLine().split(" ");
            int numOfNodes = Integer.parseInt(temp[0]);
            if (numOfNodes == 1) {
                System.out.println(true);
                continue;
            }
            ListNode head = new ListNode(temp[1]);
            ListNode flag = head;
            for(int i = 0; i < numOfNodes - 1; i++){
                flag.next = new ListNode(temp[i + 2]);
                flag = flag.next;
            }
            System.out.println(isPalindrome(head));
            numOfCases -= 1;
        }
    }

    static boolean isPalindrome(ListNode head){
        Stack<String> stack = new Stack<>();
        ListNode temp = head;
        while(head != null){
            stack.push(head.value);
            head = head.next;
        }
        while(!stack.isEmpty()){
            if(!stack.pop().equals(temp.value)){
                return false;
            }
            temp = temp.next;
        }
        return true;
    }

    static class ListNode {
        public String value;
        public ListNode next;

        public ListNode(String value) {
            this.value = value;
        }

        public String toString(){
            String appendit = (this.next == null) ? "" : this.next.toString();
            return this.value + " " + appendit;
        }
    }

}
