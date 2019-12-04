import java.util.Scanner;
import java.util.Stack;

/**
 * Description
 * 将单个链表的每K个节点之间逆序，打印出新链表；最后不足K的节点数不需要逆序；要求时间复杂度为O(n)，额外空间复杂度为O(1)。
 *
 * Input
 * 输入第一行为用例个数， 每个测试用例输入的每一行的值用空格隔开，第一个表示链表长度，中间为节点值，最后代表K。
 *
 * Output
 * 输出的每一行为新的链表，节点值用空格隔开，末尾不要空格。
 */
public class 链表区间逆序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfCases = Integer.parseInt(sc.nextLine());
        while(numOfCases > 0) {
            String[] temp = sc.nextLine().split(" ");
            int numOfNodes = Integer.parseInt(temp[0]);
            int K = Integer.parseInt(temp[temp.length - 1]);
            ListNode head = new ListNode(temp[1]);
            ListNode cur = head;
            if(numOfNodes == 1){
                System.out.println(head.value);
                continue;
            }
            for(int i = 2; i < temp.length - 1; i++){
                ListNode node = new ListNode(temp[i]);
                cur.next = node;
                cur = cur.next;
            }
            ListNode newHead = reverseK(head, K);
            cur = newHead;
            int step = numOfNodes;
            while(step > 1){
                System.out.print(cur.value);
                System.out.print(" ");
                step -= 1;
                cur = cur.next;
            }
            System.out.print(cur.value);
            System.out.println();
            numOfCases -= 1;
        }
    }

    static ListNode reverseK(ListNode head, int K){
        if(K < 2 || head == null || head.next == null){
            return head;
        }
        // 逆序的题首先考虑用栈！！！
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        int step = K;
        while(step > 0){
            if(cur == null){
                break;
            }
            stack.push(cur);
            cur = cur.next;
            step -= 1;
        }
        ListNode newHead = stack.pop();
        ListNode temp = newHead;
        if(step > 0){
            return head;
        }else {
            while (!stack.isEmpty()) {
                temp.next = stack.pop();
                temp = temp.next;
            }
        }
        while(cur != null){
            step = K;
            while(step > 0){
                if(cur == null){
                    break;
                }
                stack.push(cur);
                cur = cur.next;
                step -= 1;
            }
            if(step > 0){
                while(!stack.empty()){
                    temp.next = stack.pop();
                }
            }else{
                while(!stack.empty()){
                    temp.next = stack.pop();
                    temp = temp.next;
                }
            }
        }
        return newHead;
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



