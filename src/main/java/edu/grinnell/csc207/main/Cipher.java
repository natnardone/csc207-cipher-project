/**
 * Cipher.java
 *
 * Author: Natalie Nardone
 * Date: September 12, 2024
 * Course: CSC-207-01
 *
 */
package edu.grinnell.csc207.main;

import java.io.PrintWriter;

import edu.grinnell.csc207.util.CipherUtils;

  /**
   * A class to print out an encoding or decoding of a given word with a given key and cipher.
   *
   */
public class Cipher {

  /**
   * The value of the expected number of parameters.
   */
  private static final int EXPECTED_NUM_PARAMS = 4;

  /**
   * Takes four command-line arguments and prints the corresponding encoding or decoding.
   *
   * @param args
   *    The command line arguments.
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);

    if (args.length != EXPECTED_NUM_PARAMS) {
      System.err.println("Error: Expected 4 parameters, received " + args.length);
      return;
    } // if

    String action = null;
    String cipher = null;
    String str = null;
    String key = null;

    for (int k = 0; k < args.length; k++) {
      if (action == null) {
        if ((args[k].equals("-encode")) || (args[k].equals("-decode"))) {
          action = args[k];
          continue;
        } // if
      } // if
      if (cipher == null) {
        if ((args[k].equals("-caesar")) || (args[k].equals("-vigenere"))) {
          cipher = args[k];
          continue;
        } // if
      } // if
      if (str == null) {
        str = args[k];
        continue;
      } else {
        key = args[k];
      } // else
    } // for

    if (action == null) {
      System.err.println("Error: No valid action specified. "
          + "Legal values are '-encode' and '-decode'");
      return;
    } // if
    if (cipher == null) {
      System.err.println("Error: No valid cipher specified. "
          + "Legal values are '-caesar' and '-vigenere'");
      return;
    } // if
    if (!CipherUtils.checkValid(str)) {
      System.err.println("Error: String must be only lowercase letters.");
      return;
    } // if
    if (!CipherUtils.checkValid(key)) {
      System.err.println("Error: Key must be only lowercase letters.");
      return;
    } // if
    if (key.length() == 0) {
      System.err.println("Error: Empty keys are not permitted.");
      return;
    } // if
    if ((cipher.equals("-caesar")) && key.length() > 1) {
      System.err.println("Error: Caesar ciphers require a one-character key.");
      return;
    } // if

    if (action.equals("-encode") && cipher.equals("-caesar")) {
      pen.printf("%s\n", CipherUtils.caesarEncrypt(str, key.charAt(0)));
    } // if
    if (action.equals("-decode") && cipher.equals("-caesar")) {
      pen.printf("%s\n", CipherUtils.caesarDecrypt(str, key.charAt(0)));
    } // if
    if (action.equals("-encode") && cipher.equals("-vigenere")) {
      pen.printf("%s\n", CipherUtils.vigenereEncrypt(str, key));
    } // if
    if (action.equals("-decode") && cipher.equals("-vigenere")) {
      pen.printf("%s\n", CipherUtils.vigenereDecrypt(str, key));
    } // if

    pen.close();

  } // main(String[])
} // class Cipher
