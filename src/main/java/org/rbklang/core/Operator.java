package org.rbklang.core;

import org.rbklang.Exception.MethodMissingException;

import static java.util.Arrays.asList;

public class Operator {
  private String operator;

  public Operator(String operator) throws MethodMissingException {
    this.operator = operator;
    if (!isValid()) {
      throw new MethodMissingException();
    }
  }

  public boolean isValid() {
    return asList("+", "-", "/", "*").contains(this.operator);
  }
}
