package org.rbklang.core;

import java.util.List;

public class RbkObject {
  private List<Field> fields;
  private List<Method> methods;

  public RbkObject(List<Field> fields, List<Method> methods) {
    this.fields = fields;
    this.methods = methods;
  }
}
