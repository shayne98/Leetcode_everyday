package leecode.ds.hash.No560;

import java.util.HashMap;

/**
 * @author 小羊Shaun
 * @version 1.0
 */

class Solution {
    public int subarraySum(int[] nums, int k) {
        int psum =0,ans=0;
        //用来记录前缀和psum对应的情况数量
        HashMap<Integer,Integer> map = new HashMap<>();
        //0的情况就是前缀和本身就构成了k
        map.put(0,1);
        for(int num: nums){
            psum += num;
            //当psum-k存在时psum每多一个，ans就会增加psum-k的个数
            if(map.containsKey(psum-k)){
                ans+= map.get(psum-k);
            }
            //computeIfAbsent 用于防止hashmap中还没有psum的映射初始化为0
            map.computeIfAbsent(psum,key->0);
            map.put(psum,map.get(psum)+1);

        }
        return ans;

    }
}
