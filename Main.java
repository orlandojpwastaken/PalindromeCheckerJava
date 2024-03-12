//Using stack class

import java.util.*;
public class Main {

    static private void checkPalindrome(Stack<Character> stack, String subString1, String subString2){
        //Pushes in 1st set of substrings into a stack
        for (int i = 0 ; i < subString1.length() ; i++ ){
            stack.push(subString1.charAt(i));
        }

        /* Looks through the 2nd sub string and see if
        it matches with the head of the stack
        and pops it if they're the same */
        for (int i = 0 ; i < subString2.length() ; i++ ){
            if (subString2.charAt(i) == stack.peek()){
                stack.pop();
            }
        }
    }
    static boolean isPalindrome(String inputString){
        //Standardize the string to lower case.
        inputString = inputString.toLowerCase();

        //Get the length of the string
        int stringLength = inputString.length();

        //Create a stack
        Stack<Character> stack = new Stack<>();

        //Does operation depending on whether string is even or odd
        String sub1 = inputString.substring(0, stringLength / 2);
        String sub2;

        if (stringLength % 2 == 0) {
            //Split the string into two even substrings first
            sub2 = inputString.substring(stringLength / 2);
        } else {
            sub2 = inputString.substring(stringLength / 2 + 1);
        }
        checkPalindrome(stack, sub1, sub2);
        return stack.empty();
    }

    public static void main(String[] args){
        //Prompt for user input of string
        Scanner input = new Scanner(System.in);
        System.out.println("Input string:");

        String inputString = input.nextLine();

        System.out.println(isPalindrome(inputString));
    }
}
