package leecode.math.No415;

import java.util.Arrays;

/**
 * @author 小羊Shaun
 * @version 1.0
 * No415.415. Add Strings
 * 字符串诸位相加,注意acii码数字加48强转为char就完成了数字转char
 */
class Solution {
    public String addStrings(String num1, String num2) {
        if (num1.length() > num2.length()) {
            String tp = num1;
            num1 = num2;
            num2 = tp;
        }
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        int len1 = arr1.length;
        int len2 = arr2.length;
        char[] ans = new char[len2];
        int carry = 0;
        int j= len1-1;
        for (int i = len2 - 1; i >= 0; i--) {
            int n1 = i < len2 - len1 ? 0 : arr1[j--] - '0';
            int n2 = arr2[i]-'0';
            int sum = (n1 + n2 + carry) >= 10 ? n1 + n2+carry - 10 : n1 + n2+carry;
            carry = (n1 + n2 + carry) >= 10 ? 1 : 0;
            ans[i] = (char)(sum+48);
        }
        char first = (char) (carry +48);
        if(first=='0')return new String(ans);
        return Character.toString(first) + new String(ans);

    }
}