package leecode.math.No67;

/**
 * @author 小羊Shaun
 * @version 1.0
 * No 67. Add Binary
 */
class Solution {
    public String addBinary(String a, String b) {
        int len1 = a.length(),len2 = b.length();
        StringBuffer sb1 = new StringBuffer(a).reverse();
        StringBuffer sb2 = new StringBuffer(b).reverse();
        StringBuffer ans = new StringBuffer();
        int i =0;
        int carry = 0;
        while(i<a.length()&&i<b.length()){
            int ch1 = sb1.charAt(i)-'0';
            int ch2 = sb2.charAt(i)-'0';
            int sum = (ch1+ch2+carry)%2;
            carry = ch1+ch2+carry>1?1:0;
            ans.append(sum);
            i++;
        }
        while (i<a.length()){
            int ch1 = sb1.charAt(i)-'0';
            int sum = (ch1+carry)%2;
            carry = ch1+carry>1?1:0;
            ans.append(sum);
            i++;
        }
        while (i<b.length()){
            int ch2 = sb2.charAt(i)-'0';
            int sum = (ch2+carry)%2;
            carry = ch2+carry>1?1:0;
            ans.append(sum);
            i++;
        }
        if(carry>0){
            ans.append(carry);
        }
        return new String(ans.reverse());
    }
}