/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        int sum = 0;
        ListNode res = new ListNode();
        ListNode resAppend = res;
        while(head != null){
            int val = head.val;
            if(val == 0 && sum > 0){
                resAppend.val = sum;
                if(head.next != null){
                    resAppend.next = new ListNode();
                }
                resAppend = resAppend.next;
                sum = 0;
            }else{
                sum += val;
            }
            head = head.next;
        }
        return res;
    }
}