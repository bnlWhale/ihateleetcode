

import java.util.*;


public class Leetcode_155_Min_stack {

    static class MinStack {

        /** initialize your data structure here. */

        Stack stack = new Stack();
        private int min = Integer.MIN_VALUE;

        public MinStack() {

        }

        public void push(int x) {

            stack.push(x);
            if(min>=x){
                stack.push(min);
                min = x;

            }

        }

        public void pop() {

            if((int)stack.pop()==min){
                min = (int)stack.pop();
            }

        }

        public int top() {
             return (int)stack.peek();
        }

        public int getMin() {
            return this.min;
        }
    }

}
