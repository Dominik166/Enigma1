package Factories;

import ciphers.impl.Cipher;

public interface CipherFactory {
    Cipher create(String type);
}
