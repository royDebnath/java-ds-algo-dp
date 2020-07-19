package com.theory.java8.basics.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.theory.support.Employee;

public class SimpleStreamOperations {

  public static void main(String args[]) {

    Employee[] arrayOfEmps = { new Employee(1, "Jeff Bezos", 100000.0), new Employee(2, "Bill Gates", 200000.0),
        new Employee(3, "Mark Zuckerberg", 300000.0) };

    Stream<Employee> streamOfArray = Arrays.stream(arrayOfEmps);
    streamOfArray.forEach(System.out::println);

    List<Employee> empList = Arrays.asList(arrayOfEmps);

    empList.stream()
        .forEach(System.out::println);

    System.out.println("===========================");

    System.out.println("After Salary Increment");

    System.out.println("===========================");

    empList.stream()
        .forEach(e -> e.salaryIncrement(10.0));

    empList.stream()
        .forEach(System.out::println);

    System.out.println("===========================");

    System.out.println("Collecting To List");

    System.out.println("===========================");

    List<String> collectedListOfNames = empList.stream()
        .map(Employee::getName)
        .collect(Collectors.toList());

    collectedListOfNames.stream()
        .forEach(System.out::println);

    System.out.println("===========================");

    System.out.println("Collecting To Set");

    System.out.println("===========================");

    Set<String> collectedSetOfNames = empList.stream()
        .map(Employee::getName)
        .collect(Collectors.toSet());

    collectedSetOfNames.stream()
        .forEach(System.out::println);

    System.out.println("===========================");

    System.out.println("Collecting To Map");

    System.out.println("===========================");

    Map<String, Integer> collectedMap = empList.stream()
        .collect(Collectors.toMap(Employee::getName, Employee::getId));
    collectedMap.forEach((key, value) -> {
      System.out.println("Key : " + key + " Value : " + value);
    });

    System.out.println("===========================");

    System.out.println("Filtering Based On Condition");

    System.out.println("===========================");

    List<String> filteredList = empList.stream()
        .filter(employee -> employee.getSalary() > 150000)
        .map(Employee::getName)
        .collect(Collectors.toList());

    filteredList.stream()
        .forEach(System.out::println);

    System.out.println("===========================");

    System.out.println("Find First");

    System.out.println("===========================");

    Employee findFirst = empList.stream()
        .filter(employee -> employee.getSalary() > 150000)
        .findFirst()
        .orElse(null);

    System.out.println(findFirst.toString());

    System.out.println("===========================");

    System.out.println("Find Any");

    System.out.println("===========================");

    Employee findAny = empList.stream()
        .filter(employee -> employee.getSalary() > 150000)
        .findAny()
        .orElse(null);

    System.out.println(findAny.toString());

    System.out.println("===========================");

    System.out.println("Peek");

    /*
     * We saw forEach() earlier in this section, which is a terminal operation. However, sometimes we need to perform
     * multiple operations on each element of the stream before any terminal operation is applied. Peek is an
     * intermediate operation.
     */

    System.out.println("===========================");

    empList.stream()
        .peek(e -> e.salaryIncrement(10.0))
        .peek(System.out::println)
        .collect(Collectors.toList());

    System.out.println("===========================");

    System.out.println("Sorting");

    System.out.println("===========================");

    List<Employee> sortedlist = empList.stream()
        .sorted((e1, e2) -> e1.getName()
            .compareTo(e2.getName()))
        .collect(Collectors.toList());

    System.out.println("Sorted List");
    sortedlist.stream()
        .forEach(System.out::println);

    System.out.println("===========================");

    System.out.println("Min/Max");

    System.out.println("===========================");

    Employee firstEmp = empList.stream()
        .min((e1, e2) -> e1.getId() - e2.getId())
        .orElseThrow(NoSuchElementException::new);

    Employee maxSalEmp = empList.stream()
        .max(Comparator.comparing(Employee::getSalary))
        .orElseThrow(NoSuchElementException::new);

    System.out.println("===========================");

    System.out.println("Distinct");

    System.out.println("===========================");

    List<Integer> intList = Arrays.asList(2, 5, 3, 2, 4, 3);
    List<Integer> distinctIntList = intList.stream()
        .distinct()
        .collect(Collectors.toList());

    List<Integer> intList1 = Arrays.asList(2, 4, 5, 6, 8);

    System.out.println("===========================");

    System.out.println("Any/All/None Match");

    System.out.println("===========================");

    boolean allEven = intList1.stream()
        .allMatch(i -> i % 2 == 0);
    boolean oneEven = intList1.stream()
        .anyMatch(i -> i % 2 == 0);
    boolean noneMultipleOfThree = intList1.stream()
        .noneMatch(i -> i % 3 == 0);

    System.out.println("===========================");

    System.out.println("Reduce");
    /*
     * T reduce(T identity, BinaryOperator<T> accumulator) where identity is the starting value and accumulator is the
     * binary operation we repeated apply.
     */

    System.out.println("===========================");

    Double sumSal = empList.stream()
        .map(Employee::getSalary)
        .reduce(0.0, Double::sum);
    

    System.out.println("===========================");

    System.out.println("Partitioning");

    System.out.println("===========================");

    List<Integer> intList11 = Arrays.asList(2, 4, 5, 6, 8);
    Map<Boolean, List<Integer>> isEven = intList11.stream()
        .collect(Collectors.partitioningBy(i -> i % 2 == 0));

    System.out.println("===========================");

    System.out.println("Group By");

    System.out.println("===========================");

    Map<Character, List<Employee>> groupByAlphabet = empList.stream()
        .collect(Collectors.groupingBy(e -> new Character(e.getName()
            .charAt(0))));

    System.out.println("===========================");

    System.out.println("Parallel Stream");

    /*
     * remember that parallel streams don't magically solve all the synchronization problems. If a shared resource is
     * used by the predicates and functions used in the process, you'll have to make sure that everything is
     * thread-safe.
     */

    System.out.println("===========================");

    empList.stream()
        .parallel()
        .forEach(e -> e.salaryIncrement(10.0));

    System.out.println("===========================");

    System.out.println("Infinite Stream");

    System.out.println("===========================");

    Stream.generate(Math::random)
        .limit(5)
        .forEach(System.out::println);

    System.out.println("===========================");

    System.out.println("Flat Map");

    System.out.println("===========================");

    List<String> houseGryffindor = Arrays.asList("Albus", "Harry", "Ron", "Hermione");
    List<String> houseHufflepuff = Arrays.asList("Bridget", "Cedric", "Nymphadora");
    List<String> houseRavenclaw = Arrays.asList("Luna", "Garrick", "Filius");
    List<String> houseSlytherin = Arrays.asList("Severus", "Tom", "Phineas");

    List<List<String>> hogwarts = new ArrayList<List<String>>();
    hogwarts.add(houseGryffindor);
    hogwarts.add(houseHufflepuff);
    hogwarts.add(houseRavenclaw);
    hogwarts.add(houseSlytherin);

    // Printing All Hogwarts Houses In Pre-Java8 World
    List<String> listOfAllHouses = new ArrayList<String>();
    for (List<String> house : hogwarts) {
      for (String member : house) {
        listOfAllHouses.add(member);
      }
    }

    System.out.println("<!---------------Hogwarts Houses---------------!>");
    System.out.println(listOfAllHouses);

    System.out.println();

    // Now let's Achieve This By Using 'flatMap()' Method In Java8
    List<String> flatMapList = hogwarts.stream()
        .flatMap(hList -> hList.stream())
        .collect(Collectors.toList());

    System.out.println("<!---------------Hogwarts Houses Using Java8---------------!>");
    System.out.println(flatMapList);
  }
}
