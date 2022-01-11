package leecode.bitwise_operation.No318;

import java.util.HashMap;

/**
 * @author 小羊Shaun
 * @version 1.0
 * No318. Maximum Product of Word Lengths
 *利用位与来判断两个word是否相同，通过26位二进制数字来存储每个word出现的letter
 */
class Solution {
    public int maxProduct(String[] words) {
        int[] mask = new int[words.length];
        int[] len = new int[words.length];
        for(int i=0;i<words.length;i++){
            String str = words[i];
            char[] chars = str.toCharArray();
            int num =0;
            for(int j =0;j<chars.length;j++){
                num|=1<<(chars[j]-'a');
            }
            mask[i] = num;
            len[i] = chars.length;
        }
        int max_product = 0;
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if((mask[i] & mask[j])==0&&len[i]*len[j]>max_product){
                    max_product = len[i]*len[j];
               }
            }
        }
        return max_product;

    }
}
