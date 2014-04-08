package org.rbklang.repl;

import org.rbklang.Exception.GrammarInApplicableException;
import org.rbklang.Exception.MethodMissingException;
import org.rbklang.core.Operation;
import org.rbklang.grammer.Grammar;
import org.rbklang.parser.Parser;

public class LangCommand extends Command {
  private Parser parser;

  public LangCommand(String userInput, Grammar grammar) {
    super(userInput);
    this.parser = new Parser(grammar);
  }

  @Override
  public String execute() throws GrammarInApplicableException, MethodMissingException {
    Operation operation = parser.parse(userInput);
    return operation.execute();
  }
}
