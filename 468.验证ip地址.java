import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * @lc app=leetcode.cn id=468 lang=java
 *
 * [468] 验证IP地址
 */

// @lc code=start
class Solution {
    public String validIPAddress(String queryIP) {
        // char[] chars = queryIP.toCharArray()
        Pattern ipv4Pattern = Pattern.compile("(0|[1-9]\\d{0,2})(\\.(0|[1-9]\\d{0,2})){3}");
        Pattern ipv6Pattern = Pattern.compile("[a-f|A-F|0-9]{1,4}(:[a-fA-F0-9]{1,4}){7}");

        Matcher mIpv4 = ipv4Pattern.matcher(queryIP);
        boolean isIpv4 = true;
        if(mIpv4.matches()){
            String[] strs = queryIP.split("\\.");
            for(String str:strs){
                System.out.println(str);
                int num = Integer.parseInt(str);
                if(num<0||num>255){
                    isIpv4 = false;
                    break;
                }
            }

        }else{
            isIpv4 = false;
        }
        if(isIpv4){
            return "IPv4";
        }
        
        Matcher mIpv6 = ipv6Pattern.matcher(queryIP);
        return mIpv6.matches()?"IPv6":"Neither";




    }
}
// @lc code=end

