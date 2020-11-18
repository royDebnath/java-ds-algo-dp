package com.parctice;

public class pr1 {

    public static void main(String[] args) {

        System.out.println(factorial(4));

    }

    private static int factorial(int n) {
        System.out.println("Calculating : F(" + n + ")");
        if (n == 0) {
            int x = 1;
            System.out.println("Done : F(0)" + "-->" + x);

            return 1;
        }
        int next = n - 1;
        int f = n * factorial(next);
        System.out.println("Done : F(" + n + ")" + "-->" + f + " (" + n + "*factorial(" + next + ")");
        return f;
    }

}


class Collar {
}

class Dog {
    Collar c; // instance variable
    String name; // instance variable

    public static void main(String[] args) { // main() is placed on the stack.

        Dog d; // Reference variable d is created on the stack, but there's no
        // Dog object yet.
        d = new Dog(); // A new Dog object is created and is assigned to the d
        // reference variable.
        d.go(d); // A copy of the reference variable d is passed to the go()
        // method.
    }

    void go(Dog dog) { // The go() method is placed on the stack, with the dog
        // parameter as a local variable.
        c = new Collar(); // A new Collar object is created on the heap and
        // assigned to Dog's instance variable.
        dog.setName("Aiko");
    }

    void setName(String dogName) { // setName() is added to the stack, the
        // dogName parameter as its local variable.
        name = dogName; // The name instance variable now also refers to the
        // String object.
        // do more stuff
    }


    
}
