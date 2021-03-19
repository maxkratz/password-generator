import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * 
 * @author maxkratz
 * @version 0.7.0
 *
 */
public class Generator {

  /**
   * Returns a random string with a specific length.
   * 
   * @param letter If true, include letters.
   * @param capitalLetter If true, include capital letters.
   * @param number If true, include numbers.
   * @param symbol If true, include symbols.
   * @param length Length of the string to generate.
   * @return Randomized string.
   */
  public String generateString(final Boolean letter, final Boolean capitalLetter,
      final Boolean number, final Boolean symbol, final int length) {
    final Random rand = new Random();
    final List<Integer> values = new ArrayList<Integer>();

    if (letter) {
      values.addAll(fillRangesInSet(97, 122));
    }

    if (capitalLetter) {
      values.addAll(fillRangesInSet(65, 90));
    }

    if (number) {
      values.addAll(fillRangesInSet(48, 57));
    }

    if (symbol) {
      values.addAll(fillRangesInSet(33, 47));
      values.addAll(fillRangesInSet(58, 64));
      values.addAll(fillRangesInSet(91, 96));
      values.addAll(fillRangesInSet(123, 126));
    }

    return rand.ints(0, values.size()) //
        .limit(length) //
        .map(i -> values.get(i)) //
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append) //
        .toString();
  }

  /**
   * Returns a set of integers from min to max (inclusive).
   * 
   * @param min Lower bound.
   * @param max Upper bound.
   * @return Set of integer with values from min to max.
   */
  private Set<Integer> fillRangesInSet(final int min, final int max) {
    final Set<Integer> range = new HashSet<Integer>();

    for (int i = min; i <= max; i++) {
      range.add(i);
    }

    return range;
  }

}
