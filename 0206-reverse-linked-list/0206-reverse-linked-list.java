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
    public ListNode reverseList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        if(head == null) return head;
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        
        ListNode res = new ListNode();
        ListNode cursor = res;
        for(int i = list.size() - 1; i >=0; i--){
            int num = list.get(i);
            cursor.val = num;
            if(i>0){
                cursor.next = new ListNode();
                cursor = cursor.next;
            }
        }
        
        return res;
    }
}