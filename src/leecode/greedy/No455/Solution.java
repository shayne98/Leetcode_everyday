package leecode.greedy.No455;

import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gp = 0;
        int sp = 0;
        while(gp<g.length&&sp<s.length){
            if(s[sp]>=g[gp])gp++;
            sp++;
        }
        return gp;
    }
}
