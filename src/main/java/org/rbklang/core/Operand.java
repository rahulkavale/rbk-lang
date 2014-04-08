package org.rbklang.core;

import org.rbklang.core.classes.RbkNumber;
import org.rbklang.core.classes.RbkString;
import org.rbklang.core.classes.UserDefinedRbkClass;

public class Operand {
  private String operand;
  private Instance instance;

  public Operand(String operand) throws ClassNotFoundException {
    this.operand = operand;
    RbkClass operandClass = getClass(operand);
    if (operandClass.aClass == UserDefinedRbkClass.class) {
      this.instance = Scope.getInstance(operand);
    } else {
      this.instance = RbkClassLoader.getClass(operandClass.getName()).newInstance();
    }
  }

  private Instance getInstance(String operand) {
    return null;
  }

  private RbkClass getClass(String operand) {
    if (operand.matches("\\d+")) {
      return RbkNumber.class;
    }
    if (operand.matches("\\w*\\s*")) {
      return RbkString.class;
    }
    return UserDefinedRbkClass.class;
  }

  public String callMethod(Method method, Operand... argument) {
    return instance.callMethod(method, argument);
  }
}
