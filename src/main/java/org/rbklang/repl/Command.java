package org.rbklang.repl;

public abstract class Command {
  protected String userInput;

  public Command(String userInput) {
    this.userInput = userInput;
  }

  public abstract Object execute();

  public static boolean isReplCommand(String userInputCommand) {
    return userInputCommand.equals("help") || userInputCommand.equals("version") || userInputCommand.equals("exit");
  }

  public static Command getCommand(String userInput) {
    if (isReplCommand(userInput)) {
      return new ReplCommand(userInput);
    }
    return new LangCommand(userInput);
  }
}
