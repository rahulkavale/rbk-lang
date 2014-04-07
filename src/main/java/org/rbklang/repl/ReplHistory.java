package org.rbklang.repl;

import java.util.ArrayList;
import java.util.List;

public class ReplHistory {
  public List<String> prevCommands = new ArrayList<>();

  public void add(String userInputCommand) {
    prevCommands.add(userInputCommand);
  }
}
