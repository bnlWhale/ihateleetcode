/*


Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?



 */


import java.util.ArrayList;
import java.util.List;

public class Leetcode_206_Reverse_Linked_List {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public ListNode reverseList(ListNode head) {


            ListNode pre = null;
            ListNode cur = head;
            ListNode next = null;
            while(cur!=null){

                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;

            }


            /*
            if (head == null) {
                return null;
            }
            System.out.println(head.val);
            reverseList(head.next);
            */

            return pre;
        }

        public void helper(ListNode node, List<ListNode> nodeList){

            if(node == null){
                return;
            }
            helper(node.next, nodeList);
            //System.out.println(node.val);
            if(nodeList.size() == 0){
                nodeList.add(node);
                node.next = null;
            }else{
                nodeList.get(0).next = node;
            }


        }
    }






    static void doAction() {

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

       // ListNode node1 = new Solution().reverseList(node);
       // System.out.println(node1);

        ListNode node2 = null;
        List<ListNode> nodeList = new ArrayList<>();
        new Solution().helper(node, nodeList);
        System.out.println(node2);


    }

    public static void main(String[] args) {

        doAction();
    }


}
