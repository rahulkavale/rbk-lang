package org.rbklang.repl;

import org.rbklang.Exception.GrammarInApplicableException;
import org.rbklang.grammer.RbkLangGrammar;

import java.io.Console;

import static org.rbklang.repl.Command.getCommand;

public class Repl {
  private static ReplHistory history;
  private static Console consoleReader;

  static {
    consoleReader = System.console();
    history = new ReplHistory();
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

  public String read() {
    System.out.print("rbk-lang>");
    return consoleReader.readLine();
  }

  public Object execute(String input) {
    try {
      return getCommand(input, new RbkLangGrammar()).execute();
    } catch (GrammarInApplicableException e) {
      return e.toString();
    }
  }
}
