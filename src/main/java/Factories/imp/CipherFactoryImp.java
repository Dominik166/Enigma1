
package Factories.imp;
import ciphers.impl.Cipher;
import ciphers.impl.impl.CesarCipher;
import ciphers.impl.impl.Root13Cipher;
import ciphers.impl.impl.VigenereCipher;
import exceptions.CipherNotFoundException;

public class CipherFactoryImp implements Factories.CipherFactory {
    public static final String CESAR = "Cesar";
    public static final String ROOT13 = "root13";
    public static final String Vigenere = "Vigenere";
    @Override
    public Cipher create(String type) {
        if(type.equals(CESAR)){
            return new CesarCipher();
        }
        if(type.equals(ROOT13)){
            return new Root13Cipher();
        }
        if(type.equals(Vigenere)){
            return new VigenereCipher();
        }

        throw new CipherNotFoundException(type);
    }
}