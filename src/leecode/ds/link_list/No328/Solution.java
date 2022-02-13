package leecode.ds.link_list.No328;

/**
 * @author 小羊Shaun
 * @version 1.0
 * @date 2022/2/13 21:32
 * 328. Odd Even Linked List
 * 遍历链表，一次性处理两个节点，分别放在两个新的链表中，最后再把两个链表拼起来
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
    public ListNode oddEvenList(ListNode head) {
        ListNode rt1 = new ListNode();
        ListNode rt2 = new ListNode();
        ListNode st = head,p = rt1,q = rt2;
        while(st!=null&&st.next!=null){
            ListNode temp = st.next.next;
            p.next = st;
            q.next = st.next;
            p = p.next;
            q = q.next;
            st = temp;
        }
        if(st!=null){
            p.next = st;
            p = p.next;
        }
        p.next = rt2.next;
        q.next = null;
        head = rt1.next;
        rt1.next = null;
        rt2.next = null;
        return head;

    }
}
