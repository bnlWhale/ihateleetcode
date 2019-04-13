import java.util.*;

public class GoRemerber {

    public static void main(String[] args){

        String str = "abczee";
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        System.out.println(Arrays.toString(charArr));

        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        for(Integer num:map.values()){
            System.out.println("map value:"+num);
        }
        for(String strKey:map.keySet()){
            System.out.println("map key:"+strKey+"  value:"+map.get(strKey));
        }

        List<Integer> aList = new ArrayList<>();
        aList.add(1);
        aList.add(2);
        System.out.println(Arrays.toString(aList.toArray()));



    }


}
