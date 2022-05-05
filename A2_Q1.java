package com.jetbrains;
import java.util.Scanner;
public class A2_Q1 {
    public static void main(String[] args) {
// -------------------------------------------------------
// Assignment 2-1
// Written by: Sonia Li (40193803)
// For COMP 248 Section U – Winter 2022
// --------------------------------------------------------

        /* From the input screen, a list of Covid-19 symptoms are associated with a Symptom Code (10 to 23). Then, the user must choose the symptom description that best describes their current health symptoms
        and input the corresponding system code (an integer variable between -128 to 127) accordingly. Then, the program will output the symptom category and advice notes according to the symptom.
        If the user enters an integer value not within the available range, an error message will appear. The user's inputs are taken in with a scanner method, the corresponding outputs are regulated by a series of if statements.
        Logical operators such as the Logical AND (&&), and the Logical OR (||) is used to isolate the range of the input.
         */

        //Welcome message
        System.out.print("Welcome to the Simple COVID-19 Diagnostics Expert System:\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" );
        System.out.print("\nSystem Code => System Description\n--------------------------------------");

        //System Code and its corresponding Symptom Description
        System.out.println("\n10 => Fever\n11 => Cough\n12 => Tiredness\n13 => Loss of Taste and/or Smell\n14 => Sore Throat\n15 => Headache\n16 => Body Aches and/or Pains\n17 => Diarrhoea\n18 => Skin Rash\n19 => Finger/Toes Discoloration\n20 => Red and/or Irritated Eyed\n21 => Shortness of Breath\n22 => Confusion and/or Loss of Speech\n23 => Chest Pains");
        Scanner input = new Scanner(System.in);

        //Prompt message for the user to enter a symptom code
        System.out.print("\nPlease enter the System Code, from the aforementioned, that corresponds to your current health symptoms: ");
        int SystemNum = input.nextInt();

        //
        if ((SystemNum < 10) && (SystemNum >=-128)) {
            System.out.println("Symptom Status: NO OBVIOUS SYMPTOMS");
            System.out.println("You are currently experiencing no observable symptom with regard to either COVID-19 or a respiratory infection (e.g. flu). \nAlthough, you may be asymptomatic. Thus, kindly adhere to all the COVID-19 safety regulations within your city and province.");
            //Closing message
            System.out.print("\nThank you! Please stay safe and healthy.");
        }

        else if ((SystemNum <= 13) && (SystemNum >= 10)){
            System.out.println("Symptom Status: MOST COMMON SYMPTOMS");
            System.out.println("You are experiencing a common symptom with regard to either COVID-19 or a respiratory infection (e.g. flu). \nKindly isolate yourself as soon as possible, and endeavor to perform a PCR (Polymerase Chain Reaction) test to confirm your COVID-19 status.");
            //Closing message
            System.out.print("\nThank you! Please stay safe and healthy.");
        }
        else if ((SystemNum <= 20)&&(SystemNum >= 14)){
            System.out.println("Symptom Status: LESS COMMON SYMPTOMS");
            System.out.println("You are experiencing a common symptom with regard to either COVID-19 or a respiratory infection (e.g. flu). \nKindly isolate yourself as soon as possible, and endeavor to perform a PCR (Polymerase Chain Reaction) test to confirm your COVID-19 status.");
            //Closing message
            System.out.print("\nThank you! Please stay safe and healthy.");
        }

        else if ((SystemNum <= 23)&&(SystemNum >=21)){
            System.out.println("Symptom Status: CRITICAL SYMPTOMS");
            System.out.println("You are experiencing a CRITICAL/SEVERE symptom with regard to either COVID-19 or a respiratory infection (e.g. flu). \nKindly isolate yourself as soon as possible and call 911, immediately.");
            //Closing message
            System.out.print("\nThank you! Please stay safe and healthy.");
        }

        else if ((SystemNum >= 24)&&(SystemNum <= 127)){
            System.out.println("Symptom Status: NO OBVIOUS SYMPTOMS");
            System.out.println("You are currently experiencing no observable symptom with regard to either COVID-19 or a respiratory infection (e.g. flu). \nAlthough, you may be asymptomatic. Thus, kindly adhere to all the COVID-19 safety regulations within your city and province.");
            //Closing message
            System.out.print("\nThank you! Please stay safe and healthy.");
        }

        //Error message to try again
        else if ((SystemNum >= 128) || (SystemNum <= -128)){
            System.out.print("Error: your input/entry is not a valid integer between -128 to 127. Kindly retry again!");
        }



            }





    }








