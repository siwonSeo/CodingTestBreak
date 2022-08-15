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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = head;
        if(res == null) return head;
        while(res != null){
            if(res.next != null && res.val == res.next.val){
                res.next = res.next.next;
            }else{
                res = res.next;
            }
            
        }
        
        return head;
    }
}