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
    public int pairSum(ListNode head) {
        int res = 0;
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        
        int listLength = list.size();
        for(int i = 0; i < listLength / 2; i++){
            res = Math.max(res,list.get(i) + list.get(listLength - 1 - i));
        }
        return res;
    }
}