package org.rbklang.repl;

public class LangCommand extends Command {
  public LangCommand(String userInput) {
    super(userInput);
  }

  @Override
  public Object execute() {
    return "Executing command : " + userInput;
  }
}
