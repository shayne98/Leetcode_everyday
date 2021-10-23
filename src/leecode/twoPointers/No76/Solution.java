package leecode.twoPointers.No76;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
@SuppressWarnings("all")
class Solution {
//    public static void main(String[] args) {
//        String s = "ADOBECODEBANC";
//        String t = "ABC";
//        System.out.println(new Solution().minWindow(s,t));
//
//    }
    //O(n) time |O(1) space
    public String minWindow(String s, String t) {

        int[] tSeen=new int[125];//小写的ascii码最大为122
        boolean[] flag = new boolean[125];
        int l=0,r=0;
        int min_len=s.length()+1;
        int min_L=0;
        int t_len = t.length();
        int cnt =0;
        //计算t中各字符出现的次数
        for(int i=0;i<t_len;i++){
            char ch = t.charAt(i);
            tSeen[ch]++;
            flag[ch]=true;
        }
        //滑动窗口遍历字符串s
        for(r=0;r<s.length();r++){
                char ch = s.charAt(r);
                //若右端字符在t中出现过且出现次数小于t中的出现次数
                if(flag[ch]&&--tSeen[ch]>=0){
                    cnt++;
                }

                //t字符出现次数总数达到t的字符长度时，子字符串已找到
                //保存最小长度和当前l的值
                while (cnt==t_len){
                    if(min_len>r-l+1){
                        min_L = l;min_len=r-l+1;
                    }
                    ch = s.charAt(l);
                    //右移l，尽可能使字符串短，左端字符若在t中出现过且计算过次数，l右移需要减去该出现的次数
                    if(flag[ch]&&++tSeen[ch]>0){
                        --cnt;;
                }
                    l++;
            }
        }
        //若大于s的长度，就说明min_len为初值，没有找到这个子字符串
        return min_len>s.length()? "":s.substring(min_L,min_L+min_len);

    }
}