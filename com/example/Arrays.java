package com.example;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Change me.
 *
 * @author Christopher Di Bert
 * @version 1.0
 * @since 2024-03-27
 */

// Arrays class
public final class Arrays {

  /*Casted numbers stored as a property of the Arrays class
   * so passing by value is unnecessary.
   */
  private static int[] numbersArr;

  /** Private constructor to prevent instantiation. */
  private Arrays() {
    throw new UnsupportedOperationException("Cannot instantiate");
  }

  /**
   * This is the main method.
   *
   * @param args Unused
   */
  public static void main(final String[] args) {
    // List of relative file paths to the input data set.
    String[] readFilePaths = {"Unit2-03-set1.txt", "Unit2-03-set2.txt", "Unit2-03-set3.txt"};

    // Foreach loop that iterates over every file path.
    for (String readPath : readFilePaths) {
      File readFile = new File(readPath);
      List<String> listOfNumbersStr = new ArrayList<String>();

      // Tries to read from the specified file.
      try {
        // Reads all lines and stores them in array list.
        Scanner sc = new Scanner(readFile);
        while (sc.hasNextLine()) {
          String numStr = sc.next();
          listOfNumbersStr.add(numStr);
        }

      } catch (Exception e) {
        System.out.println("Invalid file path!");
      }

      // Overrides numbersArr property with new array of the list size.
      numbersArr = new int[listOfNumbersStr.size()];
      // Sets number array by casting every element in the string list.
      for (int i = 0; i < listOfNumbersStr.size(); i++) {
        numbersArr[i] = Integer.parseInt(listOfNumbersStr.get(i));
      }
      java.util.Arrays.sort(numbersArr);

      // Performs all calculations and presents them.
      Double meanNum = CalcMean();
      Double medianNum = CalcMedian();
      System.out.println(readPath.toUpperCase() + ":");
      System.out.println("Mean: " + meanNum);
      System.out.println("Median: " + medianNum);
    }
  }

  /**
   * This method calculates the mean.
   *
   * @param args Unused
   * @return mean
   */
  private static Double CalcMean() {
    long sum = 0l;
    for (int number : numbersArr) {
      sum += number;
    }
    Double mean = sum / Double.valueOf(numbersArr.length);
    return mean;
  }

  /**
   * This method calculates the median.
   *
   * @param args Unused
   * @return median
   */
  private static Double CalcMedian() {

    if (numbersArr.length == 1) {
      Double median = Double.valueOf(numbersArr[0]);
      return median;
    }

    if (numbersArr.length % 2 == 0) {
      int num1 = numbersArr[(numbersArr.length / 2) - 1];
      int num2 = numbersArr[(numbersArr.length / 2)];
      Double median = (num1 + num2) / 2.0;
      return median;
    } else {
      int intMedian = numbersArr[Math.floorDiv(numbersArr.length, 2)];
      Double median = Double.valueOf(intMedian);
      return median;
    }
  }
}
