import java.util.*;

class charStack {
    // Variables
    ArrayList<Character> bodyArray;

    //Constructor
    public charStack() {
        this.bodyArray = new ArrayList<>();
    }

    public Character peek(){
        return this.bodyArray.getLast();
    }
    public void push(Character character) {
        this.bodyArray.add(character);
    }
    public void pop() {
        this.bodyArray.removeLast();
    }

    public boolean empty() {
        return bodyArray.isEmpty();
    }
}


public class MainStackFromScratch {
    static private void checkPalindrome(charStack stack, String subString1, String subString2){
        //Pushes in 1st set of substrings into a stack
        for (int i = 0 ; i < subString1.length() ; i++ ){
            stack.push(subString1.charAt(i));
        }

        /* Looks through the 2nd sub string and see if
        it matches with the head of the stack
        and pops it if they're the same */
        for (int i = 0 ; i < subString2.length() ; i++ ){
            Character temp = subString2.charAt(i);
            if (temp == stack.peek()){
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
        charStack stack = new charStack();


        //Split the string into two even substrings first
        String sub1 = inputString.substring(0, stringLength / 2);
        String sub2;

        //Does operation depending on whether string is even or odd
        if (stringLength % 2 == 0) {
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
