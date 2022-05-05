package com.jetbrains;
import java.util.Scanner;

public class A3_Q2 {

    public static void main(String[] args) {

// -------------------------------------------------------
// Assignment 3-2
// Written by: Sonia Li (40193803)
// For COMP 248 Section U – Winter 2022
// --------------------------------------------------------
        /* Question 2: Student Grades Report Program

        The user is prompted to enter their classes and the grades associated with that class in the following format: "class|grades;".
        Any other format will a skewed result. The program will output a numbered list of classes the user is taken, as well as the average numerical
        grade, as well as the letter grade.

         */
        System.out.println("_______****_______****_______****_______****_______");      //ASCII Art input
        System.out.println("        Welcome to Student Courses Grade Program!");        //Display greeting message
        System.out.println("_______****_______****_______****_______****_______");      //ASCII Art input

        System.out.println("Please enter the courses you are taking this semester (course|grade and seperated by a semicolon): ");       //User prompt
        Scanner in = new Scanner (System.in);
        String report = in.nextLine();      //Reads user input until the next line

        int numberOfClasses = 1;        //counts the number of classes that the user inserts
        char seperator = ';';       //To separate the classes
        String [] reportArr = report.split(";", 0);

        for (int i = 0; i < report.length(); i++){      //Parses through the user input to determine the number of classes
            if (report.charAt(i) == seperator){
                numberOfClasses++;      //Adds classes if encounters ";"
            }
        }

        System.out.println("\nHere is a list of the courses you are taking: ");     //

        for (int i = 0; i < reportArr.length; i++){     //Loops through each class (row)
            String groupSeperatorArr = reportArr[i];      //String value associated with each class (eg: MATH101|40)
            String classLettersStr = groupSeperatorArr.substring(0, groupSeperatorArr.indexOf("|"));  //String value associated with each class (eg: MATH101)

            char [] classesLetters = classLettersStr.toCharArray();     //char array where the elements are the letters of each class
            char [][] class2dArr = new char [numberOfClasses][classesLetters.length];       //Creates the 2d array and associate size (rows = number of classes, columns = letters of each class)
            System.out.print("No."+ (i+1)+ " ");        //Outputs the class count


            for (int j = 0; j < classesLetters.length; j++){      //Loops through each letter (column)
                class2dArr[i][j] = classesLetters[j];               //Fills the 2d array
             System.out.print(class2dArr[i][j]);            //Prints the 2d array
            }
            System.out.println();       //Line break
        }

        int gradesSum = 0;      //To calculate the sum of grades
        int[] groupGradesArr = new int [numberOfClasses];       //Integer array to store grade values

        for (int i = 0; i < reportArr.length; i++){
            String groupSeperatorArr = reportArr[i];  //Loops through each class (eg: MATH101|40)
            String gradeStr = groupSeperatorArr.substring((groupSeperatorArr.indexOf("|")+1));      //Isolates grade as a string value (eg: 40)
            int gradeInt = Integer.parseInt(gradeStr);      //Transform grade string into its integer value
            groupGradesArr[i] = gradeInt;       //Fills the grades array
            gradesSum += groupGradesArr[i];     //Sums the grades together
        }
        float average = (float) gradesSum/(numberOfClasses-1);        //Calculates average grade value
        char gradeLetter = ' ';     //Initialize the letter grade char value

        //If statements to determine letter grade based on the value of the average grade
        //The AND && logical operator is used to specify the bounds for the range of average value for each letter grade
        if (average >= 88 && average < 100){
            gradeLetter = 'A';      //The letter grade A is associated with an average value between 88 and 100
        }
        if (average >= 80 && average < 88){
            gradeLetter = 'B';      //The letter grade B is associated with an average value between 80 and 88
        }
        if (average >= 67 && average < 80){
            gradeLetter = 'C';      //The letter grade C is associated with an average value between 67 and 80
        }
        if (average >= 60 && average < 67){
            gradeLetter = 'D';      //The letter grade D is associated with an average value between 60 and 67
        }
        if (average < 60 && average >=0){
            gradeLetter = 'F';      //The letter grade F is associated with an average value between 0 and 60
        }

        //Outputs
        System.out.print("The average of your courses: ");
        System.out.printf("%.2f", average);     //formatting float output to 2 decimal points with printf(), and outputs the average grade value
        System.out.println(" and the average courses letter grade is: " + gradeLetter);     //Outputs the letter grade

        System.out.print("\nThank you for using Student Courses Grade Program!");       //Closing message





    }
}
