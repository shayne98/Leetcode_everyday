package leecode.math.No504;

/**
 * @author 小羊Shaun
 * @version 1.0
 * 简单进制转换
 */
class Solution {
    public String convertToBase7(int num) {
        int op = 1;
        if(num<0){
            num = -1*num;
            op = -1;
        }
        int num_7=0;
        long pro =1;
        while(num>0){
            num_7+=pro*(num%7);
            num/=7;
            pro*=10;
        }
        num_7 *= op;
        return Integer.toString(num_7);
    }
}