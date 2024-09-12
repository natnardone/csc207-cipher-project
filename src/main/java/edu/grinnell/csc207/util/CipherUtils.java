package edu.grinnell.csc207.util;

public class CipherUtils {

  // works
  private static int letter2int(char letter) {
    int base = (int) 'a';
    return (int) (letter) - base;
  }

  // works
  private static char int2letter(int i) {
    int base = (int) 'a';
    return (char) (i + base);
  }

  // works
  public static String caesarEncrypt(String str, char letter) {
    char[] strArr = str.toCharArray();
    int strLen = str.length();
    
    for (int k = 0; k < strLen; k++) {
      char ch = strArr[k];
      strArr[k] = CipherUtils.int2letter(addChars(ch, letter));
    }
    return new String(strArr);
  }

  // works
  public static int addChars(char ch, char key) {
    int sum = CipherUtils.letter2int(ch) + CipherUtils.letter2int(key);
    if (sum > 25) {
      return sum - 26;
    }
    else {
      return sum;
    }
  }

  // works
  public static String caesarDecrypt(String str, char letter) {
    char[] strArr = str.toCharArray();
    int strLen = str.length();
    
    for (int k = 0; k < strLen; k++) {
      char ch = strArr[k];
      strArr[k] = CipherUtils.int2letter(subtractChars(ch, letter));
    }
    return new String(strArr);
  }

  // works
  public static int subtractChars(char ch, char key) {
    int sum = CipherUtils.letter2int(ch) - CipherUtils.letter2int(key);
    if (sum < 0) {
      return sum + 26;
    }
    else {
      return sum;
    }
  }

  public static String vigenereEncrypt(String str, String key) {
    return str; // STUB
  }

  public static String vigenereDecrypt(String str, String key) {
    return str;
  }
}
