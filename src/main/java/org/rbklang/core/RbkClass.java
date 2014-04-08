package org.rbklang.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class RbkClass {
  private String className;
  private Class aClass;

//  need to implement declaring a class
  private Map<String, Field> fieldsMap = new HashMap<>();
  private Map<String, Method> methodsMap = new HashMap<>();

  public RbkClass(String className, Class aClass) throws ClassNotFoundException {
    this.className = className;
    this.aClass = aClass;
  }

  public List<Method> getConstructors() {
    return asList(methodsMap.get(this.className));
  }

  public Instance newInstance() {
    List<Field> fields = new ArrayList<>(fieldsMap.values());
    List<Method> methods = new ArrayList<>(methodsMap.values());
    return new Instance(new RbkObject(fields, methods));
  }
}
