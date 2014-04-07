package org.rbklang.repl;

public class ReplCommand extends Command {
  public ReplCommand(String userInput) {
    super(userInput);
  }

  @Override
  public Object execute() {

    String result = "";
    if (userInput.equals("help")) {
      result = "RBK-Lang v0.1 Repl" + "\n" +
        "help : to show this help" + "\n" +
        "version : to print version" + "\n" +
        "exit : to exit the Repl" + "\n" +
        "Enter any valid java command to exeucte it in the Repl";
    }
    if (userInput.equals("exit")) {
      System.exit(0);
    }
    if (userInput.equals("version")) {
      result = "RBK-Lang v0.1 Repl";
    }
    return result;
  }
}

