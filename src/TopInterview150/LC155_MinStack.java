package TopInterview150;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:
 - MinStack() initializes the stack object.
 - void push(int val) pushes the element val onto the stack.
 - void pop() removes the element on the top of the stack.
 - int top() gets the top element of the stack.
 - int getMin() retrieves the minimum element in the stack.

You must implement a solution with O(1) time complexity for each function.

Example 1:
Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]
Output
[null,null,null,null,-3,null,0,-2]
Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 */
public class LC155_MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}

class MinStack {

    Stack<Integer> stack = new Stack<>();
    List<Integer> list = new ArrayList<>();
    int min = Integer.MAX_VALUE;

    public MinStack() {
    }

    public void push(int val) {
        stack.add(val);
        if (val <= min) {
            list.add(val);
            min = val;
        }
    }

    public void pop() {
        int a = stack.pop();
        if (a == min) {
            list.removeLast();
            if (list.isEmpty())
                min = Integer.MAX_VALUE;
            else
                min = list.getLast();
        }
    }

    public int top() {
        return stack.getLast();
    }

    public int getMin() {
        return min;
    }
}

/*
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */