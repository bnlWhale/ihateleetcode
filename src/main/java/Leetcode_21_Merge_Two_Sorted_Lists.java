/*



Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4


 */



public class Leetcode_21_Merge_Two_Sorted_Lists {

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
   }


    static class Solution {



        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

            if(l1 == null){
                return l2;
            }
            if(l2 == null){
                return l1;
            }

            ListNode temp1 = new ListNode(0);
            ListNode temp2 = temp1;
            while(l1!=null || l2 !=null){

                if(l1==null){
                    temp1.next = l2;
                    l2 = l2.next;
                }else if(l2 == null){
                    temp1.next = l1;
                    l1 = l1.next;
                }else{
                    if(l1.val<l2.val){
                        temp1.next = l1;
                        l1 = l1.next;

                    }else{
                        temp1.next = l2;
                        l2 = l2.next;
                    }
                }
                temp1=temp1.next;
            }
            return temp2.next;
        }
    }

}
