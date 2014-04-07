package org.rbklang.parser;

import org.rbklang.Exception.GrammarInApplicableException;
import org.rbklang.grammer.Grammar;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Parser {
  private Grammar grammar;

  public Parser(Grammar grammar) {
    this.grammar = grammar;
  }

  public AST parse(String input) throws GrammarInApplicableException {
    return grammar.generateAST(this.tokenize(input));
  }

  public List<String> tokenize(String input) {
    List<String> tokens = new ArrayList<>();
    input.replaceAll("\\s+", " ");
    StringTokenizer stringTokenizer = new StringTokenizer(input, " ");
    while (stringTokenizer.hasMoreElements()) {
      tokens.add(stringTokenizer.nextToken());
    }
    return tokens;
  }
}
