package leecode.ds.stack.No155;

import java.util.Stack;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
class MinStack {
    class Node{
        int val,minValue;

        public Node(int val, int minValue) {
            this.val = val;
            this.minValue = minValue;
        }
    }
    Stack<Node> stack;

    public MinStack() {
        stack = new Stack<>();

    }

    public void push(int val) {
        if(stack.empty()){
            Node node = new Node(val, val);
            stack.push(node);
        }
        else{
            Node last = stack.peek();
            int min = Math.min(val,last.minValue);
            stack.push(new Node(val,min));
        }
    }

    public void pop() {
        stack.pop();


    }

    public int top() {
        return stack.peek().val;

    }

    public int getMin() {
        Node top = stack.peek();
        return top.minValue;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */