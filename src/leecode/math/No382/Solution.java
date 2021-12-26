package leecode.math.No382;

import java.util.Random;

/**
 * @author 小羊Shaun
 * @version 1.0
 * No382. Linked List Random Node
 * 水库算法，在事先不知道数组大小的情况下遍历做到随机选取元素：
 * 遍历到第i个元素时，在1~i中随机选取一个数取得i则替换之前的值，这样直到每个元素遍历完成后
 * 每个元素被选到的概率=1/i*(1-1/i+1)*(1-1/i+2)...(1-1/n)= 1/n满足每个节点等概率选取
 */

  //Definition for singly-linked list.
 class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
     ListNode head;
     Random random;

    public Solution(ListNode head) {
        this.head = head;
        this.random = new Random();

    }

    public int getRandom() {
        int i=1;
        ListNode node = this.head;
        int ans =node.val;
        while(node!=null){
            //通过random取随机数使得每次替换的概率为1/i
            if(random.nextInt(i)+1==i){
                ans = node.val;
            }
            node = node.next;
        }
        return ans;

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */