import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class for generating random strings.
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
      values.addAll(HelperUtils.fillRangesInSet(97, 122));
    }

    if (capitalLetter) {
      values.addAll(HelperUtils.fillRangesInSet(65, 90));
    }

    if (number) {
      values.addAll(HelperUtils.fillRangesInSet(48, 57));
    }

    if (symbol) {
      values.addAll(HelperUtils.fillRangesInSet(33, 47));
      values.addAll(HelperUtils.fillRangesInSet(58, 64));
      values.addAll(HelperUtils.fillRangesInSet(91, 96));
      values.addAll(HelperUtils.fillRangesInSet(123, 126));
    }

    return rand.ints(0, values.size()) //
        .limit(length) //
        .map(i -> values.get(i)) //
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append) //
        .toString();
  }

}
