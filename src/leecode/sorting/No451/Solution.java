package leecode.sorting.No451;

import java.util.*;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
class Solution {
    public String frequencySort(String s) {
        if(s.isEmpty()) return s;
        int[][] f = new int[126][2];
        for(char c: s.toCharArray()) {f[c][0] = c; f[c][1]++; }
        Arrays.sort(f,(a, b)->{return b[1]-a[1];});
        char[] rv = new char[s.length()];
        int li = 0;
        for(int i =0;i<126;i++){
            for(int j = 0; j<f[i][1];j++){
                rv[li++]=(char)f[i][0];
            }
        }
        return new String(rv);
    }
}
