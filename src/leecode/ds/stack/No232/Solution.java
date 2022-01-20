package leecode.ds.No232;

import java.util.Stack;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
class MyQueue {
    Stack<Integer>s1;
    Stack<Integer>s2;
    int front;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();

    }

    public void push(int x) {
        if(s2.empty()&&s1.empty()){
            front = x;
        }
        s1.push(x);

    }

    public int pop() {
        if(!s2.empty()){
            return s2.pop();
        }
        else{
            while (!s1.empty()){
                int temp = s1.pop();
                s2.push(temp);
            }
            return s2.pop();
        }

    }

    public int peek() {
        if(!s2.empty()){
            return s2.peek();
        }
        else{
            return front;
        }

    }

    public boolean empty() {
        if(s1.empty()&&s2.empty())return true;
        else return false;

    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */