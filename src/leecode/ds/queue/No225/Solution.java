package leecode.ds.queue.No225;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author 小羊Shaun
 * @version 1.0
 * 225. Implement Stack using Queues
 * 用两个队列来实现栈，
 */
class MyStack {
    Queue<Integer> q1,q2;
    public MyStack() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();

    }

    public void push(int x) {
        q1.offer(x);

    }

    public int pop() {
        this.top();
        int peek = q1.poll();
        Queue<Integer> temp = q2;
        q2 = q1;
        q1 = temp;
        return peek;
    }

    public int top() {
        while(q1.size()>1){
            q2.offer(q1.poll());
        }
        return q1.peek();

    }

    public boolean empty() {
        return q1.isEmpty();

    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */