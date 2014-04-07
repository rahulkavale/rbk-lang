package org.rbklang.grammer;

import org.rbklang.Exception.GrammarInApplicableException;
import org.rbklang.parser.AST;

import java.util.List;

public interface Grammar {
  AST generateAST(List<String> tokenize) throws GrammarInApplicableException;
  public boolean isTerminalSymbol(CharSequence character);
  public boolean isNonTerminalSymbol(CharSequence character);
  public void addProductionRules();
}
