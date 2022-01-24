//package leecode.ds.stack.No155;
//
//import java.util.Stack;
//
///**
// * @author 小羊Shaun
// * @version 1.0
// * 用另一个栈储存最小值
// * 155. Min Stack
// */
//class MinStack {
//    Stack<Integer> stack;
//    Stack<Integer> min_stack;
//
//    public MinStack() {
//        stack = new Stack();
//        min_stack = new Stack();
//
//    }
//
//    public void push(int val) {
//        if(min_stack.empty()||val<=min_stack.peek()){
//            min_stack.push(val);
//        }
//        stack.push(val);
//
//    }
//
//    public void pop() {
//        int temp = stack.pop();
//        if(temp==min_stack.peek()){
//            min_stack.pop();
//        }
//    }
//
//    public int top() {
//        return stack.peek();
//
//    }
//
//    public int getMin() {
//        return min_stack.peek();
//    }
//}
//
///**
// * Your MinStack object will be instantiated and called as such:
// * MinStack obj = new MinStack();
// * obj.push(val);
// * obj.pop();
// * int param_3 = obj.top();
// * int param_4 = obj.getMin();
// */