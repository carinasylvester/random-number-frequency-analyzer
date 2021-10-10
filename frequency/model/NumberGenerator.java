package edu.westga.cs6311.frequency.model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The NumberGenerator generates random numbers and statistics for the random
 * numbers generated as well.
 * 
 * This class generates random number between 0 - 999.
 * 
 * @author Carina Sylvester
 * @version 11/20/2020
 *
 */

public class NumberGenerator {
    private static final int DEFAULT_NUMBERS = 100;
    private ArrayList<Integer> numbers;

    /**
     * Creates a NumberGenerator object and initializes the instance variables
     * 
     * @precondition None
     */
    public NumberGenerator() {
        this.numbers = new ArrayList<>();
    }

    /**
     * This method is used to generate total 'DEFAULT_NUMBERS' (which is equal to
     * 100) of random numbers.
     * 
     * This method is called when user enters a negative number when asked for total
     * numbers to be generated
     * 
     * @precondition None
     */
    public void generateNumbers() {
        this.generateNumbers(DEFAULT_NUMBERS);
    }

    /**
     * This method generates a specific number of random values between 0 and 999,
     * inclusive.
     * 
     * @param numbersToGenerate count of numbers to be generated
     * 
     * @precondition None
     */
    public void generateNumbers(int numbersToGenerate) {
        for (int count = 0; count < numbersToGenerate; count++) {
            int randomNumber = (int) (Math.random() * 1000);
            this.numbers.add(randomNumber);
        }
    }

    /**
     * This method calculates and returns the average of the random number generated
     * by this Number Generator.
     * 
     * @return average of random number generated
     * 
     * @precondition None
     */
    public float getAverage() {
        float sum = 0;

        for (int currentNumber : this.numbers) {
            sum += currentNumber;
        }

        return sum / this.numbers.size();
    }

    /**
     * This method calculates and returns the minimum of the random number generated
     * by this Number Generator.
     * 
     * @return minimum random number generated
     * 
     * @precondition None
     */
    public int getMinimum() {
        int minValue = Integer.MAX_VALUE;

        for (int currentNumber : this.numbers) {
            minValue = Math.min(minValue, currentNumber);
        }

        return minValue;
    }

    /**
     * This method calculates and returns the maximum of the random number generated
     * by this Number Generator.
     * 
     * @return maximum random number generated
     * 
     * @precondition None
     */
    public int getMaximum() {
        int maxValue = Integer.MIN_VALUE;

        for (int currentNumber : this.numbers) {
            maxValue = Math.max(maxValue, currentNumber);
        }

        return maxValue;
    }

    /**
     * This method returns the number generated in non-decreasing order.
     * 
     * @return ArrayList containing the random numbers generated in sorted order
     * 
     * @precondition None
     */
    public ArrayList<Integer> getNumbersInOrder() {
        ArrayList<Integer> sortedNumbers = new ArrayList<>(this.numbers);
        this.sort(sortedNumbers);
        return sortedNumbers;
    }

    /**
     * This method calculates and returns the median of the random number generated
     * by this Number Generator.
     * 
     * @return median random number generated
     * 
     * @precondition None
     */
    public float getMedian() {
        ArrayList<Integer> sortedNumbers = this.getNumbersInOrder();
        if (sortedNumbers.size() % 2 == 0) {
            return (sortedNumbers.get(sortedNumbers.size() / 2) + sortedNumbers.get(sortedNumbers.size() / 2 - 1))
                    / 2.0f;
        } else {
            return sortedNumbers.get(sortedNumbers.size() / 2);
        }
    }

    /**
     * This method will construct and return a 10‐element simple array containing
     * the count of the numbers in each 100 value bucket.
     * 
     * @return integer array with count of numbers in each 100 value bucket
     */
    public int[] getBucketCount() {
        int[] bucketCountArray = new int[10];

        for (int currentNumber : this.numbers) {
            bucketCountArray[currentNumber / 100]++;
        }

        return bucketCountArray;
    }

    /**
     * This helper method sorts the list of integers passed to it in non-decreasing
     * order.
     * 
     * @param list of Integers to sort
     * 
     * @precondition None
     */
    private void sort(ArrayList<Integer> list) {
        Collections.sort(list);
    }
}