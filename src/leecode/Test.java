package leecode;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.swing.plaf.PanelUI;
import java.security.PublicKey;
import java.util.*;

@SuppressWarnings("all")
class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] num = new int[len];
        Arrays.fill(num,1);
        int total = len;
        //从左往右遍历调整右边的元素，使得每个元素和相邻右边的元素均满足要求
        for(int i=1;i<len;i++){
            if(ratings[i]>ratings[i-1]&&num[i]<=num[i-1]){
                total += num[i-1]-num[i]+1;
                num[i] = num[i-1]+1;
            }
        }
        //如法炮制，从右往左遍历
        for(int i=len-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]&&num[i]<=num[i+1]){
                total += num[i+1]-num[i]+1;
                num[i] = num[i+1]+1;
            }
        }
        return total;
    }
}