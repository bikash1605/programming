package com.personal.leetcode.stacks;

import java.util.Stack;

public class MinStack_155 {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack_155() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }
    
    public void push(int val) {
        this.stack.push(val);
        
        val = Math.min(val, this.minStack.isEmpty() ? val : this.minStack.peek());
        this.minStack.push(val);
    
    }
    
    public void pop() {
        this.stack.pop();
        this.minStack.pop();
    }
    
    public int top() {
       return  this.stack.peek();
    }
    
    public int getMin() {
        return this.minStack.peek();
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
