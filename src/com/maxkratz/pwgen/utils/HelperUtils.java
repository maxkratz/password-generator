package com.maxkratz.pwgen.utils;

import java.util.HashSet;
import java.util.Set;

/**
 * More or less generic helper class.
 *
 * @author maxkratz
 * @version 0.1.0
 *
 */
public class HelperUtils {

  private HelperUtils() {}

  /**
   * Returns a set of integers from min to max (inclusive).
   *
   * @param min Lower bound.
   * @param max Upper bound.
   * @return Set of integer with values from min to max.
   */
  public static Set<Integer> fillRangesInSet(final int min, final int max) {
    final Set<Integer> range = new HashSet<Integer>();

    for (int i = min; i <= max; i++) {
      range.add(i);
    }

    return range;
  }

  /**
   * Calculates the number of possibilities for given parameters.
   *
   * @param chckbxLetters True if letters are selected.
   * @param chckbxCapitalLetters True if capital letters are selected.
   * @param chckbxSymbols True if symbols are selected.
   * @param chckbxNumbers True if numbers are selected.
   * @param length Length of random string.
   * @return Calculated number of possibilities.
   */
  public static double calculatePossibilities(final Boolean chckbxLetters,
      final Boolean chckbxCapitalLetters, final Boolean chckbxSymbols, final Boolean chckbxNumbers,
      final int length) {
    int counter = 0;

    // letters
    if (chckbxLetters) {
      counter = counter + 26;
    }

    // capital letters
    if (chckbxCapitalLetters) {
      counter = counter + 26;
    }

    // numbers
    if (chckbxNumbers) {
      counter = counter + 10;
    }

    // symbols
    if (chckbxSymbols) {
      counter = counter + 28;
    }

    return Math.pow(counter, length);
  }

}
