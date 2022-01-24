package leecode.ds.queue.No23;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 小羊Shaun
 * @version 1.0
 * 23. Merge k Sorted Lists
 * 将所有的Node放在一个数组中创建小堆，每次取出最小的元素以后，更新堆
 */
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

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
    public ListNode mergeKLists(ListNode[] lists) {
        //整体思路把所有的节点通过数组建小堆，每次取出第一个元素，调整一次堆，将每次取出的元素前后连接起来
        //考虑到节点总数未知，使用变长数组ArrayList
        List<ListNode> listNodes = new ArrayList<>();
        //先判断lists非空
        if(lists.length == 0)return null;
        //建堆
        int nodeNum =0;
        for(int i=0;i<lists.length;i++){
            ListNode now = lists[i];
            while(now!=null){
                listNodes.add(now);
                int pos = nodeNum ++;
                //对新插入的元素进行上浮，调整为小堆
                while(pos>0){
                    int j = (pos-1)/2;
                    ListNode temp = listNodes.get(j);
                    if(temp.val>now.val){
                        listNodes.set(pos,temp);
                        pos = j;
                    }
                    else break;
                }
                listNodes.set(pos,now);
                now = now.next;
            }
        }
        //lists中均为空链表的情况需要特判
        if(listNodes.size()==0)return null;
        //建堆完成，依次取出最小值
        ListNode last = listNodes.get(0);
        ListNode first = last;
        int endIndex = nodeNum-1;
        for(int i=0;i<nodeNum;i++){
            ListNode end = listNodes.get(endIndex--);
            listNodes.set(0,end);
            int pos = 0;
            while(2*pos+1<=endIndex){
                int j = 2*pos+1;
                //取出子节点中较小的那一个
                if(j<endIndex&&listNodes.get(j).val>listNodes.get(j+1).val)j++;
                ListNode temp = listNodes.get(j);
                //若父节点比子节点大进行下沉的操作
                if(temp.val<end.val){
                    listNodes.set(pos,temp);
                    pos = j;
                }
                else break;
            }
            listNodes.set(pos,end);
            last.next = listNodes.get(0);
            last = last.next;
        }
        last.next = null;
        return first;
    }
}
