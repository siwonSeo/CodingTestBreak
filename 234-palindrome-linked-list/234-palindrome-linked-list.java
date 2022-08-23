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
    public boolean isPalindrome(ListNode head) {
        ListNode cursor = head;
        
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);            
            head = head.next;            
        }
        
        int startIndex = 0;
        int endIndex = list.size()-1;

        while(startIndex <= endIndex){
            if(list.get(startIndex++) != list.get(endIndex--)){
                return false;
            }
        }
        
        return true;       
        
    }
}