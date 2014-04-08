package org.rbklang.core;

public class Field {
  private RbkClass type;
  private Instance instance;

  public Field(RbkClass type, Instance instance) {
    this.type = type;
    this.instance = instance;
  }
}
