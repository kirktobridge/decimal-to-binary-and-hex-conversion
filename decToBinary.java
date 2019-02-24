/*Paper Problem Solving Activity #11 - "Number systems" */

import java.util.*; // Going to use Scanner objects
import java.lang.Math; // Will probably end up using this

public class decToBinary
{
  
  
  
  public static void main(String[] args)
  {
    
    /* SETUP */
    
    
    // Initialize variables to be given by user
    
    int decNum;
    
    // Initialize variables to calculate and contain answers
    
    
    int[] binValues = new int[100]; // Create array to store digits that compose the converted binary number
    int[] hexValues = new int[100]; // Array to store hexadecimal calculations; some of these values will be converted to letters when they are fed into the string hexAns
    
    String binAns = "";
    String hexAns = "";
    
    
    
    // Create Scanner object
    
    Scanner mrSpock = new Scanner(System.in);
    
    // Prompt user for integer input value and record it
    
    System.out.print("Please enter an integer value to convert to binary and hexadecimal: ");
    
    decNum = mrSpock.nextInt(); // Record user response    
    
    
    /* BINARY CONVERSION */
    
    
    // Initialize more container variables 
    
    
    int trueDecNum = decNum; // Going to divide decNum in a loop, recording its value now to use for hex calculations later
    
    int i = 0; // Used to refer to position in binValues array
    
    
    // Iterate through values and store the binary number in an array binValues
    
    
    while (decNum != 0) // Divide the number until we go through all the digits
      
    {
      
      binValues[i] = (decNum % 2); // Store the remainder of division by 2 in the array
      
      decNum /= 2; // Divide by 2
      i++; // Increment counter used to move through array
      
    } // end of while loop
    
    
    // For loop that effectively converts the integer array into a String. Have to keep in mind the digits in binValues are currently in reverse order. This actually makes feeding them into the answer/displayed String easier.
    
    for (int j = i-1; j >= 0; j--)
    {
      
      binAns += Integer.toString(binValues[j]); // Convert each value in the array to a string object, then append it to a string we will display as the answer
      
    } // end of for loop
    
    System.out.println("The binary equivalent of the number you provided is: " + binAns); // Display answer    
    
    
    
    
    /* HEX CONVERSION */
    
    /* Iterate through all digits in the original number,
     * dividing by 16 until the remainder is 0. Then, convert 
     * values larger than 9 into their hexadecimal equivalents,
     * placing them and all other converted values in a string. 
     Unecessary zeroes will be managed by if statements and
     a boolean that checks if they exist.*/
    
    
    int k = 0; // used to refer to position in hexValues array
    boolean prevIsZero = true; // Flag to check if unnecessary zeroes are present
    boolean noMoreZeroes = false; // Flag to check if any non-zero elements have been encountered yet in the calculation process
    
    while (trueDecNum != 0) // Divide the number until we go through all the digits
      
    {
      
      hexValues[k] = (trueDecNum % 16); // Store the remainder of division by 16 in the array
      
      trueDecNum /= 16; // Divide by 16
      k++; // Increment counter used to move through array
      //System.out.println(k + "that's k, here's division: " + trueDecNum);
      
    }
    
    for (int j = i-1; j >= 0; j--)
    {
      //First, record if this number is 0
      
      if (hexValues[j] == 0) {prevIsZero = true;}
      
      else {prevIsZero = false;}
      
      
      // Letter cases
      
      if (hexValues[j] >= 10) {
        noMoreZeroes = true;
        
        switch (hexValues[j]) 
          /* Switch statement used for easy management of letter cases
           * For each number, a corresponding hexademical letter is 
           * appended to the "answer" String. */
        {
          
          case 10:
            hexAns += "A";
            break;
            
          case 11:
            hexAns += "B";
            break;
            
          case 12:
            hexAns += "C";
            break;
            
          case 13:
            hexAns += "D";
            break;
            
          case 14:
            hexAns += "E";
            break;
            
          case 15:
            hexAns += "F";
            break;
            
        } // end of switch
        
        
      } // end of if statement
      
      else if ((prevIsZero == true) && (hexValues[j] == 0) && (noMoreZeroes == false)) 
      {
        /* This else statement checks if the previous number was 0 and if the current number is 0, and if
         * any non-zero numbers have been processed yet. If these conditions are satisified, then hexAns
         * is given nothing. This avoids unnecessary zeroes lengthening the answer.*/
        
       hexAns+="";
        
        
      } 
      
      else if (hexValues[j] <= 9)
      {
        if (hexValues[j] > 0) {noMoreZeroes = true;}
        
        // This else statement handles the numbers that don't have a letter counterpart/equivalent.
        
        hexAns += Integer.toString(hexValues[j]); // Convert the integer value in the array to a string object, then append it to a string we will display as the answer
        
        
      }
      
              // System.out.println("Run number " + j + ", hexAns is now: " + hexAns +  ", prevIsZero is currently: " + prevIsZero); // debugging
    }
    
    System.out.println("The hexadecimal equivalent of the number you provided is: #" + hexAns);
    
  }
  
  
}
