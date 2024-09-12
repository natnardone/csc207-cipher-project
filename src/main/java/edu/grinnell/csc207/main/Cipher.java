package edu.grinnell.csc207.main;

import java.io.PrintWriter;

public class Cipher {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    // check each command line argument
    // if starts with dash, check encode/decode/caesar/viginere
    // set variables as we find them
    // if anything with a dash is not a correct word, throw error
    // 
    // call encode/decode caesar/vigenere on the string and key and print
    for (int i = 0; i < args.length; i++) {
      pen.printf("args[%d] = \"%s\"\n", i, args[i]);
    }
    pen.close();
    System.err.println("Error: Invalid parameters");
  }
}
