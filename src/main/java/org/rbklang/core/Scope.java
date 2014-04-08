package org.rbklang.core;

import org.rbklang.core.scope.Heap;

public class Scope {
  private static Heap heap;

  public static Instance getInstance(String operand) {
    return heap.getInstanceWithName(operand);
  }

  public static Instance newInstance(Method method){
//    implement instances creation with overridden constructors
    return null;
  }

  public static Instance newInstance(String className) throws ClassNotFoundException {
    return heap.newInstance(className);
  }
}
