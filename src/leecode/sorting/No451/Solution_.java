package leecode.sorting.No451;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 小羊Shaun
 * @version 1.0
 *
 */
public class Solution_ {
    public String frequencySort(String s) {
        int[][] buckets = new int[126][2];
        char[] chars = s.toCharArray();
        int len = chars.length, i,j,p=0;
        for (char ch : chars) {
            //二维数组其中一位保存char值
            buckets[ch][0] = ch;
            buckets[ch][1] ++;
        }
        //对桶进行排序，注意匿名函数的简写
        Arrays.sort(buckets, (a, b) -> {
            return b[1] - a[1];
        });
        char[] ans = new char[len];
        //这里必须写126，不能写len，当重复元素过多的时候，很可能超过126
        for (i = 0; i < 126; i++) {
            for(j=0;j<buckets[i][1];j++){
                ans[p++] = (char)buckets[i][0];
            }
        }
        return new String(ans);
    }
}
