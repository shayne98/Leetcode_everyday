/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
 */

// @lc code=start
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //倒数只要使得第一个指针先走，然后 n步后第二个指针再走即可
        ListNode p=head,q=head,prev = new ListNode(0,head);
        ListNode st = prev;
        for(int i=1;i<n;i++){
            p = p.next;
        }
        while(p.next!=null){
            p = p.next;
            prev = q;
            q = q.next;
        }
        prev.next = q.next;
        q.next = null;
        return st.next;

    }
}
// @lc code=end

