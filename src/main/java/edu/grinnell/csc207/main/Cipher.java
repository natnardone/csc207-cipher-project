package edu.grinnell.csc207.main;

import java.io.PrintWriter;

import edu.grinnell.csc207.util.CipherUtils;

public class Cipher {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);

    if (args.length != 4){
      System.err.println("Error: Expected 4 parameters, received " + args.length);
      return;
    }

    String action = null;
    String cipher = null;
    String str = null;
    String key = null;

    for (int k = 0; k < args.length; k++) {
      if (action == null) {
        if ((args[k].equals("-encode")) ||  (args[k].equals("-decode"))) {
          action = args[k];
          continue;
        }
      }
      if (cipher == null) {
        if ((args[k].equals("-caesar")) ||  (args[k].equals("-vigenere"))) {
          cipher = args[k];
          continue;
        }
      }
      if (str == null) {
        str = args[k];
        continue;
      }
      else { 
        key = args[k];
      }
    }

    if (action == null) {
      System.err.println("Error: No valid action specified. Legal values are '-encode' and '-decode'");
      return;
    }
    if (cipher == null) {
      System.err.println("Error: No valid cipher specified. Legal values are '-caesar' and '-vigenere'");
      return;
    }
    if (CipherUtils.checkValid(str) == false) {
      System.err.println("Error: String must be only lowercase letters.");
      return;
    }
    if (key.length() == 0) {
      System.err.println("Error: Empty keys are not permitted.");
      return;
    }
    if ((cipher.equals("-caesar")) && key.length() > 1) {
      System.err.println("Error: Caesar ciphers require a one-character key.");
      return;
    }
    // error handling complete

    if (action.equals("-encode") && cipher.equals("-caesar")) {
      pen.printf("%s\n", CipherUtils.caesarEncrypt(str, key.charAt(0)));
    }
    if (action.equals("-decode") && cipher.equals("-caesar")) {
      pen.printf("%s\n", CipherUtils.caesarDecrypt(str, key.charAt(0)));
    }
    if (action.equals("-encode") && cipher.equals("-vigenere")) {
      pen.printf("%s\n", CipherUtils.vigenereEncrypt(str, key));
    }
    if (action.equals("-decode") && cipher.equals("-vigenere")) {
      pen.printf("%s\n", CipherUtils.vigenereDecrypt(str, key));
    }

    /*
    pen.println(action);
    pen.println(cipher);
    pen.println(str);
    pen.println(key);
    */



    //for (int i = 0; i < args.length; i++) {
    //  pen.printf("args[%d] = \"%s\"\n", i, args[i]);
    //}
    pen.close();
    //System.err.println("Error: Invalid parameters");
  }
}