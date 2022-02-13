package leecode.ds.link_list.No160;

/**
 * @author 小羊Shaun
 * @version 1.0
 * @date 2022/2/11 20:40
 * 160. Intersection of Two Linked Lists
 * 在遍历到一个链表的结尾时换到另一个链表的头
 */
//Definition for singly-linked list.
class ListNode {
 int val;
 ListNode next;
 ListNode(int x) {
 val = x;
 next = null;
 }
 }

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA,p2 = headB;
        while(p1!=p2){
            p1 = p1==null?headB:p1.next;
            p2 = p2==null?headA:p2.next;
        }
        return p1;

    }
}
