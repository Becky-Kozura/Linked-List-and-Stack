// To run this program from the command line on my Windows machine,
// I used the command "java BuildLinkedList.java" while in the directory

// To generate javadocs for the BuildLinkedList class from the command
// line on my Windows machine, I used the command "javadoc BuildLinkedList.java",
// and to open the javadoc I used the command "start index-all.html", which
// opened the javadocs in my default browser.

import java.util.*; 

/**
 * Class which builds and returns a sorted linked list from user input. 
 * <p>
 * After gathering a string of integers from user input, this class 
 * converts them to integers and populates them into a Linked List 
 * using the Java Collections LinkedList class. The final linked list 
 * is sorted in ascending order and returned.
 * 
 * @author Becky Kozura
 * @version 1.0
 * @since 1.0, 6/1/24
 */

public class BuildLinkedList {  
    
    /** 
    * Class constructor for BuildLinkedList class.
    */

    public BuildLinkedList() {}
    
    /**
     * Method returns a string of integers, separated by spaces, from Scanned user input. 
     * Input is gathered by opening and closing an instance of the Scanner class.  
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
     * Sorts and inserts, in ascending order, a list of integers into an empty LinkedList 
     * object of type Integer, which is returned.
     * 
     * @param numList an array of integers
     * @param intList an empty LinkedList object of type Integer 
     * @return <code>intList</code>, populated with the integers
     */
    public static LinkedList<Integer> sortIntegersIntoList(int[] numList, LinkedList<Integer> intList) {
        // Adding unsorted elements to the linked list, return linked list of Integers
        for (int num : numList) {               // looping through all nums in list...
            if (intList.size() == 0) {              // ...if linked list is empty
                intList.add(num);
                continue;
            }
            if (intList.size() == 1) {              // ...if linked list only has head
                if (num <= intList.get(0)) { 
                    intList.add(0, num);
                } else {
                    intList.add(1, num);
                }
                continue;
            }
            int len = intList.size();               // ...if linked list has 2 or more elements
            for (int i = 0; i < len; i++) {
                if (num <= intList.get(i)) {
                    intList.add(i, num);  
                    break;
                } else {
                    if (num > intList.get(i)) {
                        int temp = i;                      // iterate through linked list until 
                        while (temp < intList.size()) {     // correct location or end of list
                            if (num > intList.get(temp)) {
                                temp++;
                            } else { break; }
                        }
                        intList.add(temp, num);  
                        break;
                    } 
                }            
            }
        }        
        System.out.println("Linked List: " + intList); 
        return intList;
    }

    /**
     * Driver code which runs BuildLinkedList class. 
     * 
     * Creates an empty LinkedList object of type Integer, gets string integer input 
     * from user, parses the string into integers, and sorts and inserts integers 
     * into a Linked List object. The final linked list object is printed (but 
     * not returned).
     * 
     * @param args optional command line arguments
     */    
    public static void main(String args[]) { 

        LinkedList<Integer> intList = new LinkedList<>(); 
        String numString = getIntegerString();
        int[] numList = parseStringsIntoInts(numString);
        intList = sortIntegersIntoList(numList, intList);
        System.out.println(intList);
    }
}

