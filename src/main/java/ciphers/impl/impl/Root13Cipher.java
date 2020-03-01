package ciphers.impl.impl;

import ciphers.impl.Cipher;

public class Root13Cipher implements Cipher {


    private final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private final int ROOT_DISPLACEMENT = 13;

    @Override
    public String encode(String TextToEncode) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < TextToEncode.length(); i++) {
            char sign = TextToEncode.charAt(i);
            if (isIncluded(sign)) {
                boolean isLowerCase = Character.isLowerCase(sign);
                int indexInALPHABET = ALPHABET.indexOf(Character.toLowerCase(sign));
                int indexAfterReplacement = (indexInALPHABET + ROOT_DISPLACEMENT) % ALPHABET.length();
                if (isLowerCase) {
                    stringBuilder.append(ALPHABET.charAt(indexAfterReplacement));
                } else {
                    stringBuilder.append(Character.toUpperCase(indexAfterReplacement));
                }
            } else {
                stringBuilder.append(sign);
            }
        }
            return stringBuilder.toString();
        }

        @Override
        public String decode (String textToDecode){
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < textToDecode.length(); i++) {
                char sign = textToDecode.charAt(i);
                if (isIncluded(sign)) {
                    boolean isLowerCase = Character.isLowerCase(sign);
                    int indexInALPHABET = ALPHABET.indexOf(Character.toLowerCase(sign));
                    int indexAfterReplacement = (indexInALPHABET + ALPHABET.length() - ROOT_DISPLACEMENT) % ALPHABET.length();
                    if (isLowerCase) {
                        stringBuilder.append(ALPHABET.charAt(indexAfterReplacement));
                    } else {
                        stringBuilder.append(Character.toUpperCase(indexAfterReplacement));
                    }
                } else {
                    stringBuilder.append(sign);
                }

            }
            return stringBuilder.toString();
        }
        private boolean isIncluded ( char sign){
            return ALPHABET.contains(Character.toString(sign).toLowerCase());
        }

    }











