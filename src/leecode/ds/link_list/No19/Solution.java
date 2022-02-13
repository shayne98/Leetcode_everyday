package leecode.ds.link_list.No19;

/**
 * @author 小羊Shaun
 * @version 1.0
 * @date 2022/2/13 22:14
 * 19. Remove Nth Node From End of List
 * 需要在N-n+1次操作中快指针走2*N-n+1步
 * 所以快指针先走n-1步，然后慢指针每走一步，快指针走两步，走到结尾回到开头
 * 这样n-1 + 2(N-n+1) = N + N-n+1,快慢指针恰好在倒数第n个节点相遇，快指针比慢指针多走一个链表
 */
// Definition for singly-linked list.
 class ListNode {
 int val;
 ListNode next;
 ListNode() {}
 ListNode(int val) { this.val = val; }
 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode rt = new ListNode(0,head);
        ListNode fast = rt,slow = rt,pre = rt;
        for(int i=1;i<n;i++){
            fast = fast.next;
        }
        while(fast!=slow||fast==rt){
            pre = slow;
            slow = slow.next;
            fast = fast.next==null?head:fast.next;
            fast = fast.next==null?head:fast.next;
        }
        pre.next = slow.next;
        slow.next = null;
        return rt.next;


    }
}