package leecode.math.No168;

/**
 * @author 小羊Shaun
 * @version 1.0
 * 168. Excel Sheet Column Title
 * 进制转换，注意从1开始，不是从0开始
 */class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while(columnNumber>0){
            int num = columnNumber%26==0?26:columnNumber%26;
            char ch = (char)('A'+num-1);
            sb.append(ch);
            columnNumber = num == 26?columnNumber/26-1:columnNumber/26;
        }
        StringBuffer ans = sb.reverse();
        return new String(ans);

    }
}
