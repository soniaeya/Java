package com.jetbrains;
import java.util.Scanner;
public class A2_Q2 {

    // -------------------------------------------------------
    // Assignment 2-2
    // Written by: Sonia Li (40193803)
    // For COMP 248 Section U – Winter 2022
    // --------------------------------------------------------

    /* Question 2 (8pts) – Simple Machine-Learning Function Program Explanation:

    The prototype Learning Function is Z = y * omega, with omega being a constant equivalent to 0.567143.
    The user's input for Weekday (Monday - Sunday) and Time (Night-Time and Day-Light) influences the value for the double variable y.
    Since these inputs need to be case-insensitive, the inputs for both "Weekday" and "Time" are first converted into
    lower case with the "toLowerCase()" method before being put through switch statements. Switch statements for the
    "Time" variable are embedded within the switch statements for the "Weekday" variable. Break statements are written
    between each code block to isolate each statement. Since all other inputs will be invalid, we assign an error message as the default in
    the switch statement. Finally, the output values are rounded to 2 decimal point with the printf() method.
     */

    public static void main(String[] args) {

        //Prompt message for the user to input the weekday and time
	System.out.println("Welcome to the Simple Machine-Learning Function Program:\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    System.out.print("\nPlease enter a Weekday and Time, respectively: ");
    Scanner input = new Scanner(System.in);

    String WeekdayInput = input.next();           //Read Weekday input
    String Weekday = WeekdayInput.toLowerCase(); //Transform Weekday input to lower case


    String TimeInput = input.next();            //Read Time input
    String Time = TimeInput.toLowerCase();      //Transform Time input to lower case

    double Z, y;
    final double omega = 0.567143;

    switch (Weekday){

        case ("monday"):
            switch (Time){
                case "night-time":
                    y = 3.25;
                    Z = y * omega;
                    System.out.printf("\nValue of the prototype learning Function, Z, is: " + "%.2f", Z);
                    break;

                case "day-light":
                    y = 2.53;
                    Z = y * omega;
                    System.out.printf("\nValue of the prototype learning Function, Z, is: " + "%.2f", Z);
                    break;}
            break;

        case "tuesday":
            switch(Time){
                case "night-time":
                    y = 2.99;
                    Z = y * omega;
                    System.out.printf("\nValue of the prototype learning Function, Z, is: " + "%.2f", Z);
                    break;

                case "day-light":
                    y = 3.15;
                    Z = y * omega;
                    System.out.printf("\nValue of the prototype learning Function, Z, is: " + "%.2f", Z);
                    break;}
            break;

        case "wednesday":
            switch (Time){
                case "night-time":
                    y = 3.99;
                    Z = y * omega;
                    System.out.printf("\nValue of the prototype learning Function, Z, is: " + "%.2f", Z);
                    break;

                case "day-light":
                    y = 3.00;
                    Z = y * omega;
                    System.out.printf("\nValue of the prototype learning Function, Z, is: " + "%.2f", Z);
                    break;}
            break;


        case "thursday":
            switch (Time){
                case "night-time":
                    y = 2.68;
                    Z = y * omega;
                    System.out.printf("\nValue of the prototype learning Function, Z, is: " + "%.2f", Z);
                    break;

                case "day-light":
                    y = 2.41;
                    Z = y * omega;
                    System.out.printf("\nValue of the prototype learning Function, Z, is: " + "%.2f", Z);
                    break;}
            break;

        case "friday":
            switch (Time){
                case "night-time":
                    y = 3.73;
                    Z = y * omega;
                    System.out.printf("\nValue of the prototype learning Function, Z, is: " + "%.2f", Z);
                    break;

                case "day-light":
                    y = 1.99;
                    Z = y * omega;
                    System.out.printf("\nValue of the prototype learning Function, Z, is: " + "%.2f", Z);
                    break;}
            break;

        case "saturday":
            switch (Time){
                case "night-time":
                    y = 2.86;
                    Z = y * omega;
                    System.out.printf("\nValue of the prototype learning Function, Z, is: " + "%.2f", Z);
                    break;

                case "day-light":
                    y = 3.59;
                    Z = y * omega;
                    System.out.printf("\nValue of the prototype learning Function, Z, is: " + "%.2f", Z);
                    break;}
            break;

        case "sunday":
            switch (Time){
                case "night-time":
                    y = 2.59;
                    Z = y * omega;
                    System.out.printf("\nValue of the prototype learning Function, Z, is: " + "%.2f", Z);
                    break;

                case "day-light":
                    y = 2.00;
                    Z = y * omega;
                    System.out.printf("\nValue of the prototype learning Function, Z, is: " + "%.2f", Z);
                    break;}
            break;

        //Invalid input was received. End program and display error message to try again.
        default:
            System.out.println("Error: An invalid value has been entered for the 'Weekday' variable. Kindly retry again!");
            System.out.print("\nValue of the prototype learning Function, Z, is: 0.00");
            break;
    }

        //Complimentary Close Message
        System.out.print("\nThank you for contributing to this Machine Learning project!");
    }
    }

