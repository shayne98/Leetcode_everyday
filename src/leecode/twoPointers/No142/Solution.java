package leecode.twoPointers.No132;

/**
 * @author 小羊Shaun
 * @version 1.0
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        //若链表无环则fast一定再某个时刻走到null
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            //当fast和slow指针相遇时，fast指针重置到头指针
            if(fast == slow){
                fast = head;
                //fast和slow每次走一步直到相遇时就是环的起点
                while(fast!=slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;

    }
}