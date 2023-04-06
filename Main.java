// Jisselle Garcia, 04/05/2023
// Lab 8
// This program is a BMI Calculator using six methods and error exceptions

package edu.cscc;

import java.util.Scanner;

public class Main {

    //Instance of Scanner
    private static Scanner input = new Scanner(System.in);
    private static final String INPUT_ERROR = "Input is not valid, try again";

    public static void main(String[] args) {
        double lbs, kgs, bmi, meters, inches;
        String classification;

        //Title of the program
        System.out.println();
        System.out.println("Hello, welcome to the CSCC Health BMI Calculator!");
        System.out.println();
        //Calling two methods, one for weight and one for height
        lbs = inputWeight();
        inches = inputHeight();

        kgs = convertToKilograms(lbs);
        meters = convertToMeters(inches);
        bmi = calcBMI(kgs, meters);
        classification = bmiClassification(bmi);

        System.out.println("Your BMI is: " + (bmi));
        System.out.println("Your BMI classification is: " + (classification));
    }

    //SIX STATIC METHODS START HERE
    //Prompts user for their with weight and includes exception handling
    public static double inputWeight() {
        String userInput;
        double weight;

        do {
            System.out.println("Please enter your weight in pounds: ");
            userInput = input.nextLine();
            try {
                weight = Double.parseDouble(userInput);
            } catch
            (NullPointerException | NumberFormatException ex) {
                weight = 0;
            }
            if (weight <= 0) {
                System.out.println(INPUT_ERROR);
            }
        }
        while (weight <= 0);
        return weight;
    }

    public static double inputHeight() {
        String userInput;
        double height;

        do {
            System.out.println("Please enter your height in inches: ");
            userInput = input.nextLine();
            try {
                height = Double.parseDouble(userInput);
            } catch
            (NullPointerException | NumberFormatException ex) {
                height = 0;
            }
            if (height <= 0) {
                System.out.println(INPUT_ERROR);
            }
        }
        while (height <= 0);
        return height;
    }

    public static double convertToKilograms(double lbs) {
        double kgs;
        kgs = (lbs / 2.2046);
        return kgs;
    }

    public static double convertToMeters(double inches) {
        double meters;
        meters = (inches / 39.37);
        return meters;
    }
    public static double calcBMI(double kgs,double meters) {
        double bmi;
        bmi = kgs / Math.pow(meters, 2.0);
        return bmi;
    }

    public static String bmiClassification(double bmi) {
        String classification;
        if (bmi <= 18.5)
            classification = "Underweight";
        else if (bmi <= 25.0)
            classification = "Normal";
        else if (bmi <= 30.0)
            classification = "Overweight";
        else
            classification = "Obese";
        return classification;
    }

}