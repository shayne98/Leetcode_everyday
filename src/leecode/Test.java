package leecode;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.swing.plaf.PanelUI;
import java.security.PublicKey;
import java.util.*;

@SuppressWarnings("all")

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        ArrayList<Integer> output = new ArrayList<>();
        char[] words = expression.toCharArray();
        boolean op = false;
        for(int i=0;i<expression.length();i++){
            char ch = words[i];
            if(ch=='+'||ch=='-'||ch=='*'){
                op = true;
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i+1));
                for (Integer integer1 : left) {
                    for (Integer integer2 : right) {
                        switch (ch){
                            case '+':
                                output.add(integer1+integer2);
                                break;
                            case '-':
                                output.add(integer1-integer2);
                                break;
                            case '*':
                                output.add(integer1*integer2);
                                break;
                        }
                    }
                }
            }
        }
        if(op==false){
            output.add(new Integer(expression));
        }
        return output;
    }
}