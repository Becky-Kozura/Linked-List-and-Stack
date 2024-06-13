// To run this program from the command line on my Windows machine,
// I used the command "java BuildStack.java" while in the directory

// To generate javadocs for the BuildStack class from the command
// line on my Windows machine, I used the command "javadoc BuildStack.java",
// and to open the javadoc I used the command "start index-all.html", which
// opened the javadocs in my default browser.

// I indicated in all javadoc comments whether the code was only reused, or
// reused and modified, from the BuildLinkedList class. They were very 
// compatible because Stack extends Vector and Vector implements List.

import java.util.*; 

/**
 * Class which builds and returns a sorted stack from user input. 
 * <p>
 * After gathering a string of integers from user input, this class 
 * converts them to integers and populates them into a stack
 * using the Java Collections Stack class. The final stack
 * is populated in ascending order and returned. In other words, the largest 
 * element will be at the top of the stack and popped first.
 * <p>
 * (Maintenance task: this code was reused and modified from BuildLinkedList class.)
 * 
 * @author Becky Kozura
 * @version 1.0
 * @since 1.0, 6/7/24
 */

public class BuildStack {  
    
    /** 
    * Class constructor for BuildStack class.
    * 
    * (Maintenance task: this code was reused and modified from BuildLinkedList class.)
    */

    public BuildStack() {}
    
    /**
     * Method returns a string of integers, separated by spaces, from Scanned user input. 
     * Input is gathered by opening and closing an instance of the Scanner class.  
     * 
     * (Maintenance task: this code was reused from BuildLinkedList class.)
     * 
     * @return <code> numString </code>, a string of integers separated by spaces
     */
    public static String getIntegerString() {
        Scanner myScan = new Scanner(System.in);
        System.out.print("Please enter a list of integers separated by spaces: ");
        String numString = myScan.nextLine();
        myScan.close();
        return numString;
    }
    
    /**
     * Method accepts string input of integers, separates and parses the 
     * integers, and populates them into an array of integers, which is returned.
     * <p>
     * (Maintenance task: this code was reused from BuildLinkedList class.)
     * 
     * @param numString a string of space-delineated integers
     * @return <code>numList</code> an array of integers
     */
    public static int[] parseStringsIntoInts(String numString) {
        // Parsing string elements into array of integers
        String[] array = numString.split(" ");
        int count = 0;
        int size = array.length;
        int[] numList = new int[size]; 
        for (String s : array) {
            int num = Integer.parseInt(s);
            numList[count] = num;
            count++;
        }
        return numList;
    }

    /**
     * Sorts and inserts, in ascending order, a list of integers into an empty Stack 
     * object of type Integer, which is returned. In other words, the largest 
     * element will be at the top of the stack and popped first.
     * <p>
     * (Maintenance task: this code was reused and modified from BuildLinkedList class.)
     * 
     * @param numList an array of integers
     * @param intStack an empty Stack object of type Integer 
     * @return <code>intStack</code>, populated with the integers
     */
    public static Stack<Integer> sortIntegersIntoStack(int[] numList, Stack<Integer> intStack) {
        // Adding unsorted elements to the stack, return stack of Integers
        for (int num : numList) {               // looping through all nums in list...
            if (intStack.size() == 0) {              // ...if stack is empty
                intStack.add(num);
                continue;
            }
            if (intStack.size() == 1) {              // ...if stack only has one element
                if (num <= intStack.peek()) { 
                    intStack.add(0, num);
                } else {
                    intStack.add(1, num);
                }
                continue;
            }
            int len = intStack.size();               // ...if stack has 2 or more elements
            for (int i = 0; i < len; i++) {
                if (num <= intStack.get(i)) {
                    intStack.add(i, num);  
                    break;
                } else {
                    if (num > intStack.get(i)) {
                        int temp = i;                      // iterate through stack until at
                        while (temp < intStack.size()) {     // correct location or end of stack
                            if (num > intStack.get(temp)) {
                                temp++;
                            } else { break; }
                        }
                        intStack.add(temp, num);  
                        break;
                    } 
                }            
            }
        }        
        System.out.println("Stack: " + intStack); 
        return intStack;
    }

    /**
     * Driver code which runs BuildStack class. 
     * <p>
     * Creates an empty Stack object of type Integer, gets string integer input 
     * from user, parses the string into integers, and sorts and inserts integers 
     * into a Stack object. The final stack object is printed (but not returned).
     * <p>
     * (Maintenance task: this code was reused and modified from BuildLinkedList class.)
     * 
     * @param args optional command line arguments
     */    
    public static void main(String args[]) { 

        Stack<Integer> intStack = new Stack<>(); 
        String numString = getIntegerString();
        int[] numList = parseStringsIntoInts(numString);
        intStack = sortIntegersIntoStack(numList, intStack);
        System.out.println(intStack);
        // following line proves that the stack implementation is working correctly
        System.out.println(intStack.pop()); 
    }
}

