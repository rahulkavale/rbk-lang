package org.rbklang.core;

import org.rbklang.Exception.MethodMissingException;

import java.util.List;

import static java.util.Arrays.asList;

public class Method {
  private String name;
  private List<Field> arguments;

  public Method(String name) throws MethodMissingException {
    this.name = name;
    if (!isValid()) {
      throw new MethodMissingException();
    }
  }

  public boolean isValid() {
    return asList("+", "-", "/", "*").contains(this.name);
  }
}
