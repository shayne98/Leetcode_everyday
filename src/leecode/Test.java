package leecode;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.swing.plaf.PanelUI;
import java.security.PublicKey;
import java.util.*;

@SuppressWarnings("all")
class Solution {
    int[][] mem ;
    public int maxCoins(int[] nums) {
        int len = nums.length+2;
        int[] op_nums = new int[len];
        mem = new int[len][len];
        op_nums[0] = 1;
        op_nums[len-1] = 1;
        for(int i=1;i<len-1;i++){
            op_nums[i] = nums[i-1];
        }
        return devide_conquer(op_nums,0,len-1);

    }
    public int devide_conquer(int[] op_nums,int st,int ed){
        if(st+1==ed)return 0;
        if(mem[st][ed]>0)return mem[st][ed];
        int max = 0;
        for(int i=st+1;i<ed;i++){
            int num = op_nums[i];
            int left = devide_conquer(op_nums,st,i);
            int right = devide_conquer(op_nums,i,ed);
            max = Math.max(max,left+right+num*op_nums[st]*op_nums[ed]);
        }
        mem[st][ed] = max;
        return max;
    }
}