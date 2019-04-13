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
    }





}
