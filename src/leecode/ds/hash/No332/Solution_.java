package leecode.ds.hash.No332;

import javafx.scene.layout.Priority;

import java.util.*;

/**
 * @author 小羊Shaun
 * @version 1.0
 * 332. Reconstruct Itinerary
 * 用Hashmap来储存从一个站出发的所有车多次下一站
 * 通过stack来记录从“JFK”出发的经由的所有站点，每次入栈后再hashmap中取消映射，当栈顶元素在hashmap中没有对应的下一站点时
 * 说明此时该站点为此时的终点站，弹出后记录
 * 需要注意下一站点的取出顺序，由于优先字母序小的，所以hashmap中的取出顺序应该是小根堆
 */
class Solution_{
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>>targets = new HashMap<>();
        List<String>ans = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        for (List<String> ticket : tickets) {
            //computeifabsent当hashmap中不存在该key会执行传入的匿名函数并返回该value
            targets.computeIfAbsent(ticket.get(0),key->new PriorityQueue<String>()).add(ticket.get(1));
        }
        stack.push("JFK");
        while (!stack.empty()) {
            while (targets.containsKey(stack.peek())&&!targets.get(stack.peek()).isEmpty()){
                stack.push(targets.get(stack.peek()).poll());
            }
            ans.add(0,stack.pop());
        }
        return ans;
    }
}
