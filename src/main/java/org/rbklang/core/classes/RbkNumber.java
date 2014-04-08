package org.rbklang.core.classes;

import org.rbklang.core.*;

public class RbkNumber extends RbkClass {
  public RbkNumber(String className) throws ClassNotFoundException {
    super(className, RbkNumber.class);
    RbkClass classToBeInstantiated = RbkClassLoader.getClass(className);
    fieldsMap.put("value", new Field(classToBeInstantiated, classToBeInstantiated.newInstance()));
  }
}
