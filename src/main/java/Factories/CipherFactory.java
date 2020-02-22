package Factories;

import impl.Cipher;

public interface CipherFactory {
    Cipher create(String type);
}
