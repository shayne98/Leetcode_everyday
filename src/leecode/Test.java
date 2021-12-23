package leecode;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.swing.plaf.PanelUI;
import java.security.PublicKey;
import java.util.*;

@SuppressWarnings("all")
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        char[] chars = expression.toCharArray();
        int len = chars.length;
        boolean flag = false;
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<len;i++){
            char ch = chars[i];
            if(ch=='+'||ch=='-'||ch=='*'){
                flag = true;
                List<Integer> left = new ArrayList<>();
                List<Integer> right = new ArrayList<>();
                left = diffWaysToCompute(expression.substring(0,i));
                right = diffWaysToCompute(expression.substring(i+1));
                for (Integer num1 : left) {
                    for (Integer num2 : right) {
                        switch (ch){
                            case '+':
                                ans.add(num1+num2);
                                break;

                            case '-':
                                ans.add(num1-num2);
                                break;
                            case '*':
                                ans.add(num1*num2);
                                break;
                        }
                    }
                }
            }
        }
        if(!flag){
            int sum = 0;
            for (char ch : chars) {
                sum = 10*sum+ch-'0';
            }
            ans.add(sum);
        }
        return ans;
    }
}