package org.rbklang.grammer;

import org.rbklang.Exception.GrammarInApplicableException;
import org.rbklang.parser.AST;
import org.rbklang.parser.Tree;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;

public class RbkLangGrammar implements Grammar {

  private Set<ProductionRule> productionRules = new HashSet<>();

  private HashSet operators = new HashSet<Character>() {{
    addAll(asList('+', '-', '*', '/', '%', '^'));
  }};

  private HashSet braces = new HashSet<Character>() {{
    addAll(asList('(', ')', '{', '}'));
  }};

  public boolean isDigit(CharSequence character) {
    return character.toString().matches("\\d");
  }

  public boolean isOperator(CharSequence character) {
    return operators.contains(character);
  }

  public boolean isCharacter(CharSequence character) {
    return character.toString().matches("\\w");
  }

  public boolean isBrace(CharSequence character) {
    return braces.contains(character);
  }

//  TODO implementation not complete
  @Override
  public AST generateAST(List<String> tokens) throws GrammarInApplicableException {
    return new AST(tokens);
  }

//  TODO may not be the right place for this method
  private boolean applicable(ProductionRule productionRule, List<String> tokens) {
    return true;
  }

  @Override
  public boolean isTerminalSymbol(CharSequence character) {
    return isCharacter(character) || isDigit(character) || isOperator(character) || isBrace(character);
  }

  @Override
  public boolean isNonTerminalSymbol(CharSequence character) {
    return !isTerminalSymbol(character);
  }

  @Override
  public void addProductionRules() {
    productionRules.add(new ProductionRule("expr -> number | (operator expr+)"));
  }
}
