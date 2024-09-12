package edu.grinnell.csc207.util;

public class CipherUtils {

  private static int letter2int(char letter) {
    int base = (int) 'a';
    return (int) (letter) - base;
  } // letter2int(char)

  private static char int2letter(int i) {
    int base = (int) 'a';
    return (char) (i + base);
  } // int2letter(int)

  public static String caesarEncrypt(String str, char letter) {
    char[] strArr = str.toCharArray();
    int strLen = str.length();

    for (int k = 0; k < strLen; k++) {
      char ch = strArr[k];
      strArr[k] = CipherUtils.int2letter(addChars(ch, letter));
    } // for
    return new String(strArr);
  } // caesarEncrypt(String, char)

  public static int addChars(char ch, char key) {
    int sum = CipherUtils.letter2int(ch) + CipherUtils.letter2int(key);
    if (sum > 25) {
      return sum - 26;
    } else {
      return sum;
    } // else
  } // addChars(char, char)

  public static String caesarDecrypt(String str, char letter) {
    char[] strArr = str.toCharArray();
    int strLen = str.length();

    for (int k = 0; k < strLen; k++) {
      char ch = strArr[k];
      strArr[k] = CipherUtils.int2letter(subtractChars(ch, letter));
    } // for
    return new String(strArr);
  } // caesarDecrypt(String, char)

  public static int subtractChars(char ch, char key) {
    int sum = CipherUtils.letter2int(ch) - CipherUtils.letter2int(key);
    if (sum < 0) {
      return sum + 26;
    } else {
      return sum;
    } // else
  } // subtractChars(char, char)

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
