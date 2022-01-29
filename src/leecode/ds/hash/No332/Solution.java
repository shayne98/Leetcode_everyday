package leecode.ds.hash.No332;

import java.util.*;

/**
 * @author 小羊Shaun
 * @version 1.0
 * 332. Reconstruct Itinerary
 */
class Solution {
    Stack<String> res = new Stack<>();
    HashMap<String,List<String>> map = new HashMap<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        if(tickets.size()==0)return new ArrayList<>();
        //维持字典序大的在前，这样在后续遍历的过程中字典序小的先入栈后出栈，
        Collections.sort(tickets,(a, b)->(a.get(1).compareTo(b.get(1))));
        Stack<String> s = new Stack<>();
        s.push("JFK");
        for (List<String> ticket : tickets) {
            String str1 = ticket.get(0);
            String str2 = ticket.get(1);
            if(map.containsKey(str1)){
                map.get(str1).add(str2);
            }
            else{
                List<String> temp = new ArrayList<>();
                temp.add(str2);
                map.put(str1,temp);
            }
        }
        while (!s.empty()){
            String temp = s.peek();
            if(map.containsKey(temp)&&!map.get(temp).isEmpty()){
                Iterator<String> iterator = map.get(temp).iterator();
                s.push(iterator.next());
                iterator.remove();
            }
            else{
                res.push(temp);
                s.pop();
            }
        }
        List<String>ans = new ArrayList<>();
        while (!res.empty()){
            ans.add(res.pop());
        }
        return ans;

    }

}