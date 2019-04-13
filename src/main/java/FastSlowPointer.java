/*








 */


public class FastSlowPointer {


    public static void main(String[] arg){

       int[] nums = {1,2,3,4,5};

       boolean notFind = true;
       int total = 0;
       int length = nums.length;
       int t1=-1;
       int t2=-1;
       int i=0;
       int j=2;
       while(total<150 && notFind){

           total++;
           if(i>length-1){
               i = i%length;
           }
           if(j>length-1){
               j = j%length;
           }
           System.out.println(nums[i]+"  "+nums[j]);
           if(nums[i] == nums[j]){
               System.out.println("find");
               notFind = false;
           }
           i++;
           j +=2;
       }


    }


}
