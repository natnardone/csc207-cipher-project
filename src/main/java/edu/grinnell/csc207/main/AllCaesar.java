package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

public class AllCaesar {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);

    String action;
    String str;
    
    // Check number of arguments
    if (args.length != 2){
      System.err.println("Error: Incorrect number of parameters.");
    }
    // Initialize variables for command-line arguments
    else{
      action = args[0];
      str = args[1];

      if (AllCaesar.checkArgs(action, str) == true) {
        if (action.equals("encode")){
          AllCaesar.encode(pen, str);
        }
        else {
          AllCaesar.decode(pen, str);
        }
      }
    }

    pen.close();
  }

  public static boolean checkArgs(String action, String str) {
    if (AllCaesar.checkAction(action) == false){
      System.err.println("Error: Invalid option: \"" + action + "\". Valid options are \"encode\" or \"decode\".");
      return false;
    }
    if (CipherUtils.checkValid(str) == false){
      System.err.println("Error: String contains characters other than lowercase letters.");
      return false;
    }
    return true;
  }

  public static boolean checkAction(String action){
    if (action.equals("encode") || action.equals("decode")) {
      return true;
    }
    return false;
  }

  public static void encode(PrintWriter pen, String str){
    for (char ch = 'a'; ch <= 'z'; ch++) {
      pen.printf("n = %c: %s\n", ch, CipherUtils.caesarEncrypt(str, ch));
    }
  }

  public static void decode(PrintWriter pen, String str){
    for (char ch = 'a'; ch <= 'z'; ch++) {
      pen.printf("n = %c: %s\n", ch, CipherUtils.caesarDecrypt(str, ch));
    }
  }

}