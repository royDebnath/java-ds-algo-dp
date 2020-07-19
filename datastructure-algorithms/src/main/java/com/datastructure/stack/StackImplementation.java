package com.datastructure.stack;

/*
 * Java Program to Implement Stack
 */
 
import java.util.*;
 
/*  Class arrayStack  */
class arrayStack
{
    protected int arr[];
    protected int top, size, len;
    /*  Constructor for arrayStack */
    public arrayStack(int n)
    {
        size = n;
        len = 0;
        arr = new int[size];
        top = -1;
    }
    /*  Function to check if stack is empty */
    public boolean isEmpty()
    {
        return top == -1;
    }
    /*  Function to check if stack is full */
    public boolean isFull()
    {
        return top == size -1 ;        
    }
    /*  Function to get the size of the stack */
    public int getSize()
    {
        return len ;
    }
    /*  Function to check the top element of the stack */
    public int peek()
    {
        if( isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        return arr[top];
    }
    /*  Function to add an element to the stack */
    public void push(int i)
    {
        if(top + 1 >= size)
            throw new IndexOutOfBoundsException("Overflow Exception");
        if(top + 1 < size )
            arr[++top] = i;
        len++ ;
    }
    /*  Function to delete an element from the stack */
    public int pop()
    {
        if( isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        len-- ;
        return arr[top--]; 
    }    
    /*  Function to display the status of the stack */
    public void display()
    {
        System.out.print("\nStack = ");
        if (len == 0)
        {
            System.out.print("Empty\n");
            return ;
        }
        for (int i = top; i >= 0; i--)
            System.out.print(arr[i]+" ");
        System.out.println();
    }    

	// Below is a recursive function
	// that inserts an element
	// at the bottom of a stack.
	void insert_at_bottom(int x) {

		if (isEmpty())
			push(x);

		else {

			// All items are held in Function
			// Call Stack until we reach end
			// of the stack. When the stack becomes
			// empty, the st.size() becomes 0, the
			// above if part is executed and
			// the item is inserted at the bottom
			int a = peek();
			pop();
			insert_at_bottom(x);

			// push allthe items held
			// in Function Call Stack
			// once the item is inserted
			// at the bottom
			push(a);
		}
	}

	// Below is the function that
	// reverses the given stack using
	// insert_at_bottom()
	void reverse() {
		if (getSize() > 0) {

			// Hold all items in Function
			// Call Stack until we
			// reach end of the stack
			int x = peek();
			pop();
			reverse();

			// Insert all the items held
			// in Function Call Stack
			// one by one from the bottom
			// to top. Every item is
			// inserted at the bottom
			insert_at_bottom(x);
		}
	}
}
 
/*  Class StackImplement  */
public class StackImplementation
{
    public static void main(String[] args)
    {/*
        Scanner scan = new Scanner(System.in);        
        System.out.println("Stack Test\n");
        System.out.println("Enter Size of Integer Stack ");
        int n = scan.nextInt();
         Creating object of class arrayStack 
        arrayStack stack = new arrayStack(n);
         Perform Stack Operations 
        char ch;
        do{
            System.out.println("\nStack Operations");
            System.out.println("1. push");
            System.out.println("2. pop");
            System.out.println("3. peek");
            System.out.println("4. check empty");
            System.out.println("5. check full");
            System.out.println("6. size");
            int choice = scan.nextInt();
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer element to push");
                try 
                {
                    stack.push( scan.nextInt() );
                }
                catch (Exception e)
                {
                    System.out.println("Error : " + e.getMessage());
                }                         
                break;                         
            case 2 : 
                try
                {
                    System.out.println("Popped Element = " + stack.pop());
                }
                catch (Exception e)
                {
                    System.out.println("Error : " + e.getMessage());
                }    
                break;                         
            case 3 :         
                try
                {
                    System.out.println("Peek Element = " + stack.peek());
                }
                catch (Exception e)
                {
                    System.out.println("Error : " + e.getMessage());
                }
                break;                         
            case 4 : 
                System.out.println("Empty status = " + stack.isEmpty());
                break;                
            case 5 :
                System.out.println("Full status = " + stack.isFull());
                break;                 
            case 6 : 
                System.out.println("Size = " + stack.getSize());
                break;                         
            default : 
                System.out.println("Wrong Entry \n ");
                break;
            }
             display stack 
            stack.display();            
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
 
        } while (ch == 'Y'|| ch == 'y');                 
    */
    	arrayStack stack = new arrayStack(6);
    	stack.push(1);stack.push(2);stack.push(3);stack.push(4);stack.push(5);stack.push(6);
    	stack.display();
    
    
    }
}