package com.theory.basics.collections.arraylist;

/**
 * Author: Dino Cajic
 *
 * Purpose: To create a resizable array implementation.
 *
 * Data Structures used: Array
 *
 * Solution to the problem: The arrayList array data field will be created and
 * will store objects passed to it. The ArrayList class will have methods to:
 * 1). add Objects to the end of the arrayList array: void add(Object x)
 * 2). add Objects to a specific index location: void add(int index, Object x)
 * 3). get the object from a specific index location: Object get(int index)
 * 4). check to see how many elements are in the arrayList: int size()
 * 5). check to see if the arrayList is empty: boolean isEmpty()
 * 6). check to see if an object exists within the array: boolean isIn(Object ob)
 * 7). get the index location of a specific object: int find(Object n)
 * 7). remove the object from the array: void remove(Object n)
 *
 * To use the class: Instantiate the ArrayList class and either pass an initial
 * size or leave blank for a default size of 10. Use the methods provided to
 * store/remove elements from ArrayList class.
 */
 class ArrayList {

    /**
     * Stores the objects in an array
     */
    private Object[] arrayList;

    /**
     * The current amount of elements in the arrayList array
     */
    private int elementsInArray;

    /**
     * The default constructor that creates an arrayList with a default size of 10.
     * Precondition: Must instantiate the class without passing a value.
     * Postcondition: Initializes the arrayList array with a default size of 10.
     */
    public ArrayList() {
        this(10);
    }

    /**
     * Constructor that allows an initial size to be passed to the array.
     * Precondition: Parameter n must be larger than 0.
     * Postcondition: The constructor initializes the arrayList data field with size n
     * and initializes the elementsInArray to 0.
     * @param n | The size of the arrayList array.
     */
    public ArrayList(int n) {
        if (n <= 0) {
            System.out.println("The size must be greater than 0. Try again.");
            return;
        }

        this.arrayList = new Object[n];
        this.elementsInArray = 0;
    }

    /**
     * A method that allows you to place an Object at the end of the ArrayList.
     * Precondition: Must pass a parameter x of type Object.
     * Postcondition: The method checks to see if the array is full. if it is,
     * a "double" argument is passed to the copyArray() method to double the arrayList's
     * capacity. The Object x is added to the arrayList array. The size, elementsInArray,
     * is incremented by 1.
     * @param x | The object to be added to the arrayList array.
     */
    public void add(Object x) {
        if (checkIfArrayFull()) {
            copyArray(0, "double");
        }

        this.arrayList[this.elementsInArray] = x;
        this.elementsInArray++;
    }

    /**
     * A method that allows you to place a value at a given location.
     * Precondition: Must pass the index location that's within the
     * arrayList array bounds; Also must pass the Object to insert
     * at a given index location.
     * Postcondition: Checks to see if the array arrayList is full.
     * If it is, the capacity is doubled in size. The method checks
     * to see if the index that was passed is out of bounds; if it
     * is, a index out of bounds message is displayed and the
     * program is terminated. A temp Object is created and stores
     * the arrayList object at the given passed index. The arrayList
     * at the passed index is assigned the value of Object x. A temp2
     * object is declared to be used in the loop. The loop is created
     * and cycles starting at the current index location to the
     * arrayList length - 1 position. The temp2 variable is assigned
     * the Object value of arrayList at i+1 position. The arrayList
     * at i+1 position is assigned the value of temp. Then the temp
     * variable is assigned the value of temp2. This ensures that the
     * Objects passed the index value are stored in the array. After
     * the loop, the copyArray() method is called. This compacts the
     * array. i.e. if the capacity was 20, and the array has 10 elements,
     * but the user decided to add the new Object at index 15, the
     * copyArray() method would move the Object from index 15 to index 10.
     * The elementsInArray data field is incremented by 1.
     * @param index | The position where the new Object should be added.
     * @param x     | The object that should be added to arrayList at the specific index.
     */
    public void add(int index, Object x) {
        if (checkIfArrayFull()) {
            copyArray(0, "double");
        }

        if (index >= this.arrayList.length) {
            System.out.println("The index is out of bounds");
            System.exit(-1);
        }

        Object temp = this.arrayList[index];
        arrayList[index] = x;

        Object temp2;

        // Invariant: index <= i < arrayList.length - 1
        for (int i = index; i < this.arrayList.length - 1; i++) {
            temp2 = arrayList[i + 1];
            arrayList[i + 1] = temp;
            temp = temp2;
        }

        copyArray(0, "");
        this.elementsInArray++;
    }

    /**
     * Allows you to retrieve a value of the arrayList array from a given location
     * Precondition: Must pass an index that's within array bounds.
     * Postcondition: Checks to see if the index is within the arrayList bounds. If it's not,
     * a message is printed to the user. If it is within bounds, the Object at the specific
     * index location is returned.
     * @param index    | The index location of the Object.
     * @return element | The Object at the specific index.
     */
    public Object get(int index) {
        Object element = null;

        // Invariant: 0 <= index < arrayList.length
        try {
            element = this.arrayList[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The index that you specified is not within bounds.");
            System.exit(-1);
        }

        return element;
    }

    /**
     * Allows you to get the number of elements currently in the Arraylist.
     * Precondition: The ArrayList object must be instantiated in the user program.
     * Postcondition: Returns the value of the elementsInArray field.
     * @return elementsInArray value.
     */
    public int size() {
        return this.elementsInArray;
    }

    /**
     * Tests to see if the Arraylist is empty.
     * Precondition: The ArrayList object must be instantiated in the user program.
     * Postcondition: Returns true if the elementsInArray value is zero meaning that
     * there are zero elements in the arrayList array. Returns false if the
     * elementsInArray value is greater than 0.
     * @return true if empty; false if not
     */
    public boolean isEmpty() {
        return this.elementsInArray == 0;
    }

    /**
     * A method that sees if a particular object exist in the arrayList
     * Precondition: Must pass a parameter of type Object
     * Postcondition: Passes the ob parameter the find() method. If the
     * find() method returns a value greater than or equal to zero, an
     * object was found and the isIn() method returns true. If the find()
     * method returns -1, no object was found() and the isIn() method
     * returns false.
     * @param ob | The object that the user checks to see if it's in the
     *             arrayList array
     * @return boolean | True if object exists, false otherwise.
     */
    public boolean isIn(Object ob) {
        return find(ob) >= 0;
    }

    /**
     * Returns the location of first occurrence of an Object starting from location 0
     * Precondition: Must pass a parameter of type Object.
     * Postcondition: Checks to see if the arrayList array contains the Object n. If
     * it does, the position of the Object is returned. Otherwise, -1 is returned.
     * @param n  | The Object that the method will search for in arrayList
     * @return i | The position of the Object n within the arrayList array
     */
    public int find (Object n) {
        // Invariant: 0 <= i < arrayList.length
        for (int i = 0; i < this.arrayList.length; i++) {
            if (n.equals(this.arrayList[i])) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Removes the first occurrence of an Object starting from location 0
     * Preconditon: Must pass the Object n as a parameter to be removed.
     * The Object n should be an element in the arrayList array.
     * Postcondition: The method loops through each of the elements in the
     * arrayList. If the Object exists in the arrayList array, the element
     * at that particular index is set to null. The elementsInArray is
     * decremented by 1. The copyArray() method is called to compact the
     * array again. The method will exit when the first instance of the
     * Object is found.
     * @param n | The Object to be removed from the arrayList array
     */
    public void remove (Object n) {
        // Invariant: 0 <= i < elementsInArray
        for (int i = 0; i < this.elementsInArray; i++) {
            if (n.equals(this.arrayList[i])) {
                this.arrayList[i] = null;
                this.elementsInArray--;
                copyArray(0, "");
                return;
            }
        }
    }

    /**
     * Checks to see if the arrayList array is full.
     * Precondition: The elementsInArray and arrayList data fields have to be initialized
     * Postcondition: Checks to see if the elementsInArray is equal to the size of the arrayList array. If it is,
     * that means that the arrayList is full. If it's full the method returns true; otherwise, returns false.
     * @return boolean
     */
    private boolean checkIfArrayFull() {
        return this.arrayList.length == this.elementsInArray;
    }

    /**
     * Copies the arrayList array to the larger tempArray array. Copies the contents of
     * the tempArray array to the new arrayList array.
     * Precondition: must pass the size that the tempArray will be incremented by. If action
     * is "double" the size will be doubled.
     * Postcondition: The size parameter is passed to the increaseArraySize() method. The
     * method performs the necessary calculations and returns the new array size. The
     * tempArray array is instantiated with the size. A tempElement is set to keep track
     * of the tempArray element position. A for loop tests to make sure that the index of
     * the element, represented as i, is less than the length of the arrayList array. After
     * each loop, i and tempElement variables are incremented by 1. Within the loop body,
     * a check is preformed to see if the current element is an Object or null. If it's null,
     * the tempElement is decremented by 1 and the loop skips the remainder of the code. If
     * it is not null, the tempArray at index tempElement is assigned the value of arrayList
     * at index i.
     *   For example, if index 1 in arrayList is null, the next go around the code may resemble
     *   the following: tempArray[1] = arrayList[2];
     * After the loop, the arrayList array is set to null. It's instantiated as a new Object[]
     * with the size that is the size of the tempArray. The arrayList is assigned assigned the
     * tempArray array.
     * @param size   | Size to increment the new array by.
     * @param action | Tells the increaseArraySize how to process the size.
     */
    private void copyArray(int size, String action) {
        size = increaseArraySize(size, action);

        Object[] tempArray = new Object[size];

        int tempElement = 0;

        // Invariants: 0 <= i < arrayList.length && 0 <= tempElement < arrayList.length
        for (int i = 0; i < this.arrayList.length; i++, tempElement++) {
            if (this.arrayList[i] == null) {
                tempElement--;
                continue;
            }

            tempArray[tempElement] = this.arrayList[i];
        }

        this.arrayList = null;
        this.arrayList = new Object[tempArray.length];
        this.arrayList = tempArray;
    }

    /**
     * Increases the array size if size positive, decreases if negative.
     *
     * Precondition: Must pass the size parameter of type int.
     * Postcondition: Checks to see if the action parameter is equal to "double". If so,
     * the arrayList length is doubled and stored within the size variable. If not,
     * the arrayList length is incremented by the value passed in the size parameter
     * and stored in the size variable. Size is then returned.
     * @param size | EDIT
     * @param action | EDIT
     */
    private int increaseArraySize(int size, String action) {
        if (action.equals("double")) {
            size = this.arrayList.length * 2;
        } else {
            size = this.arrayList.length + size;
        }

        return size;
    }
}

public class ArrayListCustomApp2 {

    /**
     * Tests the ArrayList class
     * Precondition: Must have ArrayList class in same folder
     * Postcondition: Creates an ArrayList object of size 50. Adds and removes
     * Objects from the list. Tests each of the methods to make sure everything
     * is working. Creates another ArrayList object utilizing the default
     * constructor. Again tests each of the ArrayList's methods.
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("Create Constructor setting ArrayList to capacity 50");
        ArrayList numeric = new ArrayList(50);

        System.out.println("The ArrayList is empty: " + numeric.isEmpty());
        System.out.println("The numer of elements in array is: " + numeric.size());

        System.out.println("Populate the ArrayList with values from 1 to 20");
        for (int i = 0; i < 50; i++) {
            numeric.add((int)(Math.random() * 20) + 1);
        }

        System.out.println("The ArrayList is empty: " + numeric.isEmpty());
        System.out.println("The number of elements in array is: " + numeric.size());

        System.out.println("Add an element to the end of the ArrayList: i.e. 12345");
        numeric.add(12345);
        System.out.println("The index of 12345 is " + numeric.find(12345));

        System.out.println("The number of elements in array is: " + numeric.size());
        System.out.println("The value of element 50 is: " + numeric.get(50));

        System.out.println("Element at index 5 before removal: " + numeric.get(5));
        System.out.println("The number of elements in array is: " + numeric.size());
        System.out.println("Remove element at index 5");
        numeric.remove(numeric.get(5));
        System.out.println("Element at index 5 after removal: " + numeric.get(5));
        System.out.println("The number of elements in array is: " + numeric.size());

        System.out.println("Add an element at specific position");
        System.out.println("Element at index 10 before insertion: " + numeric.get(10));
        numeric.add(10, 200);
        System.out.println("Element at index 10 after insertion: " + numeric.get(10));
        System.out.println("Element at index 11 after insertion: " + numeric.get(11));

        System.out.println("Check to see if particular element is in array?");
        System.out.println("Is 12345 in array? " + numeric.isIn(12345));
        System.out.println("Is 123456 in array? " + numeric.isIn(123456));

        for (int i = 0; i < numeric.size(); i++) {
            System.out.println("ArrayList[" + i + "]: " + numeric.get(i));
        }

        System.out.println("************************************************");

        System.out.println("Tests the default constructor");

        ArrayList test = new ArrayList();
        System.out.println("Current size: " + test.size());
        System.out.println("Is the Array List empty? : " + test.isEmpty());
        test.add("x");
        test.add("b");
        test.add("aa");
        test.add("bh");
        test.add("G");
        test.add("d");
        test.add("a");
        test.add("e");
        test.add("bd");
        test.add("c");
        test.add(2, "DINO");
        test.add(2, "CAJIC");
        test.add(10, "DINO");
        test.add(19, "DINO");
        test.remove("DINO");
        test.remove("x");
        System.out.println("Current size: " + test.size());
        System.out.println("Is the Array List empty? : " + test.isEmpty());
        System.out.println("Object at index 1: " + test.get(1));
        System.out.println("Object at index 3: " + test.get(3));
        System.out.println("Position of G: " + test.find("G"));
        System.out.println("Position of na: " + test.find("na"));
        System.out.println("Is bd in array list? : " + test.isIn("bd"));
        System.out.println("Is bda in array list? : " + test.isIn("bda"));

        for(int i = 0; i < test.size(); i++) {
            System.out.println("ArrayList[" + i + "] : " + test.get(i));
        }

        System.out.println("Out of bounds test: " + test.get(22));
    }
}
