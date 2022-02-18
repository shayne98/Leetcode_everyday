package leecode.ds.link_list.No148;

/**
 * @author 小羊Shaun
 * @version 1.0
 * @date 2022/2/14 11:11
 * 利用快慢指针找到链表的中点，然后从中间切断链表，归并排序
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
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode rt = new ListNode(0,head),fast = rt,slow = rt;
        while(fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rHead = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(rHead);
        ListNode p = left,q = right,s = rt;
        while(p!=null&&q!=null){
            if(p.val<q.val){
                s.next = p;
                p = p.next;
            }
            else{
                s.next = q;
                q = q.next;
            }
            s = s.next;
        }
        if(p!=null)s.next = p;
        if(q!=null)s.next = q;
        return rt.next;


    }

}
