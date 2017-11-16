
/**
 * 
 * @author maxkratz
 * @version 0.6.1
 *
 */
public class Generator {

  /**
   * Returns a random string with a specific length.
   * 
   * @param letter letters or no letters
   * @param capitalLetter capital letters or no capital letters
   * @param number numbers or no numbers
   * @param symbol symbols or no symbols
   * @param length length of the string
   * @return randomized string
   */
  public String generateString(Boolean letter, Boolean capitalLetter, Boolean number,
      Boolean symbol, int length) {
    String myString = "";

    // letters, numbers and symbols
    if (letter && !capitalLetter && number && symbol) {
      for (int i = 0; i < length; i++) {
        int randomNumber = this.getRandomInt(63);

        if (randomNumber <= 25) {
          myString = myString + this.getLetter(randomNumber);
        }

        if (randomNumber > 25 && randomNumber <= 36) {
          myString = myString + this.getNumber(randomNumber - 26);
        }

        if (randomNumber > 36 && randomNumber <= 63) {
          myString = myString + this.getSymbol(randomNumber - 26 - 10 - 1);
        }
      }
    }

    // letters, capital letters, symbols
    if (letter && capitalLetter && !number && symbol) {
      for (int i = 0; i < length; i++) {
        int randomNumber = this.getRandomInt(80);

        if (randomNumber <= 25) {
          myString = myString + this.getLetter(randomNumber);
        }

        if (randomNumber > 25 && randomNumber <= 51) {
          myString = myString + this.getCapitalLetter(randomNumber - 26);
        }

        if (randomNumber > 51 && randomNumber <= 80) {
          myString = myString + this.getSymbol(randomNumber - 26 - 26);
        }
      }
    }

    // letters, capital letters and numbers
    if (letter && capitalLetter && number && !symbol) {
      for (int i = 0; i < length; i++) {
        int randomNumber = this.getRandomInt(61);

        if (randomNumber <= 25) {
          myString = myString + this.getLetter(randomNumber);
        }

        if (randomNumber > 25 && randomNumber <= 51) {
          myString = myString + this.getCapitalLetter(randomNumber - 26);
        }

        if (randomNumber > 51 && randomNumber <= 61) {
          myString = myString + this.getNumber(randomNumber - 26 - 26);
        }
      }
    }

    // capital letters, numbers and symbols
    if (!letter && capitalLetter && number && symbol) {
      for (int i = 0; i < length; i++) {
        int randomNumber = this.getRandomInt(64);

        if (randomNumber <= 25) {
          myString = myString + this.getCapitalLetter(randomNumber);
        }

        if (randomNumber > 25 && randomNumber <= 36) {
          myString = myString + this.getNumber(randomNumber - 26);
        }

        if (randomNumber > 36 && randomNumber <= 64) {
          myString = myString + this.getSymbol(randomNumber - 26 - 10 - 1);
        }
      }
    }

    // letters, capital letters, numbers and symbols
    if (letter && capitalLetter && number && symbol) {
      for (int i = 0; i < length; i++) {
        int randomNumber = this.getRandomInt(90);

        if (randomNumber <= 25) {
          myString = myString + this.getLetter(randomNumber);
        }

        if (randomNumber > 25 && randomNumber <= 51) {
          myString = myString + this.getCapitalLetter(randomNumber - 26);
        }

        if (randomNumber > 51 && randomNumber <= 61) {
          myString = myString + this.getNumber(randomNumber - 26 - 26);
        }

        if (randomNumber > 61 && randomNumber <= 90) {
          myString = myString + this.getSymbol(randomNumber - 26 - 26 - 10);
        }
      }
    }

    // letters
    if (letter && !capitalLetter && !number && !symbol) {
      for (int i = 0; i < length; i++) {
        myString = myString + this.getLetter(this.getRandomInt(25));
      }
    }

    // capital letters
    if (!letter && capitalLetter && !number && !symbol) {
      for (int i = 0; i < length; i++) {
        myString = myString + this.getCapitalLetter(this.getRandomInt(25));
      }
    }

    // numbers
    if (!letter && !capitalLetter && number && !symbol) {
      for (int i = 0; i < length; i++) {
        myString = myString + this.getNumber(this.getRandomInt(9));
      }
    }

    // symbols
    if (!letter && !capitalLetter && !number && symbol) {
      for (int i = 0; i < length; i++) {
        myString = myString + this.getSymbol(this.getRandomInt(28));
      }
    }

    // letters and capital letters
    if (letter && capitalLetter && !number && !symbol) {
      for (int i = 0; i < length; i++) {
        int randomNumber = this.getRandomInt(51);

        if (randomNumber <= 25) {
          myString = myString + this.getLetter(randomNumber);
        } else {
          myString = myString + this.getCapitalLetter(randomNumber - 25);
        }

      }
    }

    // letters and numbers
    if (letter && !capitalLetter && number && !symbol) {
      for (int i = 0; i < length; i++) {
        int randomNumber = this.getRandomInt(34);

        if (randomNumber <= 24) {
          myString = myString + this.getLetter(randomNumber);
        } else {
          myString = myString + this.getNumber(randomNumber - 24);
        }

      }
    }

    // capital letters and numbers
    if (!letter && capitalLetter && number && !symbol) {
      for (int i = 0; i < length; i++) {
        int randomNumber = this.getRandomInt(34);

        if (randomNumber <= 24) {
          myString = myString + this.getCapitalLetter(randomNumber);
        } else {
          myString = myString + this.getNumber(randomNumber - 24);
        }

      }
    }

    // letters and symbols
    if (letter && !capitalLetter && !number && symbol) {
      for (int i = 0; i < length; i++) {
        int randomNumber = this.getRandomInt(53);

        if (randomNumber <= 24) {
          myString = myString + this.getLetter(randomNumber);
        } else {
          myString = myString + this.getSymbol(randomNumber - 24);
        }
      }
    }

    // capital letters and symbols
    if (!letter && capitalLetter && !number && symbol) {
      for (int i = 0; i < length; i++) {
        int randomNumber = this.getRandomInt(53);

        if (randomNumber <= 24) {
          myString = myString + this.getCapitalLetter(randomNumber);
        } else {
          myString = myString + this.getSymbol(randomNumber - 24);
        }
      }
    }

    // numbers and symbols
    if (!letter && !capitalLetter && number && symbol) {
      for (int i = 0; i < length; i++) {
        int randomNumber = this.getRandomInt(38);

        if (randomNumber <= 9) {
          myString = myString + this.getNumber(randomNumber);
        } else {
          myString = myString + this.getSymbol(randomNumber - 9);
        }
      }
    }

    return myString;
  }


  /**
   * Returns a random int between 0 and max
   * 
   * @param max maximum of random number
   * @return random number (int)
   */
  public int getRandomInt(int max) {
    return (int) ((Math.random()) * max);
  }

  /**
   * Returns a normal letter.
   * 
   * @param index index of letter
   * @return letter
   */
  public String getLetter(int index) {
    // switch-case
    switch (index) {
      case 0:
        return "a";
      case 1:
        return "b";
      case 2:
        return "c";
      case 3:
        return "d";
      case 4:
        return "e";
      case 5:
        return "f";
      case 6:
        return "g";
      case 7:
        return "h";
      case 8:
        return "i";
      case 9:
        return "j";
      case 10:
        return "k";
      case 11:
        return "l";
      case 12:
        return "m";
      case 13:
        return "n";
      case 14:
        return "o";
      case 15:
        return "p";
      case 16:
        return "q";
      case 17:
        return "r";
      case 18:
        return "s";
      case 19:
        return "t";
      case 20:
        return "u";
      case 21:
        return "v";
      case 22:
        return "w";
      case 23:
        return "x";
      case 24:
        return "y";
      case 25:
        return "z";
      default:
        return null;
    }
  }

  /**
   * Returns a capital letter.
   * 
   * @param index index of capital letter
   * @return capital letter
   */
  public String getCapitalLetter(int index) {
    // switch-case
    switch (index) {
      case 0:
        return "A";
      case 1:
        return "B";
      case 2:
        return "C";
      case 3:
        return "D";
      case 4:
        return "E";
      case 5:
        return "F";
      case 6:
        return "G";
      case 7:
        return "H";
      case 8:
        return "I";
      case 9:
        return "J";
      case 10:
        return "K";
      case 11:
        return "L";
      case 12:
        return "M";
      case 13:
        return "N";
      case 14:
        return "O";
      case 15:
        return "P";
      case 16:
        return "Q";
      case 17:
        return "R";
      case 18:
        return "S";
      case 19:
        return "T";
      case 20:
        return "U";
      case 21:
        return "V";
      case 22:
        return "W";
      case 23:
        return "X";
      case 24:
        return "Y";
      case 25:
        return "Z";
      default:
        return null;
    }
  }

  /**
   * Returns a string with a number between 0 and 9.
   * 
   * @param index number
   * @return number
   */
  public String getNumber(int index) {
    // switch-case
    switch (index) {
      case 0:
        return "0";
      case 1:
        return "1";
      case 2:
        return "2";
      case 3:
        return "3";
      case 4:
        return "4";
      case 5:
        return "5";
      case 6:
        return "6";
      case 7:
        return "7";
      case 8:
        return "8";
      case 9:
        return "9";
      default:
        return null;
    }
  }

  /**
   * Returns a symbol with index index.
   * 
   * @param index index of symbol
   * @return symbol
   */
  public String getSymbol(int index) {
    // switch-case
    switch (index) {
      case 0:
        return "€";
      case 1:
        return "@";
      case 2:
        return "!";
      case 3:
        return "§";
      case 4:
        return "$";
      case 5:
        return "%";
      case 6:
        return "&";
      case 7:
        return "/";
      case 8:
        return "(";
      case 9:
        return ")";
      case 10:
        return "=";
      case 11:
        return "?";
      case 12:
        return "ß";
      case 13:
        return "`";
      case 14:
        return "´";
      case 15:
        return "*";
      case 16:
        return "+";
      case 17:
        return "'";
      case 18:
        return "#";
      case 19:
        return "-";
      case 20:
        return "_";
      case 21:
        return ".";
      case 22:
        return ":";
      case 23:
        return ",";
      case 24:
        return ";";
      case 25:
        return "<";
      case 26:
        return ">";
      case 27:
        return "°";
      case 28:
        return "^";
      default:
        return null;
    }
  }
}
