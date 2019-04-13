/*


How would you design a stack which, in addition to push and pop, also has a function 
min which returns the minimum element? Push, pop and min should all operate in 
O(1) time

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.


 */


import java.util.Stack;

public class Leetcode_155 {

    static class Node{

        int data;
        int min;

        public Node(int data){
            this.data = data;
        }

        public  Node next;



    }


    static class MinStackLink{

        Node top;
        private int min = Integer.MAX_VALUE;

        int pop(){
            if(top != null){
                top = top.next;
                return top.data;
            }
            return Integer.MAX_VALUE;
        }

        void push(int item){
            Node t = new Node(item);
            t.next = top;
            top = t;
            if(item<min){
                min = item;
            }
            t.min = min;
        }

        int getMin(){
            if(top != null){
                return top.min;
            }
            return min;
        }

    }




    public static void main(String[] args){


        MinStackLink ml = new MinStackLink();


        ml.push(1);
        ml.push(-1);
        ml.push(-2);
        ml.push(-1);
        System.out.println(ml.getMin());
        ml.pop();
        ml.pop();
        ml.pop();
        System.out.println(ml.getMin());

        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(-1);
        minStack.push(-2);
        minStack.push(-1);

        //System.out.println(minStack.top());
        //minStack.pop();
        //System.out.println(minStack.getMin());
    }

    static class MinStack {
        long min;
        java.util.Stack<Long> stack;

        public MinStack(){
            stack=new java.util.Stack<Long>();
        }

        public void push(int x) {
            if (stack.isEmpty()){
                stack.push(0L);
                min=x;
            }else{
                stack.push(x-min);//Could be negative if min value needs to change
                if (x<min) min=x;
            }
        }

        public void pop() {
            if (stack.isEmpty()) return;

            long pop=stack.pop();

            if (pop<0)  min=min-pop;//If negative, increase the min value


        }

        public int top() {
            long top=stack.peek();
            if (top>0){
                return (int)(top+min);
            }else{
                return (int)(min);
            }
        }

        public int getMin() {
            return (int)min;
        }
    }


}
