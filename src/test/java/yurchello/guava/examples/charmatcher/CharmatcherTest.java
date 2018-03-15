package yurchello.guava.examples.charmatcher;

import com.google.common.base.CharMatcher;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CharmatcherTest {
    @Test
    public void whenRemoveSpecialCharacters_thenRemoved(){
        String input = "H*el.lo,}12";
        CharMatcher matcher = CharMatcher.JAVA_LETTER_OR_DIGIT;
        String result = matcher.retainFrom(input);

        assertEquals("Hello12", result);
    }

    @Test
    public void whenRemoveNonASCIIChars_thenRemoved() {
        String input = "あhello₤";

        String result = CharMatcher.ASCII.retainFrom(input);
        assertEquals("hello", result);

        result = CharMatcher.inRange('0', 'z').retainFrom(input);
        assertEquals("hello", result);
    }
}
