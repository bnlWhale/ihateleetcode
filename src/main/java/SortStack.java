import java.util.ArrayList;
import java.util.List;

public class SortStack {


    public void startSort(){

        int[ ] aArr = {34, 3, 31, 98, 92, 23};
        Stack stack = new Stack();
        for(int i=0;i<aArr.length;i++){
            stack.push(aArr[i]);
        }

        Stack tempStack = new Stack();
        while(stack.size>0){
            int min = stack.getMin();
            int nowInt = stack.pop();
            if(nowInt != min){
                tempStack.push(nowInt);
            }else{
                boolean isKeepingPop = true;
                while(isKeepingPop){
                    if(tempStack.getSize()==0){
                        isKeepingPop = false;
                        tempStack.push(nowInt);
                    }else{
                        if(tempStack.peel()>nowInt){
                            int currentTemp = tempStack.pop();
                            stack.push(currentTemp);
                        }else{
                            tempStack.push(nowInt);
                            isKeepingPop = false;
                        }
                    }

                }
            }

        }


        System.out.println(tempStack.toString());

    }

    public static void main(String[] args){
        SortStack aSortStack = new SortStack();
        aSortStack.startSort();
    }


    class Stack{

          private int size=0;
          Node head;
          private int min = Integer.MAX_VALUE;

          public void push(int data){
              if(size==0){
                  head = new Node();
                  head.data = data;
                  head.min = min;
              }else{
                  Node node = new Node();
                  node.data = data;
                  node.next = head;
                  head = node;
              }
              if(min>data){
                  min = data;
              }
              head.min = min;
              size += 1;
          }


          public int peel(){
              if(size==0){
                  return 0;
              }
              return head.data;
          }


          public int pop(){

              if(size==0){
                  return -99999;
              }
              Node node = head;
              head = node.next;
              if(head!=null){
                  min = head.min;
              }
              size -=1;
              if(size==0){
                  head=null;
              }
              return node.data;

          }

          public int getMin(){

              return min;
          }

          public int getSize(){
              return size;
          }

          @Override
          public String toString(){

              Node node = head;
              List<Integer> list = new ArrayList<>();
              while(node!=null){
                 list.add(node.data);
                 System.out.println(node.data);
                 node = node.next;

              }
              return list.toArray().toString();
          }

    }


     class Node{

        int data;
        Node next = null;
        int min;

     }

}
