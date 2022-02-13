package leecode.ds.link_list.No83;

/**
 * @author 小羊Shaun
 * @version 1.0
 * @date 2022/2/13 21:16
 * 83. Remove Duplicates from Sorted List
 */
// * Definition for singly-linked list.
 class ListNode {
 int val;
 ListNode next;
 ListNode() {}
 ListNode(int val) { this.val = val; }
 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        while(p!=null&&p.next!=null){
            ListNode s = p.next;
            if(p.val==s.val){
                p.next = s.next;
                s.next = null;
            }
            else p = p.next;
        }
        return head;

    }
}