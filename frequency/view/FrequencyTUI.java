package edu.westga.cs6311.frequency.view;

import java.util.ArrayList;
import java.util.Scanner;

import edu.westga.cs6311.frequency.model.NumberGenerator;

/**
 * This class is used to generate random numbers and display statistics of the
 * numbers generated.
 * 
 * @author Carina Sylvester
 * @version 11/20/2020
 * 
 */
public class FrequencyTUI {
    private NumberGenerator numberGeneratorObject;
    private Scanner scan;

    /**
     * Initializes the instance variables
     * 
     * @param numberGenerator object of NumberGenerator class
     * 
     * @precondition numberGenerator != null
     */
    public FrequencyTUI(NumberGenerator numberGenerator) {
        if (numberGenerator == null) {
			return;
		}
        this.numberGeneratorObject = numberGenerator;
        this.scan = new Scanner(System.in);
    }

    /**
     * This method asks user to enter the number of random numbers to be generated.
     * And number of numbers per line to display. Then this method generated random
     * number using NumberGenerator object and display statistics of the numbers
     * generated.
     * 
     * @precondition None
     */
    public void run() {
        System.out.println("Welcome to the Frequency Generator Application");
        System.out.println("which will display a histogram of random numbers");
        System.out.println("between 0 and 999, inclusive");
        System.out.println();

        int totalNumbers;
        do {
            System.out.print("Enter the number of numbers (maximum 5000) you would like: ");
            totalNumbers = Integer.parseInt(this.scan.nextLine());
        } while (totalNumbers > 5000);

        System.out.println();

        int numbersPerLine;
        do {
            System.out.print("Enter the number of numbers per line (maximum 12): ");
            numbersPerLine = Integer.parseInt(this.scan.nextLine());
        } while (numbersPerLine > 12 || numbersPerLine < 1);

        if (totalNumbers < 0) {
            this.numberGeneratorObject.generateNumbers();
        } else {
            this.numberGeneratorObject.generateNumbers(totalNumbers);
        }

        System.out.println();
        this.displaySortedNumbers(numbersPerLine);

        System.out.println();
        this.displayStatistics();

        System.out.println();
        this.displayHistogram();
    }

    /**
     * This method displays Minimum, Maximum, Average and Median of the random
     * numbers generated.
     * 
     * @precondition None
     */
    private void displayStatistics() {
        System.out.println("Minimum:      " + this.numberGeneratorObject.getMinimum());
        System.out.println("Maximum:      " + this.numberGeneratorObject.getMaximum());
        System.out.printf("Average:      %.2f\n", this.numberGeneratorObject.getAverage());
        System.out.printf("Median:       %.2f\n", this.numberGeneratorObject.getMedian());
    }

    /**
     * This method displays the random numbers generated in sorted order and
     * displays specific count of numbers on each line as specified by the user.
     * 
     * @param numbersPerLine the count of numbers to be displayed on each line
     * 
     * @precondition None
     */
    private void displaySortedNumbers(int numbersPerLine) {
        ArrayList<Integer> sortedNumbers = this.numberGeneratorObject.getNumbersInOrder();

        for (int index = 0; index < sortedNumbers.size();) {
            for (int count = 0; count < numbersPerLine; count++) {
                if (index < sortedNumbers.size()) {
                    System.out.printf("%-3d   ", sortedNumbers.get(index++));
                }
            }
            System.out.println();
        }
    }

    /**
     * This method displays one line of output for each of the 10 buckets (0‐99,
     * 100‐199, etc) listing the range of values and one asterisk (*) for each value
     * generated in that range.
     * 
     * @precondition None
     */
    private void displayHistogram() {
        int[] bucketCount = this.numberGeneratorObject.getBucketCount();
        int st = 0;
        int end = 99;
        for (int index = 0; index < bucketCount.length; index++) {
            System.out.printf("%3d-%3d: ", st, end);
            for (int count = 0; count < bucketCount[index]; count++) {
                System.out.print("*");
            }
            st += 100;
            end += 100;
            System.out.println();
        }
    }

}
