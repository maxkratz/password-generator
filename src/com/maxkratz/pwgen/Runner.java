package com.maxkratz.pwgen;

import java.awt.EventQueue;

/**
 * Runner that starts the application.
 *
 * @author maxkratz
 * @version 0.1.0
 *
 */
public class Runner {

  /**
   * Launch the application.
   *
   * @param args Main arguments (that will be ignored).
   */
  public static void main(final String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
          final Gui window = new Gui();
          window.frame.setVisible(true);
        } catch (final Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

}
