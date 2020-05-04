import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;


public class StreamPractice {


    public static void main(String[] args){


        class Person{

            private String name;
            private int age;

            public Person(String name, int age){
                this.setName(name);
                this.setAge(age);
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }

            public void show(){
                System.out.println("name:"+this.name+"  age:"+this.age);
            }

            @Override
            public String toString(){
                return "__name:"+this.name+"  age:"+this.age;
            }
        }


        List<Person> list = new ArrayList<>();
        list.add(new Person("jack", 20));
        list.add(new Person("tom", 30));
        list.add(new Person("mike", 25));

        List<Person> result = list.stream().filter(person->person.getAge()==20).collect(Collectors.toList());


        result = list.stream().sorted(Comparator.comparingInt(Person::getAge)).collect(Collectors.toList());


        result = list.stream().sorted((p1,p2)->p1.getAge()-p2.getAge()).collect(Collectors.toList());

        for(Person p:result){
            p.show();
        }

        //计算年龄总和：
        int sum_1 = list.stream().map(Person::getAge).reduce(0, (a, b) -> a + b);
        //与之相同:
        int sum_2 = list.stream().map(Person::getAge).reduce(0, Integer::sum);


        list.stream().sorted((p1,p2)->p1.getAge()-p2.getAge()).forEach(System.out::println);


        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] pArr = paragraph.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<pArr.length;i++){
            String temp = pArr[i].toLowerCase();
            map.put(temp, map.getOrDefault(temp, 0)+1);
        }

        String max= map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();


        class Apple {
            private Integer id;
            private String name;
            private BigDecimal money;
            private Integer num;
            public Apple(Integer id, String name, BigDecimal money, Integer num) {
                this.setId(id);
                this.setName(name);
                this.setMoney(money);
                this.setNum(num);
            }

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public BigDecimal getMoney() {
                return money;
            }

            public void setMoney(BigDecimal money) {
                this.money = money;
            }

            public Integer getNum() {
                return num;
            }

            public void setNum(Integer num) {
                this.num = num;
            }
        }


        List<Apple> appleList = new ArrayList<>();//存放apple对象集合

        Apple apple1 =  new Apple(1,"苹果1",new BigDecimal("3.25"),10);
        Apple apple12 = new Apple(1,"苹果2",new BigDecimal("1.35"),20);
        Apple apple2 =  new Apple(2,"香蕉",new BigDecimal("2.89"),30);
        Apple apple3 =  new Apple(3,"荔枝",new BigDecimal("9.99"),40);

        appleList.add(apple1);
        appleList.add(apple12);
        appleList.add(apple2);
        appleList.add(apple3);


        /**
         *
         * for and stream()
         *
         */

         List<Apple> appleLink = new LinkedList<>();
         for(Apple ap:appleList){
             boolean diff = appleLink.stream().anyMatch(arg->arg.getId().equals(ap.getId()));
             if(!diff){
                 appleLink.add(ap);
             }
         }



        //List里面的对象元素，以某个属性来分组，例如，以id分组，将id相同的放在一起：
        Map<Integer, List<Apple>> groupBy = appleList.stream().collect(Collectors.groupingBy(Apple::getId));


        /**
         * List -> Map
         * 需要注意的是：
         * toMap 如果集合对象有重复的key，会报错Duplicate key ....
         *  apple1,apple12的id都为1。
         *  可以用 (k1,k2)->k1 来设置，如果有重复的key,则保留key1,舍弃key2
         */
        Map<Integer, Apple> appleMap = appleList.stream().collect(Collectors.toMap(Apple::getId, a -> a,(k1,k2)->k1));
       // 打印appleMap
       //{1=Apple{id=1, name='苹果1', money=3.25, num=10}, 2=Apple{id=2, name='香蕉', money=2.89, num=30}, 3=Apple{id=3, name='荔枝', money=9.99, num=40}}


        //过滤出符合条件的数据
        List<Apple> filterList = appleList.stream().filter(a -> a.getName().equals("香蕉")).collect(Collectors.toList());

       // System.err.println("filterList:"+filterList);
        //[Apple{id=2, name='香蕉', money=2.89, num=30}]

        //计算 总金额
        BigDecimal totalMoney = appleList.stream().map(Apple::getMoney).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.err.println("totalMoney:"+totalMoney);  //totalMoney:17.48

        /*


        Collectors.maxBy 和 Collectors.minBy 来计算流中的最大或最小值。


        Optional<Dish> maxDish = Dish.menu.stream().
              collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories)));
        maxDish.ifPresent(System.out::println);

        Optional<Dish> minDish = Dish.menu.stream().
              collect(Collectors.minBy(Comparator.comparing(Dish::getCalories)));
        minDish.ifPresent(System.out::println);



        List<Person> unique = appleList.stream().collect(
                collectingAndThen(
                        toCollection(() -> new TreeSet<>(comparingLong(Apple::getId))), ArrayList::new)
        );
        */


        /**
         *
         *reduce
         * reduce operation applies a binary operator to each element in the stream where the first argument to the operator is the return value of the
         * previous application and second argument is the current stream element.
         *
         */
        List<String> words = Arrays.asList("GFG", "Geeks", "for", "GeeksQuiz", "GeeksforGeeks");
        Optional<String> longestString = words.stream().reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2);
        longestString.ifPresent(System.out::println); // GeeksforGeeks

        String[] array = { "Geeks", "for", "Geeks" };
        Optional<String> String_combine = Arrays.stream(array).reduce((str1, str2)-> str1 + "-" + str2);
        if (String_combine.isPresent()) {
            System.out.println(String_combine.get());
        }//Geeks-for-Geeks

        List<Integer> array_1 = Arrays.asList(-2, 0, 4, 6, 8);
        int sum = array_1.stream().reduce(0, (element1, element2) -> element1 + element2);

        /**
         *
         * parallelStream
         *
         */
        List<Integer> list2 = Arrays.asList(5, 6, 7);
        int res = list2.parallelStream().reduce(1, (s1, s2) -> s1 * s2, (p, q) -> p * q);
        System.out.println(res);

        String[] array_2 = {"Mohan", "Sohan", "Mahesh"};
        Arrays.stream(array_2).reduce((x, y) -> x +"," + y).ifPresent(s -> System.out.println("Array to String: "+ s));


        // Stream 求平均值
        int vals[] = { 2, 4, 6, 8, 10, 12, 14, 16 };
        int sum_0 = Arrays.stream(vals).sum();
        Arrays.stream(vals).average();

        long n = Arrays.stream(vals).count();//8


        /**
         *
         * foreach()
         */
        int[] nums = { 3, 4, 2, 1, 6, 7 };
        Arrays.stream(nums).forEach((e) -> { System.out.println(e); });

        Set<String> brands = new HashSet<>();

        brands.add("Nike");
        brands.add("IBM");
        brands.add("Google");
        brands.add("Apple");
        brands.forEach((e) -> { System.out.println(e); });

        Map<String, Integer> items = new HashMap<>();
        items.put("coins", 3);
        items.put("pens", 2);
        items.put("keys", 1);
        items.put("sheets", 12);
        items.forEach((k, v) -> {
            System.out.printf("%s : %d%n", k, v);
        });

        List<String> items_1 = new ArrayList<>();

        items_1.add("coins");
        items_1.add("pens");
        items_1.add("keys");
        items_1.add("sheets");

        items_1.forEach((String name) -> {
            System.out.println(name);
        });


        List<Integer> list_1 = Arrays.asList(5, 11,17,123);
        List<Integer> list_2 = Arrays.asList(124,14,80);
        OptionalInt min = list_1.stream()
                .flatMap(nn -> list_2.stream()
                        .map(r -> nn-r > 0? nn-r: r-nn))
                .mapToInt(t -> t).min();
        System.out.println(min.getAsInt());



    }





}


