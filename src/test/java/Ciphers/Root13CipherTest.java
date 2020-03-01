package Ciphers;
import ciphers.impl.Cipher;
import ciphers.impl.impl.Root13Cipher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Root13CipherTest {
//    protected final String textWitnNoAlphabeticLetters = "12312[]][";
    protected final String textWithAlphabeticLetters = "abcdd";
    protected final String expectedTextForAlphabeticLetters = "nopqq";
    protected final String mixedText = "123ac";
//    protected final String expectedTextForMixedText = "123df//";
    protected Cipher Root13Cipher = new Root13Cipher();
    @Test
    public void testOnlyAlphabeticLettersAreEncoded() {
        String encode = Root13Cipher.encode(mixedText);
        Assertions.assertEquals("123np", encode);
       String decode = Root13Cipher.decode(encode);//        Assertions.assertEquals(textWithAlphabeticLetters, decode);

        }
//    @DisplayName("Testing correction of encoding text with no alphabetic letters")
//    @Test
//    public void testOnlyAlphabeticLettersAreEncoded() {
//        String encode = Root13Cipher.encode(textWithAlphabeticLetters);
//        Assertions.assertEquals(expectedTextForAlphabeticLetters, encode);
//        String decode = Root13Cipher.decode(encode);
//        Assertions.assertEquals(textWithAlphabeticLetters, decode);
//
//
//    }

    @DisplayName("Testing correction of encoding text with no alphabetic letters")
    @Test

    public void testIfEncodingModifyTextWithAlphabeticChars (){

        String encoded = Root13Cipher.encode(textWithAlphabeticLetters);
        Assertions.assertEquals(expectedTextForAlphabeticLetters, encoded);
    }
    @DisplayName("Testing correction of encoding text with no alphabetic letters")
    @Test

    public void testIfDecodingModifyTextWithAlphabeticChars (){

        String decoded = Root13Cipher.decode(expectedTextForAlphabeticLetters);
        Assertions.assertEquals(textWithAlphabeticLetters, decoded);
    }





}
