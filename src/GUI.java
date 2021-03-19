import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

/**
 * 
 * @author maxkratz
 * @version 0.8
 *
 */
public class GUI {

  /**
   * JFrame window (GUI).
   */
  private final JFrame window;

  /**
   * Random string generator.
   */
  private final Generator strGen = new Generator();

  /**
   * Text field for the length of the random name.
   */
  private final JTextField textField_lengthName;

  /**
   * Text field for the length of the random password.
   */
  private final JTextField textField_lengthPassword;

  /**
   * Text field for the name (output).
   */
  private final JTextField textField_name;

  /**
   * Text field for the password (output).
   */
  private final JTextField textField_password;

  /**
   * Text field for the number of possible combinations (output).
   */
  private final JTextField textField_possibilities;

  /**
   * Launch the application.
   * 
   * @param args Main arguments that will be ignored.
   */
  public static void main(final String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
          final GUI window = new GUI();
          window.window.setVisible(true);
        } catch (final Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public GUI() {
    // window setup
    window = new JFrame();
    window.setResizable(false);
    window.setTitle("Password-Generator v0.8.0");
    window.setBounds(100, 100, 540, 300);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.getContentPane().setLayout(null);

    // check box for letters
    final JCheckBox chckbxLetters = new JCheckBox("Letters");
    chckbxLetters.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(final KeyEvent e) {}
    });
    chckbxLetters.setSelected(true);
    chckbxLetters.setBounds(207, 7, 147, 23);
    window.getContentPane().add(chckbxLetters);

    // check box for numbers
    final JCheckBox chckbxNumbers = new JCheckBox("Numbers");
    chckbxNumbers.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(final KeyEvent e) {}
    });
    chckbxNumbers.setSelected(true);
    chckbxNumbers.setBounds(366, 7, 128, 23);
    window.getContentPane().add(chckbxNumbers);

    // check box for symbols
    final JCheckBox chckbxSymbols = new JCheckBox("Symbols");
    chckbxSymbols.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(final KeyEvent e) {}
    });
    chckbxSymbols.setSelected(true);
    chckbxSymbols.setBounds(366, 35, 128, 23);
    window.getContentPane().add(chckbxSymbols);

    final JSeparator separator = new JSeparator();
    separator.setBounds(6, 67, 508, 12);
    window.getContentPane().add(separator);

    final JLabel lblPossibilities = new JLabel("Possibilities");
    lblPossibilities.setBounds(6, 167, 97, 16);
    window.getContentPane().add(lblPossibilities);

    textField_possibilities = new JTextField();
    textField_possibilities.setBounds(129, 162, 365, 29);
    window.getContentPane().add(textField_possibilities);
    textField_possibilities.setColumns(10);

    // check box for capital letters
    final JCheckBox chckbxCapitalLetters = new JCheckBox("Capital letters");
    chckbxCapitalLetters.setSelected(true);
    chckbxCapitalLetters.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(final KeyEvent e) {}
    });
    chckbxCapitalLetters.setBounds(207, 35, 158, 23);
    window.getContentPane().add(chckbxCapitalLetters);

    // button generate
    final JButton btnGenerate = new JButton("Generate");
    btnGenerate.setBounds(207, 230, 117, 29);
    window.getContentPane().add(btnGenerate);

    // text field length name
    textField_lengthName = new JTextField();
    textField_lengthName.setText("8");
    textField_lengthName.setBounds(129, 6, 66, 26);
    window.getContentPane().add(textField_lengthName);
    textField_lengthName.setColumns(10);

    final JLabel lblLengthName = new JLabel("Length name");
    lblLengthName.setBounds(6, 11, 95, 16);
    window.getContentPane().add(lblLengthName);

    final JLabel lblLengthPassword = new JLabel("Length pw");
    lblLengthPassword.setBounds(6, 39, 111, 16);
    window.getContentPane().add(lblLengthPassword);

    // text field length password
    textField_lengthPassword = new JTextField();
    textField_lengthPassword.setText("30");
    textField_lengthPassword.setBounds(129, 34, 66, 26);
    window.getContentPane().add(textField_lengthPassword);
    textField_lengthPassword.setColumns(10);

    // text field name
    textField_name = new JTextField();
    textField_name.setBounds(129, 85, 365, 26);
    window.getContentPane().add(textField_name);
    textField_name.setColumns(10);

    final JLabel lblName = new JLabel("Name");
    lblName.setBounds(6, 90, 61, 16);
    window.getContentPane().add(lblName);

    final JLabel lblPasswort = new JLabel("Pw");
    lblPasswort.setBounds(6, 118, 61, 16);
    window.getContentPane().add(lblPasswort);

    // text field password
    textField_password = new JTextField();
    textField_password.setBounds(129, 113, 365, 26);
    window.getContentPane().add(textField_password);
    textField_password.setColumns(10);

    // add action to generate button
    btnGenerate.addActionListener(new ActionListener() {

      // button generate is pressed
      @Override
      public void actionPerformed(final ActionEvent e) {
        try {
          textField_name.setText(strGen.generateString(chckbxLetters.isSelected(),
              chckbxCapitalLetters.isSelected(), chckbxNumbers.isSelected(),
              chckbxSymbols.isSelected(), Integer.parseInt(textField_lengthName.getText())));
        } catch (final java.lang.NumberFormatException ex) {
          System.out.println("Error: The text entered in length of name is invalid.");
          System.out.println(ex.getMessage());

          textField_name.setText("Input invalid.");
        }

        try {
          textField_password.setText(strGen.generateString(chckbxLetters.isSelected(),
              chckbxCapitalLetters.isSelected(), chckbxNumbers.isSelected(),
              chckbxSymbols.isSelected(), Integer.parseInt(textField_lengthPassword.getText())));
        } catch (final java.lang.NumberFormatException ex) {
          System.out.println("Error: The text entered in length of password is invalid.");
          System.out.println(ex.getMessage());

          textField_password.setText("Input invalid.");
        }

        final double calculatedPossibility =
            calculatePossibilities(chckbxLetters.isSelected(), chckbxCapitalLetters.isSelected(),
                chckbxSymbols.isSelected(), chckbxNumbers.isSelected());

        // test if calculatedPossibility is larger than max of double
        if (calculatedPossibility <= 1.567727E308) {
          // if the string contains no "E" it is not in exponential spelling
          if (!String.valueOf(calculatedPossibility).contains("E")) {
            textField_possibilities.setText(String.valueOf((int) calculatedPossibility));
          }

          else {
            // TODO: Implement this.
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

  /**
   * Calculates the possibilities for given parameters.
   * 
   * @param chckbxLetters True if letters are selected.
   * @param chckbxCapitalLetters True if capital letters are selected.
   * @param chckbxSymbols True if symbols are selected.
   * @param chckbxNumbers True if numbers are selected.
   * 
   * @return Calculated number of possibilities.
   */
  public double calculatePossibilities(final Boolean chckbxLetters,
      final Boolean chckbxCapitalLetters, final Boolean chckbxSymbols,
      final Boolean chckbxNumbers) {
    // Calculate the number of possibilities specified for the selection:
    final int numberOfSymbolsPassword = Integer.parseInt(textField_lengthPassword.getText());

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
      counter = counter + 28;
    }

    return Math.pow(counter, numberOfSymbolsPassword);
  }

}
