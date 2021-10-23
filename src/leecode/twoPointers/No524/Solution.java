package leecode.twoPointers.No524;

import java.util.*;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
@SuppressWarnings("all")
//O(nlogn+
class Solution {
//    public static void main(String[] args) {
//        String s = "abpcplea";
//        String[] str = new String[]{"ale","apple","monkey","plea"};
//        List<String> dictionary=Arrays.asList(str);
//        System.out.println(new Solution().findLongestWord(s,dictionary));
//    }
    public String findLongestWord(String s, List<String> dictionary) {
        //首先需要对List内的String进行排序，第一关键词是长度，第二关键词是字典序
        Collections.sort(dictionary, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //这里可以精简代码为三元运算符
                if(o1.length()!=o2.length())return o2.length()-o1.length();
                else return o1.compareTo(o2);
            }
        });
        //System.out.println(dictionary.toString());

        for (int i = 0; i <dictionary.size(); i++) {
            String term = dictionary.get(i);
            int term_len = term.length();
            if(term_len>s.length())continue;
            int p = 0;
            int q = 0;
            while(p<term_len&&q<s.length())
                if(s.charAt(q++)==term.charAt(p))p++;
            if(p==term_len)return term;
        }
        return "";
    }
}