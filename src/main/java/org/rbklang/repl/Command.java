package org.rbklang.repl;

import org.rbklang.Exception.GrammarInApplicableException;
import org.rbklang.Exception.MethodMissingException;
import org.rbklang.grammer.Grammar;

public abstract class Command {
  protected String userInput;

  public Command(String userInput) {
    this.userInput = userInput;
  }

  public abstract String execute() throws GrammarInApplicableException, MethodMissingException;

  public static boolean isReplCommand(String userInputCommand) {
    return userInputCommand.equals("help") || userInputCommand.equals("version") || userInputCommand.equals("exit");
  }

  public static Command getCommand(String userInput, Grammar grammar) {
    if (isReplCommand(userInput)) {
      return new ReplCommand(userInput);
    }
    return new LangCommand(userInput, grammar);
  }
}
