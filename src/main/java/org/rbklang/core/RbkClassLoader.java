package org.rbklang.core;

import java.util.HashMap;
import java.util.Map;

public class RbkClassLoader {
  private static Map<String, RbkClass> classCache = new HashMap<>();

  public static RbkClass getClass(String rbkClassName) throws ClassNotFoundException {
    RbkClass aClass = classCache.get(rbkClassName);
    if (aClass != null) {
      return aClass;
    }
    return new RbkClass(rbkClassName, ClassLoader.getSystemClassLoader().loadClass(rbkClassName));
  }
}
