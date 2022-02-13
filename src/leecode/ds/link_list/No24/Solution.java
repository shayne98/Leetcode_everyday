package leecode.ds.link_list.No24;

/**
 * @author 小羊Shaun
 * @version 1.0
 * @date 2022/2/13 20:55
 * 24. Swap Nodes in Pairs
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode p = head;
        if(p!=null&&p.next!=null){
            ListNode s = p.next;
            p.next = s.next;
            s.next = p;
            head = s;
            while(p.next!=null&&p.next.next!=null){
                s = p.next.next;
                p.next.next = s.next;
                s.next = p.next;
                p.next = s;
                p = s.next;
            }
        }
        return head;
    }
}
