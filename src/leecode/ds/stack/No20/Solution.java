package leecode.ds.stack.No20;

import java.util.Stack;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i] == '('||chars[i] == '['||chars[i] == '{'){
                stack.push(chars[i]);
            }
            else{
                if(stack.empty())return false;
                char top = stack.pop();
                char ch = chars[i];
                switch (ch){
                    case ')':
                        if(top != '('){
                            return false;
                        }
                        break;
                    case ']':
                        if(top != '['){
                            return false;
                        }
                        break;
                    case '}':
                        if(top != '{'){
                            return false;
                        }
                        break;
                }
            }
        }
        if(!stack.empty()){
            return false;
        }
        return true;

    }
}