package lambda;

import bean.Person;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author liuyuanju1
 * @date 2018/7/29
 * @description:
 */
public class Demo {

    private List<Person> getPersonList(){
        Person p1 = new Person().setName("liu").setAge(22).setSex("male");
        Person p2 = new Person().setName("zhao").setAge(21).setSex("male");
        Person p3 = new Person().setName("li").setAge(18).setSex("female");
        Person p4 = new Person().setName("wang").setAge(21).setSex("female");
        List<Person> list = Lists.newArrayList();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        return list;
    }
    /**
     * 用lambda表达式实现Runnable
     */
    @Test
    public void test(){
        //old
        new Thread((new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类 实现线程");
            }
        })).start();
        //lambda
        new Thread( () -> System.out.println("java8 lambda实现线程")).start();
    }
    /**
     * forEach 遍历集合
     */
    @Test
    public void test1(){
        List<Person> list = getPersonList();
        list.forEach(person -> System.out.println(person.toString()));
    }

    /**
     * forEach 遍历集合
     *  :: 表示方法引用
     */
    @Test
    public void test2(){
        List<Person> list = getPersonList();
        Consumer<Person> changeAge = e -> e.setAge(e.getAge() + 3);
        list.forEach(changeAge);
        list.forEach(System.out::println);
    }

    /**
     * filter 对集合进行过滤
     */
    @Test
    public void test3(){
        List<Person> list = getPersonList();
        list.stream().filter(e -> e.getAge() > 20)
                     .forEach(e -> System.out.println(e.toString()));
    }

    /**
     * 两种形式的多条件过滤
     */
    @Test
    public void test4(){
        List<Person> list = getPersonList();

        Predicate<Person> ageFilter = e -> e.getAge() > 20;
        Predicate<Person> sexFilter = e -> e.getSex().equals("male");

        //多条件过滤
        list.stream().filter(ageFilter)
                     .filter(sexFilter)
                     .forEach(e -> System.out.println(e.toString()));
        System.out.println("----------------------------");
        // Predicate : and or
        list.stream().filter(ageFilter.and(sexFilter))
                     .forEach(e -> System.out.println(e.toString()));
    }

    /**
     * limit 限制结果集数量
     */
    @Test
    public void  test5(){
        List<Person> list = getPersonList();
        list.stream().limit(3).forEach(e -> System.out.println(e.toString()));

        System.out.println("----------------------------");
        list.stream().limit(2).filter(e -> e.getAge() > 20)
                     .forEach(e -> System.out.println(e.toString()));
    }

    /**
     * sorted  排序
     */
    @Test
    public void test6(){
        List<Person> list = getPersonList();
        //年龄排序
        list.stream().sorted((p1,p2) -> (p1.getAge() - p2.getAge()))
                     .forEach(e -> System.out.println(e.toString()));
        //姓名排序
        System.out.println("----------------------------");
        list.stream().sorted(Comparator.comparing(Person::getName))
                     .forEach(e -> System.out.println(e.toString()));
    }

    /**
     * max min 获取结果中 某个值最大最小的的对象
     */
    @Test
    public void test7(){
        List<Person> list = getPersonList();
        // 如果 最大最小值 对应的对象有多个 只会返回第一个
        Person oldest = list.stream().max(Comparator.comparing(Person::getAge)).get();
        System.out.println(oldest.toString());
    }

    /**
     *  map : 可以遍历集合中的每一个元素，并对其进行操作 变成另一个对象
     */
    @Test
    public void test8(){
        List<Person> list = getPersonList();
        //将 每人的年龄 +3
        System.out.println("修改前：");
        list.forEach(e -> System.out.println(e.toString()));
        System.out.println("修改后：");
        list.stream().map(e -> e.setAge(e.getAge() + 3 ))
                     .forEach(e -> System.out.println(e.toString()));

    }

    /**
     * reduce : 将所有值处理合并为一个
     */
    @Test
    public void test9(){
        //第一个参数是上次函数执行的返回值（也称为中间结果），第二个参数是stream中的元素，
        // 这个函数把这两个值相加，得到的和会被赋值给下次执行这个函数的第一个参数。
        //要注意的是：第一次执行的时候第一个参数的值是Stream的第一个元素，第二个参数是Stream的第二个元素

        //将所有人的年龄加起来 求和
        List<Integer> ages = Arrays.asList(2,5,3,4,7);
        int totalAge = ages.stream().reduce((sum,age) -> sum + age).get();

        System.out.println(totalAge);
        //带 初始值的计算， 如果list没有元素 即stream为null 则直接返回初始值
        int totalAge1 = ages.stream().reduce(0,(sum,age) -> sum+age);
        List<Integer> initList = Lists.newArrayList();
        int initTotalAge = initList.stream().reduce(0,(sum,age) -> sum+age);

        System.out.println("totalAge1: "+ totalAge1 + " initTotalAge: " + initTotalAge);
    }

    /**
     * collect方法 可以对结果集 进行处理,如：将结果集 放入的新的list、set中、 也可将其拼接成一个字符串 或者 转化成 需要的map
     */
    @Test
    public void test10(){
        List<Person> list = getPersonList();
        //排序过滤等一系列操作之后的元素 放入新的list
        List<Person> filterList = list.stream().filter(e -> e.getAge() >20).collect(Collectors.toList());
        filterList.forEach(e -> System.out.println(e.toString()));

        //将 name 属性用" , "，连接拼接成一个字符串
        String nameStr = list.stream().map(Person::getName).collect(Collectors.joining(","));
        System.out.println(nameStr);
        //将name 放入到新的 set 集合中
        Set<String> nameSet = list.stream().map(person -> person.getName()).collect(Collectors.toSet());
        nameSet.forEach(e -> System.out.print(e + ","));

        System.out.println();
        System.out.println("map--------");
        Map<String,Person> personMap = list.stream().collect(Collectors.toMap(Person::getName,person -> person));
        personMap.forEach((key,val) -> System.out.println(key + ":" + val.toString()));
    }

    /**
     * 计算集合元素的最大值、最小值、总和以及平均值
     * IntStream、LongStream 和 DoubleStream 等流的类中，有个非常有用的方法叫做 summaryStatistics() 。
     * 可以返回 IntSummaryStatistics、LongSummaryStatistics 或者 DoubleSummaryStatistics，
     * 描述流中元素的各种摘要数据。
     */
    @Test
    public void test11(){
        List<Integer> ages = Arrays.asList(2,5,3,4,7);
        IntSummaryStatistics statistics = ages.stream().mapToInt(e -> e).summaryStatistics();
        System.out.println("最大值: " + statistics.getMax());
        System.out.println("最小值: " + statistics.getMin());
        System.out.println("平均值: " + statistics.getAverage());
        System.out.println("总和: " + statistics.getSum());
        System.out.println("个数: " + statistics.getCount());
    }
}
