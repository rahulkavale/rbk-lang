package org.rbklang.parser;

import org.rbklang.Exception.MethodMissingException;
import org.rbklang.core.Method;
import org.rbklang.core.Operand;

import java.util.List;

public class AST {
  private List<String> tokens;

  public AST(List<String> tokens) {
    this.tokens = tokens;
  }

  public Method getOperator() throws MethodMissingException {
    return new Method(tokens.get(1));
  }

  public Operand getCaller() {
    return new Operand(tokens.get(0));
  }

  public Operand getArgument() {
    return new Operand(tokens.get(2));
  }
}
