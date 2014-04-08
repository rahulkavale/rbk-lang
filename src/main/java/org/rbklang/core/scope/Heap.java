package org.rbklang.core.scope;

import org.rbklang.core.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Heap {
  Map<String, Instance> instances = new HashMap<>();

  public Instance getInstanceWithName(String operand) {
    return instances.get(operand);
  }

  public Instance newInstance(String rbkClass) throws ClassNotFoundException {
    RbkClass aClass = RbkClassLoader.getClass(rbkClass);
    List<Method> constructors = aClass.getConstructors();
//    as of now create a blank object
//    if(constructors.size() == 0){
    return aClass.newInstance();
//    }
  }
}
