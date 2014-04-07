package org.rbklang.repl;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;
import java.io.Reader;

public class Repl {
  private static ReplHistory history;
  private static BufferedReader br;
  private static Console consoleReader;

  static {
    br = new BufferedReader(new InputStreamReader(System.in));
    consoleReader = System.console();
    history = new ReplHistory();
  }

  public String read() {
    String input = "";
    System.out.print("rbk-lang>");
    try {
      input = consoleReader.readLine();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return input;
  }

  public Object execute(String userInputCommand) {
    return Command.getCommand(userInputCommand).execute();
  }

  public static void main(String args[]) {
    Repl repl = new Repl();
    while (true) {
//      TODO : handle ctrl+C gracefully
      String userInputCommand = repl.read();
      history.add(userInputCommand);
      Object result = repl.execute(userInputCommand);
      System.out.println(result);
    }
  }
}
