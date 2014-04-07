package org.rbklang.grammer;

import java.util.Iterator;

import static java.util.Arrays.asList;

public class ProductionRule {

  private NonTerminal input;
  private String output;

  public ProductionRule(String expression) {
    String[] splitExpression = expression.split("->");
    this.input = new NonTerminal(splitExpression[0]);

    //TODO add a validation that noth input and output exists
    this.output = splitExpression[1];
  }

  public Iterator<String> getOutputIterator(){
    return asList(output.split("\\s")).iterator();
  }
}
