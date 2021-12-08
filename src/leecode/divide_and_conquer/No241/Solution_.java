package leecode.divide_and_conquer.No241;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author 小羊Shaun
 * @version 1.0
 * DFS改进为传进String变量
 * 用动态规划记录深搜过的结果，加快深搜速度
 */
@SuppressWarnings("all")
public class Solution_ {
    HashMap<String,List> memo = new HashMap<>();
    public List<Integer> diffWaysToCompute(String expression) {
        if(memo.containsKey(expression)){
            return memo.get(expression);
        }
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
        memo.put(expression,output);
        return output;
    }
}
