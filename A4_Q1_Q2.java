
// -------------------------------------------------------
// Assignment 4
// Written by: Sonia Li 40193803
// For COMP 248 Section U – Winter 2022
// 04/13/22
// --------------------------------------------------------
/* This program is a simple classroom management system. The user must input the instructor's first name, last name, lecture room, semester, and maxclass size.
 Then, the user is prompted to select a code from a menu where they will be able to execute several possible task such as adding a new student, adding grades
 (for assignments 1 to 4, labs, midterm, and final), changing the names, getting the array position of the student id, and finally output a report card for the classroom.
This information will be inserted into different arrays and accessed through different methods (such as getters), depending if the data is static or instance based, as well
as the class the information is in (either Comp248secU or A4_Q1_Q2.
 */
package com.jetbrains;
import java.util.Scanner;

class Comp248secU {     //Implementation of the class Comp248secU
    // Static members
    private static int classSize;
    private static String semesterYear;
    private static String lectureRoom;
    private static String instructorFname;
    private static String instructorLname;

    // Available for all objects and classes
    private String studFname[];
    private String studLname[];
    private int studID[];
    private double assgt1[];
    private double assgt2[];
    private double assgt3[];
    private double assgt4[];
    private double labs[];
    private double midTerm[];
    private double finalExam[];
    public String studInfo[];
    private static double min;
    private static double max;
    private static double avg;
    public double grpMin[];
    public double grpMax[];
    public double grpAvg[];
    int counter = 0;

    //Constructor used to set all the static variables/attributes, with regard to the course instructor and classroom, as described in the table in the A4 document
    public Comp248secU(String fname, String lname, String room, String semYr, int size) { //Building the constructor

        //Initializing all the static variables/attributes, as describes in the table
        instructorFname = fname;
        instructorLname = lname;
        lectureRoom = room;
        semesterYear = semYr;
        classSize = size;


        //Allocating memory to arrays
        this.studFname = new String [size];
        this.studLname = new String [size];
        this.studID = new int [size];
        this.assgt1 = new double [size];
        this.assgt2 = new double [size];
        this.assgt3 = new double [size];
        this.assgt4 = new double [size];
        this.labs = new double [size];
        this.midTerm = new double [size];
        this.finalExam = new double [size];
    }

    //method that is called when the user inputs 103 as the CODE input
    public void addStudent(String fname, String lname, int studID, int arrIdx) {

        if(counter < classSize) { //the counter (that counts the number of students in the classroom), must be smaller than the class size for the student to be added to the class.

            //Associates values to each element in array according to the student's position (index) in the class
            this.studFname[counter] = fname;
            this.studLname[counter] = lname;
            this.studID[counter] = studID;

            //Initializes the grades to be 0.0 when no grades has been input
            this.assgt1[counter]=0.0;
            this.assgt2[counter]=0.0;
            this.assgt3[counter]=0.0;
            this.assgt4[counter]=0.0;
            this.labs[counter]=0.0;
            this.midTerm[counter]=0.0;
            this.finalExam[counter]=0.0;

            counter++; //Increments the counter once a student is added

            if (classSize >= arrIdx) {
                System.out.println("Student with ID " + studID + " added successfully");
            }
        }

        else { //Output if counter is above class size (there will be more students than available places)
            System.out.println("Student with ID: " + studID + " CANNOT be added. Class is already full.");
        }
        arrIdx++;
    }
    //Method that is called when the user inputs 106 as the CODE input
    public int getStudentIdx(int studID){
        int pos = -1; //Initiate the pos integer
        for(int i = 0; i < classSize; i++) {
            if (this.studID[i] == studID) {
                pos = i;
            }
        }
        return pos; //Will return -1 if the studID integer is not an element in the studID array, or its index in the studID array.
    }
//method that is called when the user inputs 109 as the CODE input
    public String[] getStudentInfo(int studID) {  //Makes student info
        int idx = getStudentIdx(studID);
        if(idx >= 0) {
            this.studInfo = new String [12];
            this.studInfo[0] = this.studFname[idx];
            this.studInfo[1] = this.studLname[idx];
            this.studInfo[2] = studID + "";
            this.studInfo[3] = this.assgt1[idx]+"";
            this.studInfo[4] = this.assgt2[idx]+"";
            this.studInfo[5] = this.assgt3[idx]+"";
            this.studInfo[6] = this.assgt4[idx]+"";
            this.studInfo[7] = this.labs[idx]+"";
            this.studInfo[8] = this.midTerm[idx]+"";
            this.studInfo[9] = this.finalExam[idx]+"";
        }
        return this.studInfo;
    }
//method that is called when the user inputs 112 as the CODE input
    public int delStudent(int studID) {
        int idx = getStudentIdx(studID);


        //Sets the studID to be deleted's integer information to 0 and String values to null.
        this.studFname[idx] = null;
        this.studLname[idx] = null;
        this.studID[idx] = 0;
        this.assgt1[idx] = 0.0;
        this.assgt2[idx] = 0.0;
        this.assgt3[idx] = 0.0;
        this.assgt4[idx] = 0.0;
        this.labs[idx] = 0.0;
        this.midTerm[idx] = 0.0;
        this.finalExam[idx] = 0.0;

        return 0;

    }

    //method that is called when the user inputs 115 as the CODE input
    public int updateStudentPart(String fname, String lname, int studID) {
        int idx = getStudentIdx(studID);        //Calls to  getStudentIdx() to locate the user input's idx to be deleted

        //Associate the studID's idx to new values based on user input
        this.studFname[idx] = fname;
        this.studLname[idx] = lname;
        this.studID[idx] = studID;
        return idx;
    }
//method that is called when the user inputs 118 as the CODE input
    public int updateAssgtScore(double a1, double a2, double a3, double a4, int studID) {
        int idx = getStudentIdx(studID);
        //Instantiates the user's inputs for a1, a2,a3,a4 to the studID idx equivalent in the assignments arrays
        assgt1[idx] = a1;
        assgt2[idx] = a2;
        assgt3[idx] = a3;
        assgt4[idx] = a4;
        return idx;
    }
//method that is called when the user inputs 121 as the CODE input
    public int updateOtherScore(double lab, double test, double exam, int studID) {
        int idx = getStudentIdx(studID);
        //Instantiates the user's inputs for lab, midterm, and final exams to the studID idx equivalent in the other grades arrays
        labs[idx] = lab;
        midTerm[idx] = test;
        finalExam[idx] = exam;
        return idx;
    }
//method that is called when the user inputs 124 as the CODE input
    public double computeWeightScore(int studID) {
        //Computes weight score
        double score = 0;
        int idx = getStudentIdx(studID);

        //Computes score according to grade weight
        double assgt = 100*(0.02*(this.assgt1[idx]/20) + 0.03*(this.assgt2[idx]/20) + 0.05*(this.assgt3[idx]/20) + 0.08*(this.assgt4[idx]/20));
        double labs = 100*(0.12*(this.labs[idx]/12));
        double test = 100*(0.3*(this.midTerm[idx]/30));
        double exam = 100*(0.4*(this.finalExam[idx]/40));
        score = assgt + labs + test + exam;

        return score;       //Returns score as a double
    }

    public static char computeGrade(double wgtScore) {
        char letterGrade = 0;       //instantiates the letterGrade char to 0

        //Associates the weighted numerical score to a letter grade using if statement

        if (wgtScore >= 88) {
            letterGrade= 'A';
        }
        else if (wgtScore >= 80 && wgtScore <=88) {
            letterGrade= 'B';
        }
        else if (wgtScore >= 67 && wgtScore <=80) {
            letterGrade= 'C';
        }
        else if (wgtScore >= 60 && wgtScore <=67) {
            letterGrade= 'D';
        }
        else if (wgtScore <= 60) {
            letterGrade= 'F';
        }

        return letterGrade;     //Returns char letterGrade
    }

//method that is called when the user inputs 127 as the CODE input
    public static double findMin(double [] dataArr) {
        min = dataArr[0];
        //Compares the value of each element in a given array to the first element, to find the min element in the array
        for (int i = 0; i < classSize; i++){
            if(dataArr[i] != 0) {
                if (dataArr[i] < min){
                    min = dataArr[i];
                }
            }
        }
        return min;
    }

    public static double findMax(double [] dataArr) {
        //Compares the value of each element in a given array to the first element, to find the max element in the array
        max = dataArr[0];
        for (double element : dataArr) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }


    public static double findAvg(double [] dataArr) {
        //Finds the average from the elements in a given array
        double total = 0;
        avg = 0;
        int counter = 0;
        for (int i = 0; i < classSize; i++) {
            if (dataArr[i] != 0) {
                total = total + dataArr[i];
                counter++;
            }
        }

        if (total !=0 && counter !=0) {
            //Calculates the average
            avg = total / counter;

        }

        else{
            avg = 0; //If theres no grades, the average will be 0
        }

        return avg; //Returns the average as an integer
    }
    public double [] getClassMin() {
        grpMin = new double [7];
        grpMin [0] = Comp248secU.findMin(this.assgt1);
        grpMin [1] = Comp248secU.findMin(this.assgt2);
        grpMin [2] = Comp248secU.findMin(this.assgt3);
        grpMin [3] = Comp248secU.findMin(this.assgt4);
        grpMin [4] = Comp248secU.findMin(this.labs);
        grpMin [5] = Comp248secU.findMin(this.midTerm);
        grpMin [6] = Comp248secU.findMin(this.finalExam);
        return grpMin;      //Returns the group min as an integer

    }

    public double [] getClassMax() {

        grpMax = new double [7];//The group max array will have size 7, which is the number of grade arrays that exists (a1,a2,a3,a4,labs, midterm, final exam)
//Calls the find max method with each grade array as input to find the average value of the elements in each of these arrays.
        grpMax [0] = Comp248secU.findMax(this.assgt1);
        grpMax [1] = Comp248secU.findMax(this.assgt2);
        grpMax [2] = Comp248secU.findMax(this.assgt3);
        grpMax [3] = Comp248secU.findMax(this.assgt4);
        grpMax [4] = Comp248secU.findMax(this.labs);
        grpMax [5] = Comp248secU.findMax(this.midTerm);
        grpMax [6] = Comp248secU.findMax(this.finalExam);

        return grpMax;      //Returns the group max as an integer

    }

    public double [] getClassAvg() {

        grpAvg = new double [7];        //The group average array will have size 7, which is the number of grade arrays that exists (a1,a2,a3,a4,labs, midterm, final exam)

        //Calls the find average method with each grade array as input to find the average value of the elements in each of these arrays.
        grpAvg [0] = Comp248secU.findAvg(this.assgt1);
        grpAvg [1] = Comp248secU.findAvg(this.assgt2);
        grpAvg [2] = Comp248secU.findAvg(this.assgt3);
        grpAvg [3] = Comp248secU.findAvg(this.assgt4);
        grpAvg [4] = Comp248secU.findAvg(this.labs);
        grpAvg [5] = Comp248secU.findAvg(this.midTerm);
        grpAvg [6] = Comp248secU.findAvg(this.finalExam);

        return grpAvg;      //Returns the group average as an integer
    }

    public void classReportCard() {

        //Outputs the user interface for the report card
        System.out.println("------------------------------------------------------------------------------------");
        System.out.printf("%-15s", "First Name");
        System.out.printf("%-15s", "Last Name");
        System.out.printf("%-15s", "Stud. ID ");
        System.out.printf("%-8s", "A1");
        System.out.printf("%-8s", "A2");
        System.out.printf("%-8s", "A3");
        System.out.printf("%-8s", "A4");
        System.out.printf("%-8s", "Labs");
        System.out.printf("%-8s", "Test");
        System.out.printf("%-8s", "Exam");
        System.out.printf("%-8s", "Wgt.");
        System.out.printf("%-5s", "*");
        System.out.print("\n---------------------------------------------------------------------------------------------------------------");


        //Prints the student's information based

        //for loop to loop through all of the arrays that contain the students' information
        for (int i = 0; i < classSize; i++) {
            if(this.studID[i] != 0) {
                //Outputs the student's information based on the user's index in the arrays
                System.out.println();
                System.out.printf("%-15s",this.studFname[i]);
                System.out.printf("%-15s",this.studLname[i]);
                System.out.printf("%-15s",this.studID[i]);
                System.out.printf("%-8.2f", this.assgt1[i]);
                System.out.printf("%-8.2f",this.assgt2[i]);
                System.out.printf("%-8.2f",this.assgt3[i]);
                System.out.printf("%-8.2f",this.assgt4[i]);
                System.out.printf("%-8.2f",this.labs[i]);
                System.out.printf("%-8.2f",this.midTerm[i]);
                System.out.printf("%-8.2f",this.finalExam[i]);
                System.out.printf("%-8.2f",Comp248secU.this.computeWeightScore(studID[i]));
                System.out.printf("%-8s",Comp248secU.this.computeGrade(Comp248secU.this.computeWeightScore(studID[i])));

            }

        }
    }
}

//2nd class named A4_Q1_Q2
public class A4_Q1_Q2 {

    public static void main(String[] args) { //Main point of entry into the program

        Scanner in = new Scanner(System.in);
        Scanner inCode = new Scanner(System.in);

        //User prompt
        System.out.println("Welcome to the Simple Classroom Management System:");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("\nEnter instructor's particulars (FirstName, LastName, LectureRoom, Semester, MaxClassSize) as a single-line entry:");

        byte code = 0;      //Instantiate code
        int studID;     //Declare studID
        String fname = in.next();
        String lname = in.next();
        String room = in.next();
        String semYr = in.next();
        int size = 0;       //Instantiate size

        //If the user enters an invalid value for the classSize attribute/field,
        if(!in.hasNextInt()) {  //If statement and hasNextInt() Method to the next token in the scanner's input cannot be interpreted as an int value
            System.out.print("Error: Your input/entry for 'MaxClassSize' is NOT a valid integer. Kindly retry again!");
            System.exit(0);     //Program exits if the user enters an invalid value for the classSize attribute/field
        }
        else {
            size = in.nextInt();    //attributes user input to size integer
        }

        //Call to Comp248secU constructor when user is prompted for instructor’s particulars.
        Comp248secU group = new Comp248secU(fname, lname, room, semYr, size);   //Create constructor

        //Menu window is displayed
        System.out.println("\nCode => Description");
        System.out.println("-------------------");
        System.out.println("103 => Enrol New Student");
        System.out.println("106 => Find Student Position in Class List");
        System.out.println("109 => Retrieve Student's Information");
        System.out.println("112 => Unenrol Student");
        System.out.println("115 => Update Student's Particulars");
        System.out.println("118 => Update Assignment Scores");
        System.out.println("121 => Update Other Scores");
        System.out.println("124 => Display Student's Report Card");
        System.out.println("127 => Display Class Report Card");
        System.out.println("0 ===> Exit");
        System.out.print("\nPlease enter a Code, from the aforementioned, that corresponds to your task: ");


        //With a if-else loop and hasNextByte method, check if user input has a byte
        if(!inCode.hasNextByte()) {//If the users an invalid byte value, the program exits
            System.out.print("Error: Your input/entry is not a valid integer between -128 to 127. Kindly retry again!");
            System.exit(0);
        }

        else {
            code = inCode.nextByte();
        }

        //While loop to re-prompt the user for a new menu code once it ends
         while(code >= 0 && code <=127) { //Check if code is between the available range


            if (code == 103) {
                System.out.println("\n\nEnrolling New Student...");
                System.out.println("------------------------");
                System.out.println("Enter student's particulars (FirstName, LastName, StudentID) as a single-line entry:");

                fname = in.next();
                lname = in.next();
               // Attempt to add a new student using an invalid argument for StudentID.
               // Use try catch to test for errors in the code
                try {//Tests if the user has entered an integer
                    studID = in.nextInt();

                    //call to the addStudent() method
                    group.addStudent(fname, lname, studID, size);
                }

                catch(Exception e) {//If the code in the try portion doesnt work, it means that the user has entered a non-integer input
                    System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
                    String dummy = in.next(); //Dummy string to associate the invalid user input. If this String input is not there, the user invalid input for studID will be associated with the code user input once the code menu loops again
                }

            }

            else if (code == 106) {
                System.out.println("\n\nFinding Student's Position in Class List...");
                System.out.println("-------------------------------------------");
                //User prompt
                System.out.println("Enter StudentID:");

                //If statement and hasNextInt() method to check if user input is an integer
                    if (in.hasNextInt()) {
                        studID = in.nextInt();      //Instantiates studID to the user's integer input

                        //triggers a call to the getStudentIdx() method
                        int idx = group.getStudentIdx(studID);


                        //If-Else statement to check if the studID is an element of the studID array (if the student is in the class)
                        //If the getStudentIdx() method doesnt return -1, it will return the studID input's index in the array studID array
                        if (idx != -1) {        //Successful retrieval of the index position, in studID Array, corresponding to an existing Student ID
                            System.out.println("The position of student with ID: " + studID + ", in the class list, is: " + group.getStudentIdx(studID));
                        }
                        //Unsuccessful retrieval of the index position corresponding to an inexistent Student ID
                        else {
                            System.out.println("Student with ID: " + studID + " does NOT exist");
                        }
                    }

                    //Attempt to retrieve an index position, in studID Array, using an invalid (integer) input.
                    else{
                        System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
                        String dummy = in.next();  //Dummy string to associate the invalid user input. If this String input is not there, the user invalid input for studID will be associated with the code user input once the code menu loops again
                    }


            }

            else if (code == 109) {
                System.out.println("\n\nRetrieving Student's Information...");
                System.out.println("-----------------------------------");
                System.out.println("Enter StudentID:");     //User prompt

                if(in.hasNextInt()) {
                    studID = in.nextInt();
                    int idx = group.getStudentIdx(studID);      //Gets the student's idx

                    //Gets the student's information based on its studID, with getter method
                    if(idx != -1) {
                        group.getStudentInfo(studID);
                        System.out.println("Student's First Name = " + group.studInfo[0] );
                        System.out.println("Student's Last Name = " + group.studInfo[1] );
                        System.out.println("Student's ID = "+ group.studInfo[2]);
                        System.out.println("Score in Assignment 1 = " + group.studInfo[3]);
                        System.out.println("Score in Assignment 2 = " + group.studInfo[4]);
                        System.out.println("Score in Assignment 3 = " + group.studInfo[5]);
                        System.out.println("Score in Assignment 4 = " + group.studInfo[6]);
                        System.out.println("Cummulative Score in Labs = " + group.studInfo[7]);
                        System.out.println("Mid-Term Test Score = "+ group.studInfo[8]);
                        System.out.println("Final Examination Score = "+ group.studInfo[9]);
                    }

                    else {
                        System.out.println("Student with ID: " + studID + " does NOT exist");
                        System.out.println("Unable to retrieve information for Student with ID: " + studID);
                    }
                }

                else {
                    System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
                    String dummy = in.next();
                }

            }

            //Deletes the student based on their student ID
            else if (code == 112) {
                System.out.println("\n\nUnenrolling Student...");
                System.out.println("----------------------");
                System.out.println("Enter StudentID:");

                //Checks for integer input in studID
                if(in.hasNextInt()) {
                    studID = in.nextInt();
                    int idx = group.getStudentIdx(studID);


                    if(idx != -1) {
                        group.delStudent(studID);
                        System.out.println("Successfully removed Student with ID: " + studID);
                    }

                    else {
                        System.out.println("Student with ID: " + studID + " does NOT exist");
                        System.out.println("Unable to retrieve information for Student with ID: " + studID);
                    }
                }

                else {
                    System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
                    String dummy = in.next();
                }
            }

            //Updates student information
            else if (code == 115) {
                System.out.println("\n\nUpdating Student's Particulars...");
                System.out.println("---------------------------------");
                System.out.println("Enter update to student's particulars (FirstName, LastName, StudentID) as a single-line entry:");

                //Updates the student's first and last name to the user's input
                fname = in.next();
                lname =in.next();

                //If-else loop to decide if the user's input for student ID is a valid integer
                if(in.hasNextInt()) {
                    studID = in.nextInt();
                    int idx = group.getStudentIdx(studID);      //Gets student id's index in the studID array by calling the getStudentIdx(studID) method

                    if(idx != -1) {
                        group.updateStudentPart(fname, lname, studID);
                        System.out.println("Successfully updated identification particulars for Student with ID: " + studID);
                    }

                    else {
                        System.out.println("Student with ID: " + studID + " does NOT exist");
                        System.out.println("Unable to retrieve information for Student with ID: " + studID);
                    }
                }

                else {
                    System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
                    String dummy = in.next();
                }
            }

            else if (code == 118) {
                System.out.println("\n\nUpdating Assignment Scores...");
                System.out.println("-----------------------------");
                System.out.println("Enter update to student's Assignment scores (Assignment1, Assignment2, Assignment3, Assignment4, StudentID) as a single-line entry:");

                double a1 = 0, a2 = 0, a3 = 0, a4 = 0;      //instantiates a1 to a4 to 0

                //instantiates a1 to a4 to user input
                a1 = in.nextDouble();
                a2 = in.nextDouble();
                a3 = in.nextDouble();
                a4 = in.nextDouble();

                if(in.hasNextInt()) {
                    studID = in.nextInt();
                    int idx = group.getStudentIdx(studID);

                    if(idx != -1) {
                        group.updateAssgtScore(a1, a2, a3, a4, studID);     //calls method to update student information
                        System.out.println("Successfully updated Assignments' scores for Student with ID: " + studID);
                    }

                    else {
                        System.out.println("Student with ID: " + studID + " does NOT exist");
                        System.out.println("Unable to retrieve information for Student with ID: " + studID);
                    }
                }

                else {
                    System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
                    String dummy = in.next();
                }
            }

            else if (code == 121) {
                System.out.println("\n\nUpdating Other Scores...");
                System.out.println("------------------------");
                System.out.println("Enter update to student's Assignment scores (Cummulative Labs, Midterm, FinalExam, StudentID) as a single-line entry:");

                double lab, test, exam;

                //instantiates lab, test, and exam to user input
                lab = in.nextDouble();
                test = in.nextDouble();
                exam  = in.nextDouble();

                //Checks if student ID is an integer
                if(in.hasNextInt()) {
                    studID = in.nextInt();
                    int idx = group.getStudentIdx(studID);      //Retrieves the student ID with the getStudentIdx(studID) method

                    if(idx != -1) {
                        group.updateOtherScore(lab, test, exam, studID);
                        System.out.println("Successfully updated Cummulative Labs, Mid-Term Test, Final Examination scores for Student with ID: " + studID);
                    }
                    else {
                        System.out.println("Student with ID: " + studID + " does NOT exist");
                        System.out.println("Unable to retrieve information for Student with ID: " + studID);
                    }
                }

                else {
                    System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
                    String dummy = in.next();
                }
            }

            //Displays report card
            else if (code == 124) {
                System.out.println("\n\nDisplaying Student's Report Card...");
                System.out.println("-----------------------------------");
                System.out.println("Enter StudentID:");

                if(in.hasNextInt()) {
                    studID = in.nextInt();
                    int idx = group.getStudentIdx(studID);      //Method that gets studID


                    if(idx != -1) {     //Return -1 when the studID doesn't exist

                        //calls getStudentInfo method to get the necessary info
                        group.getStudentInfo(studID);

                        //Getter to get information from group.studInfo method
                        System.out.println("Student's First Name = " + group.studInfo[0] );
                        System.out.println("Student's Last Name = " + group.studInfo[1] );
                        System.out.println("Student's ID = "+ group.studInfo[2]);
                        System.out.println("Score in Assignment 1 = " + group.studInfo[3]);
                        System.out.println("Score in Assignment 2 = " + group.studInfo[4]);
                        System.out.println("Score in Assignment 3 = " + group.studInfo[5]);
                        System.out.println("Score in Assignment 4 = " + group.studInfo[6]);
                        System.out.println("Cummulative Score in Labs = " + group.studInfo[7]);
                        System.out.println("Mid-Term Test Score = "+ group.studInfo[8]);
                        System.out.println("Final Examination Score = "+ group.studInfo[9]);
                        System.out.println("--------------------------");

                        //calls instanced-based method computeWeightScore and computeGrade to print grades (letter and numerical)
                        System.out.println("Student's Cummulative Weighted Score = " + group.computeWeightScore(studID));
                        System.out.println("Student's Final Letter Grade = " + group.computeGrade(group.computeWeightScore(studID)));
                    }

                    else {
                        System.out.println("Student with ID: " + studID + " does NOT exist");
                        System.out.println("Unable to retrieve information for Student with ID: " + studID);
                    }
                }

                else {
                    System.out.println("Error: Your input/entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
                    String dummy = in.next();
                }
            }

            else if(code == 127) {
                System.out.println("\n\nDisplaying Class Report Card...");
                System.out.println("-------------------------------");
                group.classReportCard(); //Calls the class report class method

                System.out.println("\n---------------------------------------------------------------------------------------------------------------");
                System.out.printf("%-16s", " ");
                System.out.printf("%-28s", "Minimum Score in Class:   ");

                //Displays class min values
                group.getClassMin();
                System.out.printf("%-8.2f", group.grpMin[0]);
                System.out.printf("%-8.2f",group.grpMin[1]);
                System.out.printf("%-8.2f",group.grpMin[2]);
                System.out.printf("%-8.2f",group.grpMin[3]);
                System.out.printf("%-8.2f",group.grpMin[4]);
                System.out.printf("%-8.2f",group.grpMin[5]);
                System.out.printf("%-8.2f",group.grpMin[6]);

                System.out.println();
                System.out.printf("%-16s", " ");
                System.out.printf("%-28s", "Average Score in Class: ");

                //Displays class average values
                group.getClassAvg();
                System.out.printf("%-8.2f",group.grpAvg[0]);
                System.out.printf("%-8.2f",group.grpAvg[1]);
                System.out.printf("%-8.2f",group.grpAvg[2]);
                System.out.printf("%-8.2f",group.grpAvg[3]);
                System.out.printf("%-8.2f",group.grpAvg[4]);
                System.out.printf("%-8.2f",group.grpAvg[5]);
                System.out.printf("%-8.2f",group.grpAvg[6]);

                System.out.println();
                System.out.printf("%-16s", " ");
                System.out.printf("%-28s", "Maximum Score in Class: ");

                group.getClassMax();

                //Displays class max values
                System.out.printf("%-8.2f",group.grpMax[0]);
                System.out.printf("%-8.2f",group.grpMax[1]);
                System.out.printf("%-8.2f",group.grpMax[2]);
                System.out.printf("%-8.2f",group.grpMax[3]);
                System.out.printf("%-8.2f",group.grpMax[4]);
                System.out.printf("%-8.2f",group.grpMax[5]);
                System.out.printf("%-8.2f",group.grpMax[6]);

                System.out.println();
                System.out.println("---------------------------------------------------------------------------------------------------------------");

            }

            //else if statement if the user enters a valid byte value but an invalid menu code
            else if(code != 103 && code !=106 && code != 109 && code != 112 && code != 115 && code != 118 && code != 121 && code != 124 && code != 127) {
                System.out.print("\nThank you for patronizing our Simple Classroom Management System.");
                System.exit(0);     //Program exits on invalid menu code
            }

            System.out.print("Kindly continue by adding a Code, from the menu above, that corresponds to your task: ");
            code = inCode.nextByte();

        }

    }
}
