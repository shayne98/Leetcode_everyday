package leecode;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.swing.plaf.PanelUI;
import java.security.PublicKey;
import java.util.*;

@SuppressWarnings("all")

class Solution {
    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[] bucket = new int[150];
        Integer[] char2int = new Integer[len];//comparator的不能传入基本数据类型如char，int，必须传入封装类型
        int i=0;
        for (char aChar : chars) {
            bucket[aChar]+=1;
            char2int[i++] = aChar-'A';
        }
        Arrays.sort(char2int,(a,b)->{
            if(bucket['A'+b]!=bucket['A'+a])return bucket['A'+b]-bucket['A'+a];//根据桶内每个字符的数量进行排序，从大到小
            else return b-a;//相同字符的放在一起
        });
        char[] ans = new char[len];
        for( i=0;i<len;i++){
            ans[i] = (char) ('A'+char2int[i]);
        }
        return new String(ans);
    }
}