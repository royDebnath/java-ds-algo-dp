package com.theory.basics.collections.arraylist;

import java.util.Arrays;

class ArrayListCustom<E> { 
   // Define INITIAL_CAPACITY, size of elements of custom ArrayList 
   private static final int INITIAL_CAPACITY = 10; 
   private int size = 0; 
   private Object elementData[] = {}; 
   /** 
    * 
    * constructor of custom ArrayList 
    */ 
   public ArrayListCustom() { 
   elementData = new Object[INITIAL_CAPACITY]; 
   } 
   /** 
    * add elements in custom/your own ArrayList 
    * Method adds elements in ArrayListCustom. 
    */ 
   public void add(E e) { 
   if (size == elementData.length) { 
   ensureCapacity(); // increase current capacity of list, make it 
   // double. 
   } 
   elementData[size++] = e; 
   } 
   /** 
    * method returns element on specific index. 
    */ 
   @SuppressWarnings("unchecked") 
   public E get(int index) { 
   // if index is negative or greater than size of size, we throw 
   // Exception. 
   if (index < 0 || index >= size) { 
   throw new IndexOutOfBoundsException("Index: " + index + ", Size " 
   + index); 
   } 
   return (E) elementData[index]; // return value on index. 
   } 
   /** 
    * remove elements from custom/your own ArrayList method returns 
    * 
    * removedElement on specific index. else it throws IndexOutOfBoundException 
    * if index is negative or greater than size of size. 
    */ 
   public Object remove(int index) { 
   // if index is negative or greater than size of size, we throw 
   // Exception. 
      if (index < 0 || index >= size) { 
   throw new IndexOutOfBoundsException("Index: " + index + ", Size " 
   + index); 
   } 
   Object removedElement = elementData[index]; 
   for (int i = index; i < size - 1; i++) { 
   elementData[i] = elementData[i + 1]; 
   } 
   size--; // reduce size of ArrayListCustom after removal of element. 
   return removedElement; 
   } 
   /** 
    * Ensure capacity of custom/your own ArrayList. 
    * 
    * Method increases capacity of list by making it double. 
    */ 
   private void ensureCapacity() { 
   int newIncreasedCapacity = elementData.length * 2; 
   elementData = Arrays.copyOf(elementData, newIncreasedCapacity); 
   } 
   /** 
    * Display custom/your own ArrayList. 
    * 
    * Method displays all the elements in list. 
    */ 
   public void display() { 
   System.out.print("Displaying list : "); 
   for (int i = 0; i < size; i++) { 
   System.out.print(elementData[i] + " "); 
   } 
   } 
} 
/** 
 * Main class to test ArrayListCustom functionality. 
 */ 
public class ArrayListCustomApp { 
   public static void main(String... a) { 
   ArrayListCustom<Integer> list = new ArrayListCustom<Integer>(); 
   //Add elements in custom ArrayList 
   list.add(1); 
   list.add(2); 
   list.add(3); 
   list.add(4); 
   list.add(1); 
   list.add(2); 
   //Display custom ArrayList 
   list.display(); 
   System.out.println("\nelement at index in custom ArrayList > " + 1 + " = " + list.get(1)); 
   //Remove element from custom ArrayList 
   System.out.println("element removed from index " + 1 + " = " 
   + list.remove(1)); 
   //Again display custom ArrayList 
   System.out 
  .println("\nlet's display custom ArrayList again after removal at index 1"); 
   list.display(); 
   // list.remove(11); //will throw IndexOutOfBoundsException, because 
   // there is no element to remove on index 11. 
   // list.get(11); //will throw IndexOutOfBoundsException, because there 
   // is no element to get on index 11. 
   } 
} 
/*OUTPUT 
Displaying list : 1 2 3 4 1 2 
element at index in custom ArrayList > 1 = 2 
element removed from index 1 = 2 
let's display custom ArrayList again after removal at index 1 
Displaying list : 1 3 4 1 2 
*/ 