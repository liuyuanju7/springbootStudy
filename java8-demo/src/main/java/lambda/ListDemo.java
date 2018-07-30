package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author liuyuanju1
 * @date 2018/7/28
 * @description:lamba 操作集合
 */
public class ListDemo {

    public static void main(String[] args) {
        ListDemo demo = new ListDemo();
        List<String> list = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        list.forEach(n -> System.out.println(n));
        //调用函数
        list.forEach(demo::printStr);

        //predicate
        System.out.println("print str equal with 'Java' : ");
        filter(list,(str)->str.equals("Java") );

        System.out.println("stream predicate");
        filterStream(list,(str) -> str.toString().length() > 3);

        System.out.println("print start with J and length = 4 :");
        Predicate<String> startWithJ = (n) -> n.startsWith("J");
        Predicate<String> fourLength = (n) -> n.length() == 4;
        list.stream().filter(startWithJ.and(fourLength)).forEach((str -> System.out.println(str)));

        // map reduce
        System.out.println("map :");
        List<Double> costs = Arrays.asList(100d,200d,300d,400d);
        costs.stream().map((cost) -> cost + .12*cost).forEach(System.out::println);
        double total = costs.stream().map((cost) -> cost + .12*cost).reduce((sum,cost) -> sum + cost).get();
        double oldTotal = costs.stream().reduce((sum,cost) -> sum + cost).get();
        System.out.println(total + "  " + oldTotal);

        //通过 过滤创建String 列表 filter()方法则是获得一个新的列表，且其每个元素符合过滤原则
        List<String> filterList = list.stream().filter(x -> x.length() >3).collect(Collectors.toList());
        filterList.forEach(System.out::println);

        // 将字符串换成大写并用逗号链接起来
        String transListStr = list.stream().map(x -> x.toUpperCase() ).collect(Collectors.joining(","));
        System.out.println(transListStr);
    }

    public  void printStr(String str){
        System.out.println(str + "--lyj");
    }

    public static void filter(List<String> list, Predicate predicate){
        for(String str : list){
            if(predicate.test(str)){
                System.out.println(str);
            }
        }
    }

    public static void filterStream(List list,Predicate predicate){
        list.stream().filter((name) -> (predicate.test(name))).forEach((name) ->{
            System.out.println(name + "");
        });
    }
}
