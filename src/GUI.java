import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * 
 * @author maxkratz
 * @version 0.7.3
 *
 */
public class GUI {

  private JFrame frmPasswordgeneratorV;
  private Generator myGen = new Generator();
  private JTextField textField_lengthName;
  private JTextField textField_lengthPassword;
  private JTextField textField_name;
  private JTextField textField_password;
  private JTextField textField_possibilities;

  /**
   * Launch the application.
   * 
   * @param args main arguments
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          GUI window = new GUI();
          window.frmPasswordgeneratorV.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public GUI() {
    initialize();
  }

  /**
   * Calculates the possibilites for given parameters.
   * 
   * @param possibilityOne possibility one
   * @param possibilityTwo possibility two
   * @param chckbxLetters set letter
   * @param chckbxCapitalLetters set capital letters
   * @param chckbxSymbols set symbols
   * @param chckbxNumbers set numbers
   * 
   * @return calculated Possibilities
   */
  public double calculatePossibilities(Boolean possibilityOne, Boolean possibilityTwo,
      Boolean chckbxLetters, Boolean chckbxCapitalLetters, Boolean chckbxSymbols,
      Boolean chckbxNumbers) {
    // Calculate the number of possibilities specified for the selection:
    if (possibilityOne && possibilityTwo) {
      double calculatedPossibility = 0;
      int numberOfSymbolsPassword = Integer.parseInt(textField_lengthPassword.getText());

      // new version
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
        counter = counter + 29;
      }

      calculatedPossibility = Math.pow(counter, numberOfSymbolsPassword);
      return calculatedPossibility;
    } else {
      return -1;
    }
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frmPasswordgeneratorV = new JFrame();
    frmPasswordgeneratorV.setTitle("Password-Generator v.0.7.3");
    frmPasswordgeneratorV.setBounds(100, 100, 520, 300);
    frmPasswordgeneratorV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frmPasswordgeneratorV.getContentPane().setLayout(null);

    JCheckBox chckbxLetters = new JCheckBox("Letters");
    chckbxLetters.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {}
    });
    chckbxLetters.setSelected(true);
    chckbxLetters.setBounds(207, 7, 147, 23);
    frmPasswordgeneratorV.getContentPane().add(chckbxLetters);

    JCheckBox chckbxNumbers = new JCheckBox("Numbers");
    chckbxNumbers.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {}
    });
    chckbxNumbers.setSelected(true);
    chckbxNumbers.setBounds(366, 7, 128, 23);
    frmPasswordgeneratorV.getContentPane().add(chckbxNumbers);

    JCheckBox chckbxSymbols = new JCheckBox("Symbols");
    chckbxSymbols.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {}
    });
    chckbxSymbols.setSelected(true);
    chckbxSymbols.setBounds(366, 35, 128, 23);
    frmPasswordgeneratorV.getContentPane().add(chckbxSymbols);

    JSeparator separator = new JSeparator();
    separator.setBounds(6, 67, 508, 12);
    frmPasswordgeneratorV.getContentPane().add(separator);

    JLabel lblPossibilities = new JLabel("Possibilities");
    lblPossibilities.setBounds(6, 167, 97, 16);
    frmPasswordgeneratorV.getContentPane().add(lblPossibilities);

    textField_possibilities = new JTextField();
    textField_possibilities.setBounds(129, 162, 365, 29);
    frmPasswordgeneratorV.getContentPane().add(textField_possibilities);
    textField_possibilities.setColumns(10);

    JCheckBox chckbxCapitalLetters = new JCheckBox("Capital letters");
    chckbxCapitalLetters.setSelected(true);
    chckbxCapitalLetters.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {}
    });
    chckbxCapitalLetters.setBounds(207, 35, 158, 23);
    frmPasswordgeneratorV.getContentPane().add(chckbxCapitalLetters);

    JButton btnGenerate = new JButton("Generate");

    btnGenerate.setBounds(207, 243, 117, 29);
    frmPasswordgeneratorV.getContentPane().add(btnGenerate);

    textField_lengthName = new JTextField();
    textField_lengthName.addKeyListener(new KeyAdapter() {

      // Key pressed in textfield lenghtName
      @Override
      public void keyPressed(KeyEvent e) {
        // declerations:
        Boolean possibilityOne = false;
        Boolean possibilityTwo = false;

        try {
          textField_name.setText(myGen.generateString(chckbxLetters.isSelected(),
              chckbxCapitalLetters.isSelected(), chckbxNumbers.isSelected(), false,
              Integer.parseInt(textField_lengthName.getText())));
          possibilityOne = true;
        } catch (java.lang.NumberFormatException ex) {
          System.out.println("Error: The text entered in lenght of name is invalid.");
          System.out.println(ex.getMessage());
          possibilityOne = false;

          textField_name.setText("Input invalid.");
        }

        try {
          textField_password.setText(myGen.generateString(chckbxLetters.isSelected(),
              chckbxCapitalLetters.isSelected(), chckbxNumbers.isSelected(),
              chckbxSymbols.isSelected(),
              Integer.parseInt(textField_lengthPassword.getText())));
          possibilityTwo = true;
        } catch (java.lang.NumberFormatException ex) {
          System.out.println("Error: The text entered in lenght of password is invalid.");
          System.out.println(ex.getMessage());
          possibilityTwo = false;

          textField_password.setText("Input invalid.");
        }

        double calculatedPossibility = calculatePossibilities(possibilityOne, possibilityTwo,
            chckbxLetters.isSelected(), chckbxCapitalLetters.isSelected(),
            chckbxSymbols.isSelected(), chckbxNumbers.isSelected());

        // test if calculatedPossibility is larger than max of double
        if (calculatedPossibility <= 1.567727E308) {
          // if the string contains no "E" it is not in exponential spelling
          if (!String.valueOf(calculatedPossibility).contains("E")) {
            textField_possibilities.setText(String.valueOf((int) calculatedPossibility));
          }

          else {
            /*
             * Not working yet :-)
             */

            // Debug:
            textField_possibilities.setText(String.valueOf(calculatedPossibility));
          }
        }

        // calculatedPossibility is larger than max of double
        else {
          textField_possibilities.setText("Larger than: 1.56 E308");
        }
      }
    });

    textField_lengthName.setText("8");
    textField_lengthName.setBounds(129, 6, 66, 26);
    frmPasswordgeneratorV.getContentPane().add(textField_lengthName);
    textField_lengthName.setColumns(10);

    JLabel lblLengthName = new JLabel("Length name");
    lblLengthName.setBounds(6, 11, 95, 16);
    frmPasswordgeneratorV.getContentPane().add(lblLengthName);

    JLabel lblLengthPassword = new JLabel("Length password");
    lblLengthPassword.setBounds(6, 39, 111, 16);
    frmPasswordgeneratorV.getContentPane().add(lblLengthPassword);

    textField_lengthPassword = new JTextField();
    textField_lengthPassword.addKeyListener(new KeyAdapter() {

      // key pressed in textfield lengthPassword
      @Override
      public void keyPressed(KeyEvent e) {
        // declarations:
        Boolean possibilityOne = false;
        Boolean possibilityTwo = false;

        try {
          textField_name.setText(myGen.generateString(chckbxLetters.isSelected(),
              chckbxCapitalLetters.isSelected(), chckbxNumbers.isSelected(), false,
              Integer.parseInt(textField_lengthName.getText())));
          possibilityOne = true;
        } catch (java.lang.NumberFormatException ex) {
          System.out.println("Error: The text entered in lenght of name is invalid.");
          System.out.println(ex.getMessage());
          possibilityOne = false;

          textField_name.setText("Invalid input.");
        }

        try {
          textField_password.setText(myGen.generateString(chckbxLetters.isSelected(),
              chckbxCapitalLetters.isSelected(), chckbxNumbers.isSelected(),
              chckbxSymbols.isSelected(),
              Integer.parseInt(textField_lengthPassword.getText())));
          possibilityTwo = true;
        } catch (java.lang.NumberFormatException ex) {
          System.out.println("Error: The text entered in lenght of password is invalid.");
          System.out.println(ex.getMessage());
          possibilityTwo = false;

          textField_password.setText("Invalid input.");
        }
        double calculatedPossibility = calculatePossibilities(possibilityOne, possibilityTwo,
            chckbxLetters.isSelected(), chckbxCapitalLetters.isSelected(),
            chckbxSymbols.isSelected(), chckbxNumbers.isSelected());

        // test if calculatedPossibility is larger than max of double
        if (calculatedPossibility <= 1.567727E308) {
          // if the string contains no "E" it is not in exponential spelling
          if (!String.valueOf(calculatedPossibility).contains("E")) {
            textField_possibilities.setText(String.valueOf((int) calculatedPossibility));
          }

          else {
            /*
             * Not working yet :-)
             */

            // Debug:
            textField_possibilities.setText(String.valueOf(calculatedPossibility));
          }
        }

        // calculatedPossibility is larger than max of double
        else {
          textField_possibilities.setText("Larger than: 1.56 E308");
        }
      }
    });
    textField_lengthPassword.setText("30");
    textField_lengthPassword.setBounds(129, 34, 66, 26);
    frmPasswordgeneratorV.getContentPane().add(textField_lengthPassword);
    textField_lengthPassword.setColumns(10);

    textField_name = new JTextField();
    textField_name.setBounds(129, 85, 365, 26);
    frmPasswordgeneratorV.getContentPane().add(textField_name);
    textField_name.setColumns(10);

    JLabel lblName = new JLabel("Name");
    lblName.setBounds(6, 90, 61, 16);
    frmPasswordgeneratorV.getContentPane().add(lblName);

    JLabel lblPasswort = new JLabel("Password");
    lblPasswort.setBounds(6, 118, 61, 16);
    frmPasswordgeneratorV.getContentPane().add(lblPasswort);

    textField_password = new JTextField();
    textField_password.setBounds(129, 113, 365, 26);
    frmPasswordgeneratorV.getContentPane().add(textField_password);
    textField_password.setColumns(10);

    btnGenerate.addActionListener(new ActionListener() {

      // button generated is pressed
      public void actionPerformed(ActionEvent e) {
        // declarations:
        Boolean possibilityOne = false;
        Boolean possibilityTwo = false;

        try {
          textField_name.setText(myGen.generateString(chckbxLetters.isSelected(),
              chckbxCapitalLetters.isSelected(), chckbxNumbers.isSelected(), false,
              Integer.parseInt(textField_lengthName.getText())));
          possibilityOne = true;
        } catch (java.lang.NumberFormatException ex) {
          System.out.println("Error: The text entered in lenght of name is invalid.");
          System.out.println(ex.getMessage());
          possibilityOne = false;

          textField_name.setText("Input invalid.");
        }

        try {
          textField_password.setText(myGen.generateString(chckbxLetters.isSelected(),
              chckbxCapitalLetters.isSelected(), chckbxNumbers.isSelected(),
              chckbxSymbols.isSelected(),
              Integer.parseInt(textField_lengthPassword.getText())));
          possibilityTwo = true;
        } catch (java.lang.NumberFormatException ex) {
          System.out.println("Error: The text entered in lenght of password is invalid.");
          System.out.println(ex.getMessage());
          possibilityTwo = false;

          textField_password.setText("Input invalid.");
        }

        double calculatedPossibility = calculatePossibilities(possibilityOne, possibilityTwo,
            chckbxLetters.isSelected(), chckbxCapitalLetters.isSelected(),
            chckbxSymbols.isSelected(), chckbxNumbers.isSelected());

        // test if calculatedPossibility is larger than max of double
        if (calculatedPossibility <= 1.567727E308) {
          // if the string contains no "E" it is not in exponential spelling
          if (!String.valueOf(calculatedPossibility).contains("E")) {
            textField_possibilities.setText(String.valueOf((int) calculatedPossibility));
          }

          else {
            /*
             * Not working yet :-)
             */

            // Debug:
            textField_possibilities.setText(String.valueOf(calculatedPossibility));
          }
        }

        // calculatedPossibility is larger than max of double
        else {
          textField_possibilities.setText("Larger than: 1.56 E308");
        }
      }
    });
  }
}
