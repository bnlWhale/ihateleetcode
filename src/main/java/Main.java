import java.util.ArrayList;

public class Main {

    public static void main(String[] args){

        //397. Integer Replacement

        /*
        Given a positive integer n and you can do operations as follow:

        If n is even, replace n with n/2.
        If n is odd, you can replace n with either n + 1 or n - 1.
        What is the minimum number of replacements needed for n to become 1?
        */

        int n=10000;
        int m=0;
        int[] array = new int[100];

        integerReplacement(n,m,array);

        System.out.println("Main end "+"  "+m);
    }


    private static void integerReplacement(int n, int times, int[] array){

        if(n==1){
            System.out.println("times needed:"+times);
            return;
        }
        if(n%2==0){
            ++times;
            array[times] = n/2;
           // System.out.println(n/2);
            integerReplacement(n/2,times ,array);

        }else{

            int m=1;
            if(n>3 && ((n&3)==3)){
                m = n+1;
            }else{
                m = n-1;
            }
            ++times;
            array[times]=m;
           // System.out.println(m);
            integerReplacement(m, times, array);
        }
    }

}
