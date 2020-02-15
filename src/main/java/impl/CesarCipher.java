
package impl;


public class CesarCipher implements Cipher {
    @Override
    public String encode(String textToEncode) {
        return encodeOrDecode(textToEncode, true);
    }

    @Override
    public String decode(String textToDecode) {
        return encodeOrDecode(textToDecode, false);
    }

    public String encodeOrDecode(String textToEncode, boolean isEncoding) {
        char[] lettersInMamaWord = textToEncode.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char sign : lettersInMamaWord) {
            if (Character.isAlphabetic(sign)) {
                boolean isUpperCase = Character.isUpperCase(sign);
                char codedLetter = Character.toUpperCase(sign);
                if (isEncoding) {
                    codedLetter = encode(codedLetter);
                } else {
                    codedLetter = decodeSign(codedLetter);
                }
                if (!isUpperCase) {
                    codedLetter = Character.toLowerCase(codedLetter);
                }
                stringBuilder.append(codedLetter);
            } else {
                stringBuilder.append(sign);
            }
        }
        return stringBuilder.toString();
    }

    private char decodeSign(char codedLetter) {
        if (codedLetter == 65) {
            codedLetter = 'X';
        } else if (codedLetter == 66) {
            codedLetter = 'Y';
        } else if (codedLetter == 67) {
            codedLetter = 'Z';
        } else {
            codedLetter = (char) (codedLetter - 3);
        }
        return codedLetter;
    }

    private char encode(char letterToEncode) {
        if (letterToEncode == 88) {
            letterToEncode = 'A';
        } else if (letterToEncode == 89) {
            letterToEncode = 'B';
        } else if (letterToEncode == 90) {
            letterToEncode = 'C';
        } else {
            letterToEncode = (char) (letterToEncode + 3);
        }
        return letterToEncode;
    }
}























//        package impl;
//
//import impl.Cipher;
//
//
//public class CesarCipher implements Cipher {
//    @Override
//    public String encode(String textToEncode) {
//        char[] lettersInMamaWord = textToEncode.toCharArray();
//        StringBuilder stringBuilder = new StringBuilder();
//        for (char sign : lettersInMamaWord) {
//            if (Character.isAlphabetic(sign)) {
//                boolean isUpperCase = Character.isUpperCase(sign);
//                char codedLetter = Character.toUpperCase(sign);
//
//                if (codedLetter == 88) {
//                    codedLetter = 'A';
//                } else if (codedLetter == 89) {
//                    codedLetter = 'B';
//                } else if (codedLetter == 90) {
//                    codedLetter = 'C';
//                } else {
//                    codedLetter = (char) (codedLetter + 3);
//                }
//                if (!isUpperCase) {
//                    codedLetter = Character.toLowerCase(codedLetter);
//                }
//                stringBuilder.append(codedLetter);
//            } else {
//                stringBuilder.append(sign);
//            }
//        }
//        return stringBuilder.toString();
//    }
//
//        @Override
//        public String decode(String TextToDecode){
//            return null;
//        }
//}










