package impl;

public interface Cipher {

    String encode(String textToEncode);
    String decode(String textToDecode);

}
