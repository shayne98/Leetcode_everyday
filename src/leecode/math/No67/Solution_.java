package leecode.math.No67;

/**
 * @author 小羊Shaun
 * @version 2.0
 * No 67. Add Binary 字符串二进制加法，使用StringBuffer的翻转函数
 * 按位相加注意进位
 */
public class Solution_{
    public String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        //使用StringBuffer因为内置了reverse函数
        StringBuffer ans = new StringBuffer();
        while(i>=0||j>=0){
            //先加进位
            int sum = carry ;
            //进位初始化
            carry =0;
            if(i>=0){
                sum += a.charAt(i)-'0';
                i--;
            }
            if(j>=0){
                sum += b.charAt(j)-'0';
                j--;
            }
            //加起来超过1需要进位
            if(sum>1){
                carry = 1;
                sum =sum %2;
            }
            ans.append(sum);
        }
        //最后还有进位补上即可
        if(carry>0)
            ans.append(carry);
        return new String(ans.reverse());
    }
}
