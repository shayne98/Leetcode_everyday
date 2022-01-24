package leecode.ds.stack.No739;

import java.util.Stack;

/**
 * @author 小羊Shaun
 * @version 1.0
 * 739. Daily Temperatures
 * 单调栈，将入栈顺序压栈，当栈顶温度小于当前温度时找到对应的天数，栈顶元素出栈，通过入栈顺序相减得到等待天数
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack();
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.empty()) {
                int topid = stack.peek();
                if (temperatures[topid] >= temperatures[i]) break;
                ans[topid] = i - topid;
                stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }
}