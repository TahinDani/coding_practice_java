package com.interviewcake.no27;

// Write a function reverse() that takes a string message
// and reverses the order of the words in-place.

public class Main {

    public static void reverseChars(char[] messageChars, int start, int end){
//        for loop only works for the whole array and not for parts
//
//        int halfOfLength = messageChars.length/2;
//        for (int j = start, i = end; i >= halfOfLength; i--, j++) {
//            char temp = messageChars[i];
//            messageChars[i] = messageChars[j];
//            messageChars[j] = temp;
//        }

        while (start < end){
            char temp = messageChars[end];
            messageChars[end] = messageChars[start];
            messageChars[start] = temp;
            start++;
            end--;
        }
    }


    public static String reverseWords(String message){
        char[] messageChars = message.toCharArray();

        // first, reverse the whole array so the order of words will be reversed
        reverseChars(messageChars, 0, messageChars.length-1);

        int currentWordStart = 0;

        // than look for end of words and reverse only one word
        for (int i = currentWordStart; i <= messageChars.length; i++) {
            if (i == messageChars.length || messageChars[i] == ' '){
                reverseChars(messageChars, currentWordStart, i-1);
                currentWordStart = i+1;
            }
        }
        return new String(messageChars);
    }


    public static void main(String[] args) {
        String message = "this is it";
        System.out.println(message);
        System.out.println(reverseWords(message));
    }
}
