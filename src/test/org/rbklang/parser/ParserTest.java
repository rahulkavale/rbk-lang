package org.rbklang.parser;

import org.junit.Before;
import org.junit.Test;
import org.rbklang.grammer.Grammar;
import org.rbklang.grammer.RbkLangGrammar;

import java.util.List;

import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;

public class ParserTest {

  private Grammar grammar;

  @Before
  public void setup() {
    grammar = mock(RbkLangGrammar.class);
  }

  @Test
  public void shouldParseNormalSpaceSeparatedString() throws Exception {
    String input = "1 + 2 + 3 + 4 - 5 * 5 ^ 3 + 8 + 10 / 100 ";

    Parser parser = new Parser(grammar);

    List<String> tokenizedOutput = parser.tokenize(input);

    assertEquals(19, tokenizedOutput.size());
    assertTrue(tokenizedOutput.containsAll(asList("1", "+", "2", "+", "3", "+", "4", "-", "5", "*", "5", "^", "3", "+", "8", "+", "10", "/", "100")));
  }

  @Test
  public void shouldHandleMultipleSpaces() throws Exception {
    String input = "1  +    2 + \n3 + 4 - 5 * \t5 ^ 3 + 8 + 10 / 100 ";

    Parser parser = new Parser(grammar);

    List<String> tokenizedOutput = parser.tokenize(input);

    assertEquals(19, tokenizedOutput.size());
    assertTrue(tokenizedOutput.containsAll(asList("1", "+", "2", "+", "3", "+", "4", "-", "5", "*", "5", "^", "3", "+", "8", "+", "10", "/", "100")));
    assertFalse(tokenizedOutput.contains("\t"));
    assertFalse(tokenizedOutput.contains("\n"));
  }
}
