package leecode.ds.link_list.No234;

/**
 * @author 小羊Shaun
 * @version 1.0
 * @date 2022/2/13 19:55
 */
// * Definition for singly-linked list.
 class ListNode {
 int val;
 ListNode next;
 ListNode() {}
 ListNode(int val) { this.val = val; }
 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 //用快慢指针找到链表的中点，反转后半部分链表然后，从两边向内遍历链表，即可以实现o1空间复杂度下判断回文链表
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode st = new ListNode(0,head);
        ListNode fast = st,slow = st;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow,p = slow.next,pre = slow;
        while(p!=null){
            ListNode temp = p.next;
            p.next = pre;
            pre = p;
            p = temp;
        }
        p = head;
        while(true){
            if(p.val!=pre.val){
                return false;
            }
            else{
                if(p==mid)break;
                p = p.next;
                pre = pre.next;
            }
        }
        return true;

    }
}