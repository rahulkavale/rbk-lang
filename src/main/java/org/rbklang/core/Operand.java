package org.rbklang.core;

import org.rbklang.core.classes.RbkNumber;
import org.rbklang.core.classes.RbkString;
import org.rbklang.core.classes.UserDefinedClass;

public class Operand {
  private String operand;
  private Instance instance;

  public Operand(String operand) {
    this.operand = operand;
    this.instance = Scope.getInstance(operand);
  }

  private Instance getInstance(String operand) {
    return null;
  }

  private Class getClass(String operand) {
    if (operand.matches("\\d+")) {
      return RbkNumber.class;
    }
    if (operand.matches("\\w*\\s*")) {
      return RbkString.class;
    }
    return UserDefinedClass.class;
  }

  public String callMethod(Method method, Operand... argument) {
    return instance.callMethod(method, argument);
  }
}
