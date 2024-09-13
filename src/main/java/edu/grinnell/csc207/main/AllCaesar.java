/**
 * AllCaesar.java
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
   * A class to print out all possible Caesar cipher encryptions/decryptions of a word.
   *
   */
public class AllCaesar {

  /**
   * Takes two command-line arguments and prints all of the possibilities for encoding
   * or decoding the given string.
   *
   * @param args
   *    The command line arguments.
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);

    String action;
    String str;

    if (args.length != 2) {
      System.err.println("Error: Incorrect number of parameters.");
    } else {
      action = args[0];
      str = args[1];

      if (AllCaesar.checkArgs(action, str)) {
        if (action.equals("encode")) {
          AllCaesar.encode(pen, str);
        } else {
          AllCaesar.decode(pen, str);
        } // else
      } // if
    } // else

    pen.close();
  } // main(String[])

  /**
   * Checks if the given arguments are valid options.
   *
   * @param action
   *    The given action to perform on str.
   * @param str
   *    The given string to perform an action on.
   *
   * @return boolean
   *    Returns true if the arguments are valid and false otherwise.
   */
  public static boolean checkArgs(String action, String str) {
    if (!AllCaesar.checkAction(action)) {
      System.err.println("Error: Invalid option: \"" + action
                          + "\". Valid options are \"encode\" or \"decode\".");
      return false;
    } // if
    if (!CipherUtils.checkValid(str)) {
      System.err.println("Error: String contains characters other than lowercase letters.");
      return false;
    } // if
    return true;
  } // checkArgs(String, String)

  /**
   * Checks if the given action is a valid option.
   *
   * @param action
   *    The given action to perform on the string.
   *
   * @return boolean
   *    Returns true if the action is a valid option and false otherwise.
   */
  public static boolean checkAction(String action) {
    if (action.equals("encode") || action.equals("decode")) {
      return true;
    } // if
    return false;
  } // checkAction(String)

  /**
   * Encodes and prints a given string with every possible key.
   *
   * @param pen
   *    A pen to print all of encoded strings.
   * @param str
   *    The string to encode.
   */
  public static void encode(PrintWriter pen, String str) {
    for (char ch = 'a'; ch <= 'z'; ch++) {
      pen.printf("n = %c: %s\n", ch, CipherUtils.caesarEncrypt(str, ch));
    } // for
  } // encode(PrintWriter, String)

  /**
   * Decodes and prints a given string with every possible key.
   *
   * @param pen
   *    A pen to print all of decoded strings.
   * @param str
   *    The string to decode.
   */
  public static void decode(PrintWriter pen, String str) {
    for (char ch = 'a'; ch <= 'z'; ch++) {
      pen.printf("n = %c: %s\n", ch, CipherUtils.caesarDecrypt(str, ch));
    } // for
  } // decode(PrintWriter, String)

} // class AllCaesar
