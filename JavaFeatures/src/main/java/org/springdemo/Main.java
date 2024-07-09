package org.springdemo;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {
        System.out.println("Hello world!");

//        // Without Lambda
//        Calc calc = new Calc();
//        System.out.println(calc.divide(1,5));
//
//        // With Lambda
//        Interf i = ((a,b) -> {
//            if(b != 0){
//                return a/b;
//            }
//            return 0;
//        });

//        System.out.println(i.divide(4,2));

//        Runnable runnable = (() -> {
//            System.out.println("Inside Lambda");
//        });
//
//        new Thread(runnable).start();
//

        // PREDICATES -> Functional Interface with Single Argument
        //and Return Type as Boolean , default method is test()
//
//        Predicate<String>  Size = (s) -> s.length()>3;
//
//        System.out.println(Size.test("Abds"));
//
//        System.out.println(Size.test("ad"));

        // Function  -> This Functional Interface with 1 argument and Any Return type

//        Function<String,Integer> f = (s) -> s.length();
//
//        System.out.println(f.apply("asfs"));
//
//        System.out.println(f.apply(""));

        // Streams
        ArrayList<Integer> l1 = new ArrayList<Integer>();
        for(int i=1; i<=10; i++) {
            l1.add(i);
         }

        // FILTER -> Takes Predicate as parameter
        //List<Integer> l2 = l1.stream().filter( i-> (i%3 == 0) ).toList();
        //System.out.println(l2);

        // Map -> Takes Function as Parameter
        // List<Integer> l3 = l1.stream().map(i -> i%3).toList();
        // System.out.println(l3);

        // Count -> return long
        Long odd = l1.stream().filter(i -> (i%3==0) ).count();
        System.out.println(odd);

        // Sorted -> can take comparator object
//        List<Integer> l2 = l1.stream().map(i -> (i%3) ).sorted().toList();
//        System.out.println(l2);
//
//        List<Employees> employeesList = new ArrayList<>();
//        employeesList.add(new Employees(1,"Raj","ITSM"));
//        employeesList.add(new Employees(2,"Dhyani","AIOPs"));
//        employeesList.add(new Employees(3,"Shivam","ITSM"));
//        employeesList.add(new Employees(4,"Sahil","PMG"));
//
//        // Collectors Group By
//        Map<String,List<String> > list = employeesList.stream().collect(Collectors.groupingBy(Employees::getDepartment,Collectors.mapping(Employees::getName, Collectors.toList())));
//        System.out.println(list);

        // Reduce(Identity, Accumulator, Combiner)

        List<Integer>  list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

//        int sum1 = list1.stream().reduce(0,(sum,ele)->sum + ele);
        int sum1 = list1.stream().reduce(-6,Integer::sum);
        System.out.println(sum1);

        // Avg Rating of ALL Employees using Streams

        Employees emp1 =new Employees(1,"Saurav","Marketing",new Rating());
        emp1.getRating().add(new Review(3,"Avg"));
        emp1.getRating().add(new Review(5,"Excellent"));
        Employees emp2 = new Employees(3,"Deval","Sales",new Rating());
        emp2.getRating().add(new Review(4,"Good"));
        emp2.getRating().add(new Review(2,"Worst"));
        emp2.getRating().add(new Review(4,"Nice"));


        List<Employees> employees = Arrays.asList(emp1,emp2);

        Rating averageRating = employees.stream()
                .reduce(new Rating(),
                        (rating, employee) -> Rating.average(rating, employee.getRating()),
                        Rating::average);

        System.out.println(averageRating.getPoints());

        // FlatMap
        List<List<Employees>> listList = new ArrayList<>();
        listList.add(employees);
        listList.add(employees);

        List<Employees> employeeLIST = listList.stream().flatMap(Collection::stream).toList();
        System.out.println(employeeLIST);

        // Distinct
        List<Employees> employeeDistinct = listList.stream().flatMap(Collection::stream).distinct().toList();
        System.out.println(employeeDistinct);

        //generate
        Stream<Double> st = Stream.generate(()-> 10*Math.random()).limit(10);
        System.out.println(st.toList());

        // skip
        System.out.println(employeeDistinct.stream().skip(1).toList());


        // Collect(Collector.xyz())

        // Collectors.Joininig(Delimeter)
        String str = employeeDistinct.stream().map(Objects::toString).collect(Collectors.joining("||"));
        System.out.println(str);

        // mapTo, peek
        Double rating = employeeDistinct.stream().mapToDouble(employees1 -> employees1.rating.getPoints()).peek(r-> System.out.println(r)).sum();
        System.out.println(rating);

        // Get Rating sum of rating of employees by department wise
        Map<String,Double> mp= employeeDistinct.stream().collect(Collectors.groupingBy(Employees::getDepartment,Collectors.summingDouble(emp -> emp.getRating().getPoints())));
        System.out.println(mp);

        // PartitionBy()
        Map<Boolean,List<Employees>> mp1 = employeeDistinct.stream().collect(Collectors.partitioningBy(employees1 -> employees1.getRating().getPoints() > 3.5d));
        System.out.println(mp1);




    }

}