package com.jetbrains;

import java.util.Scanner;

public class A1_Q1 {

    public static void main(String[] args) {
        // -------------------------------------------------------------------------------
        // Assignment 1_1
        // Written by: Sonia Li (40193803)
        // For COMP 248 Section U – Winter 2022
        // ---------------------------------------------------------------------------------

        /*  This is a program that emulates a treadmill burned calories machine that outputs the calories burned during the exercise given
            the user's weight, and time spend on each exercise (walking, running, and mountain climbing).

            Similar to the example, I used the integer variable type to characterize the user inputs(time, weight, minutes), and the double variable type to characterize the outputs (calorie expenditure).
            Constants are dictated by equations that compare the MET and exercise type (Running 6 MPH: 10 METS, Walking 3 MPH = 4 METS, Mountain Climbers
            3 MPH = 8 METS), as well as the following formula that calculates the calories burned: Energy expenditure (Calories/ Minute) = 0.0175 × MET × Weight (in kilograms).
            Furthermore, we need to consider lb to kg conversion: 2.2lb=1kg.

            Finally, the program outputs the amount of calories burned for each exercise as well as the total expenditure.*/

        // 1. Welcome message
        System.out.println("Welcome to Calories burned calculator:");

        // 2. Weight prompt
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your weight in pounds: \n"); //Line break between prompt and input
        int weightlb = input.nextInt();

        // 3. Prompts the user to enter the running, walking and mountain climbers’ times respectively.
        System.out.print("Running time (minutes): ");   //Taking the running time user input
        int rTime = input.nextInt();

        System.out.print("Walking time (minutes): ");   //Taking the walking time user input
        int wTime = input.nextInt();

        System.out.print("Mountain Climbers time (minutes): "); //Taking the Mountain Climbers' user input
        int mcTime = input.nextInt();

        //Unit conversions
        double weightkg = weightlb/2.2; //kg (input) to lb for output calculations

        double metrunning = (rTime) * 10; //Calculations according to MET values and activity type
        double metwalking = (wTime) * 4;
        double metmountainclimbing = (mcTime) * 8;

        //4. calculates and outputs the calories burned for each activity as well as the total number of calories burned.
        double caloriesRunning = 0.0175 * metrunning * weightkg; //Energy expenditure equation
        double caloriesWalking = 0.0175 * metwalking * weightkg;
        double caloriesMountainClimbing = 0.0175 * metmountainclimbing * weightkg;
        System.out.print("\n You burned an estimated " + caloriesRunning + " Calories Running, \n burned an estimated " +
                (caloriesWalking) + " Calories walking, and \n burned an estimated " + caloriesMountainClimbing + " Mountain Climber. ");
        double totalcalories = caloriesMountainClimbing + caloriesRunning + caloriesWalking;

        //5. Display a farewell message, so that the user knows that the program has terminated normally
        System.out.println("\n\nTotal calories burned = " + totalcalories);
        System.out.println("\nKeep up your hard work. Your progress is amazing!");
        System.out.println("Thank you for using Calories burned calculator.");
        System.out.println("\nSee you soon...");

    }
}