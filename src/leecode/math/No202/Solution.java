package leecode.math.No202;

import java.util.HashMap;

/**
 * @author 小羊Shaun
 * @version 1.0
 * 202. Happy Number
 * 这里我用了hashmap用来环路检测，实际上可以使用快慢指针的方法进行环路检测这样可以优化空间复杂度
 */
class Solution {
    public boolean isHappy(int n) {
        HashMap<Integer,Boolean>map = new HashMap<>();
        while(n!=1){
            if(map.containsKey(n)){
                return false;
            }
            else{
                map.put(n,true);
                int temp = 0;
                while(n>0){
                    temp+=(n%10)*(n%10);
                    n/=10;
                }
                n = temp;
            }
        }
        return true;

    }
}