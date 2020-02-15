
package Ciphers;
import impl.CesarCipher;
import impl.Cipher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class CesarCipherTest {
    protected final String textWitnNoAlphabeticLetters = "12312[]][";
    protected final String textWithAlphabeticLetters = "abcdd";
    protected final String expectedTextForAlphabeticLetters = "defgg";
    protected final String mixedText = "123ac";
    protected final String expectedTextForMixedText = "123df//";
    protected Cipher cesarCipher = new CesarCipher();
//    @Test
//    public void testOnlyAlphabeticLettersAreEncoded(){
//        String encode = cesarCipher.encode(mixedText);
//        Assertions.assertEquals(mixedText, encode);
//        String decode = cesarCipher.decode(textWithAlphabeticLetters);
//        Assertions.assertEquals(textWithAlphabeticLetters,decode);

    @DisplayName("Testing correction of encoding text with no alphabetic letters")
    @Test
    public void testOnlyAlphabeticLettersAreEncoded() {
        String encode = cesarCipher.encode(mixedText);
        Assertions.assertEquals(mixedText, encode);
        String decode = cesarCipher.decode(textWithAlphabeticLetters);
        Assertions.assertEquals(textWithAlphabeticLetters, decode);


    }

    @DisplayName("Testing correction of encoding text with no alphabetic letters")
    @Test

    public void testIfEncodingModifyTextWithAlphabeticChars (){

        String encoded = cesarCipher.encode(textWithAlphabeticLetters);
        Assertions.assertEquals(expectedTextForAlphabeticLetters, encoded);
    }
    @DisplayName("Testing correction of encoding text with no alphabetic letters")
    @Test

    public void testIfDecodingModifyTextWithAlphabeticChars (){

        String decoded = cesarCipher.decode(expectedTextForAlphabeticLetters);
        Assertions.assertEquals(textWithAlphabeticLetters, decoded);
    }


}









