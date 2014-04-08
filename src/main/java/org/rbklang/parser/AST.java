package org.rbklang.parser;

import org.rbklang.Exception.MethodMissingException;
import org.rbklang.core.Operand;
import org.rbklang.core.Operator;

import java.util.List;

public class AST {
  private List<String> tokens;

  public AST(List<String> tokens) {
    this.tokens = tokens;
  }

  public Operator getOperator() throws MethodMissingException {
    return new Operator(tokens.get(1));
  }

  public Operand getCaller() {
    return new Operand(tokens.get(0));
  }

  public Operand getArgument() {
    return new Operand(tokens.get(2));
  }
}
