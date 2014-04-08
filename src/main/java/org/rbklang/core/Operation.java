package org.rbklang.core;

import org.rbklang.Exception.MethodMissingException;
import org.rbklang.parser.AST;

public class Operation {
  private Method method;
  private Operand caller;
  private Operand argument;

  public Operation(AST ast) throws MethodMissingException {
    this.method = ast.getOperator();
    this.caller = ast.getCaller();
    this.argument = ast.getArgument();
  }

  public String execute() {
    return caller.callMethod(method, argument);
  }
}
