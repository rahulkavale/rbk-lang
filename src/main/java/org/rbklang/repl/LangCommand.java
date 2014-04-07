package org.rbklang.repl;

import org.rbklang.Exception.GrammarInApplicableException;
import org.rbklang.grammer.Grammar;
import org.rbklang.parser.AST;
import org.rbklang.parser.Parser;

public class LangCommand extends Command {
  private Parser parser;

  public LangCommand(String userInput, Grammar grammar) {
    super(userInput);
    this.parser = new Parser(grammar);
  }

  @Override
  public Object execute() throws GrammarInApplicableException {
    AST ast = parser.parse(userInput);
    return "Abstrct Syntax tree is : \n " + ast.toString();
  }
}
