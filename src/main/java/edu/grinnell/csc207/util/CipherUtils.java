/**
 * CipherUtils.java
 *
 * Author: Natalie Nardone
 * Date: September 12, 2024
 * Course: CSC-207-01
 *
 */

package edu.grinnell.csc207.util;

/**
 * A class with utility methods relating to encrypting and decrypting with ciphers.
 *
 */
public class CipherUtils {

  /**
   * The number of letters in the alphabet.
   */
  private static final int ALPHABET_LENGTH = 26;

  /**
   * Converts a letter to a corresponding integer.
   *
   * @param letter
   *    The letter to convert.
   *
   * @return int
   *    The integer value of the letter.
   */
  private static int letter2int(char letter) {
    int base = (int) 'a';
    return (int) (letter) - base;
  } // letter2int(char)


  /**
   * Converts an integer to a corresponding letter.
   *
   * @param i
   *    The integer to convert.
   *
   * @return char
   *    The character value of the integer.
   */
  private static char int2letter(int i) {
    int base = (int) 'a';
    return (char) (i + base);
  } // int2letter(int)

  /**
   * Encrypts a string with a letter using the Caesar cipher.
   *
   * @param str
   *    The string to encrypt.
   * @param letter
   *    The key to encrypt with.
   *
   * @return String
   *    The encrypted String.
   */
  public static String caesarEncrypt(String str, char letter) {
    char[] strArr = str.toCharArray();
    int strLen = str.length();

    for (int k = 0; k < strLen; k++) {
      char ch = strArr[k];
      strArr[k] = CipherUtils.int2letter(addChars(ch, letter));
    } // for
    return new String(strArr);
  } // caesarEncrypt(String, char)

  /**
   * Adds two characters and returns the corresponding integer value.
   *
   * @param ch
   *    One of the characters to add.
   * @param key
   *    One of the characters to add.
   *
   * @return int
   *    The sum of the two characters.
   */
  public static int addChars(char ch, char key) {
    int sum = CipherUtils.letter2int(ch) + CipherUtils.letter2int(key);
    if (sum > (ALPHABET_LENGTH - 1)) {
      return sum - ALPHABET_LENGTH;
    } else {
      return sum;
    } // else
  } // addChars(char, char)

  /**
   * Decrypts a string with a letter using the Caesar cipher.
   *
   * @param str
   *    The string to encrypt.
   * @param letter
   *    The key to encrypt with.
   *
   * @return String
   *    The decrypted String.
   */
  public static String caesarDecrypt(String str, char letter) {
    char[] strArr = str.toCharArray();
    int strLen = str.length();

    for (int k = 0; k < strLen; k++) {
      char ch = strArr[k];
      strArr[k] = CipherUtils.int2letter(subtractChars(ch, letter));
    } // for
    return new String(strArr);
  } // caesarDecrypt(String, char)

  /**
   * Subtracts two characters and returns the corresponding integer value.
   *
   * @param ch
   *    One of the characters to subtract.
   * @param key
   *    One of the characters to subtract.
   *
   * @return int
   *    The value of the subtracted characters.
   */
  public static int subtractChars(char ch, char key) {
    int sum = CipherUtils.letter2int(ch) - CipherUtils.letter2int(key);
    if (sum < 0) {
      return sum + ALPHABET_LENGTH;
    } else {
      return sum;
    } // else
  } // subtractChars(char, char)

  /**
   * Encrypts a string with a letter using the Vigenere cipher.
   *
   * @param str
   *    The string to encrypt.
   * @param key
   *    The key to encrypt with.
   *
   * @return String
   *    The encrypted string.
   */
  public static String vigenereEncrypt(String str, String key) {

    char[] strArr = str.toCharArray();
    int strLen = str.length();


    char[] keyArr = key.toCharArray();
    int keyLen = key.length();

    for (int k = 0; k < strLen; k++) {
      char ch = strArr[k];
      char add = keyArr[k % keyLen];
      strArr[k] = CipherUtils.int2letter(addChars(ch, add));
    } // for
    return new String(strArr);
  } // vigenereEncrypt(String, String)

  /**
   * Decrypts a string with a letter using the Vigenere cipher.
   *
   * @param str
   *    The string to encrypt.
   * @param key
   *    The key to encrypt with.
   *
   * @return String
   *    The decrypted string.
   */
  public static String vigenereDecrypt(String str, String key) {
    char[] strArr = str.toCharArray();
    int strLen = str.length();

    char[] keyArr = key.toCharArray();
    int keyLen = key.length();

    for (int k = 0; k < strLen; k++) {
      char ch = strArr[k];
      char add = keyArr[k % keyLen];
      strArr[k] = CipherUtils.int2letter(subtractChars(ch, add));
    } // for
    return new String(strArr);
  } // vigenereDecrypt(String, String)

  /**
   * Checks if the given string is a valid option for encoding/decoding.
   *
   * @param str
   *    The string to check.
   *
   * @return boolean
   *    Returns true if the string is a valid word for encryption and false otherwise.
   */
  public static boolean checkValid(String str) {
    char[] strArr = str.toCharArray();
    int strLen = str.length();
    char lowerBound = 'a';
    char upperBound = 'z';
    for (int i = 0; i < strLen; i++) {
      if (lowerBound > strArr[i] || strArr[i] > upperBound) {
        return false;
      } // if
    } // for
    return true;
  } // checkValid(String)
} // class CipherUtils
