
package com.jetbrains;
import java.util.Scanner;

// -------------------------------------------------------
// Assignment 3-1
// Written by: Sonia Li (40193803)
// For COMP 248 Section U – Winter 2022
// --------------------------------------------------------

/* Question 1: Sentence Scan Program
This program takes in a sentence and displays some data about the sentence, including length of each word, the number
of words in the sentence, the length of the shortest and longest words and the average length of the words.
To do so, we need to transform the sentence into and array, and use for loops to loop through each element.

The user inputs a sentence, read as a String variable by the program with the Scanner method (.nextLine()).
The .split("") method transforms the sentence into an array(arrLetters[]), where the letters of the sentence
are its elements, and the .split(" ") method transforms the sentence into another array(arrWords[]), where the
words of the sentence are its elements. If statements are used to exclude punctuation marks and whitespaces from the
letter count.

Examples:
My Quiz2 was graded.
*/

public class A3_Q1 {

    public static void main(String[] args) {
        System.out.println("_______****_______****_______****_______****_______");      //ASCII Art input
        System.out.println("Welcome To The SENTENCE SCAN PROGRAM!");        //Display greeting message
        System.out.println("_______****_______****_______****_______****_______");      //ASCII Art input
        System.out.println("Please enter the sentence to scan: ");      //Prompts user input
        Scanner in = new Scanner(System.in);        //Reads user input
        String sentence = in.nextLine();        //Outputs sentence as a String variable

        System.out.println("\n\nHere are some data about your sentence: \n");

        String [] arrWords = sentence.split(" ");        //Transforms the sentence into an array, with each word (seperated by a whitespace) being an element in it
        String [] arrLetters = sentence.split("");       //Transforms the sentence into an array, with each letter being an element in it

        int numLetters = arrLetters.length;     //Gives the length of the letter array, therefore the number of letters in the sentence
        int numWords = arrWords.length;     //Gives the length of the word array, therefore the number of words in the sentence
        int max = arrWords[0].length();     //Initialize a max variable. The length of each word in the sentence will be later compared to the first word
        int min = arrWords[0].length();     //Initialize a min variable. The length of each word in the sentence will be later compared to the first word
        float avg = 0;      //To initialize the average value
        //Loops through each word for comparing lengths

        for (int k = 0; k < numLetters; k++){       //Takes out the whitespaces when counting the number of characters in the sentence, used to later calculate the average number of letters for each word in the sentence
            if (arrLetters[k].indexOf(" ") != -1) {     //An if statement that loops through each letter of the sentence to check for a whitespace
                numLetters = numLetters -1;     //Discounts the whitespace as a letter in the sentence
            }
        }

        for (int i = 0; i < numWords; i++){ //A for loop to loop through each word in the sentence. The i represents the iteration.
            int lengthOfWord = arrWords[i].length();        //Calculates the number of letters in each word (length of each word array)
            if ((arrWords[i].indexOf('.') != -1)||(arrWords[i].indexOf('!') != -1)||(arrWords[i].indexOf('?') != -1)) //An if statement that loops through each letter to find a punctuation mark and exclude it.
            {
                lengthOfWord = lengthOfWord - 1;        //Word length is decreased by 1 to exclude the punctuation mark in the word count
                numLetters = numLetters - 1;        //The number of letters in the sentence is also decreased by 1. Used when calculating the average length of a word (The punctuation mark is not counted as a letter)
            }
            System.out.println("Word " + (i+1) + " has " + lengthOfWord + " characters.");  //i is increased by 1 because we are calculating the length of the word array (arrWord) which starts at 1, while the loop loops through indexes (therefore starts at 0)

            if (lengthOfWord > max)     //Compares the length of each word to the first.
            {
                max = lengthOfWord;     //Replaces the "max" integer variable with the length of the new word variable, if it is bigger than either the first word or the previous "max" value
            }

            if (lengthOfWord < min)     //Compares the length of each word to the first.
            {
                min = lengthOfWord;     //Replaces the "min" integer variable with the length of the new word variable, if it is smaller than either the first word or the previous "min" value
            }


            avg = (float) numLetters/numWords;      //Calculates the average length of the words by dividing the total number of characters in the sentence (minus the whitespace and punctuation marks) and dividing its value by the total number of words in the sentence.



        }


        //Printing the outputs
        System.out.println("\n\nThere are " + numWords + " words.");        //Display the number of words in the sentence
        System.out.println("The longest word has " + max + " characters.");     //Display the length of the longest word
        System.out.println("The shortest word has " + min + " characters.");        //Display the length of the shortest word
        System.out.println("The average word length is " + avg + " characters.");       ////Display the average length of the words
        System.out.print("\nThank you for using The SENTENCE SCAN PROGRAM!");       //Display closing message
    }
}

