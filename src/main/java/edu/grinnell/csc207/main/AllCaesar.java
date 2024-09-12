package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

public class AllCaesar {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    
    // Check number of arguments
    if (len(args) != 2){
      System.err.println("Error: Incorrect number of parameters.")
    }
    // Initialize variables for command-line arguments
    else{
      String action = args[0];
      String str = args[1];
    }

    // Check validity of variables
    if !(AllCaesar.checkAction(action)){
      System.err.println("Error: Invalid option: \"" + action + "\". Valid options are \"encode\" or \"decode\".");
    }
    else if !(AllCaesar.checkValid(str)){
      System.err.println("Error: String contains characters other than lowercase letters.");
    }
    else if (action == "encode"){
      AllCaesar.encode(pen, str);
    }
    else {
      AllCaesar.decode(pen, str);
    }
    pen.close();
  }

  public static boolean checkAction(String action){
    return true;
  }

  public static boolean checkValid(String str){
    return true;
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