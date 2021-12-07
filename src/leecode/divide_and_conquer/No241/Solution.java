package leecode.divide_and_conquer.No241;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 小羊Shaun
 * @version 1.0
 * 241. Different Ways to Add Parentheses
 * 通过操作符将表达式不断一分为二，分治思想
 *
 */
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        char[] input = expression.toCharArray();
        System.out.println(input);
        return DFS(input);
    }
    public ArrayList<Integer> DFS(char[] input){
        ArrayList<Integer> output = new ArrayList<>();
        boolean op = false;//用于判断表达式中是否有符号
        for(int i=0;i<input.length;i++){
            char c = input[i];
            if(c=='-'||c=='+'||c=='*'){
                //把整个表达式根据符号分为左右两半
                op =true;
                //分别计算左边和右边的表达式所有的可能值
                ArrayList<Integer> left = DFS(Arrays.copyOfRange(input,0,i));
                ArrayList<Integer> right = DFS(Arrays.copyOfRange(input,i+1,input.length));
                //把所有的可能值进行组合计算表达式的值，将值放入output中
                for (Integer integer1 : left) {
                    for (Integer integer2 : right) {
                        switch (c){
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
        //若表达式中没有操作符，直接计算所有char组成的数字的大小
        if(op==false){
            int sum=0;
            for(int i=0;i<input.length;i++){
                sum=10*sum+input[i]-'0';
            }
            output.add(sum);
        }
        return output;
    }
}
