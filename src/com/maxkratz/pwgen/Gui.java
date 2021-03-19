package com.maxkratz.pwgen;

import com.maxkratz.pwgen.utils.HelperUtils;
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
 * GUI for users.
 *
 * @author maxkratz
 * @version 0.8.0
 *
 */
public class Gui {

  /**
   * JFrame window (GUI).
   */
  final JFrame frame;

  /**
   * Random string generator.
   */
  private final Generator strGen = new Generator();

  /**
   * Text field for the length of the random name.
   */
  private final JTextField tfLengthName;

  /**
   * Text field for the length of the random password.
   */
  private final JTextField tfLengthPassword;

  /**
   * Text field for the name (output).
   */
  private final JTextField tfName;

  /**
   * Text field for the password (output).
   */
  private final JTextField tfPassword;

  /**
   * Text field for the number of possible combinations (output).
   */
  private final JTextField tfPossibilities;

  /**
   * Create the application.
   */
  public Gui() {
    // window setup
    frame = new JFrame();
    frame.setResizable(false);
    frame.setTitle("Password-Generator v0.8.0");
    frame.setBounds(100, 100, 540, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);

    // check box for letters
    final JCheckBox chckbxLetters = new JCheckBox("Letters");
    chckbxLetters.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(final KeyEvent e) {}
    });
    chckbxLetters.setSelected(true);
    chckbxLetters.setBounds(207, 7, 147, 23);
    frame.getContentPane().add(chckbxLetters);

    // check box for numbers
    final JCheckBox chckbxNumbers = new JCheckBox("Numbers");
    chckbxNumbers.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(final KeyEvent e) {}
    });
    chckbxNumbers.setSelected(true);
    chckbxNumbers.setBounds(366, 7, 128, 23);
    frame.getContentPane().add(chckbxNumbers);

    // check box for symbols
    final JCheckBox chckbxSymbols = new JCheckBox("Symbols");
    chckbxSymbols.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(final KeyEvent e) {}
    });
    chckbxSymbols.setSelected(true);
    chckbxSymbols.setBounds(366, 35, 128, 23);
    frame.getContentPane().add(chckbxSymbols);

    final JSeparator separator = new JSeparator();
    separator.setBounds(6, 67, 508, 12);
    frame.getContentPane().add(separator);

    final JLabel lblPossibilities = new JLabel("Possibilities");
    lblPossibilities.setBounds(6, 167, 97, 16);
    frame.getContentPane().add(lblPossibilities);

    tfPossibilities = new JTextField();
    tfPossibilities.setBounds(129, 162, 365, 29);
    frame.getContentPane().add(tfPossibilities);
    tfPossibilities.setColumns(10);

    // check box for capital letters
    final JCheckBox chckbxCapitalLetters = new JCheckBox("Capital letters");
    chckbxCapitalLetters.setSelected(true);
    chckbxCapitalLetters.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(final KeyEvent e) {}
    });
    chckbxCapitalLetters.setBounds(207, 35, 158, 23);
    frame.getContentPane().add(chckbxCapitalLetters);

    // button generate
    final JButton btnGenerate = new JButton("Generate");
    btnGenerate.setBounds(207, 230, 117, 29);
    frame.getContentPane().add(btnGenerate);

    // text field length name
    tfLengthName = new JTextField();
    tfLengthName.setText("8");
    tfLengthName.setBounds(129, 6, 66, 26);
    frame.getContentPane().add(tfLengthName);
    tfLengthName.setColumns(10);

    final JLabel lblLengthName = new JLabel("Length name");
    lblLengthName.setBounds(6, 11, 95, 16);
    frame.getContentPane().add(lblLengthName);

    final JLabel lblLengthPassword = new JLabel("Length pw");
    lblLengthPassword.setBounds(6, 39, 111, 16);
    frame.getContentPane().add(lblLengthPassword);

    // text field length password
    tfLengthPassword = new JTextField();
    tfLengthPassword.setText("30");
    tfLengthPassword.setBounds(129, 34, 66, 26);
    frame.getContentPane().add(tfLengthPassword);
    tfLengthPassword.setColumns(10);

    // text field name
    tfName = new JTextField();
    tfName.setBounds(129, 85, 365, 26);
    frame.getContentPane().add(tfName);
    tfName.setColumns(10);

    final JLabel lblName = new JLabel("Name");
    lblName.setBounds(6, 90, 61, 16);
    frame.getContentPane().add(lblName);

    final JLabel lblPasswort = new JLabel("Pw");
    lblPasswort.setBounds(6, 118, 61, 16);
    frame.getContentPane().add(lblPasswort);

    // text field password
    tfPassword = new JTextField();
    tfPassword.setBounds(129, 113, 365, 26);
    frame.getContentPane().add(tfPassword);
    tfPassword.setColumns(10);

    // add action to generate button
    btnGenerate.addActionListener(new ActionListener() {

      // button generate is pressed
      @Override
      public void actionPerformed(final ActionEvent e) {
        try {
          tfName.setText(strGen.generateString(chckbxLetters.isSelected(),
              chckbxCapitalLetters.isSelected(), chckbxNumbers.isSelected(),
              chckbxSymbols.isSelected(), Integer.parseInt(tfLengthName.getText())));
        } catch (final NumberFormatException ex) {
          System.out.println("Error: The text entered in length of name is invalid.");
          System.out.println(ex.getMessage());

          tfName.setText("Input invalid.");
        }

        try {
          tfPassword.setText(strGen.generateString(chckbxLetters.isSelected(),
              chckbxCapitalLetters.isSelected(), chckbxNumbers.isSelected(),
              chckbxSymbols.isSelected(), Integer.parseInt(tfLengthPassword.getText())));
        } catch (final NumberFormatException ex) {
          System.out.println("Error: The text entered in length of password is invalid.");
          System.out.println(ex.getMessage());

          tfPassword.setText("Input invalid.");
        }

        final double calculatedPossibility =
            HelperUtils.calculatePossibilities(chckbxLetters.isSelected(),
                chckbxCapitalLetters.isSelected(), chckbxSymbols.isSelected(),
                chckbxNumbers.isSelected(), Integer.parseInt(tfLengthPassword.getText()));

        // test if calculatedPossibility is larger than max of double
        if (calculatedPossibility <= 1.567727E308) {
          // if the string contains no "E" it is not in exponential spelling
          if (!String.valueOf(calculatedPossibility).contains("E")) {
            tfPossibilities.setText(String.valueOf((int) calculatedPossibility));
          } else {
            // TODO: Implement this.
            // Debug:
            tfPossibilities.setText(String.valueOf(calculatedPossibility));
          }
        } else {
          // calculatedPossibility is larger than max of double
          tfPossibilities.setText("Larger than: 1.56 E308");
        }
      }
    });
  }

}
