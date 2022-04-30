package LISP_Validator;

import java.util.Deque;
import java.util.LinkedList;

/**
 ListValidatorUsingDeque is class that utilizes Deque to leverage the LIFO (Last-In-First-Out) feature &
 add,retrieve,peek operations available in the beginning or end of the queue.
 This will be useful when checking to see if the opening/closing brackets are balanced.

 @author Angel Selva Rodriguez
 @version 1.0
 @since 04/27/2022
 */
public class LispValidatorUsingDeque {

    /**
     * Validate the incoming string by doing the following :
     *   1. Check if null --> if null --> the string is not balanced --> return false;
     *   2. Strip everything that isn't an opening or closing bracket
     *   3. Check if first char is opening '(' --> if it's any other character, it is not LISP code --> return false;
     *   4. Check if the string is balanced and of even length --> if not even, return false else return true;
     * @param lispCodeStr
     * @return true or false, depends on if the string passes series of test
     */
    public boolean isLISPCodeValid(String lispCodeStr){
        if(lispCodeStr == null) return false;

        System.out.println("Original Incoming LISP CODE is: " + "\n " + lispCodeStr);// --> used to check string before stripping
        String stripCharsInsideBrackets = lispCodeStr.replaceAll("[^()]", ""); //use REGEX to remove anything between '(' & ')'
        System.out.println("\nStripped string: " + "\n " + stripCharsInsideBrackets); //--> used to check string after it is stripped

        char[] strippedLISPCode = stripCharsInsideBrackets.toCharArray();
        //First, let's check if null and if the string is balanced
        if(strippedLISPCode.length % 2 != 0) {
            return false;
        }
        else{
            for(char bracket: strippedLISPCode){
                if(!(bracket == '(' || bracket == ')' )){
                    return false;
                }
            }
        } //string has been validated

        Deque<Character> deck = new LinkedList<>(); //LinkedList is used here as it provides an implementation of the Deque interface.
        for(char bracket: strippedLISPCode){
            //As we loop through the charArray, when locating an opening '(' char we need to add it as the 1st element of the deck
            if(bracket == '('){
                deck.addFirst(bracket);
            }else{
                /*
                Check if LinkedList is not empty, then use peek to check on the last char added by using peekFirst.
                If list is empty, then there is no matching bracket --> return false;
                If matching closing ')' bracket is found, it is safe to remove this top-most character from the list using
                removeFirst and move on to check next char in loop.
                 */
                if((!deck.isEmpty() && deck.peekFirst() == '(' && bracket == ')')){
                    deck.removeFirst(); //removal of matching opening/closing brackets
                }else{
                    return false; // this means one of the test conditions has failed and the incoming LISP code string is not valid.
                }
            }
        }
        //if all tests are passed, then we can safely return true.
        return true;
    }

}
